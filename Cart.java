import java.util.ArrayList;
//Mithuusan Kirupananthan
//501102123

public class Cart 
{
    ArrayList<CartItem> cart = new ArrayList<CartItem>();
    ArrayList<String> cartOrders = new ArrayList<String>();

    public void addCart(CartItem i)
    {
        cart.add(i);
    }

    public boolean findItem(CartItem y)
    {
        for (int i=0; i<cart.size(); i++)
        {
            if (cart.get(i).equals(y))
            {
                return true;
            }
        }
        return false;
    }

    public void removeItem(CartItem i)
    {
        if (findItem(i) == true)
        {
            cart.remove(i);
        }
    }

    public ArrayList<String> orderItems()
    {
        for (int i=0; i<cartOrders.size(); i++)
        {
            cartOrders.add(cart.get(i).getProduct().getId());
            cartOrders.add(cart.get(i).getProductOptions());
            cart.remove(i);
        }
        return cartOrders;
    }

    public void print()
    {
        for (CartItem i: cart)
        {
            i.getProduct().print(); i.getProductOptions();
    
        }
    }

    
}
