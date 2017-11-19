import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

import connection.ConnectionFactory;

class AppTest {
	
	private static Connection connection;
	
	//CREATE
	@Test
	public void createTable() throws Exception {
		Class.forName("org.postgresql.Driver");
		Statement cTable;
		connection = newConnection();
		cTable = connection.createStatement();		
		cTable.executeUpdate("CREATE TABLE Contexto (descricao varchar(30), idContexto int primary key, link_audio varchar(50), link_imagem varchar(50))");			
		cTable.executeUpdate("CREATE TABLE Desafio (contexto int references contexto(idContexto), idDesafio int primary key, palavra varchar(30), link_audio varchar(50), link_imagem varchar(50))");
		System.out.println("Database Created");
	}
		
	@Test
	public void carregarPostgresqlDriver() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
	}
	
	//Método responsável por estabelecer conexão com o banco
	@Test
	private static Connection newConnection() throws SQLException{
		Connection connection = new ConnectionFactory().getConnection();
		return connection;
	}
	
	//INSERT Contexto
	@Test
	public void insertWithPreparedStatement() throws Exception {
		insertContexto(connection, "Esporte", 1, "imgurSport.mp3", "imgursde.png");
		insertContexto(connection, "Sala de Aula", 2, "imgurClass.mp3", "imgurfe.png");
		insertContexto(connection, "Cozinha", 3, "imgurKitchen.mp3", "imgghur.png");
		
		insertDesafio(connection, 1, 1, "Bola", "mp3", "png");
		insertDesafio(connection, 1, 2, "Trave", "mp3", "png");
		insertDesafio(connection, 1, 3, "Grama", "mp3", "png");
		
		insertDesafio(connection, 2, 4, "Giz", "mp3", "png");
		insertDesafio(connection, 2, 5, "Lousa", "mp3", "png");
		insertDesafio(connection, 2, 6, "Caneta", "mp3", "png");
		
		insertDesafio(connection, 3, 7, "Panela", "mp3", "png");
		insertDesafio(connection, 3, 8, "Copo", "mp3", "png");
		insertDesafio(connection, 3, 9, "Pia", "mp3", "png");
	}
	
	//READ
	@Test
	public void readWithPreparedStatement() throws SQLException {
			connection = newConnection();
			PreparedStatement readCommandContexto = connection.prepareStatement("SELECT *FROM contexto");
			PreparedStatement readCommandoDesafio = connection.prepareStatement("SELECT *FROM desafio");
			ResultSet rs = readCommandContexto.executeQuery();
			ResultSet rs2 = readCommandoDesafio.executeQuery();
			listSelectFromContextos(rs);
			listSelectFromDesafios(rs2);
	}
	
	
	
	//UPDATE
	@Test
	public void updateTable() throws SQLException{
		connection = newConnection();
		PreparedStatement insert = connection.prepareStatement("UPDATE Contexto set descricao = 'Tangamandapio' WHERE idContexto = 2 ");
		insert.executeUpdate();
	}
	
	//DELETE
	@Test
	public void deleteTable() throws SQLException{
		connection = newConnection();
		PreparedStatement insert = connection.prepareStatement("DELETE from Desafio WHERE idDesafio = 9");
		insert.executeUpdate();
	}
	
	//Método responsável por salvar no banco de dados os dados dos contextos passados pelo método insertWithPreparedStatement()
	public void insertContexto(Connection connection, String descricao, int idContexto, String link_audio, String link_imagem) throws SQLException {
		connection = newConnection();
		PreparedStatement insert = connection.prepareStatement("INSERT INTO Contexto values(?, ?, ?, ?)");
		insert.setString(1, descricao);
		insert.setInt(2, idContexto);
		insert.setString(3, link_audio);
		insert.setString(4, link_imagem);
		insert.executeUpdate();
	}
	
	//Método responsável por salvar no banco de dados os dados dos contextos passados pelo método insertWithPreparedStatement()
	public void insertDesafio(Connection connection, int idContexto, int idDesafio, String palavra, String link_audio, String link_imagem) throws SQLException {
		connection = newConnection();
		PreparedStatement insert = connection.prepareStatement("INSERT INTO Desafio values(?, ?, ?, ?, ?)");
		insert.setInt(1, idContexto);
		insert.setInt(2, idDesafio);
		insert.setString(3, palavra);
		insert.setString(4, link_audio);
		insert.setString(5, link_imagem);
		insert.executeUpdate();
	}
	
	//Métodos responsáveis por listar as consultas informadas acima no método readWithPreparedStatement()
	private void listSelectFromContextos(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println("Resultado da Consulta Tabela Contexto -> " + "Descrição: " + rs.getString("descricao") + ", " + "idContexto: " +rs.getString("idContexto")  + ", " + "link_audio: " + rs.getString("link_audio") + ", " + "link_imagem: " +rs.getString("link_imagem"));
		}
	}
	
	private void listSelectFromDesafios(ResultSet rs2) throws SQLException {
		while(rs2.next()) {
			System.out.println("Resultado da Consulta Tabela Desafio -> " + "idContexto: " + rs2.getString("contexto") + ", " + "idDesafio: " +rs2.getString("idDesafio")  + ", " + "palavra: " + rs2.getString("palavra") + ", "
								+ "link_audio: " + rs2.getString("link_audio") + ", " + "link_imagem: " +rs2.getString("link_imagem"));
		}
	}
}