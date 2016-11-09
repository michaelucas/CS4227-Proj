package BusinessLayer.CommandProduct;

import java.util.ArrayList;
import java.util.List;

   public class Stock {
   private List<Order> orderList = new ArrayList<>(); 

   public void takeOrder(Order order){
      orderList.add(order);
      order.execute();
   }

   public void placeOrders(){
   
      for (Order order : orderList) {
         order.execute();
      }
      orderList.clear();
   }
}
