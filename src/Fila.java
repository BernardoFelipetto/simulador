import java.util.*;
import java.util.stream.Collectors;

public class Fila {

    // Usado para atribuir o valor ao id da fila, incrementando a cada fila criada
    public static int idFila = 0;
    // Usado como identificador da fila, começando por 1
    private int id;
    // Quando fila não tiver chegada: tempoChegadaMin, tempoChegadaMax e tempoChegadaInicial serão 0
    private int numServidores, numCapacidade, tempoChegadaMin, tempoChegadaMax, tempoChegadaInicial, tempoAtendimentoMin, tempoAtendimentoMax;
    private Queue<Cliente> fila;
    private Dictionary<Integer, Double> filasPassagens;

    public Fila(int numServidores, int numCapacidade, int tempoChegadaMin, int tempoChegadaMax, int tempoChegadaInicial, int tempoAtendimentoMin, int tempoAtendimentoMax) {
        idFila++;
        this.id = idFila;
        this.fila = new LinkedList<Cliente>();
        this.numServidores = numServidores;
        this.numCapacidade = numCapacidade;
        this.tempoChegadaMin = tempoChegadaMin;
        this.tempoChegadaMax = tempoChegadaMax;
        this.tempoChegadaInicial = tempoChegadaInicial;
        this.tempoAtendimentoMin = tempoAtendimentoMin;
        this.tempoAtendimentoMax = tempoAtendimentoMax;
        filasPassagens = new Hashtable<Integer, Double>();
    }

    public Dictionary<Integer, Double> getFilasPassagensIds() {
        return filasPassagens;
    }

    public void addFilaPassagem(int idFila, double prob ) {
        this.filasPassagens.put(idFila, prob);
    }

    public Queue<Cliente> getFila() {
        return fila;
    }

    public void addClienteAFila(Cliente cliente) {
        this.fila.add(cliente);
    }

    public Cliente addClienteAFila() {
        Cliente cliente = new Cliente();
        this.fila.add(cliente);
        return cliente;
    }

    public Cliente removerClienteDeFila() {
        return this.fila.poll();
    }

    public int getId() {
        return this.id;
    }

    public int getNumServidores() {
        return numServidores;
    }

    public void setNumServidores(int numServidores) {
        this.numServidores = numServidores;
    }

    public int getNumCapacidade() {
        return numCapacidade;
    }

    public void setNumCapacidade(int numCapacidade) {
        this.numCapacidade = numCapacidade;
    }

    public int getTempoChegadaMin() {
        return tempoChegadaMin;
    }

    public void setTempoChegadaMin(int tempoChegadaMin) {
        this.tempoChegadaMin = tempoChegadaMin;
    }

    public int getTempoChegadaMax() {
        return tempoChegadaMax;
    }

    public void setTempoChegadaMax(int tempoChegadaMax) {
        this.tempoChegadaMax = tempoChegadaMax;
    }

    public int getTempoChegadaInicial() {
        return tempoChegadaInicial;
    }

    public void setTempoChegadaInicial(int tempoChegadaInicial) {
        this.tempoChegadaInicial = tempoChegadaInicial;
    }

    public int getTempoAtendimentoMin() {
        return tempoAtendimentoMin;
    }

    public void setTempoAtendimentoMin(int tempoAtendimentoMin) {
        this.tempoAtendimentoMin = tempoAtendimentoMin;
    }

    public int getTempoAtendimentoMax() {
        return tempoAtendimentoMax;
    }

    public void setTempoAtendimentoMax(int tempoAtendimentoMax) {
        this.tempoAtendimentoMax = tempoAtendimentoMax;
    }

}
