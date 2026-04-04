package pcmania.computador;

import pcmania.hardware.HardwareBasico;
import pcmania.hardware.MemoriaUSB;
import pcmania.sistema.SistemaOperacional;

public class Computador {
    private String marca;
    private float preco;
    //Computador é a parte Todo, bo pras associações, yay...
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional sistemaOperacional;
    private HardwareBasico[] hardwares;

    public Computador(String marcaComputador, float precoComputador, String processadorNome, float processadorFrequencia, String memoriaRamNome, float memoriaRamCapacidade, String hdNome, float hdCapacidade) {
        //comp
        this.marca = marcaComputador;
        this.preco = precoComputador;
        //so é opcional
        this.sistemaOperacional = null;
        this.memoriaUSB = null;
        //eis a composição...
        this.hardwares = new HardwareBasico[3];
        this.hardwares[0] = new HardwareBasico(processadorNome, processadorFrequencia);
        this.hardwares[1] = new HardwareBasico(memoriaRamNome, memoriaRamCapacidade);
        this.hardwares[2] = new HardwareBasico(hdNome, hdCapacidade);
    }

    public String getMarca() {
        return marca;
    }
    public float getPreco() {
        return preco;
    }

    public void addSistemaOperacional(String nome, int tipo) {
        this.sistemaOperacional = new SistemaOperacional(nome, tipo);
    }

    public void mostraPCConfigs(){
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco);

        for(HardwareBasico hb : hardwares){
            System.out.println(hb.getNome() + " - " + hb.getCapacidade());
        }
        if(sistemaOperacional != null){
            System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " - " + sistemaOperacional.getTipo() + " bits");
        }
        if(memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + "GB");
        }
        System.out.println();
    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoriaUSB = musb;
    }

}
