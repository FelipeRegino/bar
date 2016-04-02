package com.example.negrao.com.bar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends ContaGeradaActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
      //   //   return true;
      //  }
        if(id == R.id.action_gerarConta){

            Intent intent = new Intent(getApplicationContext(), ContaGeradaActivity.class);
            intent.putExtra("Valor",ContaTotal);
        }
        return super.onOptionsItemSelected(item);
    }

    final EditText editTextValorTotal = (EditText) findViewById(R.id.editTextValorTotal);
    final EditText editTextParticipantes = (EditText) findViewById(R.id.editTextParticipantes);
    final EditText editTextServico = (EditText) findViewById(R.id.editTextTaxaServico);


    float ValorTotal = Float.valueOf(editTextValorTotal.getText().toString());
    int NumParticipantes = Integer.parseInt(editTextParticipantes.getText().toString());
    int TaxaServico = Integer.parseInt(editTextServico.getText().toString());

    float ContaParcial = ValorTotal*(TaxaServico/100);
    float ContaTotal = (ValorTotal+ContaParcial)/NumParticipantes;



    }







