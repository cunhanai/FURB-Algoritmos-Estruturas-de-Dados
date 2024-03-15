package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaduplamenteencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;

public class NoListaDupla<Type> {
    private Type info;
    private NoListaDupla<Type> anterior;
    private NoListaDupla<Type> proximo;

    public void setInfo(Type info) {
        this.info = info;
    }

    public Type getInfo() {
        return info;
    }

    public void setProximo(NoListaDupla<Type> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<Type> getProximo() {
        return proximo;
    }

    public void setAnterior(NoListaDupla<Type> anterior) {
        this.anterior = anterior;
    }

    public NoListaDupla<Type> getAnterior() {
        return anterior;
    }
}
