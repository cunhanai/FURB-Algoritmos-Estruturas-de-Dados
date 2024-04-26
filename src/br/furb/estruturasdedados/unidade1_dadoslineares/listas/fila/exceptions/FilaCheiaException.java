package br.furb.estruturasdedados.unidade1_dadoslineares.listas.fila.exceptions;

public class FilaCheiaException extends RuntimeException {

    public FilaCheiaException() {
        super("Fila cheia!");
    }
}
