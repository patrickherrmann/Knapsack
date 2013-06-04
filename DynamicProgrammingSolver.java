import java.util.*;

public class DynamicProgrammingSolver extends KnapsackSolver {
   
   private double[][] table;
   
   public DynamicProgrammingSolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
      
      
      table = new double[capacity + 1][items.size()];
      
      for (int j = 0; j < capacity + 1; j++)
         for (int i = 0; i < items.size(); i++)
            table[j][i] = -1;
      
      getCell(capacity, items.size() - 1);
      
      KnapsackSolution best = traceTable();
      
      best.approach = "Dynamic Programming solution";
      return best;
   }
   
   // Traces back table
   private KnapsackSolution traceTable() {
   
      KnapsackSolution best = new KnapsackSolution();
      best.items = new ArrayList<Item>();
   
      int i = items.size() - 1, j = capacity;
      
      while (i >= 0) {
         Item item = items.get(i);
         
         double without = i == 0 ? 0 : table[j][i - 1];
         
         if (table[j][i] != without) {
            best.items.add(item);
            best.value += item.value;
            best.weight += item.weight;
            j -= (int) item.weight;
         }
         
         i--;
      }
      
      return best;
   }
   
   // Uses recursion with memoization
   private double getCell(int j, int i) {
   
      if (i < 0 || j < 0) return 0;
      Item item = items.get(i);
      
      double with, without, cell = table[j][i];
      
      // If not memoized
      if (cell == -1) {
      
         if (item.weight > j) with = -1;
         else with = item.value + getCell(j - (int) item.weight, i - 1);
         without = getCell(j, i - 1);
         
         cell = Math.max(with, without);
            
         table[j][i] = cell; // Memoize
      }
      
      return cell;
   }
}
