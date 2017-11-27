package dsa.eetac.upc.edu.calculadorabasica;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity implements View.OnClickListener {

    public ListView historial; //operationListView
    Button esborrar, tancar;
    public ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        final ArrayList<String> historialOperacions = (ArrayList<String>) getIntent().getStringArrayListExtra("HISTORIAL");  //operationList
        historial = (ListView) findViewById(R.id.bhistorial);

        //esborrar = (Button) findViewById(R.id.besborrar);
        //esborrar.setOnClickListener(this) ;


        tancar = (Button) findViewById(R.id.btancar);
        tancar.setOnClickListener(this);



            //adaptador s'ho passa a la llista per ser mostrats.
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, historialOperacions);
            historial.setAdapter(adapter);

            Log.i("CALCULADORA", "INCI HISTIIRAKAK!!!!");

        }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btancar:
                finish();
                break;
            /*case R.id.besborrar:
                adapter.clear();
                adapter.notifyDataSetChanged();
                finish();
                break;*/
        }

    }
}
