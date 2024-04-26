package br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.classes;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.exceptions.FilaCheiaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.exceptions.FilaVaziaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.interfaces.Fila;

public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor (int limite) {
        info = new Object[limite];
        this.limite = limite;
        tamanho = 0;
        inicio = 0;
    }

    @Override
    public void inserir(T valor) throws FilaCheiaException {
        if (limite == tamanho)
            throw new FilaCheiaException();

        int posicao = (inicio + tamanho) % limite;

        info[posicao] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia())
            throw new FilaVaziaException();

        return (T) info[inicio];
    }

    @Override
    public T retirar() throws FilaVaziaException {
        T valor = peek();

        info[inicio] = null;

        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;
    }

    @Override
    public void liberar() {
        for (Object valor : info)
            valor = null;

        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int position = (inicio + i) % limite;

            if (info[position] != null) {
                string.append(info[position]);

                if (i < tamanho - 1)
                    string.append(",");
            }
        }

        return string.toString();
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(limite + f2.limite);

        for (int i = 0; i < tamanho; i++) {
            int position = (inicio + i) % limite;

            if (info[position] != null) {
                f3.inserir((T) info[position]);
            }
        }

        for (int i = 0; i < f2.tamanho; i++) {
            int position = (f2.inicio + i) % f2.limite;

            if (f2.info[position] != null) {
                f3.inserir((T) f2.info[position]);
            }
        }

        return f3;
    }

    public int getLimite() {
        return limite;
    }
}
