/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiscountCalc {

    public List<Product> getDiscount(Long totalAmount, List<Product> productList) {
        Long totalPrice = 0L;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        for (Product p : productList) {
            if (map.containsKey(p.getUnitPrice())) {
                map.put(p.getUnitPrice(), map.get(p.getUnitPrice()) + 1);
            } else {
                map.put(p.getUnitPrice(), 1);
            }
        }

        Iterator<Entry<Long, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>) it.next();
            Long unitPrice = (Long) entry.getKey();
            Integer count = (Integer) entry.getValue();
            totalPrice += unitPrice * count;
        }

        for (Product p : productList) {
            Long tempAmount = (p.getUnitPrice() * totalAmount) / (totalPrice);
            p.setAmount(tempAmount);
        }

        return productList;
    }

    public static void main(String[] args) {
        Product a = new Product();
        a.setUnitPrice(50L);
        List<Product> p = new ArrayList<Product>();
        p.add(a);
        p.add(a);

        Product b = new Product();
        b.setUnitPrice(40L);
        p.add(b);

        Product c = new Product();
        c.setUnitPrice(10L);
        p.add(c);

        DiscountCalc d = new DiscountCalc();
        d.getDiscount(130L, p);
        for (Product tp : p) {
            System.out.println(" " + tp.getUnitPrice() + " -->" + tp.getAmount());
        }

    }
}

class Product {
    /*
     * 产品单价
     */
    private Long unitPrice;
    /*
     * 产品数量
     */
    private int quantity;

    /*
     * 产品分摊所得金额
     */
    private Long amount;

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
