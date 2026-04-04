package pcmania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        int matricula = 710;

        Cliente cliente = new Cliente(nome, cpf);

        int codigo;
        int indice = 0;
        
    }
}