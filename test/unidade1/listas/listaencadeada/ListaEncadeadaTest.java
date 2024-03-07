package unidade1.listas.listaencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.ListaEncadeada;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;
import org.junit.Assert;
import org.junit.Test;

public class ListaEncadeadaTest {

    @Test
    public void GetPrimeiroNullTest() {
        ListaEncadeada lista = new ListaEncadeada();

        Assert.assertNull(lista.getPrimeiro());
    }

    @Test
    public void insertUmElementoTest(){
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserir(5);

        NoLista primeiro = lista.getPrimeiro();

        Assert.assertNotNull(primeiro);
        Assert.assertEquals(5, primeiro.getInfo());
    }

    @Test
    public void insertVariosElementosTest(){
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista primeiro = lista.getPrimeiro();

        Assert.assertNotNull(primeiro);
        Assert.assertEquals(20, primeiro.getInfo());
    }

    @Test
    public void estaVaziaTest() {
        ListaEncadeada lista = new ListaEncadeada();

        boolean isVazia = lista.estaVazia();

        Assert.assertTrue(isVazia);
    }

    @Test
    public void buscarTest(){
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inserir(30);

        NoLista busca = lista.buscar(20);

        Assert.assertEquals(20, busca.getInfo());
        Assert.assertEquals(15, busca.getProximo().getInfo());
    }

    @Test
    public void retirarPrimeiroTest() {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inserir(30);

        lista.retirar(30);

        NoLista removido = lista.buscar(30);
        NoLista primeiro = lista.getPrimeiro();

        Assert.assertNull(removido);
        Assert.assertEquals(25, primeiro.getInfo());
    }

    @Test
    public void retirarMeioTest() {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
        lista.inserir(30);

        lista.retirar(20);

        NoLista removido = lista.buscar(20);
        NoLista anterior = lista.buscar(25);

        Assert.assertNull(removido);
        Assert.assertEquals(15, anterior.getProximo().getInfo());
    }
}

