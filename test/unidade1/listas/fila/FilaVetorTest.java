package unidade1.listas.fila;

import br.furb.estruturasdedados.unidade1_dadoslineares.fila.classes.FilaVetor;
import br.furb.estruturasdedados.unidade1_dadoslineares.fila.exceptions.FilaCheiaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.fila.exceptions.FilaVaziaException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaVetorTest {

    @Test
    public void estaVaziaTest1() {
        FilaVetor<Integer> fila = new FilaVetor<>(1);

        boolean vazia = fila.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void naoEstaVaziaTest2() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);

        boolean vazia = fila.estaVazia();

        assertFalse(vazia);
    }

    @Test
    public void inserirERetirarTest3() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        int valor1 = fila.retirar();
        int valor2 = fila.retirar();
        int valor3 = fila.retirar();
        boolean vazia = fila.estaVazia();

        assertEquals(10, valor1);
        assertEquals(20, valor2);
        assertEquals(30, valor3);
        assertTrue(vazia);
    }

    @Test
    public void inserirERetirarCircularTestExtra() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);

        fila.retirar();
        fila.retirar();
        fila.retirar();

        fila.inserir(60);
        fila.inserir(10);
        String valor = fila.toString();

        assertEquals("40,50,60,10", valor);
    }

    @Test(expected = FilaCheiaException.class)
    public void filaCheiaExceptionTest4() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
    }

    @Test(expected = FilaVaziaException.class)
    public void filaVaziaExceptionTest5() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.retirar();
    }

    @Test
    public void peekTest6() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        int valorPeek = fila.peek();
        int valorRemover = fila.retirar();

        assertEquals(10, valorPeek);
        assertEquals(10, valorRemover);
    }

    @Test
    public void liberarTest7() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();
        boolean vazia = fila.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void concatenarTest8() {
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);

        fila1.inserir(10);
        fila1.inserir(20);
        fila1.inserir(30);

        FilaVetor<Integer> fila2 = new FilaVetor<>(3);

        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> filaConcatenada = fila1.criarFilaConcatenada(fila2);
        int limite = filaConcatenada.getLimite();

        String strConcat = filaConcatenada.toString();
        String str1 = fila1.toString();
        String str2 = fila2.toString();

        assertEquals("10,20,30,40,50", strConcat);
        assertEquals("10,20,30", str1);
        assertEquals("40,50", str2);
        assertEquals(8, limite);
    }

    @Test
    public void encolherCircularTest() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);

        fila.retirar();
        fila.retirar();
        fila.retirar();

        fila.inserir(60);
        fila.inserir(10);

        fila.encolher();

        String valor = fila.toString();

        assertEquals("40,50,60,10", valor);
    }

    @Test
    public void encolherTest() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);

        fila.retirar();
        fila.retirar();

        fila.encolher();

        String valor = fila.toString();

        assertEquals("30,40,50", valor);
    }
}