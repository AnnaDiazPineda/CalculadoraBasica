package dsa.eetac.upc.edu.calculadorabasica;

import android.content.Context;
import android.content.Intent;
import android.media.VolumeShaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener , Serializable{

    String tag = "Calculadora_Basica"; //tag per indicar cicle de vida de la app

    EditText numero1, numero2;
    Button suma, resta, multiplicacio,divisio, esborrar, veureHistorial;
    TextView resultat;
    StringBuilder concatenar = new StringBuilder();

    private static ArrayList<String> historialOperacions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"Event onCreate()");



         numero1 = (EditText) findViewById(R.id.num1) ;
         numero2 = (EditText) findViewById(R.id.num2) ;

         suma = (Button) findViewById(R.id.bsumar);
         resta = (Button) findViewById(R.id.brestar);
         multiplicacio = (Button) findViewById(R.id.bmultiplicar);
         divisio = (Button) findViewById(R.id.bdividir);
         esborrar = (Button) findViewById(R.id.besborrar);
         veureHistorial = (Button) findViewById(R.id.bverHistorial);

        resultat = (TextView) findViewById(R.id.bresultat);

        //declaració de events, aquests estan associats als events,
        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        divisio.setOnClickListener(this);
        multiplicacio.setOnClickListener(this);
        esborrar.setOnClickListener(this);

        veureHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Historial.class);

                //primer li haig de dir com es diu
                intent.putStringArrayListExtra("HISTORIAL", historialOperacions);
                startActivity(intent);

            }
        });






    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "Event onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "Event onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "Event onPause()");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "Event onStop()");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(tag, "Event onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Event onDestroy()");

    }


    @Override
    public void onClick(View view) {
        //hem de passar les dades a tipus int perque lo que ens entra es tipus string
        float num1 = Float.parseFloat(numero1.getText().toString());
        float num2 = Float.parseFloat(numero2.getText().toString());



        float res =0;

        switch (view.getId())
        {
            case R.id.bsumar:
                 res = num1+num2;
                resultat.setText(""+(res));
                concatenar.append( getHistorial(num1, "+", num2, res ));

                break;

            case R.id.brestar:
                res = num1-num2;
                resultat.setText(""+(res));
                concatenar.append( getHistorial(num1, "-", num2, res ));


                break;


            case R.id.bmultiplicar:
                resultat.setText(""+(num1*num2));
                concatenar.append( getHistorial(num1, "*", num2, res ));
                break;

            case R.id.bdividir:
                resultat.setText(""+(num1/num2));
                concatenar.append( getHistorial(num1, "/", num2, res ));
                break;
            case R.id.besborrar:

                numero1.setText(null);
                numero2.setText(null);
                resultat.setText(null);
                break;
            /*case R.id.bhistorial:
                Intent intent = new Intent(MainActivity.this, Historial.class);

                //primer li haig de dir com es diu
                intent.putStringArrayListExtra("HISTORIAL", historialOperacions);
                startActivity(intent);*/

        }


    }
    public  ArrayList<String> getHistorial(float num1, String operacio, float num2,   float res){
        StringBuilder construccio = new StringBuilder();
        construccio.append(num1);
        construccio.append(" "+operacio+" ");
        construccio.append(num2);
        construccio.append(" = ");
        construccio.append(res);
        construccio.append(",");


        String valor = construccio.toString();
        historialOperacions.add(valor);
        return  historialOperacions;

    }







}



