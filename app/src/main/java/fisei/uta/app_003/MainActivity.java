package fisei.uta.app_003;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fisei.uta.app_003.logica.Matematicas;

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

        //obtener los parametros de la otra Activity
        Bundle bundle = getIntent().getExtras();
        et_resultado.setText(bundle.getString("variable_usuario"));
        this.getSupportActionBar().setTitle("Usuario conectado:" +
                bundle.getString("variable_usuario"));
    }

    public void onClicMostrarActivity(View vista){
        Intent intent = new Intent(this, TercerActivity.class);

        activityResult.launch((intent));
        //startActivity(intent);

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
    public void onClicAbrirNavegador(View vista){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }
    public void onCliclLlamar(View vista){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+5930979226628"));
        //Uri  uri = new Uri("PAramentrso"); ES OTRA FORMA
        startActivity(intent);
    }

    //onActivityResult esta descontinuado recibir datos al cerrar ventana
    //RECIBIENDO INFORMACION DESDE TERCER ACTIVITY

    //NUEVA FORMA DE OBTENER LOS DATOS REGRESADOS AL CERRAR UNA ACTIVIDAD
    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //Procesar datos
                    if (result.getResultCode() == Activity.RESULT_OK){//asegura que todo esta correcto

                        //Obtener datos regresados
                        Intent data = result.getData();
                        Toast.makeText(getApplicationContext(), "Dato regresado: "+ data.getDataString(), Toast.LENGTH_LONG).show();
                    }
                }
            });

}