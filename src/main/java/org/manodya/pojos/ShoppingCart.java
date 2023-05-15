package org.manodya.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
   private long id;
   private List<Order> orders;
   private double value;
   private Status status;

   public enum Status{
      PENDING, DISPATCHED, CANCELLED
   }
}
