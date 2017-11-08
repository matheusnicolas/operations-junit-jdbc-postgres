import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	
	public static void main(String[] args){
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Funcionou");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
		
		}catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
