import Enum.EventoEnum;

public class Evento {

    EventoEnum evento;
    double tempo;
    double sorteio;

    public Evento(EventoEnum evento, double tempo, double sorteio){
        this.evento = evento;
        this.tempo = tempo;
        this.sorteio = sorteio;
    }

    public Evento(EventoEnum evento, double tempo){
        this.evento = evento;
        this.tempo = tempo;
    }

}
