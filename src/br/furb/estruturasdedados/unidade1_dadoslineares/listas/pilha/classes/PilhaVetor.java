package br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.classes;

import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.exceptions.PilhaCheiaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.exceptions.PilhaVaziaException;
import br.furb.estruturasdedados.unidade1_dadoslineares.listas.pilha.interfaces.Pilha;

public class PilhaVetor<T> implements Pilha<T> {

    public T[] info;
    public int limite;
    public int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T valor) throws PilhaCheiaException {
        if (limite == tamanho)
            throw new PilhaCheiaException();

        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() throws PilhaVaziaException {
        if (estaVazia())
            throw new PilhaVaziaException();

        T valor = peek();

        // se a lista for de objetos, é preciso remover aqui a referência do
        // objeto a ser removido

        tamanho = tamanho - 1;

        return valor;
    }

    @Override
    public T peek() throws PilhaVaziaException {
        if (estaVazia())
            throw new PilhaVaziaException();

        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        for (T valor : info)
            valor = null;

        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = tamanho - 1; i >= 0; i--) {
            string.append(info[i]);

            if (i != 0)
                string.append(",");
        }

        return string.toString();
    }

    public void concatenar(PilhaVetor<T> p) throws PilhaCheiaException {
        if (p.tamanho + tamanho > limite)
            throw new PilhaCheiaException();

        for (int i = 0; i < p.tamanho; i++)
            info[i + tamanho] = p.info[i];

        tamanho += p.tamanho;
    }
}
