import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Fila {

    // Usado para atribuir o valor ao id da fila, incrementando a cada fila criada
    public static int idFila = 0;
    // Usado como identificador da fila, começando por 1
    private int id;
    private int numServidores, numCapacidade, tempoChegadaMin, tempoChegadaMax, tempoAtendimentoMin, tempoAtendimentoMax;
    private Queue<Cliente> fila;

    public Fila(int numServidores, int numCapacidade, int tempoChegadaMin, int tempoChegadaMax, int tempoAtendimentoMin, int tempoAtendimentoMax) {
        idFila++;
        this.id = idFila;
        this.fila = new LinkedList<Cliente>();
        this.numServidores = numServidores;
        this.numCapacidade = numCapacidade;
        this.tempoChegadaMin = tempoChegadaMin;
        this.tempoChegadaMax = tempoChegadaMax;
        this.tempoAtendimentoMin = tempoAtendimentoMin;
        this.tempoAtendimentoMax = tempoAtendimentoMax;
    }

    public Queue<Cliente> getFila() {
        return fila;
    }

    public void addClienteAFila(Cliente cliente) {
        this.fila.add(cliente);
    }

    public Cliente addClienteAFila() {
        Cliente cliente = new Cliente();
        this.fila.add(cliente);
        return cliente;
    }

    public Cliente removerClienteDeFila() {
        return this.fila.poll();
//        System.out.println("Removido cliente " + cliente.getId());
    }

    public int getId() {
        return this.id;
    }

    public int getNumServidores() {
        return numServidores;
    }

    public void setNumServidores(int numServidores) {
        this.numServidores = numServidores;
    }

    public int getNumCapacidade() {
        return numCapacidade;
    }

    public void setNumCapacidade(int numCapacidade) {
        this.numCapacidade = numCapacidade;
    }

    public int getTempoChegadaMin() {
        return tempoChegadaMin;
    }

    public void setTempoChegadaMin(int tempoChegadaMin) {
        this.tempoChegadaMin = tempoChegadaMin;
    }

    public int getTempoChegadaMax() {
        return tempoChegadaMax;
    }

    public void setTempoChegadaMax(int tempoChegadaMax) {
        this.tempoChegadaMax = tempoChegadaMax;
    }

    public int getTempoAtendimentoMin() {
        return tempoAtendimentoMin;
    }

    public void setTempoAtendimentoMin(int tempoAtendimentoMin) {
        this.tempoAtendimentoMin = tempoAtendimentoMin;
    }

    public int getTempoAtendimentoMax() {
        return tempoAtendimentoMax;
    }

    public void setTempoAtendimentoMax(int tempoAtendimentoMax) {
        this.tempoAtendimentoMax = tempoAtendimentoMax;
    }


//    public List<Evento> mergeSort(List<Evento> eventos) {
//        List<Evento> primeiraMetade = new ArrayList<Evento>();;
//        List<Evento> segundaMetade = new ArrayList<Evento>();;
//        if (eventos.size() > 2) {
//            int divisao = eventos.size() / 2;
//            primeiraMetade = eventos.subList(0, divisao - 1);
//            segundaMetade = eventos.subList(divisao, eventos.size() - 1);
//        }
//        else if(eventos.size() == 2) {
//            primeiraMetade.add(eventos.get(0));
//            segundaMetade.add(eventos.get(1));
//
//        }
//        List<Evento> retorno = new ArrayList<Evento>();
//        for (int i = 0; i < primeiraMetade.size(); i++) {
//            if (primeiraMetade.get(i).tempo < segundaMetade.get(i).tempo) {
//                retorno.add(primeiraMetade.get(i));
//                retorno.add(segundaMetade.get(i));
//            } else {
//                retorno.add(segundaMetade.get(i));
//                retorno.add(primeiraMetade.get(i));
//            }
//        }
//        return retorno;
//    }


}
