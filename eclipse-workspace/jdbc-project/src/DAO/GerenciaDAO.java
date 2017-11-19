package DAO;
import connection.ConnectionFactory;
import model.Contexto;
import model.Desafio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciaDAO {

	private Connection connection;
	
	public GerenciaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	//#############ADD CONTEXTO###############
	public void addContexto(Contexto contexto) {
		String sql = "INSERT INTO Contexto " + "(descricao, id_contexto, audio_link, imagem_link)" + "values(?, ?, ?, ?)";		
	
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, contexto.getDescricao());
			insert.setInt(2, contexto.getId_contexto());
			insert.setString(3, contexto.getAudio_link());
			insert.setString(4, contexto.getImagem_link());
			insert.execute();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	//#############UPDATE CONTEXTO###############
	public void alterContexto(Contexto contexto) {
		String sql = "UPDATE Contexto SET descricao=?, audio_link=?, imagem_link=? where id_contexto=?";
		
		try {
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, contexto.getDescricao());
			update.setInt(2, contexto.getId_contexto());
			update.setString(3, contexto.getAudio_link());
			update.setString(4, contexto.getImagem_link());
			update.execute();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############DELETE CONTEXTO###############
	public void deleteContexto(Contexto contexto) {
		String sql = "DELETE FROM Contexto WHERE id_contexto = 3";
		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.setInt(1, contexto.getId_contexto());
			delete.execute();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############ADD DESAFIO###############
	public void addDesafio(Desafio desafio) {
		String sql = "INSERT INTO Contexto" + "(contexto, id_desafio, palavra, audio_link, imagem_link)" + "values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setInt(1, desafio.getContexto());
			insert.setInt(2, desafio.getId_desafio());
			insert.setString(3, desafio.getPalavra());
			insert.setString(4, desafio.getAudio_link());
			insert.setString(5, desafio.getImagem_link());
			insert.execute();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############UPDATE DESAFIO###############
	public void alterDesafio(Desafio desafio) {
		String sql = "UPDATE Desafio SET palavra=?, audio_link=?, imagem_link=? where id_desafio=?";
		
		try {
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, desafio.getPalavra());
			update.setString(2, desafio.getAudio_link());
			update.setString(3, desafio.getImagem_link());
			update.setInt(4, desafio.getId_desafio());
			update.execute();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############DELETE DESAFIO###############
		public void deleteDesafio(Desafio desafio) {
			String sql = "DELETE FROM Desafio WHERE id_desafio = 3";
			try {
				PreparedStatement delete = connection.prepareStatement(sql);
				delete.setInt(1, desafio.getId_desafio());
				delete.execute();
				
			}catch(SQLException e) {
				e.getMessage();
			}
		}
	
	
	
	
}
