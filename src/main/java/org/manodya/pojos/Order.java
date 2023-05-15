package org.manodya.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private final long id;
    private final long productId;
    private final int quantity;
    private final double value;
}
