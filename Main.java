import java.util.*;

public class Main {
   
   public static void main(String[] args) {
   
      Scanner scanner = new Scanner(System.in);
      int count = scanner.nextInt();
      
      List<Item> items = new ArrayList<Item>(count);
      for (int i = 0; i < count; i++) {
         Item item = new Item(scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
         items.add(item);
      }
      
      for (Item item : items) {
         System.out.println(item.weight);
      }
      
      int capacity = scanner.nextInt();
      
      
   }
}
