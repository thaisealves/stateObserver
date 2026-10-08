package state.observer.app;

public class ApproveEstadoReprovado extends ApproveEstado {

    private ApproveEstadoReprovado() {
    }

    private static ApproveEstadoReprovado instance = new ApproveEstadoReprovado();

    public static ApproveEstadoReprovado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Reprovado";
    }

}
