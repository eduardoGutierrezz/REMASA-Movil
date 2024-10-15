package com.example.remasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_SurtidorEntregaPorPaqueteria extends AppCompatActivity {

    ImageButton btnHome, btnCatalogo, btnPedidosFinalizados, btnPedidosEnProceso, btnNuevosPedidos, btnCuenta;
    ImageView iVBanner;
    TextView tVProducto, tVCodigo, tVPrecioPza, tVTotal, tVNombre, tVNombres, tVNumPedido, tVidPedido, tVTelefonos,
            tVTel, tVTotalFinal, tVMxn, tVcp, tVcP, tVCiudad, tVCiudadCliente, tVEstad, tVest;
    ListView lVPedidos;
    EditText eTTotal;
    Button btnCancelarPedido, btnPagado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surtidor_entrega_por_paqueteria);

        btnHome = findViewById(R.id.btnHome);
        btnCatalogo = findViewById(R.id.btnCatalogo);
        btnPedidosFinalizados = findViewById(R.id.btnPedidosFinalizados);
        btnPedidosEnProceso = findViewById(R.id.btnPedidosEnProceso);
        btnNuevosPedidos = findViewById(R.id.btnNuevosPedidos);
        btnCuenta = findViewById(R.id.btnCuenta);
        iVBanner = findViewById(R.id.iVBanner);
        tVProducto = findViewById(R.id.tVProducto);
        tVCodigo = findViewById(R.id.tVCodigo);
        tVPrecioPza = findViewById(R.id.tVPrecioPza);
        tVTotal = findViewById(R.id.tVTotal);
        tVcp = findViewById(R.id.tVcp);
        tVcP = findViewById(R.id.tVcP);
        tVCiudad = findViewById(R.id.tVCiudad);
        tVCiudadCliente = findViewById(R.id.tVCiudadCliente);
        tVEstad = findViewById(R.id.tVEstad);
        tVest = findViewById(R.id.tVest);
        lVPedidos = findViewById(R.id.lVPedidos);
        tVNombre = findViewById(R.id.tVNombre);
        tVNombres = findViewById(R.id.tVNombres);
        tVNumPedido = findViewById(R.id.tVNumPedido);
        tVidPedido = findViewById(R.id.tVidPedido);
        tVTelefonos = findViewById(R.id.tVTelefonos);
        tVTel = findViewById(R.id.tVTel);
        tVTotalFinal = findViewById(R.id.tVTotalFinal);
        eTTotal = findViewById(R.id.eTTotal);
        tVMxn = findViewById(R.id.tVMxn);
        btnCancelarPedido = findViewById(R.id.btnCancelarPedido);
        btnPagado = findViewById(R.id.btnPagado);

        //---------Metodos OnClick para los botones-------------------------------------------------

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorMenu.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorCatalogo.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnPedidosFinalizados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorPedidosFinalizados.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnPedidosEnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorPedidosEnProceso.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnNuevosPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorNuevosPedidos.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent siguiente = new Intent(getApplicationContext(), activity_SurtidorCuenta.class);
                startActivity(siguiente);
            }
        });
        //------------------------------------------------------------------------------------------
        btnCancelarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_SurtidorEntregaPorPaqueteria.this, "Pedido cancelado", Toast.LENGTH_LONG).show();
            }
        });
        //------------------------------------------------------------------------------------------
        btnPagado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_SurtidorEntregaPorPaqueteria.this, "Pedido pagado",Toast.LENGTH_LONG).show();
            }
        });
    }
}