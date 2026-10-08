package state.observer.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTests {

    PedidoEntrada pedido;

    @BeforeEach
    void setUp() {
        pedido = new PedidoEntrada(new Usuario("João"), new Clube("Clube A"));
    }

    @Test
    void deveIniciarPendente() {
        assertEquals(ApproveEstadoPendente.getInstance(), pedido.getEstado());
    }

    // Pedido pendente

    @Test
    void deveAnalisarPedidoPendente() {
        pedido.setEstado(ApproveEstadoPendente.getInstance());
        pedido.analisar();
        assertEquals(ApproveEstadoEmAnalise.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAprovarPedidoPendente() {
        pedido.setEstado(ApproveEstadoPendente.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.aprovar());
        assertEquals("Não é possível aprovar um pedido Pendente.", e.getMessage());
        assertEquals(ApproveEstadoPendente.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveReprovarPedidoPendente() {
        pedido.setEstado(ApproveEstadoPendente.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.reprovar());
        assertEquals("Não é possível reprovar um pedido Pendente.", e.getMessage());
        assertEquals(ApproveEstadoPendente.getInstance(), pedido.getEstado());
    }

    // Pedido em análise

    @Test
    void naoDeveAnalisarPedidoEmAnalise() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.analisar());
        assertEquals("Não é possível analisar um pedido Em Análise.", e.getMessage());
        assertEquals(ApproveEstadoEmAnalise.getInstance(), pedido.getEstado());
    }

    @Test
    void deveAprovarPedidoEmAnalise() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.aprovar();
        assertEquals(ApproveEstadoAprovado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveReprovarPedidoEmAnalise() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.reprovar();
        assertEquals(ApproveEstadoReprovado.getInstance(), pedido.getEstado());
    }

    // Pedido aprovado

    @Test
    void naoDeveAnalisarPedidoAprovado() {
        pedido.setEstado(ApproveEstadoAprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.analisar());
        assertEquals("Não é possível analisar um pedido Aprovado.", e.getMessage());
        assertEquals(ApproveEstadoAprovado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAprovarPedidoAprovado() {
        pedido.setEstado(ApproveEstadoAprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.aprovar());
        assertEquals("Não é possível aprovar um pedido Aprovado.", e.getMessage());
        assertEquals(ApproveEstadoAprovado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveReprovarPedidoAprovado() {
        pedido.setEstado(ApproveEstadoAprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.reprovar());
        assertEquals("Não é possível reprovar um pedido Aprovado.", e.getMessage());
        assertEquals(ApproveEstadoAprovado.getInstance(), pedido.getEstado());
    }

    // Pedido reprovado

    @Test
    void naoDeveAnalisarPedidoReprovado() {
        pedido.setEstado(ApproveEstadoReprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.analisar());
        assertEquals("Não é possível analisar um pedido Reprovado.", e.getMessage());
        assertEquals(ApproveEstadoReprovado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveAprovarPedidoReprovado() {
        pedido.setEstado(ApproveEstadoReprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.aprovar());
        assertEquals("Não é possível aprovar um pedido Reprovado.", e.getMessage());
        assertEquals(ApproveEstadoReprovado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveReprovarPedidoReprovado() {
        pedido.setEstado(ApproveEstadoReprovado.getInstance());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.reprovar());
        assertEquals("Não é possível reprovar um pedido Reprovado.", e.getMessage());
        assertEquals(ApproveEstadoReprovado.getInstance(), pedido.getEstado());
    }

}
