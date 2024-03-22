package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaduplamenteencadeada;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();

        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null)
            primeiro.setAnterior(novo);

        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(valor)) {
            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

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

        NoListaDupla<T> anterior = atual.getAnterior();

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

        NoListaDupla<T> atual = primeiro;
        int count = 0;

        while (atual != null) {
            string.append(atual.getInfo());
            atual = atual.getProximo();

            if (atual != null)
                string.append(",");
        }

        return string.toString();
    }

    public ListaDupla<T> criarSubLista(int inicio, int fim) throws IndexOutOfBoundsException {
        if (inicio < 0 || fim < 0 || fim - inicio < 0)
            throw new IndexOutOfBoundsException();

        ListaDupla<T> subLista = new ListaDupla<>();
        NoListaDupla<T> p = primeiro;

        for (int i = 1; i <= fim; i++) {
            p = p.getProximo();

            if (p == null)
                throw new IndexOutOfBoundsException();
        }

        while (p != null && fim >= inicio) {
            subLista.inserir(p.getInfo());
            p = p.getAnterior();
            fim--;
        }

        return  subLista;
    }
}
