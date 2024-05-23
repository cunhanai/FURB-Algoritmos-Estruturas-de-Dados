package unidade1.listas.arvovebinaria;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.arvores.arvoresbinarias.ArvoreBinaria;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.arvores.arvoresbinarias.NoArvoreBinaria;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArvoreBinariaTest {

    ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

    NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
    NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
    NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);

    NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
    NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);

    NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

    @Before
    public void setUp() {
        arvore.setRaiz(no1);
    }

    @Test
    public void arvoreVaziaTest1() {
        ArvoreBinaria<Integer> arvoreLocal = new ArvoreBinaria<>();

        boolean vazia = arvoreLocal.estaVazia();

        assertTrue(vazia);
    }

    @Test
    public void arvoreNaoVaziaTest2() {
        ArvoreBinaria<Integer> arvoreLocal = new ArvoreBinaria<>();

        NoArvoreBinaria<Integer> no = new NoArvoreBinaria<>(5);
        arvoreLocal.setRaiz(no);

        boolean vazia = arvoreLocal.estaVazia();

        assertFalse(vazia);
    }

    @Test
    public void toStringTest3() {
        String string = arvore.toString();

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", string);
    }

    @Test
    public void pertenceRaizTest4() {
        boolean pertence = arvore.pertence(1);

        assertTrue(pertence);
    }

    @Test
    public void pertenceNaoRaizTest5() {
        boolean pertence = arvore.pertence(3);

        assertTrue(pertence);
    }

    @Test
    public void pertenceFolhaTest6() {
        boolean pertence = arvore.pertence(6);

        assertTrue(pertence);
    }

    @Test
    public void naoPertenceTest7() {
        boolean pertence = arvore.pertence(10);

        assertFalse(pertence);
    }

    @Test
    public void contarNoTest8() {
        int quantidade = arvore.contarNos();

        assertEquals(6, quantidade);
    }

    @Test
    public void contarFolhasTest() {
        int qtd1 = arvore.contarFolhas(no1);
        int qtd2 = arvore.contarFolhas(no2);
        int qtd3 = arvore.contarFolhas(no3);

        assertEquals(3, qtd1);
        assertEquals(2, qtd3);
        assertEquals(1, qtd2);
    }

    @Test
    public void contarFolhasUmaTest() {
        NoArvoreBinaria<Integer> no = new NoArvoreBinaria<>(1);

        int qtd1 = arvore.contarFolhas(no);

        assertEquals(1, qtd1);
    }

    @Test
    public void contarFolhasNullTest() {
        int qtd1 = arvore.contarFolhas(null);

        assertEquals(0, qtd1);
    }
}
