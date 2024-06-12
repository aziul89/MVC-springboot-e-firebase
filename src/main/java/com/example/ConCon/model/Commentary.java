package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Commentary { 
    private List<Product> productsCommentary; 
    private int nameCommentaryList; 

    
    public Commentary() {
        this.productsCommentary = new ArrayList<>();
    }

    
    public List<Product> getProductsCommentary() {
        return new ArrayList<>(productsCommentary);
    }

    public void setProductsCommentary(List<Product> productsCommentary) {
        this.productsCommentary = new ArrayList<>(productsCommentary); 
    }

   
    public int getNameCommentaryList() {
        return nameCommentaryList;
    }

    public void setNameCommentaryList(int nameCommentaryList) {
        this.nameCommentaryList = nameCommentaryList;
    }
}
