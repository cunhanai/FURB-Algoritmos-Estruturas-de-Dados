package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada;

public class NoLista<Type> {

    private Type info;
    private NoLista<Type> proximo;

    public void setInfo(Type info) {
        this.info = info;
    }

    public Type getInfo() {
        return info;
    }

    public void setProximo(NoLista<Type> proximo) {
        this.proximo = proximo;
    }

    public NoLista<Type> getProximo() {
        return proximo;
    }
}
