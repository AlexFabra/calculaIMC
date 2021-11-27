package cat.dam.alex.imc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_alcada, et_pes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** calcularIMC agafa els editText et_pes i et_alcada del activity_main,
     *  calcula el imc i dirigeix el procés d'execució a SegonaActivity per
     *  mostrar el resultat.
     * @param v el botó que ha executat la funció.
     */
    public void calcularIMC(View v){

        et_alcada = (EditText) findViewById(R.id.et_alcada);
        et_pes = (EditText) findViewById(R.id.et_pes);

        double alcada = Double.parseDouble(et_alcada.getText().toString());
        double pes = Double.parseDouble(et_pes.getText().toString());
        double alcadaElevada=Math.pow(alcada,2);
        double imc = pes/alcadaElevada;

        // Configurem l’intent per obrir la segona activitat,
        //com a paràmetres itilitzem aquesta i el nom de la que volem iniciar.
        Intent intent = new Intent(this, SegonaActivity.class);
        // Afegim les dades per enviar-li
        intent.putExtra("alcada", alcada);
        intent.putExtra("pes", pes);
        intent.putExtra("imc", imc);
        // iniciem l’activitat
        startActivity(intent);
    }
}