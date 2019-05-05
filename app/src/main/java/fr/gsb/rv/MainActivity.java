package fr.gsb.rv;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request ;
import com.android.volley.RequestQueue ;
import com.android.volley.Response ;
import com.android.volley.VolleyError ;
import com.android.volley.toolbox.JsonObjectRequest ;
import com.android.volley.toolbox.Volley ;

import org.json.JSONException ;
import org.json.JSONObject ;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;


public class MainActivity extends AppCompatActivity {

    //Déclarer les attributs présents dans l'activity-main.xml

    ImageView image ;

    TextView tvMatricule ;
    EditText etMatricule ;

    TextView tvMdp ;
    EditText etMdp ;

    /* TextView tvErreur ; */

    Button bValider ;
    Button bAnnuler ;

    private static final String TAG = "GSB_MAIN_ACTIVITY" ;


    //@Override : permet d'indiquer que l'on va redéfinir une méthode qui existait auparavant dans la classe parente.
    // OnCreate : Cette méthode est la première qui est lancée au démarrage d'une application,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Déclarations des attributs.

        this.image = (ImageView) findViewById(R.id.image);

        this.tvMatricule = (TextView) findViewById(R.id.tvMatricule);
        this.etMatricule = (EditText) findViewById(R.id.etMatricule);

        this.tvMdp = (TextView) findViewById(R.id.tvMdp);
        this.etMdp = (EditText) findViewById(R.id.etMdp);

        /* this.tvErreur = (TextView) findViewById(R.id.tvErreur); */

        this.bValider = (Button) findViewById(R.id.bValider);
        this.bAnnuler = (Button) findViewById(R.id.bAnnuler);

        // Log.i : Message d'information  dans le LogCat.

        Log.i(TAG, "Création de l'activité principale !") ;

        /*
        bValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuRvActivity.class);
                startActivity(intent);
            }
        });
        */

    }

    //seConnecter : Tentative d'ouverture de la session.
    public void seConnecter(View view){

        String matricule = etMatricule.getText().toString();
        String mdp = etMdp.getText().toString();

        //matricule = "a131" ;
        //mdp = "azerty" ;

        String url = String.format( "http://192.168.104.209:5000/visiteurs/%s/%s" , matricule , mdp ) ;
        Log.i("GSB-RV-MRA" , ">>> " + url) ;


        //Création d'écouteurs
        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Visiteur visiteur = new Visiteur() ;
                System.out.println("> " + response.toString());
                try
                {
                    visiteur.setMatricule( response.getString( "vis_matricule" ) );
                    visiteur.setNom( response.getString( "vis_nom" ) ) ;
                    visiteur.setPrenom( response.getString( "vis_prenom" ) ) ;
                    System.out.println( visiteur ) ;
                    Session.ouvrir( visiteur );
                    Log.i("GSB-RV-MRA" , "" + Session.getSession()) ;
                    Log.i("GSB-RV-MRA" , "" + Session.getSession().getLeVisiteur()) ;
                    //Toast.makeText(MainActivity.this,"Connexion réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MenuRvActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Bienvenue ! " , Toast.LENGTH_SHORT).show();
                }


                catch (JSONException e)
                {
                    System.out.println("Nok : " + e.getMessage());
                }

                System.out.println("HTTP OK");

            }

        } ;

        Response.ErrorListener ecouteurErreur = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("HTTP Error > " + error.toString() );
            }

        } ;

        JsonObjectRequest requete = new JsonObjectRequest(Request.Method.GET , url, null, ecouteurReponse, ecouteurErreur);
        RequestQueue fileRequete = Volley.newRequestQueue(this) ;
        fileRequete.add(requete) ;

    }

    // Annuler : Initialisation des champs.
    public void Annuler(View view){

        etMatricule.setText("");
        etMdp.setText("");

        Toast.makeText(MainActivity.this,"Veuillez renseigner vos identifiants",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Initialisation des champs");
    }
}

