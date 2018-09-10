import java.util.ArrayList;
import java.util.Scanner;

public class Simulador {

    //const
    final static double a = 25173;
    //const
    final static double b = 13849;
    //max value
    final static double m = 32768;
    //semente
    double semente;

    ArrayList<Evento> 


    public Simulador(int semente){
        this.semente = semente;
    }

    public void simulaFila(Fila fila){
        ArrayList<Evento> filaEventos = fila.getListaEventos();

        for(int i = 0; i<10; i++){

            if(filaEventos.size() == 0){

            }

        }

    }

    public void agenda(Evento evento){

    }



    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }

}