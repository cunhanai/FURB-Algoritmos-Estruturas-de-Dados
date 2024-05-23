package br.furb.estruturasdedados.unidade1_dadoslineares.pilha.exceptions;

public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException() {
        super("Pilha vazia!");
    }
}
