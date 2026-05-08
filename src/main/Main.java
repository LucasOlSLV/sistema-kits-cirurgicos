package main;
import model.KitCirurgico;
import model.Item;
import service.KitService;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KitService service = new KitService();
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n1 - Criar kit");
            System.out.println("2 - Listar kits");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                System.out.println("Paciente:");
                String paciente = sc.nextLine();

                System.out.println("Cirurgia:");
                String cirurgia = sc.nextLine();

                KitCirurgico kit = new KitCirurgico(paciente, cirurgia);

                service.criarKit(kit);
                System.out.println("Kit criado com sucesso");


            } else if (opcao == 4) {
                System.out.println("encerrando");

            } else if (opcao == 2) {

                int index = 0;

                for (KitCirurgico k : service.listarKits()) {

                    System.out.println("\n--- KIT " + index + " ---");
                    System.out.println("Paciente: " + k.getPaciente());
                    System.out.println("Cirurgia: " + k.getTipoCirurgia());
                    System.out.println("Status: " + k.getStatus());

                    System.out.println("Itens:");

                    for (Item i : k.getItens()) {
                        System.out.println("material: " + i.getNome());
                        System.out.println("quantidade de " + i.getNome() + " é " + i.getQuantidade());
                    }

                    index++;

                }

            } else if (opcao == 3) {

                if (service.listarKits().isEmpty()) {
                    System.out.println("Nenhum kit cadastrado");

                } else {
                    int index = 0;

                    for (KitCirurgico k : service.listarKits()) {
                        System.out.println("[" + index + "] " + k.getPaciente() + " - " + k.getTipoCirurgia());
                        index++;
                    }
                    System.out.println("Escolha o número do kit:");
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Novo status:");
                    String novoStatus = sc.nextLine();

                    service.listarKits().get(escolha).atualizarStatus(novoStatus);

                    System.out.println("Status atualizado!");
                }


            }


        }
    }
}
