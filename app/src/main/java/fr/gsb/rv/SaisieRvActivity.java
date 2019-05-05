package fr.gsb.rv;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.view.* ;
import android.widget.*;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import fr.gsb.rv.entites.*;
import fr.gsb.rv.modeles.ModeleGsb;

public abstract class SaisieRvActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner praticien, motif, coeff_confiance;

    private TextView tvDateVisite, tvPraticien, tvMotif, tvBilan, tvCoeffConfiance;

    private Button modifierDate, bValider, bAnnuler;

    private EditText etBilan;

    private RapportVisite rapport;

    private ListView lvSaisieEchantillons;

    private GregorianCalendar dateVisite;

    private Integer[] lesCoefficients = {0, 1, 2, 3, 4, 5};

    private List<Praticien> lesPraticiens = ModeleGsb.getInstance().getPraticiens() ;

    private List<Motif> lesMotifs = ModeleGsb.getInstance().getMotifs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_rv);

        // Les spinners déjà

        this.praticien = (Spinner) findViewById(R.id.praticien);
        this.praticien.setOnItemSelectedListener(this);

        this.motif = (Spinner) findViewById(R.id.motif);
        this.motif.setOnItemSelectedListener(this);

        this.coeff_confiance = (Spinner) findViewById(R.id.coeff_confiance);
        this.coeff_confiance.setOnItemSelectedListener(this);

        // Ensuite les TextView & EditText

        this.tvDateVisite = (TextView) findViewById(R.id.tvDateVisite);
        dateVisite = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateVisite.getTime();
        this.tvDateVisite.setText("Date de visite : " + dateFormat.format(date));

        this.etBilan = (EditText) findViewById(R.id.etBilan);

        // Puis les ArrayAdaptater !!

        ArrayAdapter<Praticien> Praticien = new ArrayAdapter<Praticien>(this, android.R.layout.simple_spinner_item, this.lesPraticiens);
        Praticien.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.praticien.setAdapter(Praticien);

        ArrayAdapter<Motif> Motif = new ArrayAdapter<Motif>(this, android.R.layout.simple_spinner_item, this.lesMotifs);
        Motif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.motif.setAdapter(Motif);

        ArrayAdapter<Integer> Coef = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, this.lesCoefficients);
        Coef.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.coeff_confiance.setAdapter(Coef);

        this.rapport = new RapportVisite();

        // Enfin les boutons

        this.modifierDate = (Button) findViewById(R.id.modifierDate);
        this.bValider = (Button) findViewById(R.id.bValider);
        this.bAnnuler = (Button) findViewById(R.id.bAnnuler);

    }

    public void modifierDate(View view){

        DatePickerDialog.OnDateSetListener ecouteur = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                String date = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
                SaisieRvActivity.this.tvDateVisite.setText("Date de visite : " + date);
                dateVisite = new GregorianCalendar(year, monthOfYear, dayOfMonth);
            }
        };

        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        int jour = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int mois = gregorianCalendar.get(Calendar.MONTH);
        int annee = gregorianCalendar.get(Calendar.YEAR);

        new DatePickerDialog(SaisieRvActivity.this, ecouteur, annee, mois, jour).show();
    }

}