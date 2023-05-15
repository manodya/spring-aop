package org.manodya;


import org.manodya.config.ProjectConfigs;
import org.manodya.pojos.Order;
import org.manodya.pojos.ShoppingCart;
import org.manodya.services.CartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigs.class);
        CartService cartService = context.getBean(CartService.class);

        /*----@Before---*/
        /*cartService.getShoppingCart();*/

        /*-- @AfterThrowing  && @After-*/
        /* cartService.throwException(2);*/


        /*--@Around  && @AfterReturning---*/
        ShoppingCart shoppingCart = new ShoppingCart(1, null, 0, ShoppingCart.Status.PENDING);
        Order order = new Order(1,1,10, 100);
        cartService.addOrder(shoppingCart , new Order(1,1,10, 100));
        cartService.getCartValue(shoppingCart);
    }
}