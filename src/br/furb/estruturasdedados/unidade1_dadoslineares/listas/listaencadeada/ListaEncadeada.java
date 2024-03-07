package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada;

public class ListaEncadeada {

    private NoLista primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista getPrimeiro() {
        return primeiro;
    }

    public void inserir(int info) {
        NoLista novo = new NoLista();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public void exibir() {
        NoLista atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista buscar(int valor) {
        NoLista atual = primeiro;

        while (atual != null) {
            if (atual.getInfo() == valor)
                return atual;

            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(int valor) {
        NoLista anterior = null;
        NoLista atual = primeiro;

        while (atual != null && atual.getInfo() != valor) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (atual.equals(primeiro))
                primeiro = atual.getProximo();
            else
                anterior.setProximo(atual.getProximo());
        }
    }
}