package state.observer.app;

public class ApproveEstadoEmAnalise extends ApproveEstado {
    private ApproveEstadoEmAnalise() {
    }

    private static ApproveEstadoEmAnalise instance = new ApproveEstadoEmAnalise();

    public static ApproveEstadoEmAnalise getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Análise";
    }

    @Override 
    public void aprovar(PedidoEntrada pedido) {
        pedido.setEstado(ApproveEstadoAprovado.getInstance());
    }

    @Override 
    public void reprovar(PedidoEntrada pedido) {
        pedido.setEstado(ApproveEstadoReprovado.getInstance());
    }

}
