package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada;

public class NoLista {

    private int info;
    private NoLista proximo;

    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    public NoLista getProximo() {
        return proximo;
    }
}
