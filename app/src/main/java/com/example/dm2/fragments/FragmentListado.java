package com.example.dm2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentListado extends Fragment {
    private Pelicula[] datos =
            new Pelicula[]{
                    new Pelicula("Peli 1", "Hola", "Hola"),
                    new Pelicula("Peli 2", "Hola", "Hola"),
                    new Pelicula("Peli 3", "Hola", "Hola"),
                    new Pelicula("Peli 4", "Hola", "Hola"),
                    new Pelicula("Peli 5", "Hola", "Hola")};
    private ListView lstListado;
    private PeliculasListener listener;

    //private PeliculasListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado,
                container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorPeliculas(this));


        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view,
                                    int pos, long id) {
                if (listener != null)
                    listener.onPeliculaSeleccionado((Pelicula) lstListado.getAdapter().getItem(pos));
            }
        });
    }

    public interface PeliculasListener {
        void onPeliculaSeleccionado(Pelicula c);
    }

    public void setPeliculaListener(PeliculasListener listener) {
        this.listener = listener;
    }

    class AdaptadorPeliculas extends ArrayAdapter<Pelicula> {
        Activity context;

        AdaptadorPeliculas(Fragment context) {
            super(context.getActivity(), R.layout.listitem_pelicula, datos);
            this.context = context.getActivity();
        }

        public View getView(int position,
                            View convertView,
                            ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_pelicula, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.lblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblDirector =
                    (TextView) item.findViewById(R.id.lblDirector);
            lblDirector.setText(datos[position].getDirector());

            TextView lblCompositor =
                    (TextView) item.findViewById(R.id.lblCompositor);
            lblCompositor.setText(datos[position].getCompositor());


            return (item);
        }
    }
}

