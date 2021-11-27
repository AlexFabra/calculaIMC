package cat.dam.alex.imc;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class SegonaActivity extends AppCompatActivity {

    private TextView tv_pes, tv_alcada, tv_imc, tv_grup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segona);

         tv_pes = (TextView) findViewById(R.id.tv_pes);
         tv_alcada = (TextView) findViewById(R.id.tv_alcada);
         tv_imc = (TextView) findViewById(R.id.tv_imc);
         tv_grup = (TextView) findViewById(R.id.tv_grup);

         //rebem les variables enviades des-de el MainActivity:
        Bundle bundle = this.getIntent().getExtras();
        double pes= bundle.getDouble("pes");
        double alcada= bundle.getDouble("alcada");
        double imc= bundle.getDouble("imc");

        //posem els valors rebuts als textViews:
        tv_pes.setText(Double.toString(pes));
        tv_alcada.setText(Double.toString(alcada));
        tv_imc.setText(String.format("%.2f",imc));

        //calculem el grup al que pertany l'usuari segons el imc:
        if(imc<18.5){
            tv_grup.setText(R.string.pes_1);
        }else if(imc>=18.5&&imc<=24.9){
            tv_grup.setText(R.string.pes_2);
        }else if(imc>=25&&imc<=26.9){
            tv_grup.setText(R.string.pes_3);
        }else if(imc>=27&&imc<=29.9){
            tv_grup.setText(R.string.pes_4);
        }else if(imc>=30&&imc<=34.9){
            tv_grup.setText(R.string.pes_5);
        }else if(imc>=35&&imc<=39.9){
            tv_grup.setText(R.string.pes_6);
        }else if(imc>=40&&imc<=49.9){
            tv_grup.setText(R.string.pes_7);
        }else if(imc>50){
            tv_grup.setText(R.string.pes_8);
        }
    }

    /** tornarMenú envia el procés d'execució al MainActivity:
     * @param v és el botó que es pulsa per executar aquesta funció
     */
    public void tornarMenu(View v) {
        // Declarem l'intent amb el activity d'origen i el de destí)
        Intent intent = new Intent(SegonaActivity.this, MainActivity.class);
        // Iniciem la main activity amb l'intent (sense cap bundle)
        startActivity(intent);
    }
}


