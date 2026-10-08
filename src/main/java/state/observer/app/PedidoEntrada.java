package state.observer.app;

public class PedidoEntrada extends java.util.Observable {
    private Usuario usuario;
    private Clube clube;
    private ApproveEstado estado;

    public PedidoEntrada(Usuario usuario, Clube clube) {
        this.usuario = usuario;
        this.clube = clube;
        this.estado = ApproveEstadoPendente.getInstance();
    }

    void setEstado(ApproveEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public void analisar() {
        estado.analisar(this);
    }

    public void aprovar() {
        estado.aprovar(this);
    }

    public void reprovar() {
        estado.reprovar(this);
    }

    public ApproveEstado getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Clube getClube() {
        return clube;
    }

}
