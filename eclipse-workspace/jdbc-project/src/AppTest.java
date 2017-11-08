import static org.junit.jupiter.api.Assertions.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class AppTest {
	
	@Test
	public void carregarPostgresqlDriver() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
	}
	
	@Test
	public void abrirConexao() throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
	}
	
	@Test
	public void criarTabelas() throws SQLException {
		Connection database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
		Statement statement = database.createStatement();
		statement.executeUpdate("create table contexto (descricao varchar(30), idContexto int primary key, link_audio varchar(50), link_imagem varchar(50))");
		statement.executeUpdate("CREATE TABLE desafio (contexto int references contexto(idContexto), idDesafio int primary key, palavra varchar(30), link_audio varchar(50), link_imagem varchar(50))");
	}
	
	@Test
	public void insertTabelas() throws SQLException{
		Connection database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
		Statement statement = database.createStatement();
		statement.executeUpdate("insert into contexto values('cozinha', 1, 'imgur', 'imgur' )");
		statement.executeUpdate("insert into desafio values(2, 1, 'panela', 'imgur', 'imgur')");
	}
	
	@Test
	public void updateTabelas() throws SQLException{
		Connection database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
		Statement statement = database.createStatement();
		statement.executeUpdate("update desafio set palavra = 'mudou' where idDesafio = 1");
	}
	
	@Test
	public void deleteTabelas() throws SQLException{
		Connection database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_jdbc", "postgres", "war123");
		Statement statement = database.createStatement();
		statement.executeUpdate("Inserir consulta de deleção");
	}
	
	
	

}
