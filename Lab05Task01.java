import java.util.*;
import java.io.*;

public class Lab05Task01{
  public static void main(String [] args) throws Exception{
    MST m = new MST();
    System.err.println("\\\\Solved using Prim's Algorithm////");
    
    File f = new File("Map for Prims 01.txt");
    FileReader fl = new FileReader(f);
    BufferedReader br = new BufferedReader(fl);
    
    String s = br.readLine();
    int c = Integer.parseInt(s);
    String [] city = new String [c];
    
    s = br.readLine();
    StringTokenizer st = new StringTokenizer(s," ");
    for(int i=0; i<city.length; i++) //Assings city names to an array with corresponding index numbers
      city[i] = st.nextToken();
    
    int [][] map = new int [c][c];
    for(int i=0; i<map.length; i++){
      s = br.readLine();
      st = new StringTokenizer(s," ");
      for(int j=0; j<map[i].length; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    m.Prims(map, city, 0);
    System.out.println();
    
    System.err.println("\\\\Solved using Kruskal's////");
    f = new File("Map for Kruskals 01.txt");
    fl = new FileReader(f);
    br = new BufferedReader(fl);
    
    s = br.readLine();
    st = new StringTokenizer(s," ");
    int ver = Integer.parseInt(st.nextToken());
    int edg = Integer.parseInt(st.nextToken());
    
    int [] edges = new int[edg];
    String [][] vertices = new String[edg][2];
    for(int i=0; i<edges.length; i++){
      s = br.readLine();
      st = new StringTokenizer(s," ");
      edges[i] = Integer.parseInt(st.nextToken());
      vertices[i][0] = st.nextToken();
      vertices[i][1] = st.nextToken();
    }
    m.Kruskals(edges, vertices);
  }
}