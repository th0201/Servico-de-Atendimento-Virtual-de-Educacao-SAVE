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
        // Solicita os dados do usuário para buscar na lista
        System.out.print("Digite o CPF do usuário: ");
        String cpf = scanner.nextLine();
    
        // Procura o usuário na lista pelo CPF
        Usuario usuario = null;
        for (Usuario u : Usuario.usuarios) {
            if (u.getCpf().equals(cpf)) {  //equals serve para fazer a comparação dos dois objetos e ver se são iguais.
                usuario = u;
                break;
            }
        }        
    
        if (usuario != null) {
           
                
            // Cria o aluno com os dados do usuário e os dados específicos do aluno
            Administrador adm = new Administrador(usuario.getNome(), usuario.getSobrenome(), usuario.getCpf(), usuario.getTelefone(),
                    usuario.getCidade(), usuario.getBairro(), usuario.getRua(), usuario.getNumero(), usuario.getEmail(),
                    usuario.getDataNascimento(), usuario.getRg());
            Administrador.administradores.add(adm); // Adiciona o aluno à lista de alunos
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            // Se o usuário não existir, exibe uma mensagem de erro
            System.out.println("Erro: O usuário correspondente não foi encontrado!");
        }
    }

    //metodo para listar os adm
    public static void listarAdministradores() {
        if (administradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
        } else {
            System.out.println("Lista de Administradores:");
            for (int i = 0; i < administradores.size(); i++) {
                Administrador administrador = administradores.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + administrador.getNome());
                System.out.println("CPF: " + administrador.getCpf());
                System.out.println("Telefone: " + administrador.getTelefone());
                System.out.println("Cidade: " + administrador.getCidade());
                System.out.println("Bairro: " + administrador.getBairro());
                System.out.println("Rua: " + administrador.getRua());
                System.out.println("Número: " + administrador.getNumero());
                System.out.println("Email: " + administrador.getEmail());
                System.out.println("Data de Nascimento: " + administrador.getDataNascimento());
                System.out.println("RG: " + administrador.getRg());
                System.out.println("----------------------------------");
            }
        }
    }
    

    //metodo para visualizar administradores
    public static void visualizarAdministrador(Scanner scanner) {
        if (administradores.isEmpty()) {
            System.out.println("Não há administradores para visualizar.");
            return;
        }
    
        // Listar todos os administradores para selecionar qual visualizar
        listarAdministradores();
        System.out.println("Digite o índice do administrador que deseja visualizar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
    
        if (indice >= 0 && indice < administradores.size()) {
            Administrador administradorSelecionado = administradores.get(indice);
    
            // Exibir os detalhes do administrador selecionado
            System.out.println("Detalhes do Administrador:");
            System.out.println("Nome: " + administradorSelecionado.getNome());
            System.out.println("CPF: " + administradorSelecionado.getCpf());
            System.out.println("Telefone: " + administradorSelecionado.getTelefone());
            System.out.println("Cidade: " + administradorSelecionado.getCidade());
            System.out.println("Bairro: " + administradorSelecionado.getBairro());
            System.out.println("Rua: " + administradorSelecionado.getRua());
            System.out.println("Número: " + administradorSelecionado.getNumero());
            System.out.println("Email: " + administradorSelecionado.getEmail());
            System.out.println("Data de Nascimento: " + administradorSelecionado.getDataNascimento());
            System.out.println("RG: " + administradorSelecionado.getRg());
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    // metodo para editar os adm
    public static void editarAdministrador(Scanner scanner) {
        listarAdministradores();
        System.out.print("Digite o índice do administrador que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
    
        if (indice >= 0 && indice < administradores.size()) {
            Administrador administrador = administradores.get(indice);
    
            System.out.print("Digite o novo nome: ");
            administrador.setNome(scanner.nextLine());
    
            System.out.print("Digite o novo sobrenome: ");
            administrador.setSobrenome(scanner.nextLine());
    
            System.out.print("Digite o novo CPF: ");
            administrador.setCpf(scanner.nextLine());
    
            System.out.print("Digite o novo telefone: ");
            administrador.setTelefone(scanner.nextLine());
    
            System.out.print("Digite a nova cidade: ");
            administrador.setCidade(scanner.nextLine());
    
            System.out.print("Digite o novo bairro: ");
            administrador.setBairro(scanner.nextLine());
    
            System.out.print("Digite a nova rua: ");
            administrador.setRua(scanner.nextLine());
    
            System.out.print("Digite o novo número: ");
            administrador.setNumero(scanner.nextLine());
    
            System.out.print("Digite o novo email: ");
            administrador.setEmail(scanner.nextLine());
    
            System.out.print("Digite a nova data de nascimento (AAAA-MM-DD): ");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
            administrador.setDataNascimento(dataNascimento);
    
            System.out.print("Digite o novo RG: ");
            administrador.setRg(scanner.nextLine());
    
            System.out.println("Administrador editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
    
    //metodo para apagar os adm
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
