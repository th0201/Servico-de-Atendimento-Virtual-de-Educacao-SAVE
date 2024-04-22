import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;



public class Notas extends Instituicao {
    protected float nota1;
    protected float nota2;
    protected float nota3;
    protected float nota4;
    protected float media;
    protected String situacao;
    protected Usuario usuario;

    public Notas(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                       String rua, String numero, String email, LocalDate dataNascimento, String rg,
                       String nomeInstituicao, String endereco, String cnpj,  float nota1, float nota2, float nota3,
                       float nota4, float media, String situacao, Usuario usuario) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg, nomeInstituicao,
              endereco, cnpj);
        this.usuario = usuario;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        calcularMediaEVerificarSituacao();
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public float getMedia() {
        return media;
    }

    public String getSituacao() {
        return situacao;
    }

    // Método para adicionar as notas do aluno e calcular a média
    protected void calcularMediaEVerificarSituacao() {
        media = (nota1 + nota2 + nota3 + nota4) / 4;
        if (media >= 7.0) {
            situacao = "Aprovado";
        } else if (media < 4.0) {
            situacao = "Reprovado";
        } else {
            situacao = "Em recuperação";
        }
    }

    // Método para adicionar as notas do aluno e calcular a média
    // public static void adicionarNotas(Scanner scanner, List<Usuario> usuarios) {
    //     // Listar usuários para seleção
    //     listarUsuarios(usuarios);

    //     // Solicitar o índice do usuário
    //     System.out.print("Digite o índice do usuário para adicionar notas: ");
    //     int indiceUsuario = scanner.nextInt();
    //     scanner.nextLine(); // Limpar o buffer do scanner

    //     // Verificar se o índice é válido
    //     if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
    //         System.out.println("Índice de usuário inválido.");
    //         return;
    //     }

    //     // Obter o usuário selecionado
    //     Usuario usuario = usuarios.get(indiceUsuario);

    //     // Solicitar as notas
    //     System.out.print("Digite a primeira nota: ");
    //     float nota1 = scanner.nextFloat();
    //     System.out.print("Digite a segunda nota: ");
    //     float nota2 = scanner.nextFloat();
    //     System.out.print("Digite a terceira nota: ");
    //     float nota3 = scanner.nextFloat();
    //     System.out.print("Digite a quarta nota: ");
    //     float nota4 = scanner.nextFloat();

    //     // Criar um objeto Notas com as notas fornecidas
    //     Notas notas = new Notas(usuario, nota1, nota2, nota3, nota4);

    //     // Exibir as notas e a situação
    //     System.out.println("Notas do usuário " + usuario.getNome() + " " + usuario.getSobrenome() + ":");
    //     System.out.println("Nota 1: " + notas.getNota1());
    //     System.out.println("Nota 2: " + notas.getNota2());
    //     System.out.println("Nota 3: " + notas.getNota3());
    //     System.out.println("Nota 4: " + notas.getNota4());
    //     System.out.println("Média: " + notas.getMedia());
    //     System.out.println("Situação: " + notas.getSituacao());
    // }

    public static void adicionarNotas(Scanner scanner, List<Usuario> usuarios, Instituicao instituicao) {
        // Solicitar o índice do usuário
        System.out.print("Digite o índice do usuário para adicionar notas: ");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Verificar se o índice é válido
        if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Índice de usuário inválido.");
            return;
        }

        // Obter o usuário selecionado
        Usuario usuario = usuarios.get(indiceUsuario);

        // Solicitar as notas
        System.out.print("Digite a primeira nota: ");
        float nota1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota: ");
        float nota2 = scanner.nextFloat();
        System.out.print("Digite a terceira nota: ");
        float nota3 = scanner.nextFloat();
        System.out.print("Digite a quarta nota: ");
        float nota4 = scanner.nextFloat();

        // Criar um objeto Notas com as notas fornecidas
        Notas notas = new Notas(instituicao.getNome(), instituicao.getSobrenome(), instituicao.getCpf(), 
                                instituicao.getTelefone(), instituicao.getCidade(), instituicao.getBairro(), 
                                instituicao.getRua(), instituicao.getNumero(), instituicao.getEmail(), 
                                instituicao.getDataNascimento(), instituicao.getRg(), instituicao.getNomeInstituicao(),
                                instituicao.getEndereco(), instituicao.getCnpj(), nota1, nota2, nota3, nota4, 0, "", usuario);

        // Exibir as notas e a situação
        System.out.println("Notas do usuário " + usuario.getNome() + " " + usuario.getSobrenome() + ":");
        System.out.println("Nota 1: " + notas.getNota1());
        System.out.println("Nota 2: " + notas.getNota2());
        System.out.println("Nota 3: " + notas.getNota3());
        System.out.println("Nota 4: " + notas.getNota4());
        System.out.println("Média: " + notas.getMedia());
        System.out.println("Situação: " + notas.getSituacao());
    }
    

    public static void listarUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários para listar.");
        } else {
            System.out.println("Lista de Usuários:");
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Sobrenome: " + usuario.getSobrenome());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("----------------------------------");
            }
        }
    }

     // Método para editar as notas do usuário
     public static void editarNotas(Scanner scanner, List<Usuario> usuarios) {
        // Listar usuários para seleção
        listarUsuarios(usuarios);

        // Solicitar o índice do usuário
        System.out.print("Digite o índice do usuário para editar notas: ");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Verificar se o índice é válido
        if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Índice de usuário inválido.");
            return;
        }

        // Obter o usuário selecionado
        Usuario usuario = usuarios.get(indiceUsuario);

        // Exibir as notas atuais do usuário
        System.out.println("Notas atuais do usuário " + usuario.getNome() + " " + usuario.getSobrenome() + ":");
        System.out.println("Nota 1: " + usuario.getNotas().getNota1());
        System.out.println("Nota 2: " + usuario.getNotas().getNota2());
        System.out.println("Nota 3: " + usuario.getNotas().getNota3());
        System.out.println("Nota 4: " + usuario.getNotas().getNota4());

        // Solicitar as novas notas
        System.out.print("Digite a nova primeira nota: ");
        float novaNota1 = scanner.nextFloat();
        System.out.print("Digite a nova segunda nota: ");
        float novaNota2 = scanner.nextFloat();
        System.out.print("Digite a nova terceira nota: ");
        float novaNota3 = scanner.nextFloat();
        System.out.print("Digite a nova quarta nota: ");
        float novaNota4 = scanner.nextFloat();

        // Atualizar as notas do usuário
        usuario.getNotas().setNota1(novaNota1);
        usuario.getNotas().setNota2(novaNota2);
        usuario.getNotas().setNota3(novaNota3);
        usuario.getNotas().setNota4(novaNota4);

        // Recalcular a média e a situação
        usuario.getNotas().calcularMediaEVerificarSituacao();

        // Exibir as novas notas e a situação
        System.out.println("Novas notas do usuário " + usuario.getNome() + " " + usuario.getSobrenome() + ":");
        System.out.println("Nota 1: " + usuario.getNotas().getNota1());
        System.out.println("Nota 2: " + usuario.getNotas().getNota2());
        System.out.println("Nota 3: " + usuario.getNotas().getNota3());
        System.out.println("Nota 4: " + usuario.getNotas().getNota4());
        System.out.println("Média: " + usuario.getNotas().getMedia());
        System.out.println("Situação: " + usuario.getNotas().getSituacao());
    }

     // Método para visualizar as notas do usuário
     public static void visualizarNotas(Scanner scanner, List<Usuario> usuarios) {
        // Listar usuários para seleção
        listarUsuarios(usuarios);

        // Solicitar o índice do usuário
        System.out.print("Digite o índice do usuário para visualizar notas: ");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Verificar se o índice é válido
        if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Índice de usuário inválido.");
            return;
        }

        // Obter o usuário selecionado
        Usuario usuario = usuarios.get(indiceUsuario);

        // Exibir as notas e a situação do usuário
        System.out.println("Notas do usuário " + usuario.getNome() + " " + usuario.getSobrenome() + ":");
        System.out.println("Nota 1: " + usuario.getNotas().getNota1());
        System.out.println("Nota 2: " + usuario.getNotas().getNota2());
        System.out.println("Nota 3: " + usuario.getNotas().getNota3());
        System.out.println("Nota 4: " + usuario.getNotas().getNota4());
        System.out.println("Média: " + usuario.getNotas().getMedia());
        System.out.println("Situação: " + usuario.getNotas().getSituacao());
    }

    // Método para remover as notas do usuário
    public static void removerNotas(Scanner scanner, List<Usuario> usuarios) {
        // Listar usuários para seleção
        listarUsuarios(usuarios);

        // Solicitar o índice do usuário
        System.out.print("Digite o índice do usuário para remover notas: ");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Verificar se o índice é válido
        if (indiceUsuario < 0 || indiceUsuario >= usuarios.size()) {
            System.out.println("Índice de usuário inválido.");
            return;
        }

        // Obter o usuário selecionado
        Usuario usuario = usuarios.get(indiceUsuario);

        // Confirmar a remoção
        System.out.print("Tem certeza que deseja remover as notas do usuário "
                + usuario.getNome() + " " + usuario.getSobrenome() + "? (S/N): ");
        String confirmacao = scanner.nextLine();

        // Remover as notas se a confirmação for positiva
        if (confirmacao.equalsIgnoreCase("S")) {
            usuario.setNotas(null);
            System.out.println("Notas removidas com sucesso para o usuário "
                    + usuario.getNome() + " " + usuario.getSobrenome() + ".");
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}
  

