package pcmania.cliente;

import pcmania.computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void addComputador(Computador computador, int indice){
        this.computadores[indice] = computador;
    }

    public float calculaTotalCompra(){
        float total = 0;
        for(Computador computador : computadores){
            if(computador != null){
                total += computador.getPreco();
            }
        }
        return total;
    }
}
