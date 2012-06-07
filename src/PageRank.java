import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class pagerank {
   private static List<List<Integer>> graph = new ArrayList<List<Integer>> ();   //get(from).get(to)
   private static List<String> nodes = new ArrayList<String> ();               //List of names, same index across horizontal/vertical sides of matrix. same length as graph.size()
   public static void main(String[] args) {
      if(args.length != 1) {
         System.out.println("usage: PageRank <filename.csv>");
         System.exit(-1);
      }
      try {
         parseGraphs(args[0]);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.exit(-1);
      }

   }

   private static void parseGraphs(String file) throws FileNotFoundException {
      List<List<String>> edgeMap = new ArrayList<List<String>> ();
      Scanner scan = new Scanner(new File(file));
      String[] line;
      String temp;
      String delims = "[,]+";
      ArrayList<String> temp2;
      while(scan.hasNextLine()) {
         line = scan.nextLine().split(delims);
         temp2 = new ArrayList<String> ();
         for(String i : line) {
            temp = i.replaceAll("\"", "");
            temp2.add(temp.trim());
         }
         List<String> toAdd = new ArrayList<String> ();
         toAdd.add(temp2.get(0));
         toAdd.add(temp2.get(2));
         edgeMap.add(toAdd);
      }
      buildMatrix(edgeMap);
   }

   private static void buildMatrix(List<List<String>> edgeMap) {
      for (List<String> i : edgeMap) {
        for(String j : i) {
           if(!nodes.contains(j)) {
              nodes.add(j);
           }
        }
      }
      int k = nodes.size();
      for(int i = 0; i < k; i++) {
         graph.add(new ArrayList<Integer> ());
         for(int j =0; j < k; j++) {
            graph.get(i).add(0);
         }
      }
      for(List<String> i : edgeMap) {
         int fromIndex = nodes.indexOf(i.get(0));
         int toIndex = nodes.indexOf(i.get(1));
         graph.get(fromIndex).set(toIndex, 1);
         
      }/*
      for(String i : nodes) {
         System.out.print(i + " ");
      }
      
      //   for debug
      System.out.println();
      for(List<Integer> i : graph) {
         for(Integer j : i) {
            System.out.print(j + "  ");
         }
         System.out.println();
      }*/
   }
   
}
