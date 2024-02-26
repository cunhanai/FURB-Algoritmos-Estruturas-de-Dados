package unidade1.listas.listaestatica;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaestatica.ListaEstatica;
import org.junit.Assert;
import org.junit.Test;

public class ListaEstaticaTest {

    @Test
    public void testInserir() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        String listaString = lista.toString();

        Assert.assertEquals("5,10,15,20", listaString);
    }

    @Test
    public void testGetTamanho() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int tamanho = lista.getTamanho();

        Assert.assertEquals(4, tamanho);
    }

    @Test
    public void testBuscarValorExistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int resultadoBusca = lista.buscar(15);

        Assert.assertEquals(2, resultadoBusca);
    }

    @Test
    public void testBuscarValorInexistente() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int resultadoBusca = lista.buscar(30);

        Assert.assertEquals(-1, resultadoBusca);
    }

    @Test
    public void testRetirar() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        Assert.assertEquals("5,15,20", lista.toString());
        Assert.assertEquals(3, lista.getTamanho());
    }

    @Test
    public void testInserirComRedimensionamento() {
        ListaEstatica lista = new ListaEstatica();

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
    public void testObterElemento() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int elemento = lista.obterElemento(3);

        Assert.assertEquals(20, elemento);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObterElementoLancaExcecao() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int elemento = lista.obterElemento(5);
    }

    @Test
    public void testLiberar() {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        Assert.assertTrue(lista.estaVazia());
    }
}
