import Enum.EventoEnum;

public class Evento {

    // tipo de evento
    EventoEnum evento;
    // tempo em que o evento ocorre
    double tempo;
    // número relacionado à geracao do número aleatório
    double sorteio;
    // id da fila em questão
    Fila fila;
    // cliente em questão
    Cliente cliente;

    public Evento(EventoEnum evento, double tempo, double sorteio, Fila fila){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
        this.fila = fila;
    }

    public Evento(EventoEnum evento, double tempo, double sorteio, Fila fila, Cliente cliente){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
        this.fila = fila;
        this.cliente = cliente;
    }

}
