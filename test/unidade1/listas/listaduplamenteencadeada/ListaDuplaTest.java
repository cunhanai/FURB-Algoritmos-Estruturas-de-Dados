package unidade1.listas.listaduplamenteencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaduplamenteencadeada.ListaDupla;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaduplamenteencadeada.NoListaDupla;
import org.junit.Assert;
import org.junit.Test;

public class ListaDuplaTest {

    @Test
    public void inserirTest() {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> primeiroProximo = lista.getPrimeiro();
        NoListaDupla<Integer> segundoProximo = primeiroProximo.getProximo();
        NoListaDupla<Integer> terceiroProximo = segundoProximo.getProximo();
        NoListaDupla<Integer> quartoProximo = terceiroProximo.getProximo();

        NoListaDupla<Integer> terceiroUltimo = quartoProximo.getAnterior();
        NoListaDupla<Integer> segundoUltimo = terceiroUltimo.getAnterior();
        NoListaDupla<Integer> primeiroUltimo = segundoUltimo.getAnterior();

        Assert.assertEquals(20, (int)primeiroProximo.getInfo());
        Assert.assertEquals(15, (int)segundoProximo.getInfo());
        Assert.assertEquals(10, (int)terceiroProximo.getInfo());
        Assert.assertEquals(5, (int)quartoProximo.getInfo());
        Assert.assertEquals(10, (int)terceiroUltimo.getInfo());
        Assert.assertEquals(15, (int)segundoUltimo.getInfo());
        Assert.assertEquals(20, (int)primeiroUltimo.getInfo());
    }

    @Test
    public void testSublista() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2,5);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistaNegativoInicial() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(-1,5);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistaNegativoFinal() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2,-1);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistaAcimaFinal() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2,7);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistaAcimaInicial() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(7,8);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistaRangeInvalido() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(5,2);

        Assert.assertEquals("30,40,50,60", lista2.toString());
    }

    @Test
    public void testSublistaRangeDoisAcima() {
        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(0,2);

        Assert.assertEquals("10,20,30", lista2.toString());
    }
}
