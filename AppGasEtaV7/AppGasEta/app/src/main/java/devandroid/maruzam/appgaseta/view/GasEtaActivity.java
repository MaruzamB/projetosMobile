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

import java.util.List;

import devandroid.maruzam.appgaseta.R;
import devandroid.maruzam.appgaseta.controller.CombustivelController;
import devandroid.maruzam.appgaseta.model.Combustivel;
import devandroid.maruzam.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;

    Combustivel combustivelEtanol;
    Combustivel combustivelGasolina;

    EditText editEtanol;
    EditText editGasolina;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoEtanol;
    double precoGasolina;
    String recomendacao;

    List<Combustivel> dados;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);
        dados = controller.getListaDados();

        controller.toString();

        editEtanol = findViewById(R.id.editEtanol);
        editGasolina = findViewById(R.id.editGasolina);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOK = true;

                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("Obrigatorio");
                    editEtanol.requestFocus();
                    isDadosOK = false;
                }
                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("Obrigatorio");
                    editGasolina.requestFocus();
                    isDadosOK = false;
                }
                if (isDadosOK) {
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);

                } else {
                    Toast.makeText(GasEtaActivity.this, "Dados Obrigatórios!!", Toast.LENGTH_SHORT).show();

                    btnSalvar.setEnabled(false);

                }

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editEtanol.setText("");
                editGasolina.setText("");
                txtResultado.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();

            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();

                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);

                int parada = 0;

            }
        });

        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12, 3.19),
                Toast.LENGTH_SHORT).show();

    }
}
