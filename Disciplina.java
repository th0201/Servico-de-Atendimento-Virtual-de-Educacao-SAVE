// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Disciplina {
    private String nomeDisciplina;
    private int anoLetivo;
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina(String nomeDisciplina, int anoLetivo) {
        this.nomeDisciplina = nomeDisciplina;
        this.anoLetivo = anoLetivo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public static void entrarNaTurma(Scanner scanner) {
               
        System.out.println("Digite o nome da instituição:");
        String nomeDaInstituicao = scanner.nextLine();

        System.out.println("Digite o ano letivo:");
        int anoLetivo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Disciplina novaDisciplina = new Disciplina(nomeDaInstituicao, anoLetivo);
        disciplinas.add(novaDisciplina);
        System.out.println("Matrícula criada com sucesso: " + novaDisciplina);
    }

    
    public static void listarDisciplina() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < disciplinas.size(); i++) {
                Disciplina disciplina = disciplinas.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + disciplina.getNome());
                System.out.println("Matrícula: " + disciplina.getDisciplina());
                System.out.println("Ano letivo: " + disciplina.getAnoLetivo());
                System.out.println("----------------------------------");
            }
        }
    }





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
