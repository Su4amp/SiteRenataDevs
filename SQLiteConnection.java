import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteConnection {
    
    private static final String URL = "jdbc:sqlite:DataBase.db";

    // Função para conectar ao banco de dados
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Função para inserir um veículo
    public static void cadastrarVeiculo(String marca, String modelo) {
        String sql = "INSERT INTO exame_veiculo (marca, modelo) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, marca);
            pstmt.setString(2, modelo);
            pstmt.executeUpdate();
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }

    // Função para inserir um cliente
    public static void cadastrarCliente(String cpf, String nome) {
        String sql = "INSERT INTO exame_cliente (cpf, nome) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, nome);
            pstmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Função para inserir uma reserva
    public static void cadastrarReserva(int idCliente, int idVeiculo) {
        String sql = "INSERT INTO exame_reserva (id_cliente, id_veiculo) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idVeiculo);
            pstmt.executeUpdate();
            System.out.println("Reserva cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar reserva: " + e.getMessage());
        }
    }

    // Função principal para testes
    public static void main(String[] args) {
        // Teste de cadastro de veículo
        cadastrarVeiculo("Aerofolio", "para meu Palio");

        // Teste de cadastro de cliente
        cadastrarCliente("12345678901", "Renata Pugliese");

        // Teste de cadastro de reserva
        cadastrarReserva(1, 1); // Exemplo com IDs fictícios
    }
}
