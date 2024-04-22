import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
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
   
    // metodo para criar um colegio
    public static void criarInstituicao(Scanner scanner) {
        // Solicita os dados do administrador responsável pela instituição
        System.out.println("Digite os dados do administrador responsável pela instituição:");
        System.out.print("CPF do administrador: ");
        String cpfAdministrador = scanner.nextLine();
    
        // Verifica se o CPF fornecido corresponde a um usuário existente
        boolean usuarioValido = false;
        Administrador administrador = null;
        for (Administrador adm : Administrador.administradores) {
            if (adm.getCpf().equals(cpfAdministrador)) {
                usuarioValido = true;
                administrador = adm;
                break;
            }
        }
    
        if (!usuarioValido) {
            System.out.println("Erro: CPF do administrador não corresponde a um usuário existente.");
            return;
        }
    
        // Solicita os dados específicos da instituição
        System.out.println("\nDigite os dados da instituição:");
    
        System.out.print("Nome da Instituição: ");
        String nomeInstituicao = scanner.nextLine();
    
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
    
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
    
        // Cria a instituição com os dados fornecidos
        Instituicao instituicao = new Instituicao(administrador.getNome(), administrador.getSobrenome(),
                administrador.getCpf(), administrador.getTelefone(), administrador.getCidade(),
                administrador.getBairro(), administrador.getRua(), administrador.getNumero(),
                administrador.getEmail(), administrador.getDataNascimento(), administrador.getRg(),
                nomeInstituicao, endereco, cnpj);
    
        // Adiciona a instituição à lista de instituições
        Instituicao.instituicoes.add(instituicao);
    
        System.out.println("Instituição cadastrada com sucesso!");
    }
    
    // metodo para fazer uma lista das instituições
    public static void listarInstituicoes() {
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição cadastrada.");
        } else {
            System.out.println("Lista de Instituições:");
            for (int i = 0; i < instituicoes.size(); i++) {
                Instituicao instituicao = instituicoes.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome da Instituição: " + instituicao.getNomeInstituicao());
                System.out.println("Endereço: " + instituicao.getEndereco());
                System.out.println("CNPJ: " + instituicao.getCnpj());
                System.out.println("Responsável: " + instituicao.getNome() + " " + instituicao.getSobrenome());
                System.out.println("----------------------------------");
            }
        }
    }

    // metodo para editar um instituição
    public static void editarInstituicao(Scanner scanner) {
        if (instituicoes.isEmpty()) {
            System.out.println("Não há instituições cadastradas para editar.");
        } else {
            // Listar todas as instituições para escolher qual editar
            listarInstituicoes();
    
            // Solicitar o índice da instituição a ser editada
            System.out.print("Digite o índice da instituição que deseja editar: ");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
    
            // Verificar se o índice fornecido é válido
            if (indice >= 0 && indice < instituicoes.size()) {
                Instituicao instituicao = instituicoes.get(indice);
    
                // Solicitar novos dados para a instituição
                System.out.println("Digite os novos dados da instituição:");
    
                System.out.print("Novo Nome da Instituição: ");
                String novoNomeInstituicao = scanner.nextLine();
    
                System.out.print("Novo Endereço: ");
                String novoEndereco = scanner.nextLine();
    
                System.out.print("Novo CNPJ: ");
                String novoCnpj = scanner.nextLine();
    
                // Atualizar os dados da instituição
                instituicao.setNomeInstituicao(novoNomeInstituicao);
                instituicao.setEndereco(novoEndereco);
                instituicao.setCnpj(novoCnpj);
    
                System.out.println("Instituição editada com sucesso!");
            } else {
                System.out.println("Índice inválido!");
            }
        }
    }

    

    //metodo para visualizar os cadastro de colegios
    public static void visualizarInstituicao(Scanner scanner) {
        if (instituicoes.isEmpty()) {
            System.out.println("Não há instituições para visualizar.");
            return;
        }
    
        // Listar instituições para selecionar qual visualizar
        listarInstituicoes();
        System.out.println("Digite o índice da instituição que deseja visualizar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (indice >= 0 && indice < instituicoes.size()) {
            Instituicao instituicaoSelecionada = instituicoes.get(indice);
    
            // Exibir os detalhes da instituição selecionada
            System.out.println("Detalhes da Instituição:");
            System.out.println("Nome da Instituição: " + instituicaoSelecionada.getNomeInstituicao());
            System.out.println("Endereço: " + instituicaoSelecionada.getEndereco());
            System.out.println("CNPJ: " + instituicaoSelecionada.getCnpj());
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    //metodo para apagar um colegio
    public static void removerInstituicao(Scanner scanner) {
        if (instituicoes.isEmpty()) {
            System.out.println("Não há instituições para remover.");
            return;
        }
    
        // Listar instituições para selecionar qual remover
        listarInstituicoes();
        System.out.println("Digite o índice da instituição que deseja remover:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (indice >= 0 && indice < instituicoes.size()) {
            Instituicao instituicaoRemover = instituicoes.get(indice);
    
            // Remover a instituição selecionada da lista
            instituicoes.remove(instituicaoRemover);
            System.out.println("Instituição removida com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
  
}
