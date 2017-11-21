import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import DAO.GerenciaDAO;
import connection.ConnectionFactory;
import model.Contexto;
import model.Desafio;

class AppTest {
	
	private static Connection connection;
	
	//Método responsável por estabelecer conexão com o banco
	@Test
	private static Connection newConnection() throws SQLException{
		Connection connection = new ConnectionFactory().getConnection();
		return connection;
	}
	
	//CREATE
	@Ignore
	public void createTable() throws Exception {
		Class.forName("org.postgresql.Driver");
		Statement cTable;
		connection = newConnection();
		cTable = connection.createStatement();		
		cTable.executeUpdate("CREATE TABLE Contexto (descricao varchar(30), id_contexto int primary key, link_audio varchar(50), link_imagem varchar(50))");			
		cTable.executeUpdate("CREATE TABLE Desafio (contexto int references Contexto(id_contexto), id_desafio int primary key, palavra varchar(30), link_audio varchar(50), link_imagem varchar(50))");
		System.out.println("Database Created");
	}
	 
	@Test
	public void carregarPostgresqlDriver() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
	} 
	
	//INSERT Contexto
	@Ignore
	public void createContexto() throws Exception {
		Contexto contexto1 = new Contexto("Esporte", 1, "imgurSport.mp3", "imgursde.png");
		Contexto contexto2 = new Contexto("Escola", 2, "imgurClass.mp3", "imgurfe.png");
		Contexto contexto3 = new Contexto("Cozinha", 3, "imgurKitchen.mp3", "imgghur.png");		
		GerenciaDAO bdstatement = new GerenciaDAO();
		bdstatement.addContexto(contexto1);
		bdstatement.addContexto(contexto2);
		bdstatement.addContexto(contexto3);
	}		
	
	@Ignore
	public void createDesafio() throws Exception{
		Desafio desafio1 = new Desafio(1, 1, "Bola", "mp3", "png");
		Desafio desafio2 = new Desafio(1, 2, "Trave", "mp3", "png");
		Desafio desafio3 = new Desafio(1, 3, "Grama", "mp3", "png");
		Desafio desafio4 = new Desafio(2, 4, "Giz", "mp3", "png");
		Desafio desafio5 = new Desafio(2, 5, "Lousa", "mp3", "png");
		Desafio desafio6 = new Desafio(2, 6, "Caneta", "mp3", "png");
		Desafio desafio7 = new Desafio(3, 7, "Panela", "mp3", "png");
		Desafio desafio8 = new Desafio(3, 8, "Copo", "mp3", "png");
		Desafio desafio9 = new Desafio(3, 9, "Pia", "mp3", "png");		
		GerenciaDAO bdstatement = new GerenciaDAO();
		
		
		bdstatement.addDesafio(desafio1);
		bdstatement.addDesafio(desafio2);
		bdstatement.addDesafio(desafio3);
		bdstatement.addDesafio(desafio4);
		bdstatement.addDesafio(desafio5);
		bdstatement.addDesafio(desafio6);
		bdstatement.addDesafio(desafio7);
		bdstatement.addDesafio(desafio8);
		bdstatement.addDesafio(desafio9);
	}
	
	
	@Ignore
	public void deleteDesafio() throws SQLException{
		Desafio desafio7 = new Desafio(3, 7, "Panela", "mp3", "png");
		Desafio desafio8 = new Desafio(3, 8, "Copo", "mp3", "png");
		Desafio desafio9 = new Desafio(3, 9, "Pia", "mp3", "png");
		GerenciaDAO bdstatement = new GerenciaDAO();
		bdstatement.deleteDesafio(desafio7);
		bdstatement.deleteDesafio(desafio8);
		bdstatement.deleteDesafio(desafio9);
	}
	
	@Ignore
	public void deleteContexto() throws SQLException{
		Contexto contexto3 = new Contexto("Cozinha", 3, "imgurKitchen.mp3", "imgghur.png");
		GerenciaDAO bdstatement = new GerenciaDAO();
		bdstatement.deleteContexto(contexto3);
	}
	
	@Ignore
	public void updateContexto() {
		Contexto contexto2 = new Contexto("Escola", 2, "mudança no som", "imgurfdiejiedejde.png");
		GerenciaDAO bdstatement = new GerenciaDAO();
		bdstatement.updateContexto(contexto2);
	}	
	
	@Ignore
	public void updateDesafio() throws SQLException{
		Desafio desafio4 = new Desafio(2, 4, "Carteira", "mp3", "png");
		Desafio desafio5 = new Desafio(2, 5, "Apagador", "mp3", "png");
		Desafio desafio6 = new Desafio(2, 6, "Livro", "mp3", "png");
		GerenciaDAO bdstatement = new GerenciaDAO();
		bdstatement.updateDesafio(desafio4);
		bdstatement.updateDesafio(desafio5);
		bdstatement.updateDesafio(desafio6);
	}
	
	//READ
	@Test
	public void select() throws SQLException {
			connection = newConnection();
			//Consulta retorna todos os Contextos cadastrados
			PreparedStatement sql = connection.prepareStatement("SELECT *FROM Contexto where id_contexto = 1");
			PreparedStatement sql2 = connection.prepareStatement("SELECT *FROM Desafio where contexto = 1");
			//Retorna todos os Desafios cadastrados
			//PreparedStatement getAllDesafiosById = connection.prepareStatement("SELECT *FROM Desafio");
			//Retorna todos os desafios de um contexto (Consulta através do ID do contexto)
			//PreparedStatement desafioByIdContexto = connection.prepareStatement("SELECT *FROM Desafio WHERE contexto = 1");
			
			ResultSet rs = sql.executeQuery();
			ResultSet rs2 = sql2.executeQuery();
			//ResultSet rs3 = getAllDesafiosById.executeQuery();
			listSelectFromContextos(rs);
			listSelectFromDesafios(rs2);
			//listSelectFromDesafios(rs3);
	}
	
	
	//Métodos responsáveis por listar as consultas informadas acima no método readWithPreparedStatement()
	private void listSelectFromContextos(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println("Resultado da Consulta Tabela Contexto -> " + "Descrição: " + rs.getString("descricao") + ", " + "id_contexto: " +rs.getString("id_contexto")  + ", " + "link_audio: " + rs.getString("link_audio") + ", " + "link_imagem: " +rs.getString("link_imagem"));
		}
	}
	
	private void listSelectFromDesafios(ResultSet rs2) throws SQLException {
		while(rs2.next()) {
			System.out.println("Resultado da Consulta Tabela Desafio -> " + "id_contexto: " + rs2.getString("contexto") + ", " + "id_desafio: " +rs2.getString("id_desafio")  + ", " + "palavra: " + rs2.getString("palavra") + ", "
								+ "link_audio: " + rs2.getString("link_audio") + ", " + "link_imagem: " +rs2.getString("link_imagem"));
		}
	}
}