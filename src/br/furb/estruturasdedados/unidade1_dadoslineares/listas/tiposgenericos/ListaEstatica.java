package br.furb.estruturasdedados.unidade1_dadoslineares.listas.tiposgenericos;

public class ListaEstatica<T> {
    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        criarLista();
    }

    private void criarLista() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] novoInfo = new Object[tamanho + 10];

        for (int i = 0; i < tamanho; i++ ) {
            novoInfo[i] = info[i];
        }

        info = novoInfo;
    }

    public void inserir(int posicao, T valor) throws IndexOutOfBoundsException {
        if (posicao < 0 || posicao > tamanho)
            throw new IndexOutOfBoundsException();

        if (info.length == tamanho)
            redimensionar();

        for (int i = tamanho; i > posicao; i--) {
            info[i] = info[i-1];
        }

        info[posicao] = valor;
        tamanho++;
    }

    public void inserir(T valor) {
        if (info.length == tamanho)
            redimensionar();

        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        System.out.println(this);
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor))
                return i;
        }

        return -1;
    }

    public void retirar(T valor) {
        int index = buscar(valor);

        if (index > -1) {
            Object[] novoInfo = new Object[info.length];

            for (int i = 0; i < tamanho; i++) {
                if (i != index)
                    novoInfo[i < index ? i : i - 1] = info[i];
            }

            info = novoInfo;
            tamanho--;
        }
    }

    public void liberar() {
        criarLista();
    }

    public T obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao > tamanho)
            throw new IndexOutOfBoundsException("A posição dada é maior que o número de elementos da lista");

        return (T) info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            string.append(info[i].toString());

            if (i < tamanho - 1)
                string.append(",");
        }

        return string.toString();
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            Object aux = info[i];
            int index = tamanho-1-i;
            info[i] = info[index];
            info[index] = aux;
        }
    }
}
