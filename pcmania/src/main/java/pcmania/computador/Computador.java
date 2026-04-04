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
    private HardwareBasico[] hardware;

    public Computador(String marcaComputador, float precoComputador, String processadorNome, float processadorFrequencia, String memoriaRamNome, float memoriaRamCapacidade, String hdNome, float hdCapacidade) {
        //comp
        this.marca = marcaComputador;
        this.preco = precoComputador;
        //so é opcional
        this.sistemaOperacional = null;
        //eis a composição...
        this.hardware = new HardwareBasico[3];
        this.hardware[0] = new HardwareBasico(processadorNome, processadorFrequencia);
        this.hardware[1] = new HardwareBasico(memoriaRamNome, memoriaRamCapacidade);
        this.hardware[2] = new HardwareBasico(hdNome, hdCapacidade);
    }

    public String getMarca() {
        return marca;
    }
    public float getPreco() {
        return preco;
    }

//esses metodo estavam sem tipo na uml, procurar o chris??
//eis um construtor? Q isso, cenas para o proximo capitulo...
    public mostraPCConfigs(){}
    public addMemoriaUSB(MemoriaUSB){}

}
