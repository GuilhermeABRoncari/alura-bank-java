import java.util.Scanner;

public class AluraBank {
    public static int command = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static double value = 0;
    public static Client client = new Client("Guilherme", "Corrente", 1300.59);

    public static void main(String[] args) {
        System.out.println(showIn(client));
        operations(command);
        scanner.close();
    }

    private static void answers(int command, Client client, double value, Scanner scanner) {
        if (command == 1) {
            command = 0;
            System.out.println("Seu saldo atual é %.2f".formatted(client.getAmount()));
            operations(command);
        }
        if (command == 2) {
            command = 0;
            System.out.println("Digite o valor a ser recebido: ");
            value = scanner.nextDouble();
            client.setAmount(client.getAmount() + value);
            System.out.println("Saldo atual: %.2f".formatted(client.getAmount()));
            operations(command);
        }
        if (command == 3) {
            System.out.println("Informe o quanto deseja transferir: ");
            value = scanner.nextDouble();
            if (value > client.getAmount() || value < 0) {
                command = 0;
                System.out.println("Valor invalido para transferencia.");
                operations(command);
            } else {
                client.setAmount(client.getAmount() - value);
                command = 0;
                System.out.println("Transferencia efetuada, saldo atual: %.2f".formatted(client.getAmount()));
                operations(command);
            }
        }
        if (command < 0 || command > 4) {
            command = 0;
            System.out.println("Operação invalida");
            operations(command);
        } else if (command == 4) {
            System.out.println("Finalizando operação...");
        }
    }

    private static String showIn(Client client) {
        return """
                *******************************************
                Dados iniciais do cliente:
                                
                Nome:          %s
                Tipo de conta: %s
                Saldo inicial: %.2f
                ******************************************* 
                """.formatted(client.getName(), client.getAccountType(), client.getAmount());
    }

    private static void operations(int command) {
        System.out.print("""
                Operações:
                1- Consultar saldo
                2- Receber Valor
                3- Transferir Valor
                4- Sair
                                
                Digite a opção desejada: 
                """);
        command = scanner.nextInt();
        answers(command, client, value, scanner);
    }
}