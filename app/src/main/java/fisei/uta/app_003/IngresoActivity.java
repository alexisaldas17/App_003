package fisei.uta.app_003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
            //mostrar activity Intent para llamar actividades

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    //saber si el usuario presiono una apcion

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Obtener el id del item donde el usuario presiono
        int id = item.getItemId();

        if (id== R.id.menu_archivo){
            Toast.makeText(this, "Presiono en: Archivo", Toast.LENGTH_LONG).show();
        }
        if (id== R.id.menu_acercaDe){
            Toast.makeText(this, "Presiono en: Acerca de", Toast.LENGTH_LONG).show();
        }
        if (id== R.id.menu_salir){
            Toast.makeText(this, "Presiono en: Salir", Toast.LENGTH_LONG).show();
        }
        if (id== R.id.menu_copiar){
            Toast.makeText(this, "Presiono en: Copiar", Toast.LENGTH_LONG).show();
        }


        return super.onOptionsItemSelected(item);
    }
}