import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
//Mithuusan Kirupananthan
//Student ID: 501102123
public class ECommerceSystem
{
    private  Map<String, Product> products = new TreeMap<String, Product>();
    private ArrayList<Product> tproducts = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    private  Map<Integer,String> statistics = new HashMap<Integer,String>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
      // try 
      // {
      // ArrayList <Product> prod = reader("prods.txt");
      // for (Product p: prod)
      // {
      //   products.put(p.getId(),p);
      // }
      // }
      // catch (FileNotFoundException | IllegalArgumentException e)
      // {
      //   System.out.println(e.getMessage());
      //   System.exit(1);
      // }
      
      tproducts.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	tproducts.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	tproducts.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney","2021"));
    	tproducts.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	tproducts.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	tproducts.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
      tproducts.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast","1997"));
    	tproducts.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive","1963"));
    	tproducts.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney","2001"));
    	tproducts.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
      tproducts.add(new Shoes("Nike Air Max", generateProductId(), 110.5, 35, Product.Category.SHOES));

      for (Product p : tproducts)
      {
        products.put(p.getId(), p);
        statistics.put(0,p.getId());
      }

    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    public void printAllProducts()
    {
    	for (Product p : products.values())
    		p.print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
      for (Product product : products.values())
      {
        if (product.getCategory() == Product.Category.BOOKS)
        {
          product.print();
        }
      }
    }
    
    // Print all current orders
    public void printAllOrders()
    {
      for (ProductOrder order: orders)
      {
        order.print();
      }
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
    	for (ProductOrder shipped: shippedOrders)
      {
        shipped.print();
      }
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer c : customers)
      {
        c.print();
      }
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId) throws UnknownCustomerException
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
    	int indexNum = customers.indexOf(new Customer(customerId));
      if (indexNum == -1)
      {
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }
    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
      for (int i=0; i<orders.size();i++)
      {
        if (orders.get(i).getCustomer().getId().equals(customerId))
        {
          orders.get(i).print();
        }
      }
    	
    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
    	for (int i=0; i<shippedOrders.size();i++)
      {
        if (shippedOrders.get(i).getCustomer().getId().equals(customerId))
        {
          shippedOrders.get(i).print();
        }
      }
    }
    
    public String orderProduct(String productId, String customerId, String productOptions) throws UnknownProductException, UnknownCustomerException, InvalidProductOptionsException, OutOfStockException
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
    	Customer curr = null;

      for (int i=0;i<customers.size();i++)
      {
        if(customers.get(i).getId().equals(customerId))
        {
          curr = customers.get(i);
          break;
        }
      }
      if (curr == null)
      {
        throw new UnknownCustomerException("Customer not found");
      }
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	Product prod = null;

      for (String id : products.keySet())
      {
        if(id.equals(productId))
        {
          prod = products.get(id);
          break;
        }
      }
      if (prod == null)
      {
        throw new UnknownProductException("Product not found");
      }
    	
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	if (prod.validOptions(productOptions) == false)
      {
        throw new InvalidProductOptionsException("Product " + prod.getName() + " Product Id " + productId + " Invalid Options: " + productOptions);
      }
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
        if (prod.getStockCount(productOptions) == 0)
        {
          throw new OutOfStockException("No stock available for this product");
        }

      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
      String orderNumber = generateOrderNumber();
      ProductOrder product = new ProductOrder(orderNumber, prod, curr, productOptions);    	
      orders.add(product);  	
    	return ("Order # " + orderNumber); // replace this line
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public boolean createCustomer(String name, String address) throws InvalidNameException, InvalidAddressException
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
    	if (name == null || name == "")
      {
        throw new InvalidNameException("Invalid Customer Name");
      }
      if (address == null || address == "")
      {
        throw new InvalidAddressException("Invalid Customer Address");
      }
    	// Create a Customer object and add to array list
      Customer customer = new Customer(generateCustomerId(),name, address);
      customers.add(customer);
      return true;
    }
    
    public ProductOrder shipOrder(String orderNumber) throws InvalidOrderNumberException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      int indexNum = orders.indexOf(new ProductOrder(orderNumber, null, null, ""));
      if (indexNum == -1)
      {
       throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");
      }
    	ProductOrder order = orders.get(indexNum);
      orders.remove(indexNum);
      shippedOrders.add(order);
      return order;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber) throws InvalidOrderNumberException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
      int indexNum = orders.indexOf(new ProductOrder(orderNumber, null, null, ""));
      if (indexNum == -1)
      {
        throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");
      }
      orders.remove(indexNum);
    	return true;
    }
    
    // Sort products by increasing price
    public void printByPrice()
    {
      ArrayList<Product> prods = new ArrayList<>();
      Set<String> pKey = products.keySet();
      Iterator<String> iter = pKey.iterator();
  	  while (iter.hasNext())
      {
        prods.add(products.get(iter.next()));
      }
      Collections.sort(prods, new PComp());
      for (Product p: prods)
      {
        p.print();
      }
    }
    
    
    //Sort products alphabetically by product name
    public void printByName()
    {
      ArrayList<Product> prods = new ArrayList<>();
      Set<String> pKey = products.keySet();
      Iterator<String> iter = pKey.iterator();
      while (iter.hasNext())
      {
        prods.add(products.get(iter.next()));
      }
      Collections.sort(prods);
      for (Product p : prods)
      {
        p.print();
      }
        
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  Comparator<Customer> custName = new Comparator<Customer>() 
        {
          public int compare(Customer c1, Customer c2)
          {
            return c1.getName().compareTo(c2.getName());
          }
        };
        Collections.sort(customers, custName);
    }

    public void printStats()
    {
      for (String sorted : statistics.values())
      {
        System.out.println(sorted);
      }
    }

    // public void sortStats()
    // {
    //   ArrayList <Product> order = new ArrayList<>();
    //   Set <Integer> orderKey = statistics.keySet();
    //   Iterator <Integer> kIter = orderKey.iterator();
    //   while (kIter.hasNext())
    //   {
    //     order.add(products.get(kIter.next()));
    //   }

    //   Collections.sort(order, new orderCountCompare());
    //   for (Product sorted : order)
    //   {
    //     sorted.print();
    //   }
    // } 

    // Add Items to Cart
    public String addItemCart(String productId, String customerId, String productOptions) throws UnknownProductException, UnknownCustomerException, InvalidProductOptionsException
    {
      Customer curr = null;
      for (int i=0;i<customers.size();i++)
      {
        if(customers.get(i).getId().equals(customerId))
        {
          curr = customers.get(i);
          break;
        }
      }
      if (curr == null)
      {
        throw new UnknownProductException("Customer not found");
      }

      Product prod = null;
      for (String id : products.keySet())
      {
        if(id.equals(productId))
        {
          prod = products.get(id);
          break;
        }
      }
      if (prod == null)
      {
        throw new UnknownCustomerException("Product not found");
      }

      if (prod.validOptions(productOptions) == false)
      {
        throw new InvalidProductOptionsException("Product " + prod.getName() + " Product Id " + productId + " Invalid Options: " + productOptions);
      }

      CartItem cart = new CartItem(prod, productOptions);
      curr.cust.addCart(cart);
      return "ID: " + prod.getId() + " Name: " + prod.getName() + " added to Customer: #" +curr.getId() + "'s cart.";
    }

    //Remove Items from cart
    public String removeCart(String productId, String customerId) throws UnknownProductException, UnknownCustomerException, InvalidCartItemException
    {
      Customer curr = null;
      for (int i=0;i<customers.size();i++)
      {
        if(customers.get(i).getId().equals(customerId))
        {
          curr = customers.get(i);
          break;
        }
      }
      if (curr == null)
      {
        throw new UnknownCustomerException("Customer not found");
      }

      Product prod = null;
      for (String id : products.keySet())
      {
        if(id.equals(productId))
        {
          prod = products.get(id);
          break;
        }
      }
      if (prod == null)
      {
        throw new UnknownProductException("Product not found");
      }

      CartItem cart = new CartItem(prod, "");
      if (curr.cust.findItem(cart) == true)
      {
        curr.cust.removeItem(cart);
        return "ID: " + prod.getId() + " Name: " + prod.getName() + " removed from Customer: #" +curr.getId() + "'s cart.";
      }
      throw new InvalidCartItemException("This item does not exist");
    }

    //Print items in cart
    public String printCart(String customerId) throws UnknownCustomerException
    {
      Customer curr = null;
      for (int i=0;i<customers.size();i++)
      {
        if(customers.get(i).getId().equals(customerId))
        {
          curr = customers.get(i);
          break;
        }
      }
      if (curr == null)
      {
        throw new UnknownCustomerException("Customer not found");
      }

      ArrayList<CartItem> currCart = curr.cust.cart;
      if (currCart.size() == 0)
      {
        return "Customer has no items in cart";
      }
      for (int i=0; i<currCart.size(); i++)
      {
        System.out.println("Product ID: " + currCart.get(i).getProduct().getId() + " Name: " + currCart.get(i).getProduct().getName() + " Price: $" + currCart.get(i).getProduct().getPrice());
      }
      return "";
    }

    //Order items
    public String orderItem(String customerId) throws UnknownCustomerException
    {
      Customer curr = null;
      for (int i=0;i<customers.size();i++)
      {
        if(customers.get(i).getId().equals(customerId))
        {
          curr = customers.get(i);
          break;
        }
      }
      if (curr == null)
      {
        throw new UnknownCustomerException("Customer not found");
      }

      ArrayList<CartItem> currCart = curr.cust.cart;
      if (currCart.size() == 0)
      {
        return "Cart is empty";
      }

      for (int i=0; i<currCart.size(); i++)
      {
        String orderNumber = generateOrderNumber();
        Product prod = currCart.get(i).getProduct();
        ProductOrder product = new ProductOrder(orderNumber,prod,curr,currCart.get(i).getProductOptions());
        prod.reduceStockCount(currCart.get(i).getProductOptions());
        orders.add(product);
      }
      return "Products Ordered";
    }
    

    private ArrayList <Product> reader(String fName) throws FileNotFoundException
    {
      ArrayList <Product> tempProducts = new ArrayList<Product>();
      String prodCat = "";
      String prodName = "";
      String price = "";
      String author = "";
      String title = "";
      String year = "";
      String info = "";
      String stock = "";

      File file = new File(fName);
      Scanner myReader = new Scanner(file);
      while(myReader.hasNextLine());
      {
        prodCat = myReader.nextLine();
        prodName = myReader.nextLine();
        price = myReader.nextLine();
        
        if (prodCat.equals("BOOKS"))
        {
          int paperStock = myReader.nextInt();
          String hardStock = myReader.nextLine();
          hardStock = hardStock.trim();
          info = myReader.nextLine();
          Scanner i = new Scanner(info);
          i.useDelimiter("[^a-zA-Z0-9\u002E\u002C\0021\s]");
          while (i.hasNext()){
            title = i.next();
            author = i.next();
            year = i.next();
          }
          tempProducts.add(new Book(prodName, generateProductId(), Double.parseDouble(price),paperStock, Integer.parseInt(hardStock), title, author, year));
        }

        else if(prodCat.equals("GENERAL") || prodCat.equals("COMPUTERS") || prodCat.equals("CLOTHING") || prodCat.equals("FURNITTURE"))
        {
          stock = myReader.nextLine();
          info = myReader.nextLine();
          Product.Category p =  Product.Category.valueOf(prodCat); 
          tempProducts.add(new Product(prodName, generateProductId(), Double.parseDouble(price), Integer.parseInt(stock), p));
        }
      }
      myReader.close();
      return tempProducts;
    }

}

class UnknownCustomerException extends RuntimeException
{
  UnknownCustomerException(String errorM)
  {
    super(errorM);
  }

}

class UnknownProductException extends RuntimeException
{
  UnknownProductException(String errorM)
  {
    super(errorM);
  }

}

class InvalidProductOptionsException extends RuntimeException
{
  InvalidProductOptionsException(String errorM)
  {
    super(errorM);
  }

}

class OutOfStockException extends RuntimeException
{
  OutOfStockException(String errorM)
  {
    super(errorM);
  }

}

class InvalidNameException extends RuntimeException
{
  InvalidNameException(String errorM)
  {
    super(errorM);
  }

}

class InvalidAddressException extends RuntimeException
{
  InvalidAddressException(String errorM)
  {
    super(errorM);
  }

}

class InvalidOrderNumberException extends RuntimeException
{
  InvalidOrderNumberException(String errorM)
  {
    super(errorM);
  }

}

class InvalidCartItemException extends RuntimeException
{
  InvalidCartItemException(String errorM)
  {
    super(errorM);
  }
}





