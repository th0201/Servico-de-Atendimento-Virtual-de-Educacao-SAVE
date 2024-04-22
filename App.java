import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        



        int opcaoUsuario;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Editar usuário");
            System.out.println("3 - Remover usuário");
            System.out.println("4 - Visualizar usuário");
            System.out.println("5 - Listar usuários");
            System.out.println("6 - Cadastrar Aluno");
            System.out.println("7 - Cadastrar ADM");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoUsuario = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcaoUsuario) {
                case 1:
                    Usuario.criarUsuario(scanner);
                    break;
                case 2:
                    Usuario.editarUsuario(scanner);
                    break;
                case 3:
                    Usuario.removerUsuario(scanner);
                    break;
                case 4:
                    Usuario.visualizarUsuario(scanner);
                    break;
                case 5:
                    Usuario.listarUsuarios();
                    break;
                case 6:
                    CadastrarAluno();
                    break;
                case 7:
                    menuADM(scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoUsuario != 8);

        scanner.close();
    }

    public static void menuADM(Scanner scanner) {
        List<Usuario> usuarios = new ArrayList<>();
        int opcaoAdministrador;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Criar Administrador");
            System.out.println("2 - Listar Administradores");
            System.out.println("3 - Editar Administrador");
            System.out.println("4 - Remover Administrador");
            System.out.println("5 - visualizar Administrador");
            System.out.println("6 - Criar Instituição");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoAdministrador = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcaoAdministrador) {
                case 1:
                    Administrador.criarAdministrador(scanner);
                    break;
                case 2:
                    Administrador.listarAdministradores();
                    break;
                case 3:
                    Administrador.editarAdministrador(scanner);
                    break;
                case 4:
                    Administrador.removerAdministrador(scanner);
                    break;
                case 5:
                    Administrador.visualizarAdministrador(scanner);    
                case 6:
                    menuInstituicao(scanner, usuarios);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoAdministrador != 7);
    }

    public static void menuInstituicao(Scanner scanner, List<Usuario> usuarios) {
        int opcaoInstituicao;

        do {
            System.out.println("Menu Instituição:");
            System.out.println("1 - Cadastrar Instituição");
            System.out.println("2 - Listar Instituições");
            System.out.println("3 - Remover Instituição");
            System.out.println("4 - Editar Instituição");
            System.out.println("5 - Visualizar Instituição");
            System.out.println("6 - Cadastrar notas");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoInstituicao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcaoInstituicao) {
                case 1:
                    Instituicao.criarInstituicao(scanner);
                    break;
                case 2:
                    Instituicao.listarInstituicoes();
                    break;
                case 3:
                    Instituicao.removerInstituicao(scanner);
                    break;
                case 4:
                    Instituicao.editarInstituicao(scanner);
                    break;
                case 5:
                    Instituicao.visualizarInstituicao(scanner);
                    break;
                case 6:
                    cadastrarNotas(scanner, usuarios);
                    break;
                  
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoInstituicao != 7);
    }

    public static void cadastrarNotas(Scanner scanner, List<Usuario> usuarios) {
        //Instituicao instituicao = new Instituicao();
        int opcaoNotas;

        do {
            System.out.println("Menu de notas");
            System.out.println("1 - Cadastar notas de alunos");
            System.out.println("2 - Listar notas de alunos");
            System.out.println("3 - Editar notas de alunos");
            System.out.println("4 - Remover notas de alunos");
            System.out.println("5 - visualizar notas dos alunos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoNotas = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcaoNotas) {
                case 1:
                    //Notas.adicionarNotas(scanner, usuarios, instituicao);
                    break;
                case 2:
                    Notas.listarUsuarios(usuarios);
                    break;
                case 3:
                    Notas.editarNotas(scanner, usuarios);
                    break;
                case 4:
                    Notas. removerNotas(scanner, usuarios);
                    break;
                case 5:
                    Notas.visualizarNotas(scanner, usuarios);    
                case 6:
                    menuInstituicao(scanner, usuarios);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoNotas != 7);
    }

    public static void CadastrarAluno() {
        Scanner scanner = new Scanner(System.in);
        int opcao1;

        do {
            System.out.println("Menu:");
            System.out.println("1 - criar Aluno");
            System.out.println("2 - Editar Aluno");
            System.out.println("3 - Remover Aluno");
            System.out.println("4 - Listar Aluno");
            System.out.println("5 - Visualizar Aluno");
            System.out.println("6 - Agendamento de reunião"); //menu de agendamento
            System.out.println("7 - Criar Matrícula");        //menu de matricula  
            System.out.println("8 - Entrar em uma turma");    //menu de cadastramento na turma
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao1 = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao1) {
                case 1:
                    //Usuario usuario = Usuario.criarUsuario(scanner);
                    Aluno.criarAluno( scanner);// Dessa forma vai chamar tando o objeto quanto o scanner
                    break;                                // Só o scanner está dando erro 
                case 2:
                    Aluno.editarAluno(scanner);
                    break;
                case 3:
                    Aluno.removerAluno(scanner);
                    break;
                case 4:
                    Aluno.listarAlunos();
                    break;
                case 5:
                    Aluno. visualizarAluno(scanner);
                    break;    
                case 6:
                 Scanner scannerReuniao = new Scanner(System.in);
                int opcaoAgendamento;
                do {
                    System.out.println("Menu de Agendamento de Reuniões:");
                    System.out.println("1 - Criar Reunião");
                    System.out.println("2 - Editar Reunião");
                    System.out.println("3 - Remover Reunião");
                    System.out.println("4 - Listar Reuniões");
                    System.out.println("5 - Visualizar Reuniões");
                    System.out.println("6 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoAgendamento = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    switch (opcaoAgendamento) {
                        case 1:
                            AgendamentoReuniao.criarReuniao(scannerReuniao);
                            break;
                        case 2:
                            AgendamentoReuniao.editarReuniao(scannerReuniao);
                            break;
                        case 3:
                            AgendamentoReuniao.removerReuniao(scannerReuniao);
                            break;
                        case 4:
                            AgendamentoReuniao.listarReunioes();
                            break;
                        case 5:
                            AgendamentoReuniao.visualizarAgendamento(scannerReuniao);
                        case 6:
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcaoAgendamento != 6);
                    break;
                case 7:
                Scanner scannerMatricula = new Scanner(System.in);
                   int opcaoMatricula;
                    do {
                        System.out.println("\nMenu de Matrícula:");
                        System.out.println("1 - Criar Matrícula");
                        System.out.println("2 - Listar Matrículas");
                        System.out.println("3 - Editar Matrícula");
                        System.out.println("4 - Remover Matrícula");
                        System.out.println("5 - visualizar Matrícula");
                        System.out.println("6 - Voltar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");
                        opcaoMatricula = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        switch (opcaoMatricula) {
                            case 1:
                                Matricula.criarMatricula(scannerMatricula);
                                break;
                            case 2:
                                Matricula.listarMatriculas();
                                break;
                            case 3:
                                Matricula.editarMatricula(scannerMatricula);
                                break;
                            case 4:
                                Matricula.removerMatricula(scannerMatricula);
                                break;
                            case 5:
                                Matricula.visualizarMatricula(scannerMatricula);    
                            case 6:
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opcaoMatricula != 6);
                    break;
                case 8:
                Scanner scannerDisciplina = new Scanner(System.in);
                int opcaoDisciplina;
                do {
                    System.out.println("\nMenu matrícular nas Disciplinas:");
                    System.out.println("1 - Criar matrícula na disciplina");
                    System.out.println("2 - Listar quantidade de alunos na Disciplinas");
                    System.out.println("3 - editar Disciplina");
                    System.out.println("4 - visualizar Disciplina");
                    System.out.println("5 - Remover Disciplina");
                    System.out.println("6 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoDisciplina = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    switch (opcaoDisciplina) {
                        case 1:
                            Disciplina.entrarNaTurma(scannerDisciplina);
                            break;
                        case 2:
                            Disciplina.listarDisciplina();
                            break;
                        case 3:
                            Disciplina.editarDisciplina(scannerDisciplina);
                            break;
                        case 4:
                            Disciplina.visualizarDisciplina(scannerDisciplina);
                            break;    
                        case 5:
                            Disciplina.removerDisciplina(scannerDisciplina);
                            break;
                        case 6:
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcaoDisciplina != 6);
                break;    
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao1 != 9);

        scanner.close();
    }
   
}
