import java.util.*;

public class DynamicProgrammingSolver {

   private double[][] table;
   
   public DynamicProgrammingSolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
      KnapsackSolution best = new KnapsackSolution();
      
      table = new double[capacity][items.size()];
      
      for (int j = 0; j < capacity; j++) {
         for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.weight > j) {
               table[j][i] = 0;
            } else {
               double with = item.value + get(j - (int) item.weight, i - 1);
               double without = get(j, i - 1);
               table[j][i] = Math.max(with, without);
            }
         }
      }
      
      best.approach = "Dynamic Programming solution";
      return best;
   }
   
   private double get(int cap, int item) {
      if (cap <= 0 || item < 0) return 0;
      return table[cap][item];
   }
}
