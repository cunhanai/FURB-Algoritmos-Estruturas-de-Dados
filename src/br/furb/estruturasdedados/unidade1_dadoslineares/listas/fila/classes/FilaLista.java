package br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.classes;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.interfaces.Fila;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public void liberar() {

    }
}
