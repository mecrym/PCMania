package pcmania.cliente;

import pcmania.computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int quantidadeComputadores;

    public Cliente(String nome, String cpf, int capacidade) {
        this.nome = nome;
        this.cpf = cpf;
        if(capacidade < 0) {
            capacidade = 0;
        }
        this.computadores = new Computador[capacidade];
        this.quantidadeComputadores = 0;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Computador[] getComputadores(){
        return computadores;
    }
    public int getQuantidade(){
        return quantidadeComputadores;
    }

    public void addComputador(Computador computador){
        if (quantidadeComputadores >= computadores.length) {
            Computador[] novoComputador = new Computador[computadores.length * 2];
            for(int i = 0; i <  computadores.length; i++){
                novoComputador[i] = computadores[i];
            }
            computadores = novoComputador;
        }
        computadores[quantidadeComputadores++] = computador;
    }

    public float calculaTotalCompra(){
        float total = 0;
        for(int i=0; i<quantidadeComputadores; i++){
            total +=computadores[i].getPreco();
        }
        return total;
    }
}
