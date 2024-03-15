package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaduplamenteencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;

public class ListaDupla<Type> {
    private NoListaDupla<Type> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<Type> getPrimeiro() {
        return primeiro;
    }

    public void inserir(Type valor) {
        NoListaDupla<Type> novo = new NoListaDupla<>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null)
            primeiro.setAnterior(novo);

        primeiro = novo;
    }

    public NoListaDupla<Type> buscar(Type valor) {
        NoListaDupla<Type> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(valor)) {
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(Type valor) {
        NoListaDupla<Type> atual = buscar(valor);

        /*
        if (primeiro.getInfo().equals(valor)) {
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
        }
        */

        /*
        if (atual != null) {
            if (primeiro.equals(atual))
                primeiro = atual.getProximo();
            else
                atual.getAnterior().setProximo(atual.getProximo());

            if (atual.getProximo() != null)
                atual.getProximo().setAnterior(atual.getAnterior());
        }
         */

        NoListaDupla<Type> anterior = atual.getAnterior();

        //if (anterior != null && atual.getProximo() != null) {
            anterior.setProximo(atual.getProximo());
            anterior.getProximo().setAnterior(anterior);
        //}


    }

    public void exibirOrdemInversa() {

    }

    public void liberar() {
        /*
        liberar(): Deverá limpar a estrutura de dados. Ao invés de simplesmente atribuir null para a variável de
        instância primeiro, remova todos os encadeamentos dos nós, isto é, atribua null para a associação proximo e
        anterior em todos os nós da lista;

         */
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        NoListaDupla<Type> atual = primeiro;
        int count = 0;

        while (atual != null) {
            string.append(atual.getInfo());
            atual = atual.getProximo();

            if (atual != null)
                string.append(",");
        }

        return string.toString();
    }
}
