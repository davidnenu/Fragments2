package com.example.dm2.fragments;

/**
 * Created by dm2 on 10/11/2017.
 */

public class Pelicula {
    private String titulo;
    private String director;
    private String compositor;

    public Pelicula(String titulo, String director, String compositor) {
        this.titulo = titulo;
        this.director = director;
        this.compositor = compositor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

}
