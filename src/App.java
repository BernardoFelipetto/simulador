import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("digite o nome do arquivo");
        String nomeArquivo = sc.nextLine();
        ConfigIniciais configIniciais = new ConfigIniciais();
        try {
            configIniciais = Leitor.lerArquivo(nomeArquivo);
        } catch (NotTxtException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // inicializanco as filas
//        for(int i = 0; i < numFilas; i++) {
//            filas.add(new Fila(servidores, capacidade, chegadaMin, chegadaMax, atendimentoMin, atendimentoMax));
//        }
        Simulador simulador = new Simulador(configIniciais.semente);
        simulador.simularFila(configIniciais.filas, configIniciais.numEventos);
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println (simulador.random());
//        }
    }
}
