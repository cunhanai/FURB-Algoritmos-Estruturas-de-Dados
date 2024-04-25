package br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.classes;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada.ListaEncadeada;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.exceptions.PilhaVaziaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.interfaces.Pilha;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void push(T valor) throws RuntimeException {
        lista.inserir(valor);
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() throws PilhaVaziaException {
        if (estaVazia())
            throw new PilhaVaziaException();

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            T primeiro = peek();
            lista.retirar(primeiro);
        }
    }
}
