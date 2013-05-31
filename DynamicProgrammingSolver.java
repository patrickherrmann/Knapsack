import java.util.*;

public class DynamicProgrammingSolver extends KnapsackSolver {
   
   private double[][] table;
   
   public DynamicProgrammingSolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
      
      
      table = new double[capacity][items.size()];
      
      for (int j = 0; j < capacity; j++)
         for (int i = 0; i < items.size(); i++)
            table[j][i] = -1;
      
      best.value = getCell(capacity - 1, items.size() - 1);
      
      for (int j = 0; j < capacity; j++) {
         for (int i = 0; i < items.size(); i++) {
            System.out.print(table[j][i] + "  ");
         }
         System.out.println();
      }
      
      best.items = new ArrayList<Item>();
      best.approach = "Dynamic Programming solution";
      return best;
   }
   
   private KnapsackSolution traceTable() {
   
      KnapsackSolution best = new KnapsackSolution();
   
      int i = items.size() - 1, j = capacity - 1;
      
      while (i >= 0 || j > 0) {
         
      }
      
   }
   
   // Uses recursion with memoization
   private double getCell(int j, int i) {
   
      if (i < 0) return 0;
      Item item = items.get(i);
      
      if (item.weight > j) return 0;
      double cell = table[j][i];
      
      if (cell == -1) {
         double with = item.value + getCell(j - (int) item.weight, i - 1);
         double without = getCell(j, i - 1);
         cell = Math.max(with, without);
         table[j][i] = cell;
      }
      
      return cell;
   }
}
