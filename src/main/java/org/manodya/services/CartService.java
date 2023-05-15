package org.manodya.services;

import org.manodya.aspects.interfaces.LogAspect;
import org.manodya.pojos.Order;
import org.manodya.pojos.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class CartService {

    private static final Logger logger = Logger.getLogger(CartService.class.getName());

    public ShoppingCart getShoppingCart(){
        logger.info("#####Creating a new ShoppingCart.");
        return new ShoppingCart();
    }

    @LogAspect
    public void addOrder(ShoppingCart cart, Order order){

        cart.setOrders(Arrays.asList(order));
        cart.setValue(order.getValue());
        cart.setStatus(ShoppingCart.Status.PENDING);
    }


    public double getCartValue(ShoppingCart cart){
        return cart.getValue();
    }


    public void throwException(int number){
        if(number % 2 == 0){
            throw  new RuntimeException("Even Number Exception");
        }
    }


}
