package com.example.ngueu.comptable;

import android.icu.util.Currency;
import android.icu.util.CurrencyAmount;

import java.util.Locale;

public abstract class Operation {
    public static final String CREDIT = "crédit";
    public static final String DEBIT = "débit";

    private final String typeTransaction;
    private String libelle;
    private CurrencyAmount price;

    public Operation(String typeTransaction, String libelle, double price) {
        this.typeTransaction = typeTransaction;
        this.libelle = libelle;
        this.price = new CurrencyAmount(price, Currency.getInstance(new Locale("fr", "CH")));
    }

    public Operation(String typeTransaction) {
        this(typeTransaction, "", 0.00);
    }

    public String getLibelle(){
        return this.libelle;
    }

    public String getTypeTransaction() {
        return this.typeTransaction;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrice() {
        return this.price.getNumber().doubleValue();
    }

    public void setPrice(double newPrice) {
        this.price = new CurrencyAmount(newPrice, Currency.getInstance(new Locale("fr", "CH")));
    }
}
