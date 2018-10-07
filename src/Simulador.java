import Enum.EventoEnum;
import java.util.List;

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

    public void simularFila(List<Fila> filas, double chegadaInicial) {
        this.fila = filas.get(0);
        //primeira inserção na Agenda, chegada inicial é dada e sorteio é nulo
        Evento evento = new Evento(EventoEnum.CHEGADA, chegadaInicial);
        fila.addEventoEmAgenda(new Evento(EventoEnum.CHEGADA, chegadaInicial));
//        fila.addClienteAFila();
//        fila.addEventoEmAgenda(criarEventoSaida(chegadaInicial));

        for(int i = 0; i<20; i++) {
            Evento proximoEvento = fila.getAgendaEventos().remove(0);
            executarEvento(proximoEvento);
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
            Cliente cliente = fila.addClienteAFila();
            System.out.println("inserido cliente " + cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
            if (fila.getFila().size() <= fila.getNumServidores()) {
                Evento saida = criarEventoSaida(tempo);
                fila.addEventoEmAgenda(saida);
            }
        }
        Evento chegada = criarEventoChegada(tempo);
        fila.addEventoEmAgenda(chegada);
    }

    public void proximaFila() {

    }

    public void sair(Evento evento) {
        double tempo = evento.tempo;
        Cliente cliente = fila.removerClienteDeFila();
        System.out.println("removendo cliente " + cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
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