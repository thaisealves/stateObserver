package state.observer.app;

public class ApproveEstadoAprovado extends ApproveEstado {

    private ApproveEstadoAprovado() {
    }

    private static ApproveEstadoAprovado instance = new ApproveEstadoAprovado();

    public static ApproveEstadoAprovado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aprovado";
    }

}
