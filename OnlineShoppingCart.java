import java.util.ArrayList;


class Product{
    private int productID;
    private String Name;
    private double price;
    private int stockQuantity;
   
   public Product(int ProductID,String Name,double price,int stockQuantity){
        this.productID=productID;
        this.Name=Name;
        this.price=price;
        this.stockQuantity=stockQuantity;
   }

    public void displayProductInfo(){ 
    System.out.println("ID:"+productID+", ProductName:"+Name+", price:"+price+", stockQuantity:"+stockQuantity);
    }
    
    public void updateStock(int quantity){

        stockQuantity+=quantity;
        System.out.println("Stock updated to "+stockQuantity+" successfully");
    }
    
    
 }
 
class ShoppingCart{
   ArrayList<Product> cartItems = new ArrayList<>();
   
   public void addProduct(Product product,int quantity){
        cartItems.add(product);
        System.out.println(" added to cart");
        product.updateStock(quantity);
  }
  
  public void removeProduct(Product product){
    cartItems.remove(product);
    System.out.println(" removed from cart");
 }
  
  public void calculateTotal(){
  
  }
  
  public void  checkout(){
  
  }
   
   public void DisplaycartItems(){
      
    }
  
   
}


class Customer{
 private int customerID;
 private String Name;
 private ShoppingCart cart;
  
  public Customer(int customerID,String Name){
     this.customerID = customerID;
     this.Name = Name;
     this.cart =new ShoppingCart();
  }
 
 public void addToCart(Product product,int quantity){
      cart.addProduct(product,quantity);
  }
  
  public void removeFromCart(Product product){
      cart.removeProduct(product);
  }
  
  public void placeOrder(){
   
  }
   
   public void customerDetails()
   {
     System.out.println("CustomerID:"+customerID+", Name:"+Name);
    
   }
   
  
}

 
class Order{
   private int orderID;
   private String customer;
   private double  totalAmount; 
   ArrayList<Product> orderProduct = new ArrayList<>();
 
   public void displayOrderDetails(){
   
  } 
 
   
}

 public class OnlineShoppingCart{
    public static  void main(String[] args){
     Product p1 = new Product(1,"5-Star",10,50);
     p1.displayProductInfo();
     Product p2 = new Product(2,"Kinder-JOY",10,50);
     p2.displayProductInfo();
     p1.updateStock(100);
     
     Customer c1 =new Customer (224216,"Charan");
     c1.addToCart(p1,10);
     c1.addToCart(p2,10);
     c1.removeFromCart(p1);
  } 

}
