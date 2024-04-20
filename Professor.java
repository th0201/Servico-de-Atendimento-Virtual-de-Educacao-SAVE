import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario{
    private String disciplina;
    private String matricula;
    private String curso;

    private static ArrayList<Professor> professores = new ArrayList<>();

    public Professor(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                   String rua, String numero, String email, LocalDate dataNascimento, String rg,
                   String disciplina, String matricula, String curso) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg);
        this.disciplina = disciplina;
        this.matricula = matricula;
        this.curso = curso;
    }

    

    // public Professor() {
    // }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String discipina) {
        this.disciplina = discipina; 
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

    public static void cadastrarProfessor(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
            
        // Verificar se o professor está na lista de usuários
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
            System.out.print("O professor precisa de atendimento especial? (true/false): ");
            boolean atendimentoEspecial = scanner.nextBoolean();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Digite a matrícula do professor: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite a disciplina do professor: ");
            String curso = scanner.nextLine();
    
            Professor professor = new Professor(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
                    dataNascimento, rg, disciplina, matricula, curso);
            professores.add(professor);
            System.out.println("Cadastrado do professor feito com sucesso!");
        } else {
            // Se o professor não estiver na lista, exibir mensagem de erro
            System.out.println("Erro: O professor não está na lista de usuários!");
        }
    }
    
    public static void listarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            System.out.println("Lista de professores:");
            for (int i = 0; i < professores.size(); i++) {
                Professor professor = professores.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Matrícula: " + professor.getMatricula());
                System.out.println("Nome: " + professor.getNome()); // Supondo que tenha um método getNome em Usuario
                System.out.println("Curso: " + professor.getCurso());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void editarProfessor(Scanner scanner) {
        listarProfessor();
        System.out.print("Digite o índice do professor que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < professores.size()) {
            Professor professor = professores.get(indice);
                        
            System.out.print("Digite a nova matrícula do professor: ");
            professor.setMatricula(scanner.nextLine());
            System.out.print("Digite o novo curso do professor: ");
            professor.setCurso(scanner.nextLine());

            System.out.println("professor editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
    
    public static void removerProfessor(Scanner scanner) {
        listarProfessor();
        System.out.print("Digite o índice do professor que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < professores.size()) {
            professores.remove(indice);
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }




}    
