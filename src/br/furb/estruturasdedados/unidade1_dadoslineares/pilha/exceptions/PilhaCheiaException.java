package br.furb.estruturasdedados.unidade1_dadoslineares.pilha.exceptions;

public class PilhaCheiaException extends RuntimeException {

    public PilhaCheiaException() {
        super("Pilha cheia!");
    }
}
