package logica;

import java.util.List;
import java.util.Random;

import util.Utilidades;

/**
 * Created by Maria on 15/12/2015.
 */
public class LogicaPregunta {

    private static LogicaPregunta logica;
    private Pregunta seleccionada;
    private List<Pregunta> preguntas;

    private LogicaPregunta(){
       this.preguntas= Utilidades.cargarPreguntas();
        this.seleccionada=preguntas.get(new Random().nextInt(preguntas.size()));
    }

    public static LogicaPregunta  getInstance(){
        if(logica==null)
            logica=new LogicaPregunta();
        return logica;
    }

    public Pregunta getPregunta(){
        return seleccionada;
    }

    public boolean respuestaCorrecta(String text){
        return (text.equals(seleccionada.getCorrecta()));
    }
}
