package br.com.queimadas.app;

import br.com.queimadas.model.*;

import java.util.*;

public class SistemaQueimadas {

    private static Map<String, FocoIncendio> focos = new HashMap<>();
    private static Map<String, Equipe> equipes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarFoco();
                case 2 -> cadastrarEquipe();
                case 3 -> designarEquipe();
                case 4 -> alterarStatusFoco();
                case 5 -> listarFocos();
                case 6 -> listarEquipes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("\n==== Sistema de Monitoramento de Queimadas ====");
        System.out.println("1 - Cadastrar Foco de Incêndio");
        System.out.println("2 - Cadastrar Equipe");
        System.out.println("3 - Designar Equipe para Foco");
        System.out.println("4 - Alterar Status do Foco");
        System.out.println("5 - Listar Focos");
        System.out.println("6 - Listar Equipes");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFoco() {
        System.out.print("ID do Foco: ");
        String id = scanner.nextLine();
        System.out.print("Latitude: ");
        double lat = scanner.nextDouble();
        System.out.print("Longitude: ");
        double lon = scanner.nextDouble();
        scanner.nextLine();

        FocoIncendio foco = new FocoIncendio(id, new Localizacao(lat, lon));
        focos.put(id, foco);
        System.out.println("Foco cadastrado com sucesso.");
    }

    private static void cadastrarEquipe() {
        System.out.print("ID da Equipe: ");
        String id = scanner.nextLine();
        System.out.print("Nome da Equipe: ");
        String nome = scanner.nextLine();
        System.out.print("Quantos membros? ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        List<String> membros = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            System.out.print("Nome do membro " + (i + 1) + ": ");
            membros.add(scanner.nextLine());
        }

        Equipe equipe = new Equipe(id, nome, membros);
        equipes.put(id, equipe);
        System.out.println("Equipe cadastrada com sucesso.");
    }

    private static void designarEquipe() {
        System.out.print("ID do Foco: ");
        String idFoco = scanner.nextLine();
        System.out.print("ID da Equipe: ");
        String idEquipe = scanner.nextLine();

        FocoIncendio foco = focos.get(idFoco);
        Equipe equipe = equipes.get(idEquipe);

        if (foco != null && equipe != null) {
            foco.designarEquipe(equipe);
            System.out.println("Equipe designada com sucesso.");
        } else {
            System.out.println("Foco ou equipe não encontrados.");
        }
    }

    private static void alterarStatusFoco() {
        System.out.print("ID do Foco: ");
        String id = scanner.nextLine();
        FocoIncendio foco = focos.get(id);

        if (foco != null) {
            System.out.println("Status atual: " + foco.getStatus());
            System.out.println("1 - Controlar");
            System.out.println("2 - Extinguir");
            System.out.print("Escolha a opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                foco.controlarFoco();
                System.out.println("Foco controlado.");
            } else if (opcao == 2) {
                foco.extinguirFoco();
                System.out.println("Foco extinto.");
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Foco não encontrado.");
        }
    }

    private static void listarFocos() {
        if (focos.isEmpty()) {
            System.out.println("Nenhum foco cadastrado.");
            return;
        }
        focos.values().forEach(System.out::println);
    }

    private static void listarEquipes() {
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada.");
            return;
        }
        equipes.values().forEach(System.out::println);
    }
}
