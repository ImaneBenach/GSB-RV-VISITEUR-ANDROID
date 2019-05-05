package fr.gsb.rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;
import fr.gsb.rv.entites.RapportVisite;
import fr.gsb.rv.modeles.ModeleGsb;



public class ListeRvActivity extends AppCompatActivity {

    TextView tvSelection ;

    ListView mListView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        tvSelection = (TextView) findViewById(R.id.tvSelection);
        mListView = (ListView) findViewById(R.id.mListeView);

        Visiteur leVisiteur = Session.getSession().getLeVisiteur() ;

        Bundle bundle = this.getIntent().getExtras() ;
        int mois = Integer.parseInt( bundle.getString("mois") ) ;
        int annee = Integer.parseInt( bundle.getString("annee") ) ;

        List<RapportVisite> rapport_visite = ModeleGsb.getInstance().getRapportsDeVisites( leVisiteur, mois, annee );

        ArrayAdapter<RapportVisite> adapter_Rapport_Visite = new ArrayAdapter<RapportVisite>( this,android.R.layout.simple_list_item_1,rapport_visite );

        mListView.setAdapter( adapter_Rapport_Visite );


    }
}