package com.lucio.crmspring.dto;

public class RevenuMensuel {
    private int annee;
    private int mois;
    private double total;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public double getMontant() {
        return total;
    }

    public void setMontant(double montant) {
        this.total = montant;
    }
}

