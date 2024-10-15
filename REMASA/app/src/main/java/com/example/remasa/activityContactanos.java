package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.Toast;

public class activityContactanos extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnCarrito, btnWA, btnCuenta;
    ImageView iVBanner, iV;
    TextView tVLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnWA = findViewById(R.id.btnWA);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        iV = findViewById(R.id.iV);
        tVLink = findViewById(R.id.tVLink);

        String textoConSubrayado = "wa.link/29axhg";
        SpannableString spannableString = new SpannableString(textoConSubrayado);
        spannableString.setSpan(new UnderlineSpan(), 0, textoConSubrayado.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tVLink.setText(spannableString);

        tVLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirWhatsApp("3339521166"); // Reemplaza con el número de teléfono deseado
            }
        });

        //---------Metodos OnClick para los botones-------------------------------------------------

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activityPresentacion.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activityCatalogo.class);
                startActivity(siguiente);

            }
        });
        //__________________________________________________________________________________________

        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), ActivityEnDesarrolloAnuncio.class);
                startActivity(siguiente);
            }
        });
        //__________________________________________________________________________________________

        btnWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), activityContactanos.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente = new Intent(getApplicationContext(), ActivityEnDesarrolloAnuncio.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        /*tVLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activityContactanos.this,"Enviando a whatsapp", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    private void abrirWhatsApp(String numeroTelefono) {
        try {
            // Crear el URI de WhatsApp con el número de teléfono
            Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + numeroTelefono);

            // Crear el Intent
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            // Iniciar la actividad del Intent
            startActivity(intent);
        } catch (Exception e) {
            // Manejar cualquier error aquí
        }
    }
}