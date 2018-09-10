import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite a semente");
        int semente = sc.nextInt();

        System.out.println("digite o numero de servidores");
        int servidores= sc.nextInt();

        System.out.println("digite a capacidade da fila");
        int capacidade = sc.nextInt();

        System.out.println("digite o tempo de chegada");
        int chegada = sc.nextInt();

        System.out.println("digite o tempo de atendimento");
        int atendimento = sc.nextInt();

        Simulador simulator = new Simulador(semente);
        Fila fila = new Fila(servidores, capacidade, chegada, atendimento);

        for (int i = 0; i < 20; i++) {
            System.out.println (simulator.random());
        }
    }
}
