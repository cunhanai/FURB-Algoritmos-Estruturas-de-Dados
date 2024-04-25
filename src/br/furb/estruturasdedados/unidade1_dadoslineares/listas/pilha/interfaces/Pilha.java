package br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.interfaces;

public interface Pilha<T> {

    /**
     * Inclui um valor na pilha.
     * @param valor valor a ser incluído.
     */
    public void push(T valor) throws RuntimeException;

    /**
     * Retira um valor da pilha. Lança exceção quando não consegue.
     * @return O valor da que foi retirado.
     */
    public T pop();

    /**
     * Retorna o valor armazenado no topo da fila.
     * @return o valor armazendado no topo da fila.
     */
    public T peek() throws RuntimeException;

    /**
     * Verifica se a pilha está vazia.
     * @return true - pilha vazia. false - pilha contém elementos.
     */
    public boolean estaVazia();

    /**
     * Remove todos os dados armazenados na pilha
     */
    public void liberar();
}
