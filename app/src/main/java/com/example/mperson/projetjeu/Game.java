package com.example.mperson.projetjeu;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class Game extends AppCompatActivity implements View.OnClickListener{

    Button play;
    Button nbde;
    Button inter;
    Button un,deux,trois,quatre,cinq,six,sept,huit,neuf,dix,onze,douze,treize,quatorze,quinze,seize,dixsept,dixhuit,dixneuf,vingt,vingt1,vingt2,vingt3,vingt4;
    TextView des;
    public ImageView stop,jager,captain,jack,plot;

    private View.OnClickListener affichage_de = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            deClick();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        //imageview
        stop = (ImageView) findViewById(R.id.p1);
        jack = (ImageView) findViewById(R.id.p2);
        jager = (ImageView) findViewById(R.id.p3);
        plot = (ImageView) findViewById(R.id.p4);
        captain = (ImageView) findViewById(R.id.p5);

        //mouvement image
        stop.setOnTouchListener(move);
        jack.setOnTouchListener(move);
        jager.setOnTouchListener(move);
        plot.setOnTouchListener(move);
        captain.setOnTouchListener(move);


        //textview
        des = (TextView) findViewById(R.id.des);
        //tourj = (TextView) findViewById(R.id.tourjoueur);

        //boutons
        play = (Button)findViewById(R.id.buttdep);
        play.setOnClickListener(this);


        //de
        nbde = (Button)findViewById(R.id.buttde);
        nbde.setOnClickListener(affichage_de);

        //récupération des joueurs de l'activité principale
        Bundle j = getIntent().getExtras();

        if (j != null){

            //déclare la liste
           ArrayList nameplayer = new ArrayList();
            nameplayer = j.getStringArrayList("Joueurs");// vérifie qu'une valeur est associé à ma clé joueurs

            // on récupère la liste avec un adapteur
            ListView lv = (ListView) findViewById(R.id.lv1);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Game.this,
                    android.R.layout.simple_list_item_1, nameplayer);
            lv.setAdapter(adapter);

       }
    }

    // tour du joueur => à chaque début il lance l'activité du dé puis l'activité du dé se ferme et le pion avance de x cases => arrivé sur la case
    // une question s'affiche puis se ferme tour du joueur suivant
    // fonction qui test le tour du joueur
    // fonction action du joueur ( la fonction du de )
    // liste des boutons pour les récupérer
    // 3eme fonction qui amène sur une 3eme activité des questions
    //récupérer l'avancé de chacun dans l'edit text
    // fonction lancé de dés + affichage

    //LectureActivity.this.finish(); finir une activité

    /* ou méthode suivante
    * si tour joueur 1 = j 1
    * déplace l'image sur la case
    * action de la case
    * sinon rien
    *
    *
    * */
    public void deplacement (){
        int tourjoueur=0;
        if (tourjoueur == 0) {


        }

    }

    private View.OnTouchListener move = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    v.setX(event.getX() + v.getX());
                    v.setY(event.getY() + v.getY());
                    break;
                case MotionEvent.ACTION_MOVE:
                    v.setX(event.getX() + v.getX());
                    v.setY(event.getY() + v.getY());
                    break;
                case MotionEvent.ACTION_UP:
                    v.setX(event.getX() + v.getX());
                    v.setY(event.getY() + v.getY());
                    break;
            }
            return true;
        }
    };

    public void onClick (View v) {
        //liste de bouttons
        ArrayList<Button> listb = new ArrayList<Button>();

        listb.add(inter=(Button) findViewById(R.id.buttinterro));
        listb.add(un=(Button) findViewById(R.id.butt1));
        listb.add(deux=(Button) findViewById(R.id.butt2));
        listb.add(trois=(Button) findViewById(R.id.butt3));
        listb.add(quatre=(Button) findViewById(R.id.butt4));
        listb.add(cinq=(Button) findViewById(R.id.butt5));
        listb.add(six=(Button) findViewById(R.id.butt6));
        listb.add(sept=(Button) findViewById(R.id.butt7));
        listb.add(huit=(Button) findViewById(R.id.butt8));
        listb.add(neuf=(Button) findViewById(R.id.butt9));
        listb.add(dix=(Button) findViewById(R.id.butt10));
        listb.add(onze=(Button) findViewById(R.id.butt11));
        listb.add(douze=(Button) findViewById(R.id.butt12));
        listb.add(treize=(Button) findViewById(R.id.butt13));
        listb.add(quatorze=(Button) findViewById(R.id.butt14));
        listb.add(quinze=(Button) findViewById(R.id.butt15));
        listb.add(seize=(Button) findViewById(R.id.butt16));
        listb.add(dixsept=(Button) findViewById(R.id.butt17));
        listb.add(dixhuit=(Button) findViewById(R.id.butt18));
        listb.add(dixneuf=(Button) findViewById(R.id.butt19));
        listb.add(vingt=(Button) findViewById(R.id.butt20));
        listb.add(vingt1=(Button) findViewById(R.id.butt21));
        listb.add(vingt2=(Button) findViewById(R.id.butt22));
        listb.add(vingt3=(Button) findViewById(R.id.butt23));
        listb.add(vingt4=(Button) findViewById(R.id.butt24));

        // clic bouton
        for (int i = 0; i < listb.size(); i++) {
            final Button oieButton = listb.get(i);
            oieButton.setOnClickListener(this);
        }

        //si le bouton est cliqué il affiche le message souhaité
        switch (v.getId()) {

            case (R.id.buttinterro):

                //changement d'activité
                Intent aide = new Intent(Game.this, Questions.class);

                //démarrage activité
                startActivity(aide);

                break;

            case (R.id.butt1):

                AlertDialog.Builder q1 = new AlertDialog.Builder(Game.this);
                //title
                q1.setTitle("Une bouffée d'oxygène dans la bouche");
                //message
                q1.setMessage("Rajoute de la potion dans ton verre");

                //boutton
                q1.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q1.show();

                break;
            case (R.id.butt2):
                AlertDialog.Builder q2 = new AlertDialog.Builder(Game.this);
                //title
                q2.setTitle("2 d'tensions");
                //message
                q2.setMessage("Tu tournes en rond comme un vinyle, tu bois 2 gorgées");

                //boutton
                q2.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q2.show();
                break;
            case (R.id.butt3):
                AlertDialog.Builder q3 = new AlertDialog.Builder(Game.this);
                //title
                q3.setTitle("Cheval de 3");
                //message
                q3.setMessage("Tu à réussi à voler un joker au jeu, champion tu bois 3 gorgées à ta victoire");

                //boutton
                q3.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q3.show();
                break;
            case (R.id.butt4):
                AlertDialog.Builder q4 = new AlertDialog.Builder(Game.this);
                //title
                q4.setTitle("4 3 2 1");
                //message
                q4.setMessage("Tout le monde bois une gorgée, le dernier à la boire en reboit 2");

                //boutton
                q4.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q4.show();
                break;
            case (R.id.butt5):
                AlertDialog.Builder q5 = new AlertDialog.Builder(Game.this);
                //title
                q5.setTitle("Les 5 frères");
                //message
                q5.setMessage("On t'offre à boire, bois 2 gorgées dans le verre de ton choix");

                //boutton
                q5.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q5.show();
                break;
            case (R.id.butt6):
                AlertDialog.Builder q6 = new AlertDialog.Builder(Game.this);
                //title
                q6.setTitle("6 pieds sous terre");
                //message
                q6.setMessage("Extermine le joueur de ton choix et il boit 6 gorgées");

                //boutton
                q6.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q6.show();
                break;
            case (R.id.butt7):
                AlertDialog.Builder q7 = new AlertDialog.Builder(Game.this);
                //title
                q7.setTitle("Blanche neige et les septs mains");
                //message
                q7.setMessage("Tous les joueurs lancent le dé sauf toi, ceux qui feront un 3 iront sur la case 13 et en paieront les conséquences");

                //boutton
                q7.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q7.show();
                break;
            case (R.id.butt8):
                AlertDialog.Builder q8 = new AlertDialog.Builder(Game.this);
                //title
                q8.setTitle("8 miskine");
                //message
                q8.setMessage("Passe un tour");

                //boutton
                q8.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q8.show();
                break;
            case (R.id.butt9):
                AlertDialog.Builder q9 = new AlertDialog.Builder(Game.this);
                //title
                q9.setTitle("9 queues du renard");
                //message
                q9.setMessage("T'es chanceux, tu gagnes un joker");

                //boutton
                q9.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q9.show();
                break;
            case (R.id.butt10):
                AlertDialog.Builder q10 = new AlertDialog.Builder(Game.this);
                //title
                q10.setTitle("1 de perdue 10 de retrouver");
                //message
                q10.setMessage("T'es tombé sur la mauvaise chienne, bois 2 gorgées");

                //boutton
                q10.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q10.show();
                break;
            case (R.id.butt11):
                AlertDialog.Builder q11 = new AlertDialog.Builder(Game.this);
                //title
                q11.setTitle("11 septembre ");
                //message
                q11.setMessage("Ben Laden te salut. Passe 1 tour");

                //boutton
                q11.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q11.show();
                break;
            case (R.id.butt12):
                AlertDialog.Builder q12 = new AlertDialog.Builder(Game.this);
                //title
                q12.setTitle("Les 12 coups de minuit");
                //message
                q12.setMessage("L'heure du crime... lance le dé et fais boire le nombre de gorgées indiquées au joueur de ton choix");

                //boutton
                q12.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q12.show();
                break;
            case (R.id.butt13):
                AlertDialog.Builder q13 = new AlertDialog.Builder(Game.this);
                //title
                q13.setTitle("Vendredi 13");
                //message
                q13.setMessage("Tous tes malheurs sont doublés jusqu'à la fin de la partie");

                //boutton
                q13.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q13.show();
                break;
            case (R.id.butt14):
                AlertDialog.Builder q14 = new AlertDialog.Builder(Game.this);
                //title
                q14.setTitle("Début de la guerre 14/18");
                //message
                q14.setMessage("Attends qu'un joueur fasse un 6 pour que la guerre finisse. Direction la case 18 si tu gagnes sinon tu bois une gorgée à chaque défaite");

                //boutton
                q14.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q14.show();
                break;
            case (R.id.butt15):
                AlertDialog.Builder q15 = new AlertDialog.Builder(Game.this);
                //title
                q15.setTitle("15 c'est le samu");
                //message
                q15.setMessage("C'est parti pour un tour d'ambulance, lance le dés et recule du nombre de cases indiqué");

                //boutton
                q15.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q15.show();
                break;
            case (R.id.butt16):
                AlertDialog.Builder q16 = new AlertDialog.Builder(Game.this);
                //title
                q16.setTitle("16ans t'as le droit à de la bière lol");
                //message
                q16.setMessage("Ici c'est le gouffre on plaisante pas, prends un shooter");

                //boutton
                q16.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q16.show();
                break;
            case (R.id.butt17):
                AlertDialog.Builder q17 = new AlertDialog.Builder(Game.this);
                //title
                q17.setTitle("17h tu vomis ");
                //message
                q17.setMessage("Avance de 7 cases et bois 1 gorgée");

                //boutton
                q17.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q17.show();
                break;
            case (R.id.butt18):
                AlertDialog.Builder q18 = new AlertDialog.Builder(Game.this);
                //title
                q18.setTitle("Fin de la guerre");
                //message
                q18.setMessage("Armistice de l'apéro, tout le monde bois 2 gorgées ");

                //boutton
                q18.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q18.show();
                break;
            case (R.id.butt19):
                AlertDialog.Builder q19 = new AlertDialog.Builder(Game.this);
                //title
                q19.setTitle("19 quoi de neuf ?");
                //message
                q19.setMessage("Casse toi la gueule : Tous les adversaires lancent le dés et boivent le nombre de gorgées indiquées");

                //boutton
                q19.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q19.show();
                break;
            case (R.id.butt20):
                AlertDialog.Builder q20 = new AlertDialog.Builder(Game.this);
                //title
                q20.setTitle("20 c'est l'heure du vin");
                //message
                q20.setMessage("Choisis le joueur de ton choix pour une partie de pierre feuille ciseaux. Le perdant prend un cul sec");

                //boutton
                q20.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q20.show();
                break;
            case (R.id.butt21):
                AlertDialog.Builder q21 = new AlertDialog.Builder(Game.this);
                //title
                q21.setTitle("21 sale catin");
                //message
                q21.setMessage("On t'a pété les reins, tu boites, le SAMU viens te chercher, retourne sur la case 15");

                //boutton
                q21.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q21.show();
                break;
            case (R.id.butt22):
                AlertDialog.Builder q22 = new AlertDialog.Builder(Game.this);
                //title
                q22.setTitle("22 t'es un Dieu");
                //message
                q22.setMessage("Tu es invincible comme Schwarzy, tu gagnes un joker et bois 2 gorgées");

                //boutton
                q22.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q22.show();
                break;
            case (R.id.butt23):
                AlertDialog.Builder q23 = new AlertDialog.Builder(Game.this);
                //title
                q23.setTitle("23 qu'est ce que tu crois ?");
                //message
                q23.setMessage("Retourne sur la case 6");

                //boutton
                q23.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q23.show();
                break;
            case (R.id.butt24):
                AlertDialog.Builder q24 = new AlertDialog.Builder(Game.this);
                //title
                q24.setTitle("24 retourne te battre");
                //message
                q24.setMessage("Le gouffre te la fait toujours à l'envers. On ne peut pas sortir du gouffre, fais toi une raison.. Finis ton verre et savoure la défaite !");

                //boutton
                q24.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                //afficher alerte
                q24.show();
                break;
        /*//changement d'activité
        Intent defis = new Intent(Game.this, Questions.class);
        //on va stocker et transférer des données
        //Bundle defisbundle = new Bundle();
        //defisbundle.;
        //defis.putExtras(defisbundle);
        //démarrage activité
        startActivity(defis);*/

        }
    }




    public void deClick(){

        String affde;
        int de=0;

        de = 1 + (int) (Math.random()*6);
        affde = Integer.toString(de);

        des.setText(affde);

    }

        }

        /*struct joueur
                {
                int idJoueur;
                bool IA;
                }

                int OnExecute(struct joueur)
                {
                if (joueur.IA == true)
                OnExecuteIA()
                else
                OnExecuteJoueur()
                }

                while (endGame)
                {
                if (joueur.idJoueur == idJoueurQuiACliquer)
                OnExecute(joueur);
                else
                printf("Ce n'est pas ton tour de jouer !")
                }*/



