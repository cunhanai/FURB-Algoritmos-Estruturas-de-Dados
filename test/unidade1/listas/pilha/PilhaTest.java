package unidade1.listas.pilha;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.classes.PilhaVetor;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.exceptions.PilhaCheiaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.exceptions.PilhaVaziaException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilhaTest {

    @Test
    public void estaVaziaPilhaVaziaTest1() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);

        boolean isVazia = pilha.estaVazia();

        assertTrue(isVazia);
    }

    @Test
    public void estaVaziaPilhaComValorTest2() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);

        boolean isVazia = pilha.estaVazia();

        assertFalse(isVazia);
    }

    @Test
    public void pushAndPopTest3() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);

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

    @Test(expected = PilhaCheiaException.class)
    public void pilhaCheiaExceptionTest4() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
    }

    @Test(expected = PilhaVaziaException.class)
    public void pilhaVaziaExceptionTest5() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);

        int valor = pilha.pop();
    }

    @Test
    public void peekTopoPilhaTest6() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        int valorPeek = pilha.peek();
        int valorPop = pilha.pop();

        assertEquals(30, valorPeek);
        assertEquals(30, valorPop);
    }

    @Test
    public void liberarTest7() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();
        boolean vazia = pilha.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void concatenarPilhasTest8() {
        PilhaVetor<Integer> pilha1 = new PilhaVetor<>(5);

        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);

        pilha2.push(40);
        pilha2.push(50);

        pilha1.concatenar(pilha2);
        String str1 = pilha1.toString();
        String str2 = pilha2.toString();

        assertEquals("50,40,30,20,10", str1);
        assertEquals("50,40", str2);
    }
 }
