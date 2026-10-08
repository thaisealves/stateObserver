package state.observer.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObserverTests {

    Usuario usuario;
    Clube clube;
    PedidoEntrada pedido;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("João");
        clube = new Clube("Clube A");
        pedido = new PedidoEntrada(usuario, clube);
    }

    // Usuário como observer

    @Test
    void deveNotificarUsuarioAoAnalisarPedido() {
        pedido.addObserver(usuario);
        pedido.analisar();
        assertEquals("Seu pedido no clube Clube A está Em Análise.", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioAoAprovarPedido() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.addObserver(usuario);
        pedido.aprovar();
        assertEquals("Seu pedido no clube Clube A está Aprovado.", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioAoReprovarPedido() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.addObserver(usuario);
        pedido.reprovar();
        assertEquals("Seu pedido no clube Clube A está Reprovado.", usuario.getUltimaNotificacao());
    }

    // Clube como observer

    @Test
    void naoDeveAdicionarMembroAoAnalisarPedido() {
        pedido.addObserver(clube);
        pedido.analisar();
        assertFalse(clube.getMembros().contains(usuario));
    }

    @Test
    void deveAdicionarMembroAoAprovarPedido() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.addObserver(clube);
        pedido.aprovar();
        assertTrue(clube.getMembros().contains(usuario));
    }

    @Test
    void naoDeveAdicionarMembroAoReprovarPedido() {
        pedido.setEstado(ApproveEstadoEmAnalise.getInstance());
        pedido.addObserver(clube);
        pedido.reprovar();
        assertFalse(clube.getMembros().contains(usuario));
    }

    // Registro de observers

    @Test
    void solicitarEntradaDeveRegistrarUsuarioEClubeComoObservers() {
        PedidoEntrada pedido = usuario.solicitarEntrada(clube);
        assertEquals(2, pedido.countObservers());

        pedido.analisar();
        assertEquals("Seu pedido no clube Clube A está Em Análise.", usuario.getUltimaNotificacao());
        assertTrue(clube.getMembros().isEmpty());

        pedido.aprovar();
        assertEquals("Seu pedido no clube Clube A está Aprovado.", usuario.getUltimaNotificacao());
        assertTrue(clube.getMembros().contains(usuario));
    }

    @Test
    void naoDeveNotificarObserversNaoRegistrados() {
        pedido.analisar();
        pedido.aprovar();
        assertNull(usuario.getUltimaNotificacao());
        assertTrue(clube.getMembros().isEmpty());
    }

    @Test
    void deveNotificarSomenteObserversDoPedidoAlterado() {
        Usuario maria = new Usuario("Maria");
        Clube clubeB = new Clube("Clube B");
        PedidoEntrada pedidoJoao = usuario.solicitarEntrada(clube);
        maria.solicitarEntrada(clubeB);

        pedidoJoao.analisar();
        pedidoJoao.aprovar();

        assertEquals("Seu pedido no clube Clube A está Aprovado.", usuario.getUltimaNotificacao());
        assertTrue(clube.getMembros().contains(usuario));
        assertNull(maria.getUltimaNotificacao());
        assertTrue(clubeB.getMembros().isEmpty());
    }

}
