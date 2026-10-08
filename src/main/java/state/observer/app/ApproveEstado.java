package state.observer.app;

public abstract class ApproveEstado {
    public abstract String getEstado();

    public void analisar(PedidoEntrada pedido) {
        throw new IllegalStateException("Não é possível analisar um pedido " + getEstado() + ".");
    }

    public void aprovar(PedidoEntrada pedido) {
        throw new IllegalStateException("Não é possível aprovar um pedido " + getEstado() + ".");
    }

    public void reprovar(PedidoEntrada pedido) {
        throw new IllegalStateException("Não é possível reprovar um pedido " + getEstado() + ".");
    }

}
