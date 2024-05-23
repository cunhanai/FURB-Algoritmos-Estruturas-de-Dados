package unidade1.listas.fila;

import br.furb.estruturasdedados.unidade1_dadoslineares.fila.classes.FilaLista;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaListaTest {

    @Test
    public void estaVaziaTest1() {
        FilaLista<Integer> fila = new FilaLista<>();

        boolean vazia = fila.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void naoEstaVaziaTest2() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);
        fila.inserir(20);

        boolean vazia = fila.estaVazia();

        assertFalse(vazia);
    }

    @Test
    public void inserirERetirarTest3() {
        FilaLista<Integer> fila = new FilaLista<>();

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
    public void peekInicioTest4() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        int valor1 = fila.peek();
        int valor2 = fila.retirar();

        assertEquals(10, valor1);
        assertEquals(10, valor2);
    }

    @Test
    public void liberarTest() {
        FilaLista<Integer> fila = new FilaLista<>();

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();


    }
}
