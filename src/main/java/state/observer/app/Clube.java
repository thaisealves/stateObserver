package state.observer.app;

import java.util.*;

public class Clube implements java.util.Observer {
    private String nome;
    private List<Usuario> membros = new ArrayList<>();

    public Clube(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    @Override
    public void update(Observable o, Object arg) {
        PedidoEntrada pedido = (PedidoEntrada) o;
        if (pedido.getEstado() == ApproveEstadoAprovado.getInstance()) {
            membros.add(pedido.getUsuario());
        }
    }

}
