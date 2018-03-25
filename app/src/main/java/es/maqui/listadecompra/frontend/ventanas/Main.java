package es.maqui.listadecompra.frontend.ventanas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import es.maqui.listadecompra.R;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button botonCrearLista = findViewById(R.id.botonCrearLista);
        Button botonGestionarListas = findViewById(R.id.botonGestionarListasCreadas);
        Button botonCerrar = findViewById(R.id.botonCerrarAplicacion);

        botonCrearLista.setOnClickListener((View v) -> {
            startActivity(new Intent(Main.this, CrearListas.class));
        });

        botonGestionarListas.setOnClickListener((View v) -> {
            startActivity(new Intent(Main.this, UsarListas.class));
        });

        botonCerrar.setOnClickListener((View v) -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });


    }
}
