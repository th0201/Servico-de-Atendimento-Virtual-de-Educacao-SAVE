


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
//import java.time.LocalTime;

public class Matricula extends Aluno {
    private String nomeDaInstituicao;
    private int anoLetivo;

    protected static List<Matricula> matriculas = new ArrayList<>();

    
    public Matricula(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
    String rua, String numero, String email, LocalDate dataNascimento, String rg, String nomeDaMae, String nomeDoPai,
    boolean atendimentoEspecial, String matricula, String curso, String nomeDaInstituicao, int anoLetivo) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg, nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso);
        this.nomeDaInstituicao = nomeDaInstituicao;
        this.anoLetivo = anoLetivo;
}

    public String getNomeDaInstituicao() {
        return nomeDaInstituicao;
    }

    public void setNomeDaInstituicao(String nomeDaInstituicao) {
        this.nomeDaInstituicao = nomeDaInstituicao;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public static void criarMatricula(Scanner scanner) {

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

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

        
        System.out.println("Digite o nome da instituição:");
        String nomeDaInstituicao = scanner.nextLine();

        System.out.println("Digite o ano letivo:");
        int anoLetivo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Matricula novaMatricula = new Matricula(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
        dataNascimento, rg, nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso, nomeDaInstituicao, anoLetivo);
        matriculas.add(novaMatricula);
        System.out.println("Matrícula criada com sucesso: " + novaMatricula);
    }

    public static void listarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < matriculas.size(); i++) {
                Matricula matricula = matriculas.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + matricula.getNome());
                System.out.println("CPF: " + matricula.getCpf());
                System.out.println("Telefone: " + matricula.getTelefone());
                System.out.println("Cidade: " + matricula.getCidade());
                System.out.println("Bairro: " + matricula.getBairro());
                System.out.println("Rua: " + matricula.getRua());
                System.out.println("Número: " + matricula.getNumero());
                System.out.println("Email: " + matricula.getEmail());
                System.out.println("Data de Nascimento: " + matricula.getDataNascimento());
                System.out.println("RG: " + matricula.getRg());
                System.out.println("Matrícula: " + matricula.getMatricula());
                System.out.println("Curso: " + matricula.getCurso());
                System.out.println("Nome da instituição: " + matricula.getNomeDaInstituicao());
                System.out.println("Ano letivo: " + matricula.getAnoLetivo());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void removerMatricula(Scanner scanner) {
        if (matriculas.isEmpty()) {
            System.out.println("Não há matrículas para remover.");
        } else {
            listarMatriculas();
            System.out.println("Digite o índice da matrícula que deseja remover:");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (indice >= 0 && indice < matriculas.size()) {
                Matricula matriculaRemovida = matriculas.remove(indice);
                System.out.println("Matrícula removida com sucesso: " + matriculaRemovida);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

        public static void editarMatricula(Scanner scanner) {
            if (matriculas.isEmpty()) {
                System.out.println("Não há matrículas para editar.");
            } else {
                listarMatriculas();
                System.out.println("Digite o índice da matrícula que deseja editar:");
                int indice = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
    
                if (indice >= 0 && indice < matriculas.size()) {
                    System.out.println("Digite o novo nome da instituição:");
                    String novoNome = scanner.nextLine();
    
                    System.out.println("Digite o novo ano letivo:");
                    int novoAno = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
    
                    Matricula matriculaEditada = matriculas.get(indice);
                    matriculaEditada.setNomeDaInstituicao(novoNome);
                    matriculaEditada.setAnoLetivo(novoAno);
    
                    System.out.println("Matrícula editada com sucesso: " + matriculaEditada);
                } else {
                    System.out.println("Índice inválido.");
                }
            }
        }
    

    // Métodos para listar, editar e remover matrículas...

    // @Override
    // public String toString() {
    //     return "Matricula{" +
    //             "nomeDaInstituicao='" + nomeDaInstituicao + '\'' +
    //             ", anoLetivo=" + anoLetivo +
    //             '}';
    // }
}


