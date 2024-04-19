import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendamentoReuniao extends Aluno {
    private LocalDate data;
    private LocalTime hora;
    private String local;
    //protected List<String> participantes;

    protected static List<AgendamentoReuniao> agendamentos = new ArrayList<>();

    // public AgendamentoReuniao(LocalDate data, LocalTime hora, String local) {
    //     this.data = data;
    //     this.hora = hora;
    //     this.local = local;
    //     //this.participantes = new ArrayList<>();
    // }
     public AgendamentoReuniao(String nome, String sobrenome, String cpf, String telefone, String cidade, String bairro,
                              String rua, String numero, String email, LocalDate dataNascimento, String rg,
                              String nomeDaMae, String nomeDoPai, boolean atendimentoEspecial,
                              String matricula, String curso, LocalDate data, LocalTime hora, String local) {
        super(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, email, dataNascimento, rg,
                nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso);
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

    // Método para criar uma nova reunião
    public static void criarReuniao(Scanner scanner) {

        System.out.print("Digite o telefone: ");

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o sobrenome: ");
            String sobrenome = scanner.nextLine();
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
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
            System.out.print("Digite o nome da mãe: ");
            String nomeDaMae = scanner.nextLine();
            System.out.print("Digite o nome do pai: ");
            String nomeDoPai = scanner.nextLine();
            System.out.print("O aluno precisa de atendimento especial? (true/false): ");
            boolean atendimentoEspecial = scanner.nextBoolean();
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite o curso do aluno: ");
            String curso = scanner.nextLine();
        
        System.out.println("Criando uma nova reunião:");
        System.out.print("Digite a data (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);
        System.out.print("Digite a hora (HH:MM): ");
        String horaStr = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaStr);
        System.out.print("Digite o local: ");
        String local = scanner.nextLine();

        // AgendamentoReuniao reuniao = new AgendamentoReuniao(data, hora, local);
        // agendamentos.add(reuniao);
        // System.out.println("Reunião criada com sucesso!");
        AgendamentoReuniao reuniao = new AgendamentoReuniao(nome, sobrenome, cpf, telefone, cidade, bairro, rua, numero, 
                            email, dataNascimento, rg, nomeDaMae, nomeDoPai, atendimentoEspecial, matricula, curso,
                            data, hora, local);
        agendamentos.add(reuniao);
        System.out.println("Reunião criada com sucesso!");
    }

    // Método para editar uma reunião existente
    public static void editarReuniao(Scanner scanner) {
        System.out.println("Editando uma reunião:");
        // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para editar
        // Depois, solicite as novas informações e atualize a reunião selecionada
    }

    // Método para remover uma reunião existente
    public static void removerReuniao(Scanner scanner) {
        System.out.println("Removendo uma reunião:");
        // Implemente a lógica para listar as reuniões e permitir que o usuário selecione uma para remover
        // Depois, remova a reunião selecionada da lista
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
            System.out.println("Matrícula: " + reuniao.getMatricula());
            System.out.println("Curso: " + reuniao.getCurso());

            System.out.println("----------------------------------");
        }
    }
}




    //sobrescrevendo um método
    // @Override
    // public String toString() {
    //     return "AgendamentoReuniao{" +
    //             "data=" + data +
    //             ", hora=" + hora +
    //             ", local='" + local + '\'' +
    //             '}';
    // }
}
