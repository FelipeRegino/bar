package trabalho.barzinho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import trabalho.com.result;

public class Main extends AppCompatActivity {

    private float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText pessoas = (EditText) findViewById(R.id.pessoas);
        EditText conta = (EditText) findViewById(R.id.conta);
        EditText gorjeta = (EditText) findViewById(R.id.gorjeta);

        int Qpessoas = Integer.parseInt(pessoas.getText().toString());
        float ValorConta = Float.valueOf(conta.getText().toString());
        float ValorGorjeta = Float.valueOf(gorjeta.getText().toString());

        resultado = (ValorConta+ValorGorjeta)/Qpessoas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.result) {
                Intent intent = new Intent(Main.this, result.class);
                intent.putExtra("result", resultado);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
