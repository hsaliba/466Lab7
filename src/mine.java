import java.util.ArrayList;
import java.util.List;


public class PageRank {
   private List<List<Integer>> graph = new ArrayList<List<Integer>> ();
   private List<String> nodes = new ArrayList<String> ();
   private List<Double> pageRanks = new ArrayList<Double>();

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
          

      
      return 0.0;
   }

   //d = prob of clicking on any links on page
   private static double pageRank(int ndx) {
      double pr = 0.0;
      double sum = 0.0;
      double d = (double)getOut(in.get(i))/graph.size();//maybe not size
      ArrayList<Integer> in = new ArrayList<Integer>();
      ArrayList<Double> pprs = new ArrayList<Double>();

      //find all in 
      for (int i = 0; i < graph.size(); i++) {
         if (graph.get(i).get(ndx) == 1)
            in.add(i);
      }

      for (int i = 0; i < in.size(); i++) {
         double prev = pageRank(in.get(i));
         ppr.add(prev);
         sum += (1/(double)getOut(in.get(i))) + prev; 
      }

      pr = (1-d)*(1/(double)graph.size()) + d * sum;

      sum = 0.0;
      for (int i = 0; i < pprs.size(); i++) {

   }

   private static boolean stop() {

      if (pageRanks.size() < graph.size()) 
         return false;
      
      for (int i = 0; i < pageRanks.size(); i++) {

         for (int j = 0; j <   


      }

   }  

   public static void main(String[] args) {
      if(args.length != 2) {
         System.out.println("usage: PageRank <filename.csv>");
         System.exit(-1);
      }
      parseGraphs();

   }

   private static void parseGraphs() {
      
      
   }

}
