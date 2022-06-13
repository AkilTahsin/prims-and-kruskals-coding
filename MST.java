import java.util.*;

public class MST{
  public MST(){ }
  public void Prims(int [][] g, String [] c, int start){
    int [] cost = new int [g.length];
    int [] parent = new int [g.length];
    int [] color = new int [g.length];
    for(int i=0; i<g.length; i++)
      cost[i] = 999;
    
//    for(int i=0; i<g.length; i++){
//      for(int j=0; j<g[0].length; j++)
//        System.out.print(g[i][j]+" ");
//      System.out.println();
//    }
    
    cost [start] = 0;
    Queue<Integer> Q = new LinkedList<Integer>();
    for(int i=0; i<g.length; i++) Q.add(i);
    
    while(!Q.isEmpty()){
      int u = Q.remove();
      for(int v=0; v<g.length; v++){
        if(g[u][v] != 0){
          if(color[v] == 0 && g[u][v] < cost[v]){
            parent[v] = u;
            cost[v] = g[u][v];
          }
        }
      }
      color[u] = 1;
    }
    
    for(int i=1; i<parent.length; i++)
      System.out.println("("+c[parent[i]]+" - "+c[i]+")");
  }
  
  
  
  public void Kruskals(int [] e, String [][] vr){
    for(int i=0; i<e.length; i++){
      for(int j=i+1; j<e.length; j++){
        if(e[i] > e[j]){
          int temp = e[i];
          e[i] = e[j];
          e[j] = temp;
          String temp0 = vr[i][0], temp1 = vr[i][1];
          vr[i][0] = vr[j][0]; vr[i][1] = vr[j][1];
          vr[j][0] = temp0; vr[j][1] = temp1;
        }
      }
    }
    
    Queue<String> p1 = new LinkedList<String>();
    Queue<String> p2 = new LinkedList<String>();
    
    String set = "";
    for(int i=0; i<e.length; i++){
      String u = vr[i][0];
      String v = vr[i][1];
      if(!set.contains(u) || !set.contains(v)){
        set+=u; set+=v;
        p1.add(u); p2.add(v);
      }
    }
    
    while(!p1.isEmpty()){
      System.out.println("("+p1.remove()+" - "+p2.remove()+")");
    }
  }
}