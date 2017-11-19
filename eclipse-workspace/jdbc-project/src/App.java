import java.sql.Connection;
import connection.ConnectionFactory;
public class App {
	
	public static void main(String[] args){
		
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = new ConnectionFactory().getConnection();
				System.out.println("Funcionou");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
			
}
		

