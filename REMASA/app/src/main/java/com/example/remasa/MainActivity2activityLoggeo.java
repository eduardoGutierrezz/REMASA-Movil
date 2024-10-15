package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2activityLoggeo extends AppCompatActivity {
    //------Creacion de elementos-------------------------------------------------------------------
    ImageView iVLoggin;
    Button btnIniciarSesion, btnIngresarSinCuenta;
    EditText eTUsuario, etContra;
    TextView tVUsuario, tVContra,tVISB, tVCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2loggeo);

        //---------Enlace de elementos--------------------------------------------------------------

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        eTUsuario = findViewById(R.id.eTUsuario);
        etContra = findViewById(R.id.eTContra);
        tVUsuario = findViewById(R.id.tVUsuario);
        tVContra = findViewById(R.id.tVContra);
        tVISB = findViewById(R.id.tVISB);
        iVLoggin = findViewById(R.id.iVLoggin);
        tVCrearCuenta = findViewById(R.id.tVCrearCuenta);
        btnIngresarSinCuenta = findViewById(R.id.btnIngresarSinCuenta);

        String textoConSubrayado = "¿No tienes una cuenta? regístrate aquí";
        SpannableString spannableString = new SpannableString(textoConSubrayado);
        spannableString.setSpan(new UnderlineSpan(), 0, textoConSubrayado.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tVCrearCuenta.setText(spannableString);


        //---------Creacion del objeto--------------------------------------------------------------

        Usuario usuario = new Usuario();

        //-----Evento OnClick-----------------------------------------------------------------------

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //---------Guardar los datos que el usuario escriba en variables----------------------------
                /*eTUsuario.setText("");
                etContra.setText("");*/
                String correoUsuarioIntro= String.valueOf(eTUsuario.getText()).trim();
                String contraseniaIntro = String.valueOf(etContra.getText()).trim();

                usuario.consultarUsuario(correoUsuarioIntro);

                int it = 0;
                //Condicional para comparar valores entre las variables
                if(correoUsuarioIntro.equals(usuario.getCorreo())&&contraseniaIntro.equals(usuario.getContraseña())){
                    Toast.makeText(MainActivity2activityLoggeo.this, " la contraseña es"+usuario.getContraseña()+"Tu usuario es "+usuario.getTipoUsuario(), Toast.LENGTH_LONG).show();
                    if(usuario.getTipoUsuario().equals("Cliente")){
                        Intent siguiente = new Intent(getApplicationContext(), activityPresentacion.class);
                        startActivity(siguiente);



                    }else if(usuario.getTipoUsuario().equals("Administrador")){
                        Intent siguiente = new Intent(getApplicationContext(), activity_AdminMenu.class);
                        startActivity(siguiente);

                    }else if(usuario.getTipoUsuario().equals("Surtidor")) {
                        Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorMenu.class);
                        startActivity(siguiente);
                    }
                }else{
                    Toast.makeText(MainActivity2activityLoggeo.this ,"Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                    if(it==1) {
                        Toast.makeText(MainActivity2activityLoggeo.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                    }
                    it++;

                }
            }
        });

        btnIngresarSinCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activityPresentacion.class);
                startActivity(siguiente);
            }
        });

    }
}