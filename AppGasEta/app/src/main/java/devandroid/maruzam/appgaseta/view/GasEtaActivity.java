package devandroid.maruzam.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.maruzam.appgaseta.R;
import devandroid.maruzam.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    //Declaração dos Atributos

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        //associar ligações com id
        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //pegar o click com botão
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if (TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("**Obrigatório**");
                    editGasolina.requestFocus();
                    isDadosOK = false;
                }
                if (TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("**Obrigatório**");
                    editEtanol.requestFocus();
                    isDadosOK = false;
                }
                if (isDadosOK){
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);

                    txtResultado.setText(recomendacao);

                }else {
                    Toast.makeText(GasEtaActivity.this,
                            "Por Favor Digite os Dados Obrigatários", Toast.LENGTH_LONG).show();

                }

            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           }

        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editEtanol.setText("");
                editGasolina.setText("");

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Obrigado Por Usar O GasEta", Toast.LENGTH_LONG).show();
                finish();
            }
        });





        //Toast.makeText(GasEtaActivity.this, UtilGasEta.mensagem(), Toast.LENGTH_SHORT).show();
        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12, 3.39), Toast.LENGTH_SHORT).show();
    }
}

