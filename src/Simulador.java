import java.util.Scanner;

public class Simulador {

    //const
    final static double a = 25173;
    //const
    final static double b = 13849;
    //max value
    final static double m = 32768;
    //semente
    double x;

    public Simulador(int semente){
        //semente is equal to half of the max value
        x = semente;
    }

    public double random() {
        x = (a * x + b) % m;
        x = x/m;
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite a semente");
        int semente = sc.nextInt();

        Simulador simulator = new Simulador(semente);

        for (int i = 0; i < 20; i++) {
            System.out.println (simulator.random());
        }

    }
}