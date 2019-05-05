package fr.gsb.rv.entites;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class RapportVisite {

    private int numero ;
    private int coefConfiance ;

    private String bilan ;

    private boolean lu ;

    private GregorianCalendar dateVisite ;
    private GregorianCalendar dateRedaction ;

    private Praticien lePraticien ;
    private Visiteur leVisiteur ;
    private Motif leMotif ;
    private Map<Medicament,Integer> lesEchantillons = new HashMap<Medicament,Integer>() ;

    public RapportVisite() {
    }

    public RapportVisite(int numero, int coefConfiance, String bilan, boolean lu, GregorianCalendar dateVisite, GregorianCalendar dateRedaction, Praticien lePraticien, Visiteur leVisiteur, Motif leMotif, Map<Medicament, Integer> lesEchantillons) {
        this.numero = numero;
        this.coefConfiance = coefConfiance;
        this.bilan = bilan;
        this.lu = lu;
        this.dateVisite = dateVisite;
        this.dateRedaction = dateRedaction;
        this.lePraticien = lePraticien;
        this.leVisiteur = leVisiteur;
        this.leMotif = leMotif;
        this.lesEchantillons = lesEchantillons;
    }

    public RapportVisite(int numero, int coefConfiance, String bilan, boolean lu, GregorianCalendar dateVisite, GregorianCalendar dateRedaction) {
        this.numero = numero;
        this.coefConfiance = coefConfiance;
        this.bilan = bilan;
        this.lu = lu;
        this.dateVisite = dateVisite;
        this.dateRedaction = dateRedaction;
    }

    public RapportVisite(int numero, String ras, int i, GregorianCalendar gregorianCalendar, GregorianCalendar dateVisite, boolean b) {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCoefConfiance() {
        return coefConfiance;
    }

    public void setCoefConfiance(int coefConfiance) {
        this.coefConfiance = coefConfiance;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public GregorianCalendar getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(GregorianCalendar dateVisite) {
        this.dateVisite = dateVisite;
    }

    public GregorianCalendar getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(GregorianCalendar dateRedaction) {
        this.dateRedaction = dateRedaction;
    }

    public Praticien getLePraticien() {
        return lePraticien;
    }

    public void setLePraticien(Praticien lePraticien) {
        this.lePraticien = lePraticien;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public void setLeVisiteur(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur;
    }

    public Motif getLeMotif() {
        return leMotif;
    }

    public void setLeMotif(Motif leMotif) {
        this.leMotif = leMotif;
    }

    public Map<Medicament, Integer> getLesEchantillons() {
        return lesEchantillons;
    }

    public void setLesEchantillons(Map<Medicament, Integer> lesEchantillons) {
        this.lesEchantillons = lesEchantillons;
    }

    @Override
    public String toString() {
        return "RapportVisite{" +
                "numero=" + numero +
                ", coefConfiance=" + coefConfiance +
                ", bilan='" + bilan + '\'' +
                ", lu=" + lu +
                ", dateVisite=" + dateVisite +
                ", dateRedaction=" + dateRedaction +
                ", lePraticien=" + lePraticien +
                ", leVisiteur=" + leVisiteur +
                ", leMotif=" + leMotif +
                ", lesEchantillons=" + lesEchantillons +
                '}';
    }
}