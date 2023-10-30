import java.util.Comparator;

public class PComp implements Comparator<Product> {
    public int compare(Product p1, Product p2)
    {
        return new Double(p1.getPrice()).compareTo(p2.getPrice());
    }
    

}
