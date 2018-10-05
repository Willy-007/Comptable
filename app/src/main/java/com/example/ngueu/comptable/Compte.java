package com.example.ngueu.comptable;

import java.util.LinkedList;

public class Compte {
    private String nomCompte;
    private final Company proprio;
    private LinkedList<Operation> listOperations;

    public Compte(String nomCompte, Company proprio) {
        this.nomCompte = nomCompte;
        this.proprio = proprio;
        this.listOperations = new LinkedList<>();
    }

    public void addOperation(String typeOperation, String libelle, double price) {
        switch (typeOperation) {
            case Operation.CREDIT :
                listOperations.add(new Credit(libelle, price));
                break;
            case Operation.DEBIT :
                listOperations.add(new Debit(libelle, price));
                break;
            default:
                break;
        }
    }

    public String getNomCompte() {
        return nomCompte;
    }
}
