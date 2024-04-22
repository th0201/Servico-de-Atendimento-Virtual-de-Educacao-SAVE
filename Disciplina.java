import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Disciplina extends Aluno {
    private String nomeDisciplina;
    private int cargaHoraria;
    private String professor;

    protected static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                      String rua, String numero, String email, LocalDate dataNascimento, String rg,
                      String nomeDaMae, String nomeDoPai, boolean atendimentoEspecial,
                      String nomeDisciplina, int cargaHoraria, String professor) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg,
                nomeDaMae, nomeDoPai, atendimentoEspecial);
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    // Getters e Setters
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    // fazer a matricula na turma
    public static void entrarNaTurma(Scanner scanner) {
        // Verificar se o limite máximo de alunos na turma foi atingido
        if (Disciplina.disciplinas.size() >= 2) { //Quantidade maxima de aluns 
            System.out.println("Erro: Limite máximo de alunos na turma atingido (50 alunos).");
            return;
        }
    
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
            // Criar a matricula no curso com base nos dados do aluno
            System.out.println("Criando uma nova matricula:");
    
            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = scanner.nextLine();
            System.out.print("Digite a quantidade de horas: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome do professor: ");
            String professor = scanner.nextLine();
    
            // Criar a disciplina com base nos dados do aluno
            Disciplina aula = new Disciplina(aluno.getNome(), aluno.getSobrenome(),
                    aluno.getCpf(), aluno.getTelefone(), aluno.getCidade(), aluno.getBairro(),
                    aluno.getRua(), aluno.getNumero(), aluno.getEmail(), aluno.getDataNascimento(),
                    aluno.getRg(), aluno.getNomeDaMae(), aluno.getNomeDoPai(), aluno.isAtendimentoEspecial(),
                    nomeDisciplina, cargaHoraria, professor);
            Disciplina.disciplinas.add(aula); // Adiciona a disciplina à lista de disciplinas
            System.out.println("Disciplina criada com sucesso!");
        } else {
            System.out.println("Erro: Aluno não encontrado com o CPF fornecido!");
        }
    }
    
    // metodo para listar os atributos da classe e pegando a herança tbm
    public static void listarDisciplina() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < disciplinas.size(); i++) {
                Disciplina disciplina = disciplinas.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome da disciplina: " + disciplina.getNomeDisciplina());
                System.out.println("Quantidade de horas: " + disciplina.getCargaHoraria());
                System.out.println("Nome do Professor: " + disciplina.getProfessor());

                 // Acessando os atributos herdados da classe Aluno
                System.out.println("Nome: " + disciplina.getNome());
                System.out.println("CPF: " + disciplina.getCpf());
                System.out.println("Telefone: " + disciplina.getTelefone());
                System.out.println("Cidade: " + disciplina.getCidade());
                System.out.println("Bairro: " + disciplina.getBairro());
                System.out.println("Rua: " + disciplina.getRua());
                System.out.println("Número: " + disciplina.getNumero());
                System.out.println("Email: " + disciplina.getEmail());
                System.out.println("Data de Nascimento: " + disciplina.getDataNascimento());
                System.out.println("RG: " + disciplina.getRg());
                System.out.println("Nome da Mãe: " + disciplina.getNomeDaMae());
                System.out.println("Nome do Pai: " + disciplina.getNomeDoPai());
                System.out.println("Atendimento Especial: " + disciplina.isAtendimentoEspecial());
                
                System.out.println("----------------------------------");
            }
        }
    }
    
    //metodo para editar
    public static void editarDisciplina(Scanner scanner) {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas para editar.");
            return;
        }
    
        // Listar disciplinas para selecionar qual editar
        listarDisciplina();
        System.out.println("Digite o índice da disciplina que deseja editar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (indice >= 0 && indice < disciplinas.size()) {
            Disciplina disciplinaSelecionada = disciplinas.get(indice);
    
            // Solicitar novos dados
            System.out.print("Digite o novo nome da disciplina: ");
            String novoNomeDisciplina = scanner.nextLine();
            System.out.print("Digite a nova quantidade de horas: ");
            int novaCargaHoraria = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Digite o novo nome do professor: ");
            String novoProfessor = scanner.nextLine();
    
            // Atualizar os dados da disciplina
            disciplinaSelecionada.setNomeDisciplina(novoNomeDisciplina);
            disciplinaSelecionada.setCargaHoraria(novaCargaHoraria);
            disciplinaSelecionada.setProfessor(novoProfessor);
    
            System.out.println("Disciplina editada com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void visualizarDisciplina(Scanner scanner) {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas para visualizar.");
            return;
        }
    
        // Listar disciplinas para selecionar qual visualizar
        listarDisciplina();
        System.out.println("Digite o índice da disciplina que deseja visualizar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (indice >= 0 && indice < disciplinas.size()) {
            Disciplina disciplinaSelecionada = disciplinas.get(indice);
    
            // Exibir os dados da disciplina selecionada
            System.out.println("Dados da Disciplina:");
            System.out.println("Nome da disciplina: " + disciplinaSelecionada.getNomeDisciplina());
            System.out.println("Quantidade de horas: " + disciplinaSelecionada.getCargaHoraria());
            System.out.println("Nome do Professor: " + disciplinaSelecionada.getProfessor());
    
            // Exibir os dados herdados da classe Aluno
            System.out.println("Dados do Aluno:");
            System.out.println("Nome: " + disciplinaSelecionada.getNome());
            System.out.println("CPF: " + disciplinaSelecionada.getCpf());
            System.out.println("Telefone: " + disciplinaSelecionada.getTelefone());
            System.out.println("Cidade: " + disciplinaSelecionada.getCidade());
            System.out.println("Bairro: " + disciplinaSelecionada.getBairro());
            System.out.println("Rua: " + disciplinaSelecionada.getRua());
            System.out.println("Número: " + disciplinaSelecionada.getNumero());
            System.out.println("Email: " + disciplinaSelecionada.getEmail());
            System.out.println("Data de Nascimento: " + disciplinaSelecionada.getDataNascimento());
            System.out.println("RG: " + disciplinaSelecionada.getRg());
            System.out.println("Nome da Mãe: " + disciplinaSelecionada.getNomeDaMae());
            System.out.println("Nome do Pai: " + disciplinaSelecionada.getNomeDoPai());
            System.out.println("Atendimento Especial: " + disciplinaSelecionada.isAtendimentoEspecial());
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    // metodo para fazer a remoçaõ     
    public static void removerDisciplina(Scanner scanner) {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas para remover.");
        } else {
            listarDisciplina();
            System.out.println("Digite o índice da disciplina que deseja remover:");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (indice >= 0 && indice < disciplinas.size()) {
                Disciplina disciplinaRemovida = disciplinas.remove(indice);
                System.out.println("Disciplina removida com sucesso: " + disciplinaRemovida);
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
   
}
