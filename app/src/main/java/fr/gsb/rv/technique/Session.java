package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public class Session {

    private static Session session = null ;
    private Visiteur leVisiteur = null ;

    private Session(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur ;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public static Session getSession() {
        return Session.session;
    }

    public static void ouvrir(Visiteur leVisiteur){
        Session.session = new Session( leVisiteur ) ;

    }

    public static void fermer(){

        Session.session = null ;

    }

}