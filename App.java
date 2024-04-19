//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.Scanner;
//import java.time.LocalTime;
//import java.util.List;





public class App   {


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
        int opcaoAdministrador;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Criar Administrador");
            System.out.println("2 - Listar Administradores");
            System.out.println("3 - Editar Administrador");
            System.out.println("4 - Remover Administrador");
            System.out.println("5 - Criar Instituição");
            System.out.println("6 - Sair");
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
                    menuInstituicao(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoAdministrador != 6);
    }

    public static void menuInstituicao(Scanner scanner) {
        int opcaoInstituicao;

        do {
            System.out.println("Menu Instituição:");
            System.out.println("1 - Cadastrar Instituição");
            System.out.println("2 - Listar Instituições");
            System.out.println("3 - Remover Instituição");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoInstituicao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcaoInstituicao) {
                case 1:
                    Instituicao.cadastrarInstituicao(scanner);
                    break;
                case 2:
                    Instituicao.listarInstituicoes();
                    break;
                case 3:
                    Instituicao.removerInstituicao(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcaoInstituicao != 4);
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
            System.out.println("5 - Agendamento de reunião");
            System.out.println("6 - Criar Matrícula");
            System.out.println("7 - Entrar em uma turma");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao1 = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao1) {
                case 1:
                    Aluno.criarAluno(scanner);
                    break;
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
                 Scanner scannerReuniao = new Scanner(System.in);
                int opcaoAgendamento;
                do {
                    System.out.println("Menu de Agendamento de Reuniões:");
                    System.out.println("1 - Criar Reunião");
                    System.out.println("2 - Editar Reunião");
                    System.out.println("3 - Remover Reunião");
                    System.out.println("4 - Listar Reuniões");
                    System.out.println("5 - Voltar ao Menu Principal");
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
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcaoAgendamento != 5);
                    break;
                case 6:
                Scanner scannerMatricula = new Scanner(System.in);
                   int opcaoMatricula;
                    do {
                        System.out.println("\nMenu de Matrícula:");
                        System.out.println("1 - Criar Matrícula");
                        System.out.println("2 - Listar Matrículas");
                        System.out.println("3 - Editar Matrícula");
                        System.out.println("4 - Remover Matrícula");
                        System.out.println("5 - Voltar ao Menu Principal");
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
                                System.out.println("Voltando ao Menu Principal...");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (opcaoMatricula != 5);
                    break;
                case 7:
                Scanner scannerDisciplina = new Scanner(System.in);
                int opcaoDisciplina;
                do {
                    System.out.println("\nMenu de Disciplina:");
                    System.out.println("1 - Criar Disciplina");
                    System.out.println("2 - Listar Disciplinas");
                    System.out.println("3 - Remover Disciplina");
                    System.out.println("4 - Voltar ao Menu Principal");
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
                            Disciplina.removerDisciplina(scannerDisciplina);
                            break;
                        case 4:
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (opcaoDisciplina != 4);
                break;    
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao1 != 8);

        scanner.close();
    }

    // Scanner scanner = new Scanner(System.in);
    //     int opcao1;

    //     do {
    //         System.out.println("Menu:");
    //         System.out.println("1 - Cadastrar professor");
    //         System.out.println("2 - Editar professor");
    //         System.out.println("3 - Remover professor");
    //         System.out.println("4 - Listar professor");
    //         System.out.println("5 - Sair");
    //         System.out.print("Escolha uma opção: ");
    //         opcao1 = scanner.nextInt();
    //         scanner.nextLine(); // Limpa o buffer do scanner

    //         switch (opcao1) {
    //             case 1:
    //                 cadastrarProfessor(scanner);
    //                 break;
    //             case 2:
    //                 editarProfessor(scanner);
    //                 break;
    //             case 3:
    //                 removerProfessor(scanner);
    //                 break;
    //             case 4:
    //                 listarProfessor();
    //                 break;
    //             case 5:
    //                 System.out.println("Saindo...");
    //                 break;
    //             default:
    //                 System.out.println("Opção inválida.");
    //         }
    //     } while (opcao1 != 7);

    //     scanner.close();
    // }
}
