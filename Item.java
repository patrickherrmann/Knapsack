import java.util.*;

public class Item {
   
   public int label;
   public double value;
   public double weight;
   
   public double getRatio() {
      return value / weight;
   }
}
