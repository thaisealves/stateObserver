package state.observer.app;

public class ApproveEstadoPendente extends ApproveEstado {
    private ApproveEstadoPendente() {
    }

    private static ApproveEstadoPendente instance = new ApproveEstadoPendente();

    public static ApproveEstadoPendente getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pendente";
    }

    @Override 
    public void analisar(PedidoEntrada pedido) {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
    }
}
