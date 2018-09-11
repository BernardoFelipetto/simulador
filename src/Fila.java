import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Fila {


    private int numServidores, numCapacidade, tempoChegadaMin, tempoChegadaMax, tempoAtendimentoMin, tempoAtendimentoMax;
    private ArrayList<Evento> agenda;
    private Queue<Cliente> fila;

    public Fila(int numServidores, int numCapacidade, int tempoChegadaMin, int tempoChegadaMax, int tempoAtendimentoMin, int tempoAtendimentoMax) {

        this.agenda = new ArrayList<Evento>();
        this.fila = new LinkedList<Cliente>();
        this.numServidores = numServidores;
        this.numCapacidade = numCapacidade;
        this.tempoChegadaMin = tempoChegadaMin;
        this.tempoChegadaMax = tempoChegadaMax;
        this.tempoAtendimentoMin = tempoAtendimentoMin;
        this.tempoAtendimentoMax = tempoAtendimentoMax;

    }

    public ArrayList<Evento> getAgendaEventos(){
        return agenda;
    }

    public void addEventoEmAgenda(Evento evento) {
        agenda.add(evento);
        //chamar função de ordenação para ordenar eventos
    }

    public Queue<Cliente> getFila() {
        return fila;
    }

    public void addClienteAFila() {
        this.fila.add(new Cliente());
    }

    public void removerClienteDeFila() {
        this.fila.poll();
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
