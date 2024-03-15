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
}
