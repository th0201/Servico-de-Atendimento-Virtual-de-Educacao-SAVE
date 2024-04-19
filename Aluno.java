
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario{
    protected String nomeDaMae;
    protected String nomeDoPai;
    protected boolean atendimentoEspecial;
    protected String matricula;
    protected String curso;

    protected static ArrayList<Aluno> alunos = new ArrayList<>();


    public Aluno(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                String rua, String numero, String email, LocalDate dataNascimento, String rg,
                String nomeDaMae, String nomeDoPai, boolean atendimentoEspecial,
                String matricula, String curso) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg);
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.atendimentoEspecial = atendimentoEspecial;
        this.matricula = matricula;
        this.curso = curso;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

     public static void criarAluno(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        // Mais informações do aluno...
    
        // Verificar se o aluno está na lista de usuários
        boolean encontrado = false;
        for (Usuario usuario : Usuario.usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                encontrado = true;
                break;
            }
        }
    
        if (encontrado) {
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Digite a cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Digite o bairro: ");
            String bairro = scanner.nextLine();
            System.out.print("Digite a rua: ");
            String rua = scanner.nextLine();
            System.out.print("Digite o número: ");
            String numero = scanner.nextLine();
            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
            System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
            System.out.print("Digite o RG: ");
            String rg = scanner.nextLine();
            System.out.print("Digite o nome da mãe: ");
            String nomeDaMae = scanner.nextLine();
            System.out.print("Digite o nome do pai: ");
            String nomeDoPai = scanner.nextLine();
            System.out.print("O aluno precisa de atendimento especial? (true/false): ");
            boolean atendimentoEspecial = scanner.nextBoolean();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite o curso do aluno: ");
            String curso = scanner.nextLine();
    
            Aluno aluno = new Aluno(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
                    dataNascimento, rg, nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso);
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            // Se o aluno não estiver na lista, exibir mensagem de erro
            System.out.println("Erro: O aluno não está na lista de usuários!");
        }
    }



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
                System.out.println("Matrícula: " + aluno.getMatricula());
                System.out.println("Nome: " + aluno.getNome()); // Supondo que tenha um método getNome em Usuario
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void editarAluno(Scanner scanner) {
        listarAlunos();
        System.out.print("Digite o índice do aluno que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < alunos.size()) {
            Aluno aluno = alunos.get(indice);


            System.out.print("Digite a nova matrícula do aluno: ");
            aluno.setMatricula(scanner.nextLine());
            System.out.print("Digite o novo curso do aluno: ");
            aluno.setCurso(scanner.nextLine());

            System.out.println("Aluno editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }




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
