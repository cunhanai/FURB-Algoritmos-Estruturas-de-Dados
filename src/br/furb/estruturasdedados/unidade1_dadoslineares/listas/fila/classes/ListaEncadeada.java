package br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.classes;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.NoLista;
import jdk.jshell.spi.ExecutionControl;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>();

        novo.setInfo(valor);
        novo.setProximo(null);

        if (estaVazia()) {
            primeiro = novo;
        }
        else {
            ultimo.setProximo(novo);
        }

        ultimo = novo;
    }

    public boolean estaVazia() {
        return primeiro == null && ultimo == null;
    }

    public void exibir() {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor))
                return atual;

            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(valor)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (atual.equals(ultimo))
                ultimo = anterior;

            if (atual.equals(primeiro))
                primeiro = atual.getProximo();
            else
                anterior.setProximo(atual.getProximo());
        }
    }

    public int obterComprimento() {
        NoLista<T> atual = primeiro;
        int count = 0;

        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }

        return count;
    }

    public NoLista<T> obterNo(int idx) throws IndexOutOfBoundsException {
        if (idx < 0)
            throw new IndexOutOfBoundsException();

        NoLista<T> atual = primeiro;

        while (atual != null && idx > 0) {
            idx--;
            atual = atual.getProximo();
        }

        if (atual == null)
            throw new IndexOutOfBoundsException();

        return atual;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        NoLista<T> atual = primeiro;
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
