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

    double tempoUltimoEvento;

    Fila fila;


//    ArrayList<Evento>


    public Simulador(int semente){
        this.semente = semente;
    }

    public void simularFila(Fila fila, int chegadaInicial) {
        this.fila = fila;
        //primeira inserção na Agenda, chegada inicial é dada e sorteio é nulo
        fila.addEventoEmAgenda(new Evento(EventoEnum.CHEGADA, chegadaInicial));
        tempoUltimoEvento = chegadaInicial;
        fila.addClienteAFila();
        fila.addEventoEmAgenda(new Evento(EventoEnum.SAIDA, calcularTempo(tempoUltimoEvento)));

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
        double tempo = calcularTempo(tempoUltimoEvento);
        if (fila.getFila().size() < fila.getNumCapacidade()) {
            fila.addClienteAFila();
            if (fila.getFila().size() <= fila.getNumServidores()) {
                fila.addEventoEmAgenda(new Evento(EventoEnum.SAIDA, tempo ));
            }
        }
        fila.addEventoEmAgenda(new Evento(EventoEnum.CHEGADA, tempo));
        tempoUltimoEvento = tempo;
    }

    public void sair(Evento evento) {
        fila.removerClienteDeFila();
        if (fila.getFila().size() >= 1) {
            fila.addEventoEmAgenda(new Evento(EventoEnum.SAIDA, calcularTempo(tempoUltimoEvento)));
        }
    }
//
//    public void agendarEntrada(Fila fila, double tempoChegada) {
//        fila.addEventoEmAgenda(new Evento(EventoEnum.CHEGADA, tempoChegada));
//        tempoUltimoEvento = tempoChegada;
//        fila.addClienteAFila();
//    }

    public void agenda(Evento evento){

    }

    private double calcularTempo(double tempoAnterior) {
        semente = random();
        return tempoAnterior + semente;
    }

    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }

}