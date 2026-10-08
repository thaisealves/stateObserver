package state.observer.app;

import java.util.*;

public class Usuario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PedidoEntrada solicitarEntrada(Clube clube) {
        PedidoEntrada pedido = new PedidoEntrada(this, clube);
        pedido.addObserver(this);
        pedido.addObserver(clube);
        return pedido;
    }

    @Override
    public void update(Observable o, Object arg) {
        PedidoEntrada pedido = (PedidoEntrada) o;
        this.ultimaNotificacao = "Seu pedido no clube " + pedido.getClube().getNome()
                + " está " + pedido.getEstado().getEstado() + ".";
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

}
