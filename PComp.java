import java.util.Comparator;
//Mithuusan Kirupananthan
//Student ID: 501102123
public class PComp implements Comparator<Product> {
    public int compare(Product p1, Product p2)
    {
        return new Double(p1.getPrice()).compareTo(p2.getPrice());
    }
    

}
