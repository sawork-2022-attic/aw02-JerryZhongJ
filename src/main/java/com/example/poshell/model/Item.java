package com.example.poshell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int amount;

    @Override
    public String toString(){
        return product.toString() +"\t" + amount;
    }

    public boolean add(int addAmount){
        amount += addAmount;
        return true;
    }

    public boolean remove(int rmAmount){
        if(amount < rmAmount)
            return false;

        amount -= rmAmount;
        return false;
    }
}
