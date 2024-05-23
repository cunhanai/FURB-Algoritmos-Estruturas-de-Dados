package br.furb.estruturasdedados.unidade1_dadoslineares.fila.interfaces;

public interface Fila<T> {

    public void inserir(T valor);
    public boolean estaVazia();
    public T peek();
    public T retirar();
    public void liberar();
}
