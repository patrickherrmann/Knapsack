import java.util.*;

public class GreedySolver extends KnapsackSolver {
   
   public GreedySolver(List<Item> items, int capacity) {
      super(items, capacity);
   }
   
   @Override
   public KnapsackSolution solve() {
   
      KnapsackSolution greedy = new KnapsackSolution();
      
      greedy.items = new ArrayList<Item>(items);
      
      Comparator<Item> greedyFunction = new Comparator<Item>() {
         public int compare(Item i1, Item i2) {
            return Double.compare(i2.getRatio(), i1.getRatio());
         }
      };
      
      Collections.sort(greedy.items, greedyFunction);
      
      double capUsed = 0;
      double value = 0;
      int i;
      
      for (i = 0; i < greedy.items.size(); i++) {
         Item item = greedy.items.get(i);
         if (capUsed + item.weight > capacity) break;
         
         capUsed += item.weight;
         value += item.value;
      }
      
      greedy.items = greedy.items.subList(0, i);
      greedy.weight = capUsed;
      greedy.value = value;
      greedy.approach = "Greedy solution (not necessarily optimal)";
      
      return greedy;
   }
}
