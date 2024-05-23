package unidade1.listas.pilha;

import br.furb.estruturasdedados.unidade1_dadoslineares.pilha.classes.PilhaLista;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilhaListaTest {

    @Test
    public void estaVaziaTest1() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        boolean vazia = pilha.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void naoEstaVaziaTest2() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);

        boolean vazia = pilha.estaVazia();

        assertFalse(vazia);
    }

    @Test
    public void pushAndPopTest3() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        int valor1 = pilha.pop();
        int valor2 = pilha.pop();
        int valor3 = pilha.pop();

        boolean vazia = pilha.estaVazia();

        assertEquals(30, valor1);
        assertEquals(20, valor2);
        assertEquals(10, valor3);
        assertTrue(vazia);
    }

    @Test
    public void peekTopoTest4() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        int valorPeek = pilha.peek();
        int valorPop = pilha.pop();

        assertEquals(30, valorPeek);
        assertEquals(30, valorPop);
    }

    @Test
    public void liberarTest5() {
        PilhaLista<Integer> pilha = new PilhaLista<>();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();
        boolean vazia = pilha.estaVazia();

        assertTrue(vazia);
    }
}
