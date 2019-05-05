package fr.gsb.rv.entites;

public class Motif {

    private String code ;
    private int libelle ;

    public Motif(String code, int libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Motif() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLibelle() {
        return libelle;
    }

    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Motif{" +
                "code='" + code + '\'' +
                ", libelle=" + libelle +
                '}';
    }
}