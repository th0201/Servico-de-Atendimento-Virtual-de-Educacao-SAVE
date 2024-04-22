import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Matricula extends Aluno {
    private String nomeDaInstituicao;
    private int anoLetivo;
    private String curso;
    private static List<Matricula> matriculas = new ArrayList<>();

    public Matricula(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                     String rua, String numero, String email, LocalDate dataNascimento, String rg, String nomeDaMae,
                     String nomeDoPai, boolean atendimentoEspecial,  
                     String nomeDaInstituicao, int anoLetivo, String curso) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg, nomeDaMae,
                nomeDoPai, atendimentoEspecial);
        this.nomeDaInstituicao = nomeDaInstituicao;
        this.anoLetivo = anoLetivo;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso; 
    }

    public static void criarMatricula(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine().trim();
    
        // Verificar se o CPF corresponde a algum aluno
        Aluno aluno = null;
        for (Aluno a : Aluno.alunos) {
            if (a.getCpf().equals(cpf)) {
                aluno = a;
                break;
            }
        }
    
        if (aluno != null) {
            // Criar a matrícula com base nos dados do aluno
            System.out.println("Digite o nome da instituição:");
            String nomeDaInstituicao = scanner.nextLine();
            System.out.println("Digite o ano letivo:");
            int anoLetivo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Digite o curso do aluno: ");
            String curso = scanner.nextLine();
    
            // Criar a matrícula com base nos dados do aluno
            Matricula matricula = new Matricula(aluno.getNome(), aluno.getSobrenome(),
                    aluno.getCpf(), aluno.getTelefone(), aluno.getCidade(), aluno.getBairro(),
                    aluno.getRua(), aluno.getNumero(), aluno.getEmail(), aluno.getDataNascimento(),
                    aluno.getRg(), aluno.getNomeDaMae(), aluno.getNomeDoPai(), aluno.isAtendimentoEspecial(),
                    nomeDaInstituicao, anoLetivo, curso);
            Matricula.matriculas.add(matricula); // Adiciona a matrícula à lista de matrículas
            System.out.println("Matrícula criada com sucesso!");
        } else {
            System.out.println("Erro: Aluno não encontrado com o CPF fornecido!");
        }
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
                System.out.println("Curso: " + matricula.getCurso());
                System.out.println("Nome da instituição: " + matricula.getNomeDaInstituicao());
                System.out.println("Ano letivo: " + matricula.getAnoLetivo());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void visualizarMatricula(Scanner scanner) {
        if (matriculas.isEmpty()) {
            System.out.println("Não há matrículas para visualizar.");
            return;
        }
    
        // Listar matrículas para selecionar qual visualizar
        listarMatriculas();
        System.out.println("Digite o índice da matrícula que deseja visualizar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (indice >= 0 && indice < matriculas.size()) {
            Matricula matriculaSelecionada = matriculas.get(indice);
    
            // Exibir os dados da matrícula selecionada
            System.out.println("Dados da Matrícula:");
            System.out.println("Nome da instituição: " + matriculaSelecionada.getNomeDaInstituicao());
            System.out.println("Ano letivo: " + matriculaSelecionada.getAnoLetivo());
            System.out.println("Curso: " + matriculaSelecionada.getCurso());
    
            // Exibir os dados herdados da classe Aluno
            System.out.println("Dados do Aluno:");
            System.out.println("Nome: " + matriculaSelecionada.getNome());
            System.out.println("CPF: " + matriculaSelecionada.getCpf());
            System.out.println("Telefone: " + matriculaSelecionada.getTelefone());
            System.out.println("Cidade: " + matriculaSelecionada.getCidade());
            System.out.println("Bairro: " + matriculaSelecionada.getBairro());
            System.out.println("Rua: " + matriculaSelecionada.getRua());
            System.out.println("Número: " + matriculaSelecionada.getNumero());
            System.out.println("Email: " + matriculaSelecionada.getEmail());
            System.out.println("Data de Nascimento: " + matriculaSelecionada.getDataNascimento());
            System.out.println("RG: " + matriculaSelecionada.getRg());
            System.out.println("Nome da Mãe: " + matriculaSelecionada.getNomeDaMae());
            System.out.println("Nome do Pai: " + matriculaSelecionada.getNomeDoPai());
            System.out.println("Atendimento Especial: " + matriculaSelecionada.isAtendimentoEspecial());
        } else {
            System.out.println("Índice inválido.");
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

                    System.out.println("Digite o novo nome do Curso");
                    String novoCurso = scanner.nextLine();
    
                    Matricula matriculaEditada = matriculas.get(indice);
                    matriculaEditada.setNomeDaInstituicao(novoNome);
                    matriculaEditada.setAnoLetivo(novoAno);
                    matriculaEditada.setCurso(novoCurso);
    
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


