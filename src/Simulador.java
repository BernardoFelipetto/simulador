import Enum.EventoEnum;

public class Simulador {

    //const
    final static double a = 25173;
    //const
    final static double b = 13849;
    //max value
    final static double m = 32768;
    //semente
    double semente;


    Fila fila;


    public Simulador(int semente){
        this.semente = semente;
    }

    public void simularFila(Fila fila, double chegadaInicial) {
        this.fila = fila;
        //primeira inserção na Agenda, chegada inicial é dada e sorteio é nulo
        fila.addEventoEmAgenda(new Evento(EventoEnum.CHEGADA, chegadaInicial));
        fila.addClienteAFila();
        fila.addEventoEmAgenda(criarEventoSaida(chegadaInicial));

        for(int i = 0; i<10; i++){
            Evento evento = fila.getAgendaEventos().remove(0);
            executarEvento(evento);
        }

    }

    public void executarEvento(Evento evento) {
        if (evento.evento == EventoEnum.CHEGADA) {
            chegar(evento);
        } else {
            sair(evento);
        }
    }

    public void chegar(Evento evento) {
        double tempo = evento.tempo;
        if (fila.getFila().size() < fila.getNumCapacidade()) {
            fila.addClienteAFila();
            if (fila.getFila().size() <= fila.getNumServidores()) {
                Evento saida = criarEventoSaida(tempo);
                fila.addEventoEmAgenda(saida);
            }
        }
        Evento chegada = criarEventoChegada(tempo);
        fila.addEventoEmAgenda(chegada);
    }

    public void sair(Evento evento) {
        double tempo = evento.tempo;
        fila.removerClienteDeFila();
        if (fila.getFila().size() >= fila.getNumServidores()) {
            fila.addEventoEmAgenda(criarEventoSaida(tempo));
        }
    }

    private Evento criarEventoChegada(double tempoEvento) {
        semente = random();
        double sorteio = ((fila.getTempoChegadaMax() - fila.getTempoChegadaMin()) * semente) + fila.getTempoChegadaMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.CHEGADA, tempo, sorteio);
    }

    private Evento criarEventoSaida(double tempoEvento) {
        semente = random();
        double sorteio = ((fila.getTempoAtendimentoMax() - fila.getTempoAtendimentoMin()) * semente) + fila.getTempoAtendimentoMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.SAIDA, tempo, sorteio);
    }

    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }

}