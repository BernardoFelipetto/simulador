import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite a semente");
        int semente = sc.nextInt();

        System.out.println("digite o numero de servidores");
        int servidores= sc.nextInt();

        System.out.println("digite a capacidade da fila");
        int capacidade = sc.nextInt();

        System.out.println("digite o tempo de chegada Minimo");
        int chegadaMin = sc.nextInt();

        System.out.println("digite o tempo de chegada Maximo");
        int chegadaMax = sc.nextInt();

        System.out.println("digite o tempo de atendimento Minimo");
        int atendimentoMin = sc.nextInt();

        System.out.println("digite o tempo de atendimento Maximo");
        int atendimentoMax = sc.nextInt();

        System.out.println("digite o número de filas");
        int numFilas = sc.nextInt();

        Simulador simulador = new Simulador(semente);

        List<Fila> filas = new ArrayList<Fila>();

        // inicializanco as filas
        for(int i = 0; i < numFilas; i++) {
            filas.add(new Fila(servidores, capacidade, chegadaMin, chegadaMax, atendimentoMin, atendimentoMax));
        }

        simulador.simularFila(filas, 2);

        for (int i = 0; i < 20; i++) {
            System.out.println (simulador.random());
        }
    }
}
