import java.util.*;

public class Main {
   
   public static void main(String[] args) {
   
      Scanner scanner = new Scanner(System.in);
      int count = scanner.nextInt();
      
      List<Item> items = new LinkedList<Item>();
      for (int i = 0; i < count; i++) {
         Item item = new Item();
         item.label = scanner.nextInt();
         item.value = scanner.nextDouble();
         item.weight = scanner.nextDouble();
         items.add(item);
      }
      
      int capacity = scanner.nextInt();
      
      List<KnapsackSolver> solvers = new ArrayList<KnapsackSolver>();
      
      if (items.size() <= 20) 
         solvers.add(new BruteForceSolver(items, capacity));
      solvers.add(new GreedySolver(items, capacity));
      solvers.add(new DynamicProgrammingSolver(items, capacity));
      solvers.add(new BranchAndBoundSolver(items, capacity));
      
      for (KnapsackSolver solver : solvers) {
         System.out.println(solver.solve());
      }
   }
}
