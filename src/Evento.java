import Enum.EventoEnum;

public class Evento {

    // tipo de evento
    EventoEnum evento;
    // tempo em que o evento ocorre
    double tempo;
    // número relacionado à geracao do número aleatório
    double sorteio;
    // id da fila em questão
    int idFila;
    // cliente em questão
    Cliente cliente;

    public Evento(EventoEnum evento, double tempo, double sorteio, int idFila){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
        this.idFila = idFila;
    }

    public Evento(EventoEnum evento, double tempo, double sorteio, int idFila, Cliente cliente){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
        this.idFila = idFila;
        this.cliente = cliente;
    }

}
