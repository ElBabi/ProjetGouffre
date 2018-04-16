package com.example.mperson.projetjeu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Locale;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button flagen, flagfr;
    EditText Player1;
    EditText Player2;
    EditText Player3;
    EditText Player4;
    EditText Player5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        Button jeu = (Button)findViewById(R.id.butplay);
        jeu.setOnClickListener(this);
    }


    public void flagClick (View l){

        Button flagEN = (Button)findViewById(R.id.butflagen);
        flagEN.setOnClickListener(this);
       /* Button flagFR = (Button)findViewById(R.id.butflagfr);
        flagFR.setOnClickListener(this);*/

        //switch (l.getId()) {

          //  case (R.id.butflagen):
                String langage  = "en"; // ta langue
                Locale locale = new Locale(langage);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_menu);
               /* Intent lfr = new Intent(Menu.this, Menu.class);
                lfr.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(lfr);*/

              //  break;

            /*case  (R.id.butflagfr):
                String language  = "fr"; // ta langue
                Locale localfr = new Locale(language);
                Locale.setDefault(localfr);
                Configuration configfr = new Configuration();
                configfr.locale = localfr;
                getBaseContext().getResources().updateConfiguration(configfr, getBaseContext().getResources().getDisplayMetrics());


                Intent len = new Intent(Menu.this, Menu.class);
                len.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(len);

                break;
        }*/
    }

    public void onClick(View v) {
        // on récupère ce qu'on a écrit dans nos edittext sous forme de chaine de caractères
        Player1 = (EditText) findViewById(R.id.nomj1);
        Player2 = (EditText) findViewById(R.id.nomj2);
        Player3 = (EditText) findViewById(R.id.nomj3);
        Player4 = (EditText) findViewById(R.id.nomj4);
        Player5 = (EditText) findViewById(R.id.nomj5);

        //chaine de caractères
        String str = Player1.getText().toString();
        String str1 = Player2.getText().toString();
        String str2 = Player3.getText().toString();
        String str3 = Player4.getText().toString();
        String str4 = Player5.getText().toString();

        //ajout des edittext dans la liste
        ArrayList<String> listplay = new ArrayList<String>();
        listplay.add(str);
        listplay.add(str1);
        listplay.add(str2);
        listplay.add(str3);
        listplay.add(str4);


        //message d'alerte
        AlertDialog.Builder mess = new AlertDialog.Builder(Menu.this);
        //titre
        mess.setTitle("Attention");
        //message
        mess.setMessage("L'abus d'alcool est dangereux pour la santé");
        //button
        mess.setNeutralButton("OK", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }

        });
        mess.show();

        //changement d'activité
        Intent gouffre = new Intent(Menu.this, Game.class);
        //on va stocker et transférer des données
        Bundle nomplayer = new Bundle();
        nomplayer.putStringArrayList("Joueurs",listplay);
        gouffre.putExtras(nomplayer);
        //démarrage activité
        startActivity(gouffre);

    }


}
