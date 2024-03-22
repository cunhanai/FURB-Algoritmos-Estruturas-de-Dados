package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaestatica;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        criarLista();
    }

    private void criarLista() {
        info = new int[10];
        tamanho = 0;
    }

    private void redimensionar() {
        int[] novoInfo = new int[tamanho + 10];

        for (int i = 0; i < tamanho; i++ ) {
            novoInfo[i] = info[i];
        }

        info = novoInfo;
    }



    public void inserir(int valor) {
        if (info.length == tamanho)
            redimensionar();

        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        System.out.println(this);
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor)
                return i;
        }

        return -1;
    }

    public void retirar(int valor) {
        int posicao = buscar(valor);

        if (posicao > -1) {
            for (int i=posicao+1; i<tamanho; i++) {
                info[i-1] = info[i];
            }

            tamanho--;
        }
    }

    public void liberar() {
        criarLista();
    }

    public int obterElemento(int posicao) throws IndexOutOfBoundsException {
        if (posicao > tamanho)
            throw new IndexOutOfBoundsException("A posição dada é maior que o número de elementos da lista");

        return info[posicao];
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
            string.append(info[i]);

            if (i < tamanho - 1)
                string.append(",");
        }

        return string.toString();
    }
}
