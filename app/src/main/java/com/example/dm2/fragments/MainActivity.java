package com.example.dm2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.dm2.fragments.FragmentListado.PeliculasListener;

public class MainActivity extends AppCompatActivity implements PeliculasListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado=
                (FragmentListado)
                        getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setPeliculaListener(this);
    }
    @Override
    public void onPeliculaSeleccionado(Pelicula p) {
        boolean hayDetalle =
                getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)!=null;
        if (hayDetalle){
            ((FragmentDetalle) getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(p.getTitulo());
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, p.getTitulo());
            startActivity(i);
        }
    }
}
