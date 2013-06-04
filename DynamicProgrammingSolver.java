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
      
      getCell(capacity - 1, items.size() - 1);
      
      KnapsackSolution best = traceTable();
      
      best.approach = "Dynamic Programming solution";
      return best;
   }
   
   // Traces back table
   private KnapsackSolution traceTable() {
   
      KnapsackSolution best = new KnapsackSolution();
      best.items = new ArrayList<Item>();
   
      int i = items.size() - 1, j = capacity - 1;
      
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
