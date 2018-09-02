public class Fila {
    private int numServidores, numCapacidade, tempoChegada, tempoAtendimento;

    public Fila(int numServidores, int numCapacidade, int tempoChegada, int tempoAtendimento) {

        this.numServidores = numServidores;
        this.numCapacidade = numCapacidade;
        this.tempoChegada = tempoChegada;
        this.tempoAtendimento = tempoAtendimento;
    }

    public int getNumServidores() {
        return numServidores;
    }

    public int getNumCapacidade() {
        return numCapacidade;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setNumServidores(int numServidores) {
        this.numServidores = numServidores;
    }

    public void setNumCapacidade(int numCapacidade) {
        this.numCapacidade = numCapacidade;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public void setTempoAtendimento(int tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }
}
