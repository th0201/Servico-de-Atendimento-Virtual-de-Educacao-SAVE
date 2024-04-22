import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendamentoReuniao extends Aluno {
    private LocalDate data;
    private LocalTime hora;
    private String local;
    
    protected static List<AgendamentoReuniao> agendamentos = new ArrayList<>();
    
    public AgendamentoReuniao(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                          String rua, String numero, String email, LocalDate dataNascimento, String rg,
                          String nomeDaMae, String nomeDoPai, boolean atendimentoEspecial,
                          LocalDate data, LocalTime hora, String local) {
    super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg,
            nomeDaMae, nomeDoPai, atendimentoEspecial);
    this.data = data;
    this.hora = hora;
    this.local = local;
}

    // public AgendamentoReuniao() {
    // }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
       
    public static void criarReuniao(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine().trim();
    
        // Verificar se o CPF corresponde a algum aluno
        Aluno aluno = null;
        for (Aluno a : Aluno.alunos) {
            if (a.getCpf().equals(cpf)) {
                aluno = a;
                break;
            }
        }
    
        if (aluno != null) {
            // Criar a reunião com base nos dados do aluno
            System.out.println("Criando uma nova reunião:");
            System.out.print("Digite a data (AAAA-MM-DD): ");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr);
            System.out.print("Digite a hora (HH:MM): ");
            String horaStr = scanner.nextLine();
            LocalTime hora = LocalTime.parse(horaStr);
            System.out.print("Digite o local: ");
            String local = scanner.nextLine();
    
            // Criar a reunião com base nos dados do aluno
            AgendamentoReuniao reuniao = new AgendamentoReuniao(aluno.getNome(), aluno.getSobrenome(),
                    aluno.getCpf(), aluno.getTelefone(), aluno.getCidade(), aluno.getBairro(),
                    aluno.getRua(), aluno.getNumero(), aluno.getEmail(), aluno.getDataNascimento(),
                    aluno.getRg(), aluno.getNomeDaMae(), aluno.getNomeDoPai(), aluno.isAtendimentoEspecial(),
                    data, hora, local);
            AgendamentoReuniao.agendamentos.add(reuniao); // Adiciona a reunião à lista de reuniões
            System.out.println("Reunião criada com sucesso!");
        } else {
            System.out.println("Erro: Aluno não encontrado com o CPF fornecido!");
        }
    }
        
    public static void editarReuniao(Scanner scanner) {
        System.out.println("Editando uma reunião:");
    
        // Solicita o CPF do usuário para buscar a reunião correspondente
        System.out.print("Digite o CPF do usuário da reunião que deseja editar: ");
        String cpf = scanner.nextLine();
    
        // Procura a reunião na lista de agendamentos pelo CPF do usuário
        AgendamentoReuniao reuniaoParaEditar = null;
        for (AgendamentoReuniao reuniao : agendamentos) {
            if (reuniao.getCpf().equals(cpf)) {
                reuniaoParaEditar = reuniao;
                break;
            }
        }
    
        if (reuniaoParaEditar != null) {
            // Exibe os detalhes da reunião antes da edição
            System.out.println("Detalhes da reunião antes da edição:");
            System.out.println("Data: " + reuniaoParaEditar.getData());
            System.out.println("Hora: " + reuniaoParaEditar.getHora());
            System.out.println("Local: " + reuniaoParaEditar.getLocal());
    
            // Solicita as novas informações para a reunião
            System.out.println("Digite as novas informações para a reunião:");
    
            System.out.print("Digite a nova data (AAAA-MM-DD): ");
            String newDataStr = scanner.nextLine();
            LocalDate newData = LocalDate.parse(newDataStr);
    
            System.out.print("Digite a nova hora (HH:MM): ");
            String newHoraStr = scanner.nextLine();
            LocalTime newHora = LocalTime.parse(newHoraStr);
    
            System.out.print("Digite o novo local: ");
            String newLocal = scanner.nextLine();
    
            // Atualiza os dados da reunião com as novas informações
            reuniaoParaEditar.setData(newData);
            reuniaoParaEditar.setHora(newHora);
            reuniaoParaEditar.setLocal(newLocal);
    
            System.out.println("Reunião editada com sucesso!");
        } else {
            System.out.println("Não foi encontrada nenhuma reunião com o CPF fornecido.");
        }
    }
    
    // Método para remover uma reunião existente
    public static void removerReuniao(Scanner scanner) {
        System.out.println("Removendo uma reunião:");
    
        // Solicita o CPF do usuário para buscar a reunião correspondente
        System.out.print("Digite o CPF do usuário da reunião que deseja remover: ");
        String cpf = scanner.nextLine();
    
        // Procura a reunião na lista de agendamentos pelo CPF do usuário
        AgendamentoReuniao reuniaoParaRemover = null;
        for (AgendamentoReuniao reuniao : agendamentos) {
            if (reuniao.getCpf().equals(cpf)) {
                reuniaoParaRemover = reuniao;
                break;
            }
        }
    
        if (reuniaoParaRemover != null) {
            // Remove a reunião da lista de agendamentos
            agendamentos.remove(reuniaoParaRemover);
            System.out.println("Reunião removida com sucesso!");
        } else {
            System.out.println("Não foi encontrada nenhuma reunião com o CPF fornecido.");
        }
    }

    public static void visualizarAgendamento(Scanner scanner) {
        if (agendamentos.isEmpty()) {
            System.out.println("Não há agendamentos para visualizar.");
            return;
        }
    
        // Listar todos os agendamentos para selecionar qual visualizar
        listarReunioes();
        System.out.println("Digite o CPF do aluno associado ao agendamento que deseja visualizar:");
        String cpf = scanner.nextLine().trim();
    
        // Procurar o agendamento correspondente na lista
        AgendamentoReuniao agendamentoSelecionado = null;
        for (AgendamentoReuniao agendamento : agendamentos) {
            if (agendamento.getCpf().equals(cpf)) {
                agendamentoSelecionado = agendamento;
                break;
            }
        }
    
        if (agendamentoSelecionado != null) {
            // Exibir os detalhes do agendamento selecionado
            System.out.println("Detalhes do Agendamento:");
            System.out.println("Data: " + agendamentoSelecionado.getData());
            System.out.println("Hora: " + agendamentoSelecionado.getHora());
            System.out.println("Local: " + agendamentoSelecionado.getLocal());
    
            // Exibir os dados herdados da classe Aluno
            System.out.println("Dados do Aluno:");
            System.out.println("Nome: " + agendamentoSelecionado.getNome());
            System.out.println("CPF: " + agendamentoSelecionado.getCpf());
            System.out.println("Telefone: " + agendamentoSelecionado.getTelefone());
            System.out.println("Cidade: " + agendamentoSelecionado.getCidade());
            System.out.println("Bairro: " + agendamentoSelecionado.getBairro());
            System.out.println("Rua: " + agendamentoSelecionado.getRua());
            System.out.println("Número: " + agendamentoSelecionado.getNumero());
            System.out.println("Email: " + agendamentoSelecionado.getEmail());
            System.out.println("Data de Nascimento: " + agendamentoSelecionado.getDataNascimento());
            System.out.println("RG: " + agendamentoSelecionado.getRg());
            System.out.println("Nome da Mãe: " + agendamentoSelecionado.getNomeDaMae());
            System.out.println("Nome do Pai: " + agendamentoSelecionado.getNomeDoPai());
            System.out.println("Atendimento Especial: " + agendamentoSelecionado.isAtendimentoEspecial());
        } else {
            System.out.println("Não foi encontrado nenhum agendamento com o CPF fornecido.");
        }
    }
    
        
    // Método para listar todas as reuniões agendadas
public static void listarReunioes() {
    System.out.println("Listando todas as reuniões agendadas:");
    if (agendamentos.isEmpty()) {
        System.out.println("Nenhuma reunião agendada.");
    } else {
        for (AgendamentoReuniao reuniao : agendamentos) {
            System.out.println("Data: " + reuniao.getData());
            System.out.println("Hora: " + reuniao.getHora());
            System.out.println("Local: " + reuniao.getLocal());

            // Acessando os atributos herdados da classe Aluno
            System.out.println("Nome: " + reuniao.getNome());
            System.out.println("CPF: " + reuniao.getCpf());
            System.out.println("Telefone: " + reuniao.getTelefone());
            System.out.println("Cidade: " + reuniao.getCidade());
            System.out.println("Bairro: " + reuniao.getBairro());
            System.out.println("Rua: " + reuniao.getRua());
            System.out.println("Número: " + reuniao.getNumero());
            System.out.println("Email: " + reuniao.getEmail());
            System.out.println("Data de Nascimento: " + reuniao.getDataNascimento());
            System.out.println("RG: " + reuniao.getRg());
            System.out.println("Nome da Mãe: " + reuniao.getNomeDaMae());
            System.out.println("Nome do Pai: " + reuniao.getNomeDoPai());
            System.out.println("Atendimento Especial: " + reuniao.isAtendimentoEspecial());
            //System.out.println("Matrícula: " + reuniao.getMatricula());
            //System.out.println("Curso: " + reuniao.getCurso());

            System.out.println("----------------------------------");
        }
    }
}
    
}
