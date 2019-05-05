package fr.gsb.rv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.gsb.rv.technique.Session;
import fr.gsb.rv.entites.Visiteur;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MenuRvActivity extends AppCompatActivity {

    ImageView accueil ;

    TextView visiteur ;

    Button consulter ;
    Button saisir ;

    TextView resultat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);

        this.accueil = (ImageView) findViewById(R.id.accueil);

        this.visiteur = (TextView) findViewById(R.id.visiteur) ;

        this.consulter = (Button) findViewById(R.id.consulter);
        this.saisir = (Button) findViewById(R.id.saisir) ;


        // Pour afficher nom de l'utilisateur

        Log.e("GSB-RV-MRA" , "" + Session.getSession().getLeVisiteur()) ;
        visiteur.setText("Bonjour "+ Session.getSession().getLeVisiteur().getNom() + " " + Session.getSession().getLeVisiteur().getPrenom() + "!") ;


        // Création SimpleDateFormat

        SimpleDateFormat heure = new SimpleDateFormat("HH");
        SimpleDateFormat minute = new SimpleDateFormat("mm");

        Calendar c = Calendar.getInstance();

        //Je sépare en 2 variables l'heure et la minute.
        String heure1 = heure.format(c.getTime());
        String minute1 = minute.format(c.getTime());

        // Dans résultat je stock mon heure

        resultat = (TextView)findViewById(R.id.resulat);
        resultat.setText("Il est " + heure1 + " heures et "+ minute1 +" minutes.");
    }

    public void Consulter(View vue){
        consulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this,RechercheRvActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Saisir (View view) {
        saisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this,SaisieRvActivity.class);
                startActivity(intent);
            }
        });
    }
}
