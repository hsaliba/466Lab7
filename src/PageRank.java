import java.util.ArrayList;
import java.util.List;


public class PageRank {
   private List<List<Integer>> graph = new ArrayList<List<Integer>> ();
   private List<String> nodes = new ArrayList<String> ();
   
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