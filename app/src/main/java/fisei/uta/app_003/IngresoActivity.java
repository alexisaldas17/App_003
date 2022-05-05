package fisei.uta.app_003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoActivity extends AppCompatActivity {
    EditText etUsuario;
    EditText etCOntrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        etUsuario = findViewById(R.id.editTextUsuario);
        etCOntrasenia = findViewById(R.id.editTextContrasenia);

    }

    public void onClicIngrear(View vista){
        String usuario = etUsuario.getText().toString();
        String contrasenia = etCOntrasenia.getText().toString();
        if (usuario.equals("admin") && contrasenia.equals("admin")) {
            //mostrar activity
            //Intent intent = new Intent(IngresoActivity.this, MainActivity.class);
            Intent intent = new Intent(this, MainActivity.class);
            //pasar parametro al activity
            intent.putExtra("variable_usuario", usuario);
            startActivity(intent);
            //...putExtra
        }
        else
        {
            Toast.makeText(this, "Usuario/Clave incorrectos", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), "Usuario/Clave incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}