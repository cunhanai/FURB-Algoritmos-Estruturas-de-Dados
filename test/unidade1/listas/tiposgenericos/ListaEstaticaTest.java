package unidade1.listas.tiposgenericos;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.tiposgenericos.ListaEstatica;
import org.junit.Assert;
import org.junit.Test;

public class ListaEstaticaTest {

    @Test
    public void testInserirInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        String listaString = lista.toString();

        Assert.assertEquals("5,10,15,20", listaString);
    }

    @Test
    public void testGetTamanhoInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int tamanho = lista.getTamanho();

        Assert.assertEquals(4, tamanho);
    }

    @Test
    public void testBuscarValorExistenteInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int resultadoBusca = lista.buscar(15);

        Assert.assertEquals(2, resultadoBusca);
    }

    @Test
    public void testBuscarValorInexistenteInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int resultadoBusca = lista.buscar(30);

        Assert.assertEquals(-1, resultadoBusca);
    }

    @Test
    public void testRetirarInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        Assert.assertEquals("5,15,20", lista.toString());
        Assert.assertEquals(3, lista.getTamanho());
    }

    @Test
    public void testInserirComRedimensionamentoInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);
        lista.inserir(10);
        lista.inserir(11);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(14);
        lista.inserir(15);

        Assert.assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
        Assert.assertEquals(15, lista.getTamanho());
    }

    @Test
    public void testObterElementoInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int elemento = lista.obterElemento(3);

        Assert.assertEquals(20, elemento);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterElementoLancaExcecaoInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int elemento = lista.obterElemento(5);
    }

    @Test
    public void testLiberarInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        Assert.assertTrue(lista.estaVazia());
    }

    @Test
    public void testInverterParInt() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        Assert.assertEquals("20,15,10,5", lista.toString());
    }

    @Test
    public void testInverterParImpar() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();

        Assert.assertEquals("25,20,15,10,5", lista.toString());
    }
}
