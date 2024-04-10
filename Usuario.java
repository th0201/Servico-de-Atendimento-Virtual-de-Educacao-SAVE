import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private int senha;
    private int cpf;
    private String telefone;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String dataDeNascimento;

    Scanner ent = new Scanner(System.in);
    private ArrayList<Usuario> listaUsuario;

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public int getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void criarUsuario() {
        for (Usuario usuario : listaUsuario) {

            System.out.print("NOME: ");
            nome = ent.next();
            System.out.print("SENHA: ");
            senha = ent.nextInt();
            System.out.print("CPF: ");
            cpf = ent.nextInt();
            System.out.print("TELEFONE: ");
            telefone = ent.next();
            System.out.print("CIDADE: ");
            cidade = ent.next();
            System.out.print("BAIRRO: ");
            bairro = ent.next();
            System.out.print("RUA: ");
            rua = ent.next();
            System.out.print("NÚMERO: ");
            numero = ent.nextInt();
            boolean dataValida = false;

            do {
                System.out.print("DATA DE NASCIMENTO (dia/mês/ano): ");
                dataDeNascimento = ent.next();
                SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
                Date dataNascimento = null;
                try {
                    dataNascimento = formato.parse(dataDeNascimento);
                    dataValida = true;
                } catch (ParseException e) {
                    System.out.println("Data de nascimento inválida! Por favor, tente novamente.");

                }
            } while (!dataValida);
            System.out.println("Usuário cadastrado com sucesso!");
            listaUsuario.add(usuario);
        }

    }

    public void editarUsuario() {
        String novoNome;
        int novaSenha;
        String novoTelefone;
        String novaCidade;
        String novoBairro;
        String novaRua;
        int novoNumero;
        System.out.println("Digite o CPF: ");
        cpf = ent.nextInt();
        for (Usuario usuario : listaUsuario) {

            if (cpf >= 0 && cpf < listaUsuario.size()) {
                System.out.println("EDITAR DADOS");
                System.out.print("Novo Nome:");
                novoNome = ent.next();
                System.out.print("Nova Senha:");
                novaSenha = ent.nextInt();
                System.out.print("Nova Cidade:");
                novaCidade = ent.next();
                System.out.print("Nova Rua:");
                novaRua = ent.next();
                System.out.print("Novo Bairro:");
                novoBairro = ent.next();
                System.out.print("Novo Telefone:");
                novoTelefone = ent.next();
                System.out.print("Novo Número:");
                novoNumero = ent.nextInt();
                usuario.setNome(novoNome);
                usuario.setSenha(novaSenha);
                usuario.setTelefone(novoTelefone);
                usuario.setCidade(novaCidade);
                usuario.setBairro(novoBairro);
                usuario.setRua(novaRua);
                usuario.setNumero(novoNumero);
                System.out.println("Dados do Usuário editados com sucesso.");
                listaUsuario.add(usuario);
            } else {
                System.out.println("CPF inválido! O usuário não foi encontrado.");
            }
        }
    }

    public void removerUsuario() {
        System.out.println("REMOVER USUÁRIO");
        System.out.println("Digite o CPF: ");
        cpf = ent.nextInt();
        for (Usuario usuario : listaUsuario) {

            if (cpf >= 0 && cpf < listaUsuario.size()) {
                listaUsuario.remove(usuario);
                System.out.println("Usuário removido.");

            } else {
                System.out.println("CPF inválido! O usuário não foi encontrado.");
            }
        }

    }

    public void visualizarUsuario(){
        System.out.println("VISUALIZAR USUÁRIO");
        System.out.println("Digite o CPF: ");
        cpf = ent.nextInt();
        for (Usuario usuario : listaUsuario) {
            if (cpf >= 0 && cpf < listaUsuario.size()) {
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("SENHA: " + usuario.getSenha());
            System.out.println("TELEFONE: " + usuario.getTelefone());
            System.out.println("CIDADE: " + usuario.getCidade());
            System.out.println("BAIRRO: " + usuario.getBairro());
            System.out.println("NÚMERO: " + usuario.getNumero());
            System.out.println("DATA DE NASCIMENTO: " + usuario.getDataDeNascimento());
            }
    }
}

    public void listarUsuarios(){
        System.out.println("LISTA DE USUÁRIOS CADASTRADOS:");
        for (Usuario usuario : listaUsuario) {
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("SENHA: " + usuario.getSenha());
            System.out.println("TELEFONE: " + usuario.getTelefone());
            System.out.println("CIDADE: " + usuario.getCidade());
            System.out.println("BAIRRO: " + usuario.getBairro());
            System.out.println("NÚMERO: " + usuario.getNumero());
            System.out.println("DATA DE NASCIMENTO: " + usuario.getDataDeNascimento());
        }
    }
    
}
