import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {


    protected static ArrayList<Administrador> administradores = new ArrayList<>();

    public Administrador(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
            String rua, String numero, String email, LocalDate dataNascimento, String rg) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg);
    }

    public static void criarAdministrador(Scanner scanner) {
        System.out.println("Digite os dados do administrador:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
        System.out.print("RG: ");
        String rg = scanner.nextLine();

        // Cria um novo administrador com os dados fornecidos
        Administrador administrador = new Administrador(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero,
                email, dataNascimento, rg);
        // Adiciona o administrador à lista de administradores
        administradores.add(administrador);

        System.out.println("Administrador criado com sucesso!");
    }

    public static void listarAdministradores() {
        if (administradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
        } else {
            System.out.println("Lista de Administradores:");
            for (Administrador administrador : administradores) {
                System.out.println(administrador);
            }
        }
    }

    public static void editarAdministrador(Scanner scanner) {
        listarAdministradores();
        System.out.print("Digite o índice do administrador que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < administradores.size()) {
            Administrador administrador = administradores.get(indice);
            System.out.println("Digite os novos dados do administrador:");
            System.out.print("Nome: ");
            administrador.setNome(scanner.nextLine());
            System.out.print("Sobrenome: ");
            administrador.setSobrenome(scanner.nextLine());
            System.out.print("CPF: ");
            administrador.setCpf(scanner.nextLine());
            System.out.print("Telefone: ");
            administrador.setTelefone(scanner.nextLine());
            System.out.print("Cidade: ");
            administrador.setCidade(scanner.nextLine());
            System.out.print("Bairro: ");
            administrador.setBairro(scanner.nextLine());
            System.out.print("Rua: ");
            administrador.setRua(scanner.nextLine());
            System.out.print("Número: ");
            administrador.setNumero(scanner.nextLine());
            System.out.print("Email: ");
            administrador.setEmail(scanner.nextLine());
            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            String dataNascimentoStr = scanner.nextLine();
            administrador.setDataNascimento(LocalDate.parse(dataNascimentoStr));
            System.out.print("RG: ");
            administrador.setRg(scanner.nextLine());

            System.out.println("Administrador editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void removerAdministrador(Scanner scanner) {
        listarAdministradores();
        System.out.print("Digite o índice do administrador que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < administradores.size()) {
            administradores.remove(indice);
            System.out.println("Administrador removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
