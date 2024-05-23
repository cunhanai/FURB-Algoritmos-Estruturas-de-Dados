package unidade1.listas.arvorenaria;

import br.furb.estruturasdedados.unidade2_arvores.arvoresnarias.Arvore;
import br.furb.estruturasdedados.unidade2_arvores.arvoresnarias.NoArvore;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArvoreNAriaTest {

    Arvore<Integer> arvore = new Arvore<>();

    @Before
    public void setUp() {
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no5 = new NoArvore<>(5);

        NoArvore<Integer> no2 = new NoArvore<>(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);

        NoArvore<Integer> no8 = new NoArvore<>(8);

        NoArvore<Integer> no3 = new NoArvore<>(3);
        no3.inserirFilho(no8);

        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);

        NoArvore<Integer> no4 = new NoArvore<>(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        NoArvore<Integer> no1 = new NoArvore<>(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        arvore.setRaiz(no1);
    }

    @Test
    public void toStringTest1() {
        String texto = arvore.toString();

        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", texto);
    }

    @Test
    public void partenceTest2() {
        boolean pertence = arvore.pertence(7);

        assertTrue(pertence);
    }

    @Test
    public void naoPartenceTest3() {
        boolean pertence = arvore.pertence(55);

        assertFalse(pertence);
    }

    @Test
    public void contarNosTest4() {
        int quantidade = arvore.contarNos();

        assertEquals(10, quantidade);
    }
}
