import Enum.EventoEnum;
import java.util.List;

public class Simulador {

    //const
    final static double a = 25173;
    //const
    final static double b = 13849;
    //max value
    final static double m = 32768;
    //semente (número utilizado para gerar número randômico)
    double semente;


    List<Fila> filas;

    //lista de eventos
    Agenda agenda;


    public Simulador(int semente){
        this.semente = semente;
        this.agenda = new Agenda();
    }

    public void simularFila(List<Fila> filas, double chegadaInicial) {
        this.filas = filas;
        //primeira inserção na Agenda, chegada inicial é dada e sorteio é nulo
        Evento evento = new Evento(EventoEnum.CHEGADA, chegadaInicial, semente, filas.get(0), new Cliente());
        agenda.addEventoEmAgenda(evento);

        for(int i = 0; i<20; i++) {
            Evento proximoEvento = agenda.getAgendaEventos().remove(0);
            Fila fila = proximoEvento.fila;
            executarEvento(proximoEvento, fila);
        }
    }

    public void executarEvento(Evento evento, Fila fila) {
        if (evento.evento == EventoEnum.CHEGADA)
            chegar(evento, fila);
        else if (evento.evento == EventoEnum.SAIDA)
            sair(evento, fila);
        else {
            /* quando for evento de ir para a próxima fila
            *  primeiro ocorre o evento de sair da fila anterior,
            *  e depois ocorre o evento de prosseguir para a próxima fila */
            Fila filaAnterior = this.filas.get(this.filas.indexOf(fila) - 1);
            sair(evento, filaAnterior);
            chegar(evento, fila);
        }
    }

    public void chegar(Evento evento, Fila fila) {
        double tempo = evento.tempo;
        // se houver espaco na fila, adicionar cliente a fila
        if (fila.getFila().size() < fila.getNumCapacidade()) {
            fila.addClienteAFila(evento.cliente);
            // Se houver servidor disponível para atender cliente, agendar saída
            if (fila.getFila().size() <= fila.getNumServidores()) {
                Evento novoEvento = criarEventoProximaFila(evento.cliente, tempo, fila);
                // se esta for a última fila, agenda saída, se não, agenda passagem para próxima fila
//                if(evento.fila.getId() == filas.size()) {
//                    novoEvento = criarEventoSaida(evento.cliente, tempo, fila);
//                } else {
//                    novoEvento = criarEventoProximaFila(evento.cliente, tempo, fila);
//                }
                agenda.addEventoEmAgenda(novoEvento);
            }
            System.out.println("FILA: " + fila.getId());
            System.out.println("inserido cliente " + evento.cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
        }
        // caso seja a primeira fila, criar evento de chegada para a primeira fila
        if (fila.getId() == 1) {
            Evento chegada = criarEventoChegada(tempo, fila);
            agenda.addEventoEmAgenda(chegada);
        }
    }

    public void sair(Evento evento, Fila fila) {
        double tempo = evento.tempo;
        Cliente cliente = fila.removerClienteDeFila();
        if (fila.getFila().size() >= fila.getNumServidores()) {
            Cliente proximoASair = fila.getFila().peek();
            if (fila.getId() == this.filas.size()) {
                agenda.addEventoEmAgenda(criarEventoSaida(proximoASair, tempo, fila));
            }
            else {
                Evento novoEvento = criarEventoProximaFila(proximoASair, tempo, fila);
//                double rnd = random();
//                if (rnd < 0.5) {
//                    // se for para agendar uma saida dessa fila para uma próxima, criar um evento do tipo PROXIMO
//                    // é importante passar por parâmetro a fila seguinte,
//                    // pois o método criarEventoProximaFila considera a fila passada por parâmetro a fila de chegada
//                    Fila proximaFila = this.filas.get(this.filas.indexOf(fila) + 1);
//                    agenda.addEventoEmAgenda(criarEventoProximaFila(proximoASair, tempo, proximaFila));
//                }
//                else {
//                    agenda.addEventoEmAgenda(criarEventoSaida(proximoASair, tempo, fila));
//                }
                agenda.addEventoEmAgenda(novoEvento);
            }
        }
        System.out.println("FILA: " + fila.getId());
        System.out.println("removendo cliente " + cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
    }

//    private Evento criarEventoProximaFila(Cliente cliente, double tempoEvento, Fila fila) {
//        semente = random();
//        double sorteio = ((fila.getTempoChegadaMax() - fila.getTempoChegadaMin()) * semente) + fila.getTempoChegadaMin();
//        double tempo = tempoEvento + sorteio;
//        return new Evento(EventoEnum.PROXIMA, tempo, sorteio, fila, cliente);
//    }

    private Evento criarEventoProximaFila(Cliente cliente, double tempoEvento, Fila fila) {
        double rnd = random();
        if (rnd < 0.5) {
            Fila proximaFila = this.filas.get(this.filas.indexOf(fila) + 1);
            semente = random();
            double sorteio = ((proximaFila.getTempoChegadaMax() - proximaFila.getTempoChegadaMin()) * semente) + proximaFila.getTempoChegadaMin();
            double tempo = tempoEvento + sorteio;
            return new Evento(EventoEnum.PROXIMA, tempo, sorteio, proximaFila, cliente);
        } else {
            return criarEventoSaida(cliente, tempoEvento, fila);
        }
    }


    private Evento criarEventoChegada(double tempoEvento, Fila fila) {
        semente = random();
        double sorteio = ((fila.getTempoChegadaMax() - fila.getTempoChegadaMin()) * semente) + fila.getTempoChegadaMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.CHEGADA, tempo, sorteio, fila, new Cliente());
    }

    private Evento criarEventoSaida(Cliente cliente, double tempoEvento, Fila fila) {
        semente = random();
        double sorteio = ((fila.getTempoAtendimentoMax() - fila.getTempoAtendimentoMin()) * semente) + fila.getTempoAtendimentoMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.SAIDA, tempo, sorteio, fila, cliente);
    }

    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }

}