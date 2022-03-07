package com.example.poshell.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Product product, int amount){
        for(Item item:items){
            if(item.getProduct() == product) {
                return item.add(amount);

            }
        }

        return items.add(new Item(product, amount));
    }

    public boolean removeItem(Product product, int amount){
        for(Item item:items){
            if(item.getProduct() == product)
                return item.remove(amount);
        }
        return false;
    }

    public boolean emptyCart(){
        items.clear();
        return true;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
