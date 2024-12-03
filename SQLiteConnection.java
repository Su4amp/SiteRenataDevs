import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static void main(String[] args) {
        // Caminho para o banco de dados SQLite
        String url = "jdbc:sqlite:DataBase.db";
        
        // Conexão ao banco de dados
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
