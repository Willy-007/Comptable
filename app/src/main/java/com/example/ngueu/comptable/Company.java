package com.example.ngueu.comptable;


import java.util.HashMap;
import java.util.LinkedList;

public class Company {
    private String companyName;
    private HashMap<String, Compte> listComptes;

    public Company(String companyName) {
        this.companyName = companyName;
        this.listComptes = new HashMap<>();
    }

    public void makeTransaction(String nomCompte, String typeTransaction, String libelle, double price ){
        listComptes.get(nomCompte).addOperation(typeTransaction, libelle, price);
    }

    public void addAccount(Compte newCompte) {
        listComptes.put(newCompte.getNomCompte(), newCompte);
    }
}
