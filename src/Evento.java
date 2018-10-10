import Enum.EventoEnum;

public class Evento {

    // tipo de evento
    EventoEnum evento;
    // tempo em que o evento ocorre
    double tempo;
    // número relacionado à geracao do número aleatório
    double sorteio;
    // id da fila em questão
    Fila filaOrigem;
    // id da fila em questão
    Fila filaChegada;
    // cliente em questão
    Cliente cliente;


    public Evento(EventoEnum evento, double tempo, double sorteio, Fila filaOrigem, Fila filaChegada, Cliente cliente){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
        this.filaOrigem = filaOrigem;
        this.filaChegada = filaChegada;
        this.cliente = cliente;
    }

}
