package fisei.uta.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //DECLARACION
    private EditText et_base;
    private EditText et_exponente;
    private EditText et_resultado;
    private Button btn_Potencia;
    private Button btn_Salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INSTANCIACION
        et_base = findViewById(R.id.editTextPrimerValor);
        et_exponente = findViewById(R.id.editTextSegundoValor);
        et_resultado = findViewById(R.id.editTextResultado);
        btn_Potencia = findViewById(R.id.buttonPotencia);
        btn_Salir = findViewById(R.id.buttonSalir);
        //manejador para el evento clic del boton
        btn_Potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = et_base.getText().toString();
                String e = et_exponente.getText().toString();
                int base_ = Integer.parseInt(b);
                int exponente_ = Integer.parseInt(e);

                Matematicas matematicas = new Matematicas();
                long res = matematicas.Potencia(base_, exponente_);

                et_resultado.setText(String.valueOf(res));
            }
        });
        btn_Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
/*
    public void onCLicPotencia(View vista) {
        String b = et_base.getText().toString();
        String e = et_exponente.getText().toString();
        int base_ = Integer.parseInt(b);
        int exponente_ = Integer.parseInt(e);

        Matematicas matematicas = new Matematicas();
        long res = matematicas.Potencia(base_, exponente_);

        et_resultado.setText(String.valueOf(res));
    }
    */

  
}