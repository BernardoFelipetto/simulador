import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
import java.util.List;

public class Leitor {

    public static ConfigIniciais lerArquivo(String nameArq) throws NotTxtException, IOException {
        ConfigIniciais configIniciais = new ConfigIniciais();
        if (!nameArq.contains(".txt")) {
            throw new NotTxtException("Arquivo deve ser txt");
        }
        final Reader reader = new FileReader(nameArq);
        final BufferedReader bufferReader = new BufferedReader(reader);
        String currentLine = "";
        configIniciais.semente = new Scanner(bufferReader.readLine()).nextInt();
        configIniciais.numEventos = new Scanner(bufferReader.readLine()).nextInt();
        configIniciais.filas = new ArrayList<Fila>();
        bufferReader.readLine(); // pular uma linha
        bufferReader.readLine(); // pular uma linha
        while(!currentLine.equals("end")) {
            int numServidores = new Scanner(bufferReader.readLine()).nextInt();
            int capacidadeFila = new Scanner(bufferReader.readLine()).nextInt();
            int tempoChegadaMin = new Scanner(bufferReader.readLine()).nextInt();
            int tempoChegadaMax = new Scanner(bufferReader.readLine()).nextInt();
            int tempoChegadaInic = new Scanner(bufferReader.readLine()).nextInt();
            int tempoAtendMin = new Scanner(bufferReader.readLine()).nextInt();
            int tempoAtendMax = new Scanner(bufferReader.readLine()).nextInt();
            Fila fila = new Fila(numServidores, capacidadeFila, tempoChegadaMin, tempoChegadaMax, tempoChegadaInic, tempoAtendMin, tempoAtendMax);

            while (true) {
                String newLine = bufferReader.readLine();
                if (newLine.isEmpty())
                    break;
                Scanner scanner = new Scanner(newLine);
                int idFila = scanner.nextInt();
                double prob = scanner.nextDouble();
                fila.addFilaPassagem(idFila, prob);
            }
            configIniciais.filas.add(fila);
            currentLine = new Scanner(bufferReader.readLine()).nextLine();
        }

        reader.close();
        bufferReader.close();
        return configIniciais;
    }
}
