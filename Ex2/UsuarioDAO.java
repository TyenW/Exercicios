import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private static final String URL = "jdbc:postgresql://localhost:55555/Exercício1"; // URL de conexão PostgreSQL
    private static final String USER = "postgres"; // Usuário do banco de dados
    private static final String PASSWORD = "Senha14933"; // Senha do banco de dados

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Carrega o driver PostgreSQL
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void adicionarUsuario(int id, String usuario) {
        String sql = "INSERT INTO usuarios (id, usuario) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, usuario);
            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                System.out.println("ID: " + id + ", Usuário: " + usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // Adicionar usuários
        dao.adicionarUsuario(1, "Ana");
        dao.adicionarUsuario(2, "Bruno");

        // Listar usuários
        dao.listarUsuarios();

        // Excluir um usuário
        dao.excluirUsuario(1);

        // Listar usuários novamente
        dao.listarUsuarios();
    }
}
