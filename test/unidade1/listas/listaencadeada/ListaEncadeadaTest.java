package unidade1.listas.listaencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.ListaEncadeada;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;
import org.junit.Assert;
import org.junit.Test;

public class ListaEncadeadaTest {

    @Test
    public void estaVaziaTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        boolean isVazia = lista.estaVazia();

        Assert.assertTrue(isVazia);
    }

    @Test
    public void naoEstaVaziaTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        boolean isVazia = lista.estaVazia();

        Assert.assertFalse(isVazia);
    }

    @Test
    public void insertUmElementoTest(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);

        NoLista<Integer> primeiro = lista.getPrimeiro();
        int info = primeiro.getInfo();
        NoLista<Integer> proximo = primeiro.getProximo();

        Assert.assertNotNull(primeiro);
        Assert.assertEquals(5, info);
        Assert.assertNull(proximo);
    }

    @Test
    public void insertVariosElementosTest(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        int tamanho = lista.obterComprimento();
        String valores = lista.toString();

        Assert.assertEquals(3, tamanho);
        Assert.assertEquals("15,10,5", valores);
    }

    @Test
    public void buscarPrimeiroTest(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> busca = lista.buscar(20);
        int info = busca.getInfo();

        Assert.assertEquals(20, info);
    }

    @Test
    public void buscarMeioTest(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> busca = lista.buscar(15);
        int info = busca.getInfo();

        Assert.assertEquals(15, info);
    }

    @Test
    public void buscarInexistenteTest(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> busca = lista.buscar(50);

        Assert.assertNull(busca);
    }

    @Test
    public void retirarPrimeiroTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        NoLista<Integer> removido = lista.buscar(20);
        int primeiro = lista.getPrimeiro().getInfo();

        Assert.assertNull(removido);
        Assert.assertEquals(15, primeiro);
        Assert.assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void retirarMeioTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);

        NoLista<Integer> removido = lista.buscar(15);

        Assert.assertNull(removido);
        Assert.assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void obterNoPrimeiroZeroTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        int info = no.getInfo();

        Assert.assertNotNull(no);
        Assert.assertEquals(20, info);
    }

    @Test
    public void obterNoUltimoTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        int info = no.getInfo();

        Assert.assertNotNull(no);
        Assert.assertEquals(5, info);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void obterNoInvalidoTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(10);
    }

    @Test
    public void obterComprimentoVazioTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        int comprimento = lista.obterComprimento();

        Assert.assertEquals(0, comprimento);
    }

    @Test
    public void obterComprimentoNaoVazioTest() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int comprimento = lista.obterComprimento();

        Assert.assertEquals(4, comprimento);
    }
}

