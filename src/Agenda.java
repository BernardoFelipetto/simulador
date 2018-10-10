import java.util.ArrayList;
import java.util.List;

public class Agenda {

    List<Evento> eventos;

    public Agenda() {
        this.eventos = new ArrayList<Evento>();
    }

    public List<Evento> getAgendaEventos(){
        return this.eventos;
    }

    // adicionar evento mantendo-os em ordem
    public void addEventoEmAgenda(Evento novoEvento) {
        if (this.eventos.isEmpty())
            eventos.add(novoEvento);
        else {
            for (Evento evento: this.eventos) {
                if (evento.tempo > novoEvento.tempo){
                    eventos.add(eventos.indexOf(evento), novoEvento);
                    return;
                }
            }
            eventos.add(novoEvento);
        }
    }

}
