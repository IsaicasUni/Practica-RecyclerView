package com.example.apprecyclerview;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

import modelo.AlumnoDbHelper;
import modelo.AlumnosDb;

public class Aplicacion extends Application {
    public static ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;
    private AlumnosDb alumnosDb;
    private AlumnoDbHelper helper = new AlumnoDbHelper(this);
    private AlumnosDb alumnoDb = new AlumnosDb(this, helper);
    public static ArrayList<Alumno> getAlumnos() { return alumnos;}
    public MiAdaptador getAdaptador(){ return adaptador; }

    @Override
    public void onCreate(){
        super.onCreate();
        alumnoDb.openDataBase();
        alumnosDb = new AlumnosDb(getApplicationContext());
        alumnos = alumnosDb.allAlumnos();
        adaptador = new MiAdaptador(alumnos, this);
        alumnoDb.closeDataBase();
    }
}
