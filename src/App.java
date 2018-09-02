import java.util.Scanner;

public class App {

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
