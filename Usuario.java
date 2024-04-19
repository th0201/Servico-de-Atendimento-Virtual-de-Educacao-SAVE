import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
//import java.time.LocalTime;
//import java.util.List;


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

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    //protected static ArrayList<Aluno> alunos = new ArrayList<>();
   // protected static ArrayList<Professor> professores = new ArrayList<>();
   // protected static List<AgendamentoReuniao> agendamentos = new ArrayList<>();
    //protected static List<Matricula> matriculas = new ArrayList<>();
    //protected static ArrayList<Administrador> administradores = new ArrayList<>();
    //protected static List<Instituicao> instituicoes = new ArrayList<>();



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

    //Cadastro para usuario//
    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static void criarUsuario(Scanner scanner) {
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
    
    //MENU para ALUNO, PROFESSOR E COLEGIO//
    //////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    // public static void menuCadastro() {
    //     Scanner scanner = new Scanner(System.in);
    //     int opcao = 0;

    //     do {
    //         System.out.println("Menu de Cadastro");
    //         System.out.println("1 - Cadastrar Aluno");
    //         System.out.println("2 - Cadastrar Professor");
    //         System.out.println("3 - Cadastrar Escola");
    //         System.out.println("0 - Voltar ao menu principal");
    //         System.out.print("Escolha uma opção: ");
    //         opcao = scanner.nextInt();
    //         scanner.nextLine(); // Limpar o buffer do scanner

    //         switch (opcao) {
    //             case 1:
    //                 cadastrarAluno();
    //                 break;
    //             case 2:
    //                 cadastrarProfessor();
    //                 break;
    //             //case 3:
    //             //    cadastrarEscola();
    //             //    break;
    //             case 0:
    //                 System.out.println("Voltando ao menu principal...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcao != 0);

    //     scanner.close();
    // }
    
    //Cadastro para aluno//
    //////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    
    // public static void criarAluno(Scanner scanner) {
    //     System.out.print("Digite o nome: ");
    //     String nome = scanner.nextLine();
    //     System.out.print("Digite o sobrenome: ");
    //     String sobrenome = scanner.nextLine();
    //     System.out.print("Digite o CPF: ");
    //     String cpf = scanner.nextLine();
    //     // Mais informações do aluno...
    
    //     // Verificar se o aluno está na lista de usuários
    //     boolean encontrado = false;
    //     for (Usuario usuario : Usuario.usuarios) {
    //         if (usuario.getCpf().equals(cpf)) {
    //             encontrado = true;
    //             break;
    //         }
    //     }
    
    //     if (encontrado) {
    //         System.out.print("Digite o telefone: ");
    //         String telefone = scanner.nextLine();
    //         System.out.print("Digite a cidade: ");
    //         String cidade = scanner.nextLine();
    //         System.out.print("Digite o bairro: ");
    //         String bairro = scanner.nextLine();
    //         System.out.print("Digite a rua: ");
    //         String rua = scanner.nextLine();
    //         System.out.print("Digite o número: ");
    //         String numero = scanner.nextLine();
    //         System.out.print("Digite o email: ");
    //         String email = scanner.nextLine();
    //         System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
    //         String dataNascimentoStr = scanner.nextLine();
    //         LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
    //         System.out.print("Digite o RG: ");
    //         String rg = scanner.nextLine();
    //         System.out.print("Digite o nome da mãe: ");
    //         String nomeDaMae = scanner.nextLine();
    //         System.out.print("Digite o nome do pai: ");
    //         String nomeDoPai = scanner.nextLine();
    //         System.out.print("O aluno precisa de atendimento especial? (true/false): ");
    //         boolean atendimentoEspecial = scanner.nextBoolean();
    //         scanner.nextLine(); // Limpar o buffer do scanner
    //         System.out.print("Digite a matrícula do aluno: ");
    //         String matricula = scanner.nextLine();
    //         System.out.print("Digite o curso do aluno: ");
    //         String curso = scanner.nextLine();
    
    //         Aluno aluno = new Aluno(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
    //                 dataNascimento, rg, nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso);
    //         alunos.add(aluno);
    //         System.out.println("Aluno cadastrado com sucesso!");
    //     } else {
    //         // Se o aluno não estiver na lista, exibir mensagem de erro
    //         System.out.println("Erro: O aluno não está na lista de usuários!");
    //     }
    // }
    

    

    // public static void listarAlunos() {
    //     if (alunos.isEmpty()) {
    //         System.out.println("Nenhum aluno cadastrado.");
    //     } else {
    //         System.out.println("Lista de Alunos:");
    //         for (int i = 0; i < alunos.size(); i++) {
    //             Aluno aluno = alunos.get(i);
    //             System.out.println("Índice: " + i);
    //             System.out.println("Matrícula: " + aluno.getMatricula());
    //             System.out.println("Nome: " + aluno.getNome()); // Supondo que tenha um método getNome em Usuario
    //             System.out.println("Curso: " + aluno.getCurso());
    //             System.out.println("----------------------------------");
    //         }
    //     }
    // }

    // public static void editarAluno(Scanner scanner) {
    //     listarAlunos();
    //     System.out.print("Digite o índice do aluno que deseja editar: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < alunos.size()) {
    //         Aluno aluno = alunos.get(indice);

            
    //         System.out.print("Digite a nova matrícula do aluno: ");
    //         aluno.setMatricula(scanner.nextLine());
    //         System.out.print("Digite o novo curso do aluno: ");
    //         aluno.setCurso(scanner.nextLine());

    //         System.out.println("Aluno editado com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }


   

    // public static void removerAluno(Scanner scanner) {
    //     listarAlunos();
    //     System.out.print("Digite o índice do aluno que deseja remover: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < alunos.size()) {
    //         alunos.remove(indice);
    //         System.out.println("Aluno removido com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }

     //Cadastrar reunião//
    ///////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

     // Método para criar uma nova reunião
    //  public static void criarReuniao(Scanner scanner, List<AgendamentoReuniao> reunioes) {
    //     System.out.println("Criando uma nova reunião:");
    //     System.out.print("Digite a data (AAAA-MM-DD): ");
    //     String dataStr = scanner.nextLine();
    //     LocalDate data = LocalDate.parse(dataStr);
    //     System.out.print("Digite a hora (HH:MM): ");
    //     String horaStr = scanner.nextLine();
    //     LocalTime hora = LocalTime.parse(horaStr);
    //     System.out.print("Digite o local: ");
    //     String local = scanner.nextLine();

    //     AgendamentoReuniao reuniao = new AgendamentoReuniao(data, hora, local);
    //     reunioes.add(reuniao);
    //     System.out.println("Reunião criada com sucesso!");
    // }

    // // Método para editar uma reunião existente
    // public static void editarReuniao(Scanner scanner, List<AgendamentoReuniao> reunioes) {
    //     System.out.println("Editando uma reunião:");
    //     // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para editar
    //     // Depois, solicite as novas informações e atualize a reunião selecionada
    // }

    // // Método para remover uma reunião existente
    // public static void removerReuniao(Scanner scanner, List<AgendamentoReuniao> reunioes) {
    //     System.out.println("Removendo uma reunião:");
    //     // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para remover
    //     // Depois, remova a reunião selecionada da lista
    // }

    // // Método para listar todas as reuniões agendadas
    // public static void listarReunioes(List<AgendamentoReuniao> reunioes) {
    //     System.out.println("Listando todas as reuniões agendadas:");
    //     if (reunioes.isEmpty()) {
    //         System.out.println("Nenhuma reunião agendada.");
    //     } else {
    //         for (AgendamentoReuniao reuniao : reunioes) {
    //             System.out.println(reuniao);
    //         }
    //     }
    // }

    //  // Método para criar uma nova reunião
    //  public static void criarReuniao(Scanner scanner) {
    //     System.out.println("Criando uma nova reunião:");
    //     System.out.print("Digite a data (AAAA-MM-DD): ");
    //     String dataStr = scanner.nextLine();
    //     LocalDate data = LocalDate.parse(dataStr);
    //     System.out.print("Digite a hora (HH:MM): ");
    //     String horaStr = scanner.nextLine();
    //     LocalTime hora = LocalTime.parse(horaStr);
    //     System.out.print("Digite o local: ");
    //     String local = scanner.nextLine();

    //     AgendamentoReuniao reuniao = new AgendamentoReuniao(data, hora, local);
    //     agendamentos.add(reuniao);
    //     System.out.println("Reunião criada com sucesso!");
    // }

    // // Método para editar uma reunião existente
    // public static void editarReuniao(Scanner scanner) {
    //     System.out.println("Editando uma reunião:");
    //     // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para editar
    //     // Depois, solicite as novas informações e atualize a reunião selecionada
    // }

    // // Método para remover uma reunião existente
    // public static void removerReuniao(Scanner scanner) {
    //     System.out.println("Removendo uma reunião:");
    //     // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para remover
    //     // Depois, remova a reunião selecionada da lista
    // }

    // // Método para listar todas as reuniões agendadas
    // public static void listarReunioes() {
    //     System.out.println("Listando todas as reuniões agendadas:");
    //     if (agendamentos.isEmpty()) {
    //         System.out.println("Nenhuma reunião agendada.");
    //     } else {
    //         for (AgendamentoReuniao reuniao : agendamentos) {
    //             System.out.println(reuniao);
    //         }
    //     }
    // }

    //Matrícula //
    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    // public static void criarMatricula(Scanner scanner) {
    //     System.out.println("Digite o nome da instituição:");
    //     String nomeDaInstituicao = scanner.nextLine();

    //     System.out.println("Digite o ano letivo:");
    //     int anoLetivo = scanner.nextInt();
    //     scanner.nextLine(); // Limpar o buffer do scanner

    //     Matricula novaMatricula = new Matricula(nomeDaInstituicao, anoLetivo);
    //     matriculas.add(novaMatricula);
    //     System.out.println("Matrícula criada com sucesso: " + novaMatricula);
    // }

    // // Método para listar todas as matrículas
    // public static void listarMatriculas() {
    //     if (matriculas.isEmpty()) {
    //         System.out.println("Não há matrículas cadastradas.");
    //     } else {
    //         System.out.println("Lista de Matrículas:");
    //         for (Matricula matricula : matriculas) {
    //             System.out.println(matricula);
    //         }
    //     }
    // }

    // // Método para editar uma matrícula existente
    // public static void editarMatricula(Scanner scanner) {
    //     if (matriculas.isEmpty()) {
    //         System.out.println("Não há matrículas para editar.");
    //     } else {
    //         listarMatriculas();
    //         System.out.println("Digite o índice da matrícula que deseja editar:");
    //         int indice = scanner.nextInt();
    //         scanner.nextLine(); // Limpar o buffer do scanner

    //         if (indice >= 0 && indice < matriculas.size()) {
    //             System.out.println("Digite o novo nome da instituição:");
    //             String novoNome = scanner.nextLine();

    //             System.out.println("Digite o novo ano letivo:");
    //             int novoAno = scanner.nextInt();
    //             scanner.nextLine(); // Limpar o buffer do scanner

    //             Matricula matriculaEditada = matriculas.get(indice);
    //             matriculaEditada.setNomeDaInstituicao(novoNome);
    //             matriculaEditada.setAnoLetivo(novoAno);

    //             System.out.println("Matrícula editada com sucesso: " + matriculaEditada);
    //         } else {
    //             System.out.println("Índice inválido.");
    //         }
    //     }
    // }

    // // Método para remover uma matrícula existente
    // public static void removerMatricula(Scanner scanner) {
    //     if (matriculas.isEmpty()) {
    //         System.out.println("Não há matrículas para remover.");
    //     } else {
    //         listarMatriculas();
    //         System.out.println("Digite o índice da matrícula que deseja remover:");
    //         int indice = scanner.nextInt();
    //         scanner.nextLine(); // Limpar o buffer do scanner

    //         if (indice >= 0 && indice < matriculas.size()) {
    //             Matricula matriculaRemovida = matriculas.remove(indice);
    //             System.out.println("Matrícula removida com sucesso: " + matriculaRemovida);
    //         } else {
    //             System.out.println("Índice inválido.");
    //         }
    //     }
    // }

    //     public static void CadastrarAluno() {
    //     Scanner scanner = new Scanner(System.in);
    //     int opcao1;

    //     do {
    //         System.out.println("Menu:");
    //         System.out.println("1 - criar Aluno");
    //         System.out.println("2 - Editar Aluno");
    //         System.out.println("3 - Remover Aluno");
    //         System.out.println("4 - Listar Aluno");
    //         System.out.println("5 - Agendamento de reunião");
    //         System.out.println("6 - Criar Matrícula");
    //         System.out.println("6 - ");
    //         System.out.println("7 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcao1 = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcao1) {
    //             case 1:
    //                 criarAluno(scanner);
    //                 break;
    //             case 2:
    //                 editarAluno(scanner);
    //                 break;
    //             case 3:
    //                 removerAluno(scanner);
    //                 break;
    //             case 4:
    //                 listarAlunos();
    //                 break;
    //             case 5:
    //              Scanner scannerReuniao = new Scanner(System.in);
    //             int opcaoAgendamento;
    //             do {
    //                 System.out.println("Menu de Agendamento de Reuniões:");
    //                 System.out.println("1 - Criar Reunião");
    //                 System.out.println("2 - Editar Reunião");
    //                 System.out.println("3 - Remover Reunião");
    //                 System.out.println("4 - Listar Reuniões");
    //                 System.out.println("5 - Voltar ao Menu Principal");
    //                 System.out.print("Escolha uma opção: ");
    //                 opcaoAgendamento = scanner.nextInt();
    //                 scanner.nextLine(); // Limpar o buffer do scanner
                    
    //                 switch (opcaoAgendamento) {
    //                     case 1:
    //                         criarReuniao(scannerReuniao);
    //                         break;
    //                     case 2:
    //                         editarReuniao(scannerReuniao);
    //                         break;
    //                     case 3:
    //                         removerReuniao(scannerReuniao);
    //                         break;
    //                     case 4:
    //                         listarReunioes();
    //                         break;
    //                     case 5:
    //                         System.out.println("Voltando ao Menu Principal...");
    //                         break;
    //                     default:
    //                         System.out.println("Opção inválida.");
    //                 }
    //             } while (opcaoAgendamento != 5);
    //                 break;
    //             case 6:
    //                int opcaoMatricula;
    //                 do {
    //                     System.out.println("\nMenu de Matrícula:");
    //                     System.out.println("1 - Criar Matrícula");
    //                     System.out.println("2 - Listar Matrículas");
    //                     System.out.println("3 - Editar Matrícula");
    //                     System.out.println("4 - Remover Matrícula");
    //                     System.out.println("5 - Voltar ao Menu Principal");
    //                     System.out.print("Escolha uma opção: ");
    //                     opcaoMatricula = scanner.nextInt();
    //                     scanner.nextLine(); // Limpar o buffer do scanner
            
    //                     switch (opcaoMatricula) {
    //                         case 1:
    //                             Matricula.criarMatricula(scanner);
    //                             break;
    //                         case 2:
    //                             Matricula.listarMatriculas();
    //                             break;
    //                         case 3:
    //                             Matricula.editarMatricula(scanner);
    //                             break;
    //                         case 4:
    //                             Matricula.removerMatricula(scanner);
    //                             break;
    //                         case 5:
    //                             System.out.println("Voltando ao Menu Principal...");
    //                             break;
    //                         default:
    //                             System.out.println("Opção inválida.");
    //                     }
    //                 } while (opcaoMatricula != 5);                
    //                 break;
    //             case 7:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcao1 != 8);

    //     scanner.close();
    // }

   

    // Cadastrar Professores //
    ///////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    //public static void cadastrarProfessor() {
      //  ;

    // public static void cadastrarProfessor(Scanner scanner) {
    //     System.out.print("Digite o nome: ");
    //     String nome = scanner.nextLine();
    //     System.out.print("Digite o sobrenome: ");
    //     String sobrenome = scanner.nextLine();
    //     System.out.print("Digite o CPF: ");
    //     String cpf = scanner.nextLine();
            
    //     // Verificar se o professor está na lista de usuários
    //     boolean encontrado = false;
    //     for (Usuario usuario : Usuario.usuarios) {
    //         if (usuario.getCpf().equals(cpf)) {
    //             encontrado = true;
    //             break;
    //         }
    //     }
    
    //     if (encontrado) {
    //         System.out.print("Digite o telefone: ");
    //         String telefone = scanner.nextLine();
    //         System.out.print("Digite a cidade: ");
    //         String cidade = scanner.nextLine();
    //         System.out.print("Digite o bairro: ");
    //         String bairro = scanner.nextLine();
    //         System.out.print("Digite a rua: ");
    //         String rua = scanner.nextLine();
    //         System.out.print("Digite o número: ");
    //         String numero = scanner.nextLine();
    //         System.out.print("Digite o email: ");
    //         String email = scanner.nextLine();
    //         System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
    //         String dataNascimentoStr = scanner.nextLine();
    //         LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
    //         System.out.print("Digite o RG: ");
    //         String rg = scanner.nextLine();
    //         System.out.print("Digite o nome da mãe: ");
    //         String nomeDaMae = scanner.nextLine();
    //         System.out.print("Digite o nome do pai: ");
    //         String nomeDoPai = scanner.nextLine();
    //         System.out.print("O professor precisa de atendimento especial? (true/false): ");
    //         boolean atendimentoEspecial = scanner.nextBoolean();
    //         scanner.nextLine(); // Limpar o buffer do scanner
    //         System.out.print("Digite a matrícula do professor: ");
    //         String matricula = scanner.nextLine();
    //         System.out.print("Digite a disciplina do professor: ");
    //         String curso = scanner.nextLine();
    
    //         Professor professor = new Professor(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email,
    //                 dataNascimento, rg, disciplina, matricula, curso);
    //         professores.add(professor);
    //         System.out.println("Cadastrado do professor feito com sucesso!");
    //     } else {
    //         // Se o professor não estiver na lista, exibir mensagem de erro
    //         System.out.println("Erro: O professor não está na lista de usuários!");
    //     }
    // }
    
    // public static void listarProfessor() {
    //     if (professores.isEmpty()) {
    //         System.out.println("Nenhum professor cadastrado.");
    //     } else {
    //         System.out.println("Lista de professores:");
    //         for (int i = 0; i < professores.size(); i++) {
    //             Professor professor = professores.get(i);
    //             System.out.println("Índice: " + i);
    //             System.out.println("Matrícula: " + professor.getMatricula());
    //             System.out.println("Nome: " + professor.getNome()); // Supondo que tenha um método getNome em Usuario
    //             System.out.println("Curso: " + professor.getCurso());
    //             System.out.println("----------------------------------");
    //         }
    //     }
    // }

    // public static void editarProfessor(Scanner scanner) {
    //     listarProfessor();
    //     System.out.print("Digite o índice do professor que deseja editar: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < professores.size()) {
    //         Professor professor = professores.get(indice);
                        
    //         System.out.print("Digite a nova matrícula do professor: ");
    //         professor.setMatricula(scanner.nextLine());
    //         System.out.print("Digite o novo curso do professor: ");
    //         professor.setCurso(scanner.nextLine());

    //         System.out.println("professor editado com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }
    
    // public static void removerProfessor(Scanner scanner) {
    //     listarProfessor();
    //     System.out.print("Digite o índice do professor que deseja remover: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < professores.size()) {
    //         professores.remove(indice);
    //         System.out.println("Professor removido com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }

    // Cadastrar ADM//
    ////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    // public static void criarAdministrador(Scanner scanner) {
    //     System.out.println("Digite os dados do administrador:");
    //     System.out.print("Nome: ");
    //     String nome = scanner.nextLine();
    //     System.out.print("Sobrenome: ");
    //     String sobrenome = scanner.nextLine();
    //     System.out.print("CPF: ");
    //     String cpf = scanner.nextLine();
    //     System.out.print("Telefone: ");
    //     String telefone = scanner.nextLine();
    //     System.out.print("Cidade: ");
    //     String cidade = scanner.nextLine();
    //     System.out.print("Bairro: ");
    //     String bairro = scanner.nextLine();
    //     System.out.print("Rua: ");
    //     String rua = scanner.nextLine();
    //     System.out.print("Número: ");
    //     String numero = scanner.nextLine();
    //     System.out.print("Email: ");
    //     String email = scanner.nextLine();
    //     System.out.print("Data de Nascimento (AAAA-MM-DD): ");
    //     String dataNascimentoStr = scanner.nextLine();
    //     LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
    //     System.out.print("RG: ");
    //     String rg = scanner.nextLine();

    //     // Cria um novo administrador com os dados fornecidos
    //     Administrador administrador = new Administrador(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero,
    //             email, dataNascimento, rg);
    //     // Adiciona o administrador à lista de administradores
    //     administradores.add(administrador);

    //     System.out.println("Administrador criado com sucesso!");
    // }

    // public static void listarAdministradores() {
    //     if (administradores.isEmpty()) {
    //         System.out.println("Nenhum administrador cadastrado.");
    //     } else {
    //         System.out.println("Lista de Administradores:");
    //         for (Administrador administrador : administradores) {
    //             System.out.println(administrador);
    //         }
    //     }
    // }

    // public static void editarAdministrador(Scanner scanner) {
    //     listarAdministradores();
    //     System.out.print("Digite o índice do administrador que deseja editar: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < administradores.size()) {
    //         Administrador administrador = administradores.get(indice);
    //         System.out.println("Digite os novos dados do administrador:");
    //         System.out.print("Nome: ");
    //         administrador.setNome(scanner.nextLine());
    //         System.out.print("Sobrenome: ");
    //         administrador.setSobrenome(scanner.nextLine());
    //         System.out.print("CPF: ");
    //         administrador.setCpf(scanner.nextLine());
    //         System.out.print("Telefone: ");
    //         administrador.setTelefone(scanner.nextLine());
    //         System.out.print("Cidade: ");
    //         administrador.setCidade(scanner.nextLine());
    //         System.out.print("Bairro: ");
    //         administrador.setBairro(scanner.nextLine());
    //         System.out.print("Rua: ");
    //         administrador.setRua(scanner.nextLine());
    //         System.out.print("Número: ");
    //         administrador.setNumero(scanner.nextLine());
    //         System.out.print("Email: ");
    //         administrador.setEmail(scanner.nextLine());
    //         System.out.print("Data de Nascimento (AAAA-MM-DD): ");
    //         String dataNascimentoStr = scanner.nextLine();
    //         administrador.setDataNascimento(LocalDate.parse(dataNascimentoStr));
    //         System.out.print("RG: ");
    //         administrador.setRg(scanner.nextLine());

    //         System.out.println("Administrador editado com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }

    // public static void removerAdministrador(Scanner scanner) {
    //     listarAdministradores();
    //     System.out.print("Digite o índice do administrador que deseja remover: ");
    //     int indice = scanner.nextInt();
    //     scanner.nextLine(); // Limpa o buffer do scanner

    //     if (indice >= 0 && indice < administradores.size()) {
    //         administradores.remove(indice);
    //         System.out.println("Administrador removido com sucesso!");
    //     } else {
    //         System.out.println("Índice inválido!");
    //     }
    // }

    // Cadastrar Instituição //
    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    // public static void cadastrarInstituicao(Scanner scanner) {
    //     System.out.println("Cadastrar Nova Instituição:");
    //     System.out.print("Nome: ");
    //     String nome = scanner.nextLine();
    //     System.out.print("Endereço: ");
    //     String endereco = scanner.nextLine();
    //     System.out.print("Telefone: ");
    //     String telefone = scanner.nextLine();
    //     System.out.print("Email: ");
    //     String email = scanner.nextLine();
    //     System.out.print("CNPJ: ");
    //     String cnpj = scanner.nextLine();

    //     Instituicao instituicao = new Instituicao(nome, endereco, telefone, email, cnpj);
    //     instituicoes.add(instituicao);
    //     System.out.println("Instituição cadastrada com sucesso!");
    // }

    // public static void listarInstituicoes() {
    //     if (instituicoes.isEmpty()) {
    //         System.out.println("Nenhuma instituição cadastrada.");
    //     } else {
    //         System.out.println("Lista de Instituições:");
    //         for (Instituicao instituicao : instituicoes) {
    //             System.out.println(instituicao);
    //         }
    //     }
    // }

    // public static void removerInstituicao(Scanner scanner) {
    //     if (instituicoes.isEmpty()) {
    //         System.out.println("Nenhuma instituição cadastrada para remover.");
    //     } else {
    //         listarInstituicoes();
    //         System.out.print("Digite o número da instituição que deseja remover: ");
    //         int numero = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         if (numero >= 0 && numero < instituicoes.size()) {
    //             instituicoes.remove(numero);
    //             System.out.println("Instituição removida com sucesso!");
    //         } else {
    //             System.out.println("Número de instituição inválido.");
    //         }
    //     }
    // }

    // public static void editarInstituicao(Scanner scanner) {
    //     if (instituicoes.isEmpty()) {
    //         System.out.println("Nenhuma instituição cadastrada para editar.");
    //     } else {
    //         listarInstituicoes();
    //         System.out.print("Digite o número da instituição que deseja editar: ");
    //         int numero = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner
    
    //         if (numero >= 0 && numero < instituicoes.size()) {
    //             Instituicao instituicao = instituicoes.get(numero);
    
    //             System.out.println("Editando Instituição:");
    //             System.out.print("Novo nome (atual: " + instituicao.getNome() + "): ");
    //             String novoNome = scanner.nextLine();
    //             instituicao.setNome(novoNome);
    
    //             System.out.print("Novo endereço (atual: " + instituicao.getEndereco() + "): ");
    //             String novoEndereco = scanner.nextLine();
    //             instituicao.setEndereco(novoEndereco);
    
    //             System.out.print("Novo telefone (atual: " + instituicao.getTelefone() + "): ");
    //             String novoTelefone = scanner.nextLine();
    //             instituicao.setTelefone(novoTelefone);
    
    //             System.out.print("Novo email (atual: " + instituicao.getEmail() + "): ");
    //             String novoEmail = scanner.nextLine();
    //             instituicao.setEmail(novoEmail);
    
    //             System.out.print("Novo CNPJ (atual: " + instituicao.getCnpj() + "): ");
    //             String novoCnpj = scanner.nextLine();
    //             instituicao.setCnpj(novoCnpj);
    
    //             System.out.println("Instituição editada com sucesso!");
    //         } else {
    //             System.out.println("Número de instituição inválido.");
    //         }
    //     }
    // }
  

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int opcaoUsuario;

       

    //         do {
    //         System.out.println("Menu:");
    //         System.out.println("1 - Criar usuário");
    //         System.out.println("2 - Editar usuário");
    //         System.out.println("3 - Remover usuário");
    //         System.out.println("4 - Visualizar usuário");
    //         System.out.println("5 - Listar usuários");
    //         System.out.println("6 - Cadastrar Aluno");
    //         System.out.println("7 - Cadastrar ADM");
    //         System.out.println("8 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcaoUsuario = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcaoUsuario) {
    //             case 1:
    //                 criarUsuario(scanner);
    //                 break;
    //             case 2:
    //                 editarUsuario(scanner);
    //                 break;
    //             case 3:
    //                 removerUsuario(scanner);
    //                 break;
    //             case 4:
    //                 visualizarUsuario(scanner);
    //                 break;
    //             case 5:
    //                 listarUsuarios();
    //                 break;
    //             case 6:
    //                 CadastrarAluno();
    //                 break; 
    //             case 7:
    //                 menuADM(scanner);
    //                 break;
    //             case 8:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcaoUsuario != 8);

    //     scanner.close();
    // }

    // public static void menuADM(Scanner scanner) {
    //     int opcaoAdministrador;

    //     do {
    //         System.out.println("Menu:");
    //         System.out.println("1 - Criar Administrador");
    //         System.out.println("2 - Listar Administradores");
    //         System.out.println("3 - Editar Administrador");
    //         System.out.println("4 - Remover Administrador");
    //         System.out.println("5 - Criar Instituição");
    //         System.out.println("6 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcaoAdministrador = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcaoAdministrador) {
    //             case 1:
    //                 criarAdministrador(scanner);
    //                 break;
    //             case 2:
    //                 listarAdministradores();
    //                 break;
    //             case 3:
    //                 editarAdministrador(scanner);
    //                 break;
    //             case 4:
    //                 removerAdministrador(scanner);
    //                 break;
    //             case 5:
    //                 menuInstituicao(scanner);
    //                 break;
    //             case 6:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcaoAdministrador != 6);
    // }

    // public static void menuInstituicao(Scanner scanner) {
    //     int opcaoInstituicao;

    //     do {
    //         System.out.println("Menu Instituição:");
    //         System.out.println("1 - Cadastrar Instituição");
    //         System.out.println("2 - Listar Instituições");
    //         System.out.println("3 - Remover Instituição");
    //         System.out.println("4 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcaoInstituicao = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcaoInstituicao) {
    //             case 1:
    //                 cadastrarInstituicao(scanner);
    //                 break;
    //             case 2:
    //                 listarInstituicoes();
    //                 break;
    //             case 3:
    //                 removerInstituicao(scanner);
    //                 break;
    //             case 4:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcaoInstituicao != 4);
    // }

    // public static void CadastrarAluno() {
    //     Scanner scanner = new Scanner(System.in);
    //     int opcao1;

    //     do {
    //         System.out.println("Menu:");
    //         System.out.println("1 - criar Aluno");
    //         System.out.println("2 - Editar Aluno");
    //         System.out.println("3 - Remover Aluno");
    //         System.out.println("4 - Listar Aluno");
    //         System.out.println("5 - Agendamento de reunião");
    //         System.out.println("6 - Criar Matrícula");
    //         System.out.println("6 - ");
    //         System.out.println("7 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcao1 = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcao1) {
    //             case 1:
    //                 criarAluno(scanner);
    //                 break;
    //             case 2:
    //                 editarAluno(scanner);
    //                 break;
    //             case 3:
    //                 removerAluno(scanner);
    //                 break;
    //             case 4:
    //                 listarAlunos();
    //                 break;
    //             case 5:
    //              Scanner scannerReuniao = new Scanner(System.in);
    //             int opcaoAgendamento;
    //             do {
    //                 System.out.println("Menu de Agendamento de Reuniões:");
    //                 System.out.println("1 - Criar Reunião");
    //                 System.out.println("2 - Editar Reunião");
    //                 System.out.println("3 - Remover Reunião");
    //                 System.out.println("4 - Listar Reuniões");
    //                 System.out.println("5 - Voltar ao Menu Principal");
    //                 System.out.print("Escolha uma opção: ");
    //                 opcaoAgendamento = scanner.nextInt();
    //                 scanner.nextLine(); // Limpar o buffer do scanner
                    
    //                 switch (opcaoAgendamento) {
    //                     case 1:
    //                         criarReuniao(scannerReuniao);
    //                         break;
    //                     case 2:
    //                         editarReuniao(scannerReuniao);
    //                         break;
    //                     case 3:
    //                         removerReuniao(scannerReuniao);
    //                         break;
    //                     case 4:
    //                         listarReunioes();
    //                         break;
    //                     case 5:
    //                         System.out.println("Voltando ao Menu Principal...");
    //                         break;
    //                     default:
    //                         System.out.println("Opção inválida.");
    //                 }
    //             } while (opcaoAgendamento != 5);
    //                 break;
    //             case 6:
    //                int opcaoMatricula;
    //                 do {
    //                     System.out.println("\nMenu de Matrícula:");
    //                     System.out.println("1 - Criar Matrícula");
    //                     System.out.println("2 - Listar Matrículas");
    //                     System.out.println("3 - Editar Matrícula");
    //                     System.out.println("4 - Remover Matrícula");
    //                     System.out.println("5 - Voltar ao Menu Principal");
    //                     System.out.print("Escolha uma opção: ");
    //                     opcaoMatricula = scanner.nextInt();
    //                     scanner.nextLine(); // Limpar o buffer do scanner
            
    //                     switch (opcaoMatricula) {
    //                         case 1:
    //                             Matricula.criarMatricula(scanner);
    //                             break;
    //                         case 2:
    //                             Matricula.listarMatriculas();
    //                             break;
    //                         case 3:
    //                             Matricula.editarMatricula(scanner);
    //                             break;
    //                         case 4:
    //                             Matricula.removerMatricula(scanner);
    //                             break;
    //                         case 5:
    //                             System.out.println("Voltando ao Menu Principal...");
    //                             break;
    //                         default:
    //                             System.out.println("Opção inválida.");
    //                     }
    //                 } while (opcaoMatricula != 5);                
    //                 break;
    //             case 7:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcao1 != 8);

    //     scanner.close();
    // }


    // Métodos para cada funcionalidade


      
}

