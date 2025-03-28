package com.lucio.crmspring.dto;

import java.util.List;

public class StatistiqueResponse {
    private int clients = 0;
    private int projets = 0;
    private int taches = 0;
    private int offres = 0;
    private int factures = 0;
    private int paiements = 0;
    private List<RevenuMensuel> revenus_mensuels;

    private Double sommeInvoice = 0.0;

    public Double getSommeInvoice() {
        return sommeInvoice;
    }

    public void setSommeInvoice(Double sommeInvoice) {
        this.sommeInvoice = sommeInvoice;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getProjets() {
        return projets;
    }

    public void setProjets(int projets) {
        this.projets = projets;
    }

    public int getTaches() {
        return taches;
    }

    public void setTaches(int taches) {
        this.taches = taches;
    }

    public int getOffres() {
        return offres;
    }

    public void setOffres(int offres) {
        this.offres = offres;
    }

    public int getFactures() {
        return factures;
    }

    public void setFactures(int factures) {
        this.factures = factures;
    }

    public int getPaiements() {
        return paiements;
    }

    public void setPaiements(int paiements) {
        this.paiements = paiements;
    }

    public List<RevenuMensuel> getRevenusMensuels() {
        return revenus_mensuels;
    }

    public void setRevenusMensuels(List<RevenuMensuel> revenusMensuels) {
        this.revenus_mensuels = revenusMensuels;
    }
}
