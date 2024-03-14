package br.furb.estruturasdedados.unidade1_dadoslineares.listas.listaencadeada;

public class ListaEncadeada<Type> {

    private NoLista<Type> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<Type> getPrimeiro() {
        return primeiro;
    }

    public void inserir(Type info) {
        NoLista<Type> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void exibir() {
        NoLista<Type> atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    public NoLista<Type> buscar(Type valor) {
        NoLista<Type> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor))
                return atual;

            atual = atual.getProximo();
        }

        return null;
    }

    public void retirar(Type valor) {
        NoLista<Type> anterior = null;
        NoLista<Type> atual = primeiro;

        while (atual != null && !atual.getInfo().equals(valor)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (atual.equals(primeiro))
                primeiro = atual.getProximo();
            else
                anterior.setProximo(atual.getProximo());
        }
    }

    public int obterComprimento() {
        NoLista<Type> atual = primeiro;
        int count = 0;

        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }

        return  count;
    }

    public NoLista<Type> obterNo(int idx) throws IndexOutOfBoundsException {
        if (idx < 0)
            throw new IndexOutOfBoundsException();

        NoLista<Type> atual = primeiro;

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

        NoLista<Type> atual = primeiro;
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