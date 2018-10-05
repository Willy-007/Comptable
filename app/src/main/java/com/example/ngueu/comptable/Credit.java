package com.example.ngueu.comptable;

public class Credit extends Operation {
    public Credit(String libelle, double price) {
        super(Operation.CREDIT, libelle, price);
    }

    public Credit() {
        this("", 0.00);
    }
}
