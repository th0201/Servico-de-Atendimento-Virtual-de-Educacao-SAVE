
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario{
    protected String nomeDaMae;
    protected String nomeDoPai;
    protected boolean atendimentoEspecial;
   
    protected static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                String rua, String numero, String email, LocalDate dataNascimento, String rg,
                String nomeDaMae, String nomeDoPai, boolean atendimentoEspecial) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg);
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.atendimentoEspecial = atendimentoEspecial;
        
    }

    // public Aluno() {
    // }

    // Métodos GET e SET

     public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public boolean isAtendimentoEspecial() {
        return atendimentoEspecial;
    }

    public void setAtendimentoEspecial(boolean atendimentoEspecial) {
        this.atendimentoEspecial = atendimentoEspecial;
    }  
     
    // metodo para fazer o cadastro dos alunos
    public static void criarAluno(Scanner scanner) {
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
            // Se o usuário existir, solicita os dados específicos do aluno
            System.out.print("Digite o nome da mãe: ");
            String nomeDaMae = scanner.nextLine();
            System.out.print("Digite o nome do pai: ");
            String nomeDoPai = scanner.nextLine();
            System.out.print("O aluno precisa de atendimento especial? (true/false): ");
            boolean atendimentoEspecial = scanner.nextBoolean();
            scanner.nextLine(); // Limpar o buffer do scanner
                
            // Cria o aluno com os dados do usuário e os dados específicos do aluno
            Aluno aluno = new Aluno(usuario.getNome(), usuario.getSobrenome(), usuario.getCpf(), usuario.getTelefone(),
                    usuario.getCidade(), usuario.getBairro(), usuario.getRua(), usuario.getNumero(), usuario.getEmail(),
                    usuario.getDataNascimento(), usuario.getRg(), nomeDaMae, nomeDoPai, atendimentoEspecial);
            Aluno.alunos.add(aluno); // Adiciona o aluno à lista de alunos
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            // Se o usuário não existir, exibe uma mensagem de erro
            System.out.println("Erro: O usuário correspondente não foi encontrado!");
        }
    }
    
    // metodo apara fazer uma listas dos alunos
    public static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + aluno.getNome()); 
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Telefone: " + aluno.getTelefone());
                System.out.println("Cidade: " + aluno.getCidade());
                System.out.println("Bairro: " + aluno.getBairro());
                System.out.println("Rua: " + aluno.getRua());
                System.out.println("Número: " + aluno.getNumero());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                System.out.println("RG: " + aluno.getRg());
                System.out.println("Nome da Mãe: " + aluno.getNomeDaMae()); //classe aluno
                System.out.println("Nome do Pai: " + aluno.getNomeDoPai()); //classe aluno
                System.out.println("----------------------------------");
            }
        }
    }
    
    //metodo para editar os alunos
    public static void editarAluno(Scanner scanner) {
        listarAlunos();
        System.out.print("Digite o índice do aluno que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < alunos.size()) {
            Aluno aluno = alunos.get(indice);


            System.out.print("Digite o nome da mãe: ");
            aluno.setNomeDaMae(scanner.nextLine());
            System.out.print("Digite o nome do pai: ");
            aluno.setNomeDoPai(scanner.nextLine());

            System.out.println("Aluno editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
    
    //visualizar os alunos
    public static void visualizarAluno(Scanner scanner) {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos para visualizar.");
            return;
        }
    
        // Listar todos os alunos para selecionar qual visualizar
        listarAlunos();
        System.out.println("Digite o índice do aluno que deseja visualizar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
    
        if (indice >= 0 && indice < alunos.size()) {
            Aluno alunoSelecionado = alunos.get(indice);
    
            // Exibir os detalhes do aluno selecionado
            System.out.println("Detalhes do Aluno:");
            System.out.println("Nome: " + alunoSelecionado.getNome());
            System.out.println("CPF: " + alunoSelecionado.getCpf());
            System.out.println("Telefone: " + alunoSelecionado.getTelefone());
            System.out.println("Cidade: " + alunoSelecionado.getCidade());
            System.out.println("Bairro: " + alunoSelecionado.getBairro());
            System.out.println("Rua: " + alunoSelecionado.getRua());
            System.out.println("Número: " + alunoSelecionado.getNumero());
            System.out.println("Email: " + alunoSelecionado.getEmail());
            System.out.println("Data de Nascimento: " + alunoSelecionado.getDataNascimento());
            System.out.println("RG: " + alunoSelecionado.getRg());
            System.out.println("Nome da Mãe: " + alunoSelecionado.getNomeDaMae());
            System.out.println("Nome do Pai: " + alunoSelecionado.getNomeDoPai());
            System.out.println("Atendimento Especial: " + alunoSelecionado.isAtendimentoEspecial());
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    // metodo para apagar os alunos
    public static void removerAluno(Scanner scanner) {
        listarAlunos();
        System.out.print("Digite o índice do aluno que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < alunos.size()) {
            alunos.remove(indice);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
