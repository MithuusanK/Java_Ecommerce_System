//Mithuusan Kirupananthan
//Student ID: 501102123

public class CartItem extends Product
{
    private Product product;
    private String productOptions;

    public CartItem(Product product, String productOptions)
    {
        this.product = product;
        this.productOptions = productOptions;
    }

    public Product getProduct()
    {
        return product;
    }

    public String getProductOptions()
    {
        return productOptions;
    }

    public void print()
    {
        product.print();
    }

    public boolean equal(Object o)
    {
        CartItem other = (CartItem) o;
        if(this.product.getId().equals(other.product.getId()))
        {
            return true;
        }
        return false;
    }
    
}
