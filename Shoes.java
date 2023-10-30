

public class Shoes extends Product 
{
    private int black6 = 0;
    private int black7 = 0;
    private int black8 = 0;
    private int black9 = 0;
    private int black10 = 0;
    private int brown6 = 0;
    private int brown7 = 0;
    private int brown8 = 0;
    private int brown9 = 0;
    private int brown10 = 0;

    public Shoes(String name, String id, double price, int stock, Category category)
    {
        super(name, id, price, stock, Product.Category.SHOES);
    }

    public boolean validOptions(String productOptions)
    {
        if (productOptions.equalsIgnoreCase("black6") || productOptions.equalsIgnoreCase("black7") || productOptions.equalsIgnoreCase("black8") || productOptions.equalsIgnoreCase("black9") || productOptions.equalsIgnoreCase("black10"))
        {
            return true;
        }
        else if (productOptions.equalsIgnoreCase("brown6") || productOptions.equalsIgnoreCase("brown7") || productOptions.equalsIgnoreCase("brown8") || productOptions.equalsIgnoreCase("brown9") || productOptions.equalsIgnoreCase("brown10"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getStockCount(String productOptions)
    {
        if (productOptions.equalsIgnoreCase("black6"))
        {
            black6++;
            return black6;
        }
        else if (productOptions.equalsIgnoreCase("black7"))
        {
            black7++;
            return black7;
        }
        else if (productOptions.equalsIgnoreCase("black8"))
        {
            black8++;
            return black8;
        }
        else if (productOptions.equalsIgnoreCase("black9"))
        {
            black9++;
            return black9;
        }
        else if (productOptions.equalsIgnoreCase("black10"))
        {
            black10++;
            return black10;
        }
        else if (productOptions.equalsIgnoreCase("brown6"))
        {
            brown6++;
            return brown6;
        }
        else if (productOptions.equalsIgnoreCase("brown7"))
        {
            brown7++;
            return brown7;
        }
        else if (productOptions.equalsIgnoreCase("brown8"))
        {
            brown8++;
            return brown8;
        }
        else if (productOptions.equalsIgnoreCase("brown9"))
        {
            brown9++;
            return brown9;
        }
        else if (productOptions.equalsIgnoreCase("brown10"))
        {
            brown10++;
            return brown10;
        }
        return 0;
    }

    public void setStockCount(int stockCount, String productOptions)
	{
        if (productOptions.equalsIgnoreCase("black6"))
        {
            black6 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("black7"))
        {
            black7 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("black8"))
        {
            black8 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("black9"))
        {
            black9 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("black10"))
        {
            black10 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("brown6"))
        {
            brown6 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("brown7"))
        {
            brown7 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("brown8"))
        {
            brown8 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("brown9"))
        {
            brown9 = stockCount;
        }
        else if (productOptions.equalsIgnoreCase("brown10"))
        {
            brown10 = stockCount;
        }
    }

    public void reduceStockCount(String productOptions)
    {
        if (productOptions.equalsIgnoreCase("black6"))
        {
            black6 --;
        }
        else if (productOptions.equalsIgnoreCase("black7"))
        {
            black7 --;
        }
        else if (productOptions.equalsIgnoreCase("black8"))
        {
            black8 --;
        }
        else if (productOptions.equalsIgnoreCase("black9"))
        {
            black9 --;
        }
        else if (productOptions.equalsIgnoreCase("black10"))
        {
            black10 --;
        }
        else if (productOptions.equalsIgnoreCase("brown6"))
        {
            brown6 --;
        }
        else if (productOptions.equalsIgnoreCase("brown7"))
        {
            brown7 --;
        }
        else if (productOptions.equalsIgnoreCase("brown8"))
        {
            brown8 --;
        }
        else if (productOptions.equalsIgnoreCase("brown9"))
        {
            brown9 --;
        }
        else if (productOptions.equalsIgnoreCase("brown10"))
        {
            brown10 --;
        }
    }

    public void print()
    {
  	    super.print(); 
    }


    
}
