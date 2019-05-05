package fr.gsb.rv.modeles;

import java.util.ArrayList;
import java.util.List ;

import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.gsb.rv.entites.*;


public class ModeleGsb {

    private static ModeleGsb modele = null ;

    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
    private List<Praticien> lesPraticiens = new ArrayList<Praticien>();
    private List<Medicament> lesMedicaments = new ArrayList<Medicament>();
    private List<Motif> lesMotifs = new ArrayList<Motif>();
    private List<RapportVisite> lesRapportsDeVisites = new ArrayList<RapportVisite>();

    private ModeleGsb(){
        super() ;
        this.peupler() ;
    }

    public static ModeleGsb getInstance(){
        if( ModeleGsb.modele == null ){
            modele = new ModeleGsb() ;
        }
        return ModeleGsb.modele ;
    }

    private void peupler(){
        this.lesVisiteurs.add( new Visiteur("a131","azerty","Villechalane","Louis") ) ;

        this.lesPraticiens.add(new Praticien(1, "Notini", "Alain"));

        this.lesMedicaments.add(new Medicament("3MYC7", "TRIMYCINE"));

        this.lesMotifs.add(new Motif("Périodicité", 1));

        this.lesRapportsDeVisites.add(new RapportVisite(1, "RAS", 2, new GregorianCalendar(2018, Calendar.MARCH, 3), new GregorianCalendar(2018, Calendar.MARCH, 5), true));

    }

    public Visiteur seConnecter(String matricule, String mdp){

        for( Visiteur unVisiteur : this.lesVisiteurs ){
            if( unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp) ){
                return unVisiteur ;
            }
        }

        return null ;

    }

    public List<Motif> getMotifs(){
        return this.lesMotifs;
    }

    public Motif getMotif(int code) {
        for (Motif unMotif : this.lesMotifs) {
            if (unMotif.getCode().equals(code)) {
                return unMotif;
            }
        }
        return null;
    }

    public List<Praticien> getPraticiens(){
        return this.lesPraticiens;
    }

    public Praticien getPraticien(int numero) {
        for (Praticien unPraticien : this.lesPraticiens) {
            if (unPraticien.getNumero() == numero) {
                return unPraticien;
            }
        }
        return null;
    }

    public List<Medicament> getLesMedicaments(){
        return this.lesMedicaments;
    }

    public Medicament getMedicament(String depotLegal) {
        for (Medicament unMedicament : this.lesMedicaments) {
            if (unMedicament.getDepotLegal().equals(depotLegal)) {
                return unMedicament;
            }
        }
        return null;
    }

    public List<RapportVisite> getRapportsDeVisites(Visiteur visiteur, int mois, int annee) {
        List<RapportVisite> rapports = new ArrayList<RapportVisite>();

        for (RapportVisite unRapport : this.lesRapportsDeVisites) {
            if (unRapport.getLeVisiteur().getMatricule().equals(visiteur.getMatricule())) {
                int m = unRapport.getDateVisite().get(Calendar.MONTH);
                if (m == mois - 1) {
                    if (unRapport.getDateVisite().get(Calendar.YEAR) == annee) {
                        rapports.add(unRapport);
                    }
                }
            }
        }

        return rapports;
    }

    public RapportVisite getUnRapport( int id ){

        for (RapportVisite unRapport : this.lesRapportsDeVisites) {
            if( id == unRapport.getNumero() ) {
                return unRapport;
            }
        }
        return null;
    }

}

