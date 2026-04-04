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
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public float calculaTotalCompra(){
        float total = 0;
        for(int i=0; i<quantidadeComputadores; i++){
            total +=computadores[i].getPreco();
        }
        return total;
    }
}
