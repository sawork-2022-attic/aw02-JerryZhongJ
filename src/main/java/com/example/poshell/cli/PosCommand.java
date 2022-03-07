package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethod(value="Print items in cart", key="print-cart")
    public String printCart(){
        return posService.getCart().toString();
    }

    @ShellMethod(value="Empty cart", key="empty")
    public String emptyCart(){
        if(posService.empty())
            return posService.getCart().toString();
        else
            return "Error";
    }
    @ShellMethod(value="Remove products from cart", key="remove")
    public String removeCart(String productId, int amount){
        if(posService.remove(productId, amount))
            return posService.getCart().toString();
        else
            return "Error";
    }

}
