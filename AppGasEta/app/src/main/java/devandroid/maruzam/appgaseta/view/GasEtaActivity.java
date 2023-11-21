package devandroid.maruzam.appgaseta.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.maruzam.appgaseta.R;
import devandroid.maruzam.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    //UtilGasEta utilGasEta = new UtilGasEta();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);


        //Toast.makeText(GasEtaActivity.this, UtilGasEta.mensagem(), Toast.LENGTH_SHORT).show();
        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12, 3.39), Toast.LENGTH_SHORT).show();
    }
}
