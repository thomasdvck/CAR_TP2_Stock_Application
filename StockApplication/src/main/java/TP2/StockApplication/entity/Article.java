package TP2.StockApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    private String nom;
    private int quantite;

    public Article() {}
    public Article(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
}
