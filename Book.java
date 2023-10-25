
/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
//Mithuusan Kirupananthan
//Student ID: 501102123
public class Book extends Product 
{
  private String author;
  private String title;
  private String year;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, String year)
  {
  	 // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 // Set category to BOOKS
     super(name, id, price, 100000, Product.Category.BOOKS);
     this.title = title;
     this.author = author;
     this.paperbackStock = paperbackStock;
     this.hardcoverStock = hardcoverStock; 
     this.year = year;
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false
    if (productOptions.equalsIgnoreCase("Paperback") || productOptions.equalsIgnoreCase("Hardcover") || productOptions.equalsIgnoreCase("EBook"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
    int e = 0;
    if (productOptions.equalsIgnoreCase("Paperback"))
     {
       paperbackStock ++;
       return paperbackStock;
     }
     else if (productOptions.equalsIgnoreCase("Hardcover"))
     {
       hardcoverStock ++;
       return hardcoverStock;
     }
     else if (productOptions.equalsIgnoreCase("EBook"))
     {
       e = super.getStockCount("EBook");
       return e;
     }
     return 1;
	}
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback"))
    {
      paperbackStock = stockCount;
    }
    else if (productOptions.equalsIgnoreCase("Hardcover"))
    {
      hardcoverStock = stockCount;
    }
    else if (productOptions.equalsIgnoreCase("EBook"))
    {
    super.setStockCount(stockCount,productOptions);
    }
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback"))
    {
      paperbackStock --;
    }
    else if (productOptions.equalsIgnoreCase("Hardcover"))
    {
      hardcoverStock --;
    }
    else if (productOptions.equalsIgnoreCase("EBook"))
    {
      super.reduceStockCount(productOptions);
    }
	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  @Override
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
  	super.print(); System.out.printf("  " + "Book Title: " + title + " " + "Author: " + author + " Publiccation Year: " + year);
  }
}
