package com.example.ngueu.comptable;

public class Debit extends Operation {

    public Debit(String libelle, double price) {
        super(Operation.DEBIT, libelle, price);
    }

    public Debit() {
        this("", 0.00);
    }
}
