package com.hello.core.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int dicountPrice;
}
