package logica;

/**
 * Created by Maria on 15/12/2015.
 */
public class Pregunta {

    private String enunciado;
    private String[] respuestas = new String[3];
    private int correcta, imagen;

    public Pregunta (String enunciado, String respuesta1, String respuesta2, String respuesta3, int correcta,int imagen){
        this.enunciado=enunciado;
        this.respuestas[0] = respuesta1;
        this.respuestas[1] = respuesta2;
        this.respuestas[2] = respuesta3;
        this.correcta=correcta;
        this.imagen=imagen;
    }

    public String getEnunciado(){
        return enunciado;
    }
     public int getImagen(){
         return imagen;
     }

    public String getRespuesta (int position){
        return respuestas[position];
    }

    public String getCorrecta(){
        return respuestas[correcta];
    }
}
