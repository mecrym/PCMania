package pcmania.cliente;

import pcmania.computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int quantidadeComputadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[2];
        this.quantidadeComputadores =  0;
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
            Computador[] novoArrayComputadores = new Computador[computadores.length * 2];
            for (int i = 0; i< computadores.length; i++){
                novoArrayComputadores[i] = computadores[i];
            }
            computadores = novoArrayComputadores;
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
