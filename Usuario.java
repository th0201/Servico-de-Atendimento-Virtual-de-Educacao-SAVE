import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected String telefone;
    protected String cidade;
    protected String bairro;
    protected String rua;
    protected String numero;
    protected String email;
    protected LocalDate dataNascimento;
    protected String rg;
    protected Notas notas;

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                   String rua, String numero, String email, LocalDate dataNascimento, String rg) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        //this.notas = notas;
    }

    // public Usuario() {
    // }
    
    // Métodos GET e SET 
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

     // Getter e Setter para o atributo Notas
     public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public static boolean verificarCredenciais(String nomeUsuario, String senha) {
        // Verifica se o nome de usuário e a senha correspondem
        return nomeUsuario.equals("usuario") && senha.equals("123");
    }


    public static Usuario criarUsuario(Scanner scanner) {
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
    
        Usuario usuario = new Usuario(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
                dataNascimento, rg);
        usuarios.add(usuario);
        System.out.println("Usuário criado com sucesso!");
        return usuario; // Retorna o usuário recém-criado
    }
    

    public static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Lista de Usuários:");
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                System.out.println("Índice: " + i);
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Sobrenome: " + usuario.getSobrenome());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("Telefone: " + usuario.getTelefone());
                System.out.println("Cidade: " + usuario.getCidade());
                System.out.println("Bairro: " + usuario.getBairro());
                System.out.println("Rua: " + usuario.getRua());
                System.out.println("Número: " + usuario.getNumero());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
                System.out.println("RG: " + usuario.getRg());
                System.out.println("----------------------------------");
            }
        }
    }


    public static void editarUsuario(Scanner scanner) {
        listarUsuarios();
        System.out.print("Digite o índice do usuário que deseja editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < usuarios.size()) {
            Usuario usuario = usuarios.get(indice);

            System.out.print("Digite o novo nome: ");
            usuario.setNome(scanner.nextLine());
            System.out.print("Digite o novo sobrenome: ");
            usuario.setSobrenome(scanner.nextLine());
            System.out.print("Digite o novo CPF: ");
            usuario.setCpf(scanner.nextLine());
            System.out.print("Digite o novo telefone: ");
            usuario.setTelefone(scanner.nextLine());
            System.out.print("Digite a nova cidade: ");
            usuario.setCidade(scanner.nextLine());
            System.out.print("Digite o novo bairro: ");
            usuario.setBairro(scanner.nextLine());
            System.out.print("Digite a nova rua: ");
            usuario.setRua(scanner.nextLine());
            System.out.print("Digite o novo número: ");
            usuario.setNumero(scanner.nextLine());
            System.out.print("Digite o novo email: ");
            usuario.setEmail(scanner.nextLine());
            System.out.print("Digite a nova data de nascimento (AAAA-MM-DD): ");
            String dataNascimentoStr = scanner.nextLine();
            usuario.setDataNascimento(LocalDate.parse(dataNascimentoStr));
            System.out.print("Digite o novo RG: ");
            usuario.setRg(scanner.nextLine());

            System.out.println("Usuário editado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void removerUsuario(Scanner scanner) {
        listarUsuarios();
        System.out.print("Digite o índice do usuário que deseja remover: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void visualizarUsuario(Scanner scanner) {
        listarUsuarios();
        System.out.print("Digite o índice do usuário que deseja visualizar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        if (indice >= 0 && indice < usuarios.size()) {
            Usuario usuario = usuarios.get(indice);
            System.out.println("Detalhes do usuário:");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Sobrenome: " + usuario.getSobrenome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("Cidade: " + usuario.getCidade());
            System.out.println("Bairro: " + usuario.getBairro());
            System.out.println("Rua: " + usuario.getRua());
            System.out.println("Número: " + usuario.getNumero());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
            System.out.println("RG: " + usuario.getRg());
        } else {
            System.out.println("Índice inválido!");
        }
    }

}
    
    
