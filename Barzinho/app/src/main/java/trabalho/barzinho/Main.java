package trabalho.barzinho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private Button button;
    private EditText pessoas,conta,gorjeta;
    private float resultado, ValorConta=0, ValorGorjeta=0;
    private int Qpessoas = 1;
    private String sult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pessoas = (EditText) findViewById(R.id.pessoas);
        conta = (EditText) findViewById(R.id.conta);
        gorjeta = (EditText) findViewById(R.id.gorjeta);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pessoas.length()!=0 && conta.length()!=0 && gorjeta.length()!=0) {
                    String p = pessoas.getText().toString();
                    String c = conta.getText().toString();
                    String g = gorjeta.getText().toString();

                    Qpessoas = Integer.parseInt(p);
                    ValorConta = Float.parseFloat(c);
                    ValorGorjeta = Float.parseFloat(g);

                    resultado = (ValorConta+ValorGorjeta)/Qpessoas;
                }
                if (pessoas.length()!=0 && conta.length()!=0 && gorjeta.length()==0){
                    String p = pessoas.getText().toString();
                    String c = conta.getText().toString();

                    Qpessoas = Integer.parseInt(p);
                    ValorConta = Float.parseFloat(c);
                    ValorGorjeta = 0;

                    resultado = (ValorConta+ValorGorjeta)/Qpessoas;
                }

                sult = Float.toString(resultado);
                Intent intent = new Intent(Main.this, result.class);
                intent.putExtra("result", sult);
                startActivity(intent);
                //setContentView(R.layout.activity_result);

                Toast.makeText(Main.this, "Feito. Vá no menu para voltar ao início", Toast.LENGTH_LONG).show();
            }
        });
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
                intent.putExtra("result", sult);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
