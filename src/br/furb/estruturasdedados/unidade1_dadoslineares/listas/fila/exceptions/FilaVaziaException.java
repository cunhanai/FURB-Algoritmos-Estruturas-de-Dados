package br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.exceptions;

public class FilaVaziaException extends RuntimeException {

    public FilaVaziaException() {
        super("Fila vazia!");
    }
}
