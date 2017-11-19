package model;

public class Desafio {
	
	private Integer contexto;
	private Integer id_desafio;
	private String palavra;
	private String audio_link;
	private String imagem_link;
	
	public Integer getContexto() {
		return this.contexto;
	}
	
	public void setContexto(Integer contexto) {
		this.contexto = contexto;
	}
	
	public Integer getId_desafio() {
		return this.id_desafio;
	}
	
	public void setId_desafio(Integer id_desafio) {
		this.id_desafio = id_desafio;
	}
	
	public String getPalavra() {
		return this.palavra;
	}
	
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public String getAudio_link() {
		return this.audio_link;
	}
	
	public void setAudio_link(String audio_link) {
		this.audio_link = audio_link;
	}
	
	public String getImagem_link() {
		return this.imagem_link;
	}
	
	public void setImagem_link(String imagem_link) {
		this.imagem_link = imagem_link;
	}
	
}
