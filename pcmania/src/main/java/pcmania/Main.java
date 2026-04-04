package pcmania;

import java.util.Scanner;

import pcmania.cliente.Cliente;
import pcmania.computador.Computador;
import pcmania.hardware.MemoriaUSB;
import pcmania.sistema.SistemaOperacional;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        int matricula = 710;
        int capacidadeInicial = 10;
        int MIN_COMPUTADORES = 2;
        
        Cliente cliente = new Cliente(nome, cpf, capacidadeInicial);

        int codigo;
        
        do{
            System.out.println("Olá, bem vindo ao PCMania! Temos exelentes promocoes, confira:");
            mostraPCConfigs();
            System.out.println("Caso queira comprar um de nossos computadores, saiba que nossas promoções são validas apenas para as compras que contenham no mínimo " + MIN_COMPUTADORES + " computadores por cliente.");
            System.out.println("Deseja comprar? Digite o código do computador para adiciona-lo, sendo 1 para a promoção 1, 2 para a promoção 2 e 3 para a promoção 3. Digite 0 para finalizar a compra.");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
            codigo = scanner.nextInt();
            scanner.nextLine();

            if(codigo == 1){
                Computador pc = new Computador(
                    "Apple", matricula, "Pentium Core i3", 2200, "Mémoria RAM", 8, "HD", 500 
                );
                pc.addSistemaOperacional(new SistemaOperacional("macOS Sequoia", 64));
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
                cliente.addComputador(pc);

                System.out.println("Promoção 1 adicionada!");
            }else if(codigo == 2){
                Computador pc = new Computador(
                    "Samsung", matricula +1234, "Pentium Core i5", 3370, "Memória RAM", 16, "HD", 1000
                );
                pc.addSistemaOperacional(new SistemaOperacional("Windowns 8", 64));
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                cliente.addComputador(pc);
                System.out.println("Promoção 2 adicionada!");
            }else if(codigo == 3){
                Computador pc = new Computador(
                    "Dell", matricula+5678, "Pentium Core i7", 4500, "Memória RAM", 32, "HB", 2000
                );
                pc.addSistemaOperacional(new SistemaOperacional("Windows 10", 64));
                pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                cliente.addComputador(pc);
                System.out.println("Promoção 3 adicionada!");
            }else if (codigo == 0){
                if(cliente.getQuantidade() < MIN_COMPUTADORES){
                    System.out.println("Desculpe, mas você precisa comprar no mínimo "+ MIN_COMPUTADORES+" computadores...");
                    System.out.println("Escolha mais um ítem da promoção antes de finalizar!");
                }else{
                    break;
                }
            }else{
                System.out.println("Código inválido. Digite 1, 2, 3 para selecionar sua promoção.");
            }
    }while(true);
    
}