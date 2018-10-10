import Enum.EventoEnum;
import java.util.List;
import java.util.Map;

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

    public void simularFila(List<Fila> filas) {
        this.filas = filas;
        //inserir em agendas eventos de chegadas para as filas com chegadas
        for (Fila fila: filas) {
            if (fila.getTempoChegadaInicial() != 0) {
                Evento evento = new Evento(
                        EventoEnum.CHEGADA,
                        fila.getTempoChegadaInicial(),
                        semente,
                        null,
                        fila,
                        new Cliente());
                agenda.addEventoEmAgenda(evento);
            }
        }

        for(int i = 0; i<20; i++) {
            Evento proximoEvento = agenda.getAgendaEventos().remove(0);
            executarEvento(proximoEvento, proximoEvento.filaOrigem, proximoEvento.filaChegada);
        }
    }

    public void executarEvento(Evento evento, Fila filaOrigem, Fila filaChegada) {
        if (evento.evento == EventoEnum.CHEGADA)
            chegar(evento, filaChegada);
        else if (evento.evento == EventoEnum.SAIDA)
            sair(evento, filaOrigem);
        else {
            /* quando for evento de ir para a próxima fila
            *  primeiro ocorre o evento de sair da fila anterior,
            *  e depois ocorre o evento de prosseguir para a próxima fila */
//            Fila filaAnterior = this.filas.get(this.filas.indexOf(fila) - 1);
            sair(evento, filaOrigem);
            chegar(evento, filaChegada);
        }
    }

    public void chegar(Evento evento, Fila fila) {
        double tempo = evento.tempo;
        // se houver espaco na fila, adicionar cliente a fila
        if (fila.getFila().size() < fila.getNumCapacidade()) {
            fila.addClienteAFila(evento.cliente);
            // Se houver servidor disponível para atender cliente, agendar saída
            if (fila.getFila().size() <= fila.getNumServidores()) {
                agenda.addEventoEmAgenda(this.criarProximoEvento(evento.cliente, tempo, fila));
            }
            System.out.println("FILA: " + fila.getId());
            System.out.println("inserido cliente " + evento.cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
        }
        // caso seja a primeira fila, criar evento de chegada para a primeira fila
        if (fila.getTempoChegadaInicial() != 0) {
            Evento chegada = criarEventoChegada(tempo, fila);
            agenda.addEventoEmAgenda(chegada);
        }
    }

    public void sair(Evento evento, Fila fila) {
        double tempo = evento.tempo;
        Cliente cliente = fila.removerClienteDeFila();
        if (fila.getFila().size() >= fila.getNumServidores()) {
            Cliente proximoASair = fila.getFila().peek();
            agenda.addEventoEmAgenda(criarProximoEvento(proximoASair, tempo, fila));
        }
        System.out.println("FILA: " + fila.getId());
        System.out.println("removendo cliente " + cliente.getId() + " - tamanho da fila: " + fila.getFila().size() + " - tempo do evento: " + tempo);
        if(evento.evento == EventoEnum.PROXIMA)
            System.out.println("Cliente " + cliente.getId() + " está indo para a fila " + evento.filaChegada.getId());
        else
            System.out.println("Cliente " + cliente.getId() + " está saíndo do sistema de filas");
    }

    private Evento criarProximoEvento(Cliente cliente, double tempoEvento, Fila fila) {
        semente = random();
        Map<Integer, Double> filasPassagens = fila.getFilasPassagens();
        for(int filaId : filasPassagens.keySet()) {
            double valor = filasPassagens.get(filaId);
            if (valor < semente) {
                return criarEventoPassagem(cliente, tempoEvento, fila, this.buscarFilaPorId(filaId));
            }
        }
        return criarEventoSaida(cliente, tempoEvento, fila);
    }

    private Evento criarEventoPassagem(Cliente cliente, double tempoEvento, Fila filaOrigem, Fila filaChegada) {
        semente = random();
        double sorteio = ((filaOrigem.getTempoAtendimentoMin() - filaOrigem.getTempoAtendimentoMax()) * semente) + filaOrigem.getTempoAtendimentoMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.PROXIMA, tempo, sorteio, filaOrigem, filaChegada, cliente);
    }

//    private Evento sortearEntreSaidaEPassagem(Cliente cliente, double tempoEvento, Fila fila) {
//        semente = random();
//        if (semente < 0.5) {
//            Fila proximaFila = this.filas.get(this.filas.indexOf(fila) + 1);
//            return criarEventoPassagem(cliente, tempoEvento, proximaFila);
//        } else {
//            return criarEventoSaida(cliente, tempoEvento, fila);
//        }
//    }

    private Evento criarEventoChegada(double tempoEvento, Fila fila) {
        semente = random();
        double sorteio = ((fila.getTempoChegadaMax() - fila.getTempoChegadaMin()) * semente) + fila.getTempoChegadaMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.CHEGADA, tempo, sorteio, null, fila, new Cliente());
    }

    private Evento criarEventoSaida(Cliente cliente, double tempoEvento, Fila fila) {
        semente = random();
        double sorteio = ((fila.getTempoAtendimentoMax() - fila.getTempoAtendimentoMin()) * semente) + fila.getTempoAtendimentoMin();
        double tempo = tempoEvento + sorteio;
        return new Evento(EventoEnum.SAIDA, tempo, sorteio, fila, null, cliente);
    }

    private Fila buscarFilaPorId(int id) {
        for (Fila fila: this.filas) {
            if (fila.getId() == id)
                return fila;
        }
        return null;
    }

    public double random() {
        semente = (a * semente + b) % m;
        semente = semente/m;
        return semente;
    }


}