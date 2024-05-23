package br.furb.estruturasdedados.unidade2_arvores.arvoresnarias;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> primeiro; // primeiro filho
    private NoArvore<T> proximo; // proximo irmão

    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }

    public void inserirFilho(NoArvore<T> sa) {
        sa.proximo = primeiro;
        primeiro = sa;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
}
