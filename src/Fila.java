import java.util.ArrayList;

public class Fila {
    private int numServidores, numCapacidade, tempoChegadaMin, tempoChegadaMax, tempoAtendimentoMin, tempoAtendimentoMax;
    private ArrayList<Evento> fila;

    public Fila(int numServidores, int numCapacidade, int tempoChegadaMin, int tempoChegadaMax, int tempoAtendimentoMin, int tempoAtendimentoMax) {

        ArrayList<Evento> fila = new ArrayList<Evento>();

        this.numServidores = numServidores;
        this.numCapacidade = numCapacidade;
        this.tempoChegadaMin = tempoChegadaMin;
        this.tempoChegadaMax = tempoChegadaMax;
        this.tempoAtendimentoMin = tempoAtendimentoMin;
        this.tempoAtendimentoMax = tempoAtendimentoMax;

    }

    public ArrayList<Evento> getListaEventos(){
        return fila;
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
