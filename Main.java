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
      
      BruteForceSolver solver = new BruteForceSolver(items, capacity);
      
      for (Item item : solver.solve()) {
         System.out.print(item.label);
      }
      
      System.out.println();
   }
}
