package DAO;
import connection.ConnectionFactory;
import model.Contexto;
import model.Desafio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciaDAO {

	protected Connection connection;
	
	public GerenciaDAO() {
		this.connection = new ConnectionFactory().getConnection();
		
	}
	//#############ADD CONTEXTO###############
	public void addContexto(Contexto contexto) {
		String sql = "INSERT INTO Contexto (descricao, id_contexto, link_audio, link_imagem) values(?, ?, ?, ?)";		
	
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, contexto.getDescricao());
			insert.setInt(2, contexto.getId_contexto());
			insert.setString(3, contexto.getAudio_link());
			insert.setString(4, contexto.getImagem_link());
			insert.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############UPDATE CONTEXTO###############
	public void updateContexto(Contexto contexto) {
		String sql = "UPDATE Contexto SET descricao=?, link_audio=?, link_imagem=? where id_contexto=?";
		
		try {
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, contexto.getDescricao());			
			update.setString(2, contexto.getAudio_link());
			update.setString(3, contexto.getImagem_link());
			update.setInt(4, contexto.getId_contexto());
			update.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############DELETE CONTEXTO###############
	public void deleteContexto(Contexto contexto) {
		String sql = "DELETE FROM Contexto WHERE id_contexto=?";
		try {
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.setInt(1, contexto.getId_contexto());
			delete.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############ADD DESAFIO###############
	public void addDesafio(Desafio desafio) {
		String sql = "INSERT INTO Desafio (contexto, id_desafio, palavra, link_audio, link_imagem) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setInt(1, desafio.getContexto());
			insert.setInt(2, desafio.getId_desafio());
			insert.setString(3, desafio.getPalavra());
			insert.setString(4, desafio.getAudio_link());
			insert.setString(5, desafio.getImagem_link());
			insert.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############UPDATE DESAFIO###############
	public void updateDesafio(Desafio desafio) {
		String sql = "UPDATE Desafio SET palavra=?, link_audio=?, link_imagem=? where id_desafio=?";
		
		try {
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, desafio.getPalavra());
			update.setString(2, desafio.getAudio_link());
			update.setString(3, desafio.getImagem_link());
			update.setInt(4, desafio.getId_desafio());
			update.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	//#############DELETE DESAFIO###############
		public void deleteDesafio(Desafio desafio) {
			String sql = "DELETE FROM Desafio WHERE id_desafio=? ";
			try {
				PreparedStatement delete = connection.prepareStatement(sql);
				delete.setInt(1, desafio.getId_desafio());
				delete.executeUpdate();
				
			}catch(SQLException e) {
				e.getMessage();
			}
		}
}
	