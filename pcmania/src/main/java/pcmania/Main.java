package pcmania;

import java.util.Scanner;

import pcmania.cliente.Cliente;
import pcmania.computador.Computador;
import pcmania.hardware.MemoriaUSB;
import pcmania.utils.ProcessarPedidos;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        int matricula = 710;
        int MIN_COMPUTADORES = 2;
        
        Cliente cliente = new Cliente(nome, cpf);
        
        Computador promocao1 = new Computador(
            "Apple", matricula, "Pentium core i3", 2200, "Memória RAM", 8, "HD", 500
        );
        promocao1.addSistemaOperacional("manOS Sequoia", 64);
        promocao1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
        Computador.registraPromocao(promocao1);

        Computador promocao2 = new Computador("Samsung", matricula + 1234, "Pentium core i5", 3370, "Memória Ram", 16, "HD", 1000);
        promocao2.addSistemaOperacional("Windows 8", 64);
        promocao2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
        Computador.registraPromocao(promocao2);

        Computador promocao3 = new Computador("Dell", matricula + 5678, "Pentium core i7", 4500, "Memória RAM", 32, "HD", 2000);
        promocao3.addSistemaOperacional("Windows 10", 64);
        promocao3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
        Computador.registraPromocao(promocao3);

        int codigo;

        do {
            System.out.println("Olá, bem vindo ao PCMania! Temos excelentes promoções, confira:");
            Computador.mostraPCConfigs();
            System.out.println("Caso queira comprar um de nossos computadores, saiba que nossas promoções são válidas apenas para as compras que contenham no mínimo " + MIN_COMPUTADORES + " computadores por cliente.");
            System.out.println("Deseja comprar? Digite o código do computador para adicioná-lo, sendo 1 para a promoção 1, 2 para a promoção 2 e 3 para a promoção 3. Digite 0 para finalizar a compra.");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
            codigo = scanner.nextInt();
            scanner.nextLine();

            if (codigo == 1) {
                cliente.addComputador(promocao1);
                System.out.println("Promoção 1 adicionada!");
            } else if (codigo == 2) {
                cliente.addComputador(promocao2);
                System.out.println("Promoção 2 adicionada!");
            } else if (codigo == 3) {
                cliente.addComputador(promocao3);
                System.out.println("Promoção 3 adicionada!");
            } else if (codigo == 0) {
                if (cliente.getQuantidade() < MIN_COMPUTADORES) {
                    System.out.println("Desculpe, mas você precisa comprar no mínimo " + MIN_COMPUTADORES + " computadores...");
                    System.out.println("Escolha mais um ítem da promoção antes de finalizar!");
                } else {
                    break;
                }
            } else {
                System.out.println("Código inválido. Digite 1, 2, 3 para selecionar sua promoção.");
            }
        } while (true);

        System.out.println("========== RESUMO DA COMPRA ==========");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println();

        System.out.println("Computadores adquiridos:");
        for (int i = 0; i < cliente.getQuantidade(); i++) {
            System.out.println("--- PC " + (i + 1) + " ---");
            cliente.getComputadores()[i].mostraDetalhesPromocoes();
        }

        System.out.println("Total da compra: R$" + cliente.calculaTotalCompra());

        ProcessarPedidos.processar(cliente.getComputadores());

        scanner.close();
    }
}