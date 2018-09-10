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

//  int numServidores, capacidadeFila;

    public Simulador(int semente){
        this.semente = semente;
//        this.numServidores = numServidores;
//        this.capacidadeFila = capacidadeFila;
    }

    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }

}