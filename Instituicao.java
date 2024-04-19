import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.List;

public class Instituicao  extends Administrador{
    private String nomeInstituicao;
    private String endereco;
    private String cnpj;

    private static List<Instituicao> instituicoes = new ArrayList<>();

    public Instituicao(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                       String rua, String numero, String email, LocalDate dataNascimento, String rg,
                       String nomeInstituicao, String endereco, String cnpj) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg);
        this.nomeInstituicao = nomeInstituicao;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }
    

    // public Instituicao() {
        
    // }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static void cadastrarInstituicao(Scanner scanner) {
        System.out.println("Cadastrar Nova Instituição:");
        System.out.print("Nome: ");
        String nomeDaInstituicao = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        String cnpj = scanner.nextLine();

        Instituicao instituicao = new Instituicao(nomeInstituicao, endereco, cnpj);
        instituicoes.add(instituicao);
        System.out.println("Instituição cadastrada com sucesso!");
    }

    public static void listarInstituicoes() {
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição cadastrada.");
        } else {
            System.out.println("Lista de Instituições:");
            for (Instituicao instituicao : instituicoes) {
                System.out.println(instituicao);
            }
        }
    }

    public static void removerInstituicao(Scanner scanner) {
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição cadastrada para remover.");
        } else {
            listarInstituicoes();
            System.out.print("Digite o número da instituição que deseja remover: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            if (numero >= 0 && numero < instituicoes.size()) {
                instituicoes.remove(numero);
                System.out.println("Instituição removida com sucesso!");
            } else {
                System.out.println("Número de instituição inválido.");
            }
        }
    }

    public static void editarInstituicao(Scanner scanner) {
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição cadastrada para editar.");
        } else {
            listarInstituicoes();
            System.out.print("Digite o número da instituição que deseja editar: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            if (numero >= 0 && numero < instituicoes.size()) {
                Instituicao instituicao = instituicoes.get(numero);

                System.out.println("Editando Instituição:");
                System.out.print("Novo nome (atual: " + instituicao.getNome() + "): ");
                String novoNome = scanner.nextLine();
                instituicao.setNome(novoNome);

                System.out.print("Novo endereço (atual: " + instituicao.getEndereco() + "): ");
                String novoEndereco = scanner.nextLine();
                instituicao.setEndereco(novoEndereco);
                               
                System.out.print("Novo CNPJ (atual: " + instituicao.getCnpj() + "): ");
                String novoCnpj = scanner.nextLine();
                instituicao.setCnpj(novoCnpj);

                System.out.println("Instituição editada com sucesso!");
            } else {
                System.out.println("Número de instituição inválido.");
            }
        }
    }

   
}
