import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PageRank {
   private static List<List<Integer>> graph = new ArrayList<List<Integer>> ();   //get(from).get(to)
   private static List<String> nodes = new ArrayList<String> ();               //List of names, same index across horizontal/vertical sides of matrix. same length as graph.size()
   private static List<Double> pageRanks = new ArrayList<Double>();
      
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
  
   private static int getOut(int ndx) {
      int count = 0;

      for (int i = 0; i < graph.size(); i++) 
         if (graph.get(ndx).get(i) == 1)
            count++;

      return count;
   }
   
   private static int getIn(int ndx) {
      int count = 0;

      for (int i = 0; i < graph.size(); i++) {
         if (graph.get(i).get(ndx) == 1)
            count++;
      }
      return count;
   }

   public static double getPageRank(int ndx) {
      double d = 0.0;
      double pr = 0.0;
      double ppr = 0.0;


      d = (double)getIn(ndx)/graph.size();

      for (int i = 0; i < getOut(ndx); i++) {
      //while diff is large enough
      //for all incoming pages
      // get page rank
      // mult pr by 1/#out
      //sum of ^
       }   

      
      return 0.0;
   }

   //d = prob of clicking on any links on page
   private static double pageRank(int ndx) {
      double pr = 0.0;
      double sum = 0.0;
      ArrayList<Integer> in = new ArrayList<Integer>();
      double d = (double)getOut(in.get(ndx))/graph.size();//maybe not size
      ArrayList<Double> pprs = new ArrayList<Double>();

      //find all in 
      for (int i = 0; i < graph.size(); i++) {
         if (graph.get(i).get(ndx) == 1)
            in.add(i);
      }

      for (int i = 0; i < in.size(); i++) {
         double prev = pageRank(in.get(i));
         pprs.add(new Double(prev));
         sum += (1/(double)getOut(in.get(i))) + prev; 
      }

      pr = (1-d)*(1/(double)graph.size()) + d * sum;

      sum = 0.0;
      for (int i = 0; i < pprs.size(); i++) {
      }
      return 0;
   }

   private static boolean stop() {

      if (pageRanks.size() < graph.size()) 
         return false;
      
      for (int i = 0; i < pageRanks.size(); i++) {



      }
   return false;
   } 
   
}
