import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList; 

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
    private ArrayList<Usuario> listaUsuario;
    Scanner sc = new Scanner(System.in);
    
    
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

    public void criarUsuario(){
    System.out.print("NOME: ");
    nome = sc.next();
    System.out.print("SENHA: ");
    senha = sc.nextInt();
    System.out.print("CPF: ");
    cpf = sc.nextInt();
    System.out.print("TELEFONE: ");
    telefone = sc.next();
    System.out.print("CIDADE: ");
    cidade = sc.next();
    System.out.print("BAIRRO: ");
    bairro = sc.next();
    System.out.print("RUA: ");
    rua = sc.next();
    System.out.print("NÚMERO: ");
    numero = sc.nextInt();
    System.out.print("DATA DE NASCIMENTO:");
    boolean dataValida = false;
    while(!dataValida){ 

     dataDeNascimento = sc.next();
     SimpleDateFormat formato = new SimpleDateFormat ("dd/mm/yyyy");
     Date dataNascimento = null;
     try{
            dataNascimento = formato.parse(dataDeNascimento);
            dataValida = true; 
     } catch (ParseException e) {
            System.out.println ("Data de nascimento inválida! Por favor, tente novamente.");
            System.exit(0);
          }
    }
}
    public void editarUsuario(String novoNome, int novaSenha, String novoTelefone, String novaCidade, String novoBairro, String novaRua, int novoNumero){
        System.out.println("Digite o CPF: ");
        cpf = sc.nextInt();
        if(cpf >= 0 && cpf < listaUsuario.size()){
            Usuario usuario = listaUsuario.get(cpf);
            usuario.setNome(novoNome);
            usuario.setSenha(novaSenha);
            usuario.setTelefone(novoTelefone);
            usuario.setCidade(novaCidade);
            usuario.setBairro(novoBairro);;
            usuario.setRua(novaRua);
            usuario.setNumero(novoNumero);
            System.out.println("Dados do Usuário editados com sucesso.");
        }else {
        System.out.println("CPF inválido! O usuário não foi encontrado.");
    }
    }
    sc.close();
  }
