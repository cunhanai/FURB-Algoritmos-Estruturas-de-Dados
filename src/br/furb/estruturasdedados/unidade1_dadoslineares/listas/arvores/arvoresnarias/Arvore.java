package br.furb.estruturasdedados.unidade1_dadoslineares.listas.arvores.arvoresnarias;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "";

        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<" + no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        return s += ">";
    }

    public boolean pertence(T info) {
        return raiz != null && pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info)
            return true;

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            if (pertence(p, info))
                return true;

            p = p.getProximo();
        }

        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null)
            return 0;

        int quantidade = 1;

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            quantidade += contarNos(p);
            p = p.getProximo();
        }

        return quantidade;
    }
}
