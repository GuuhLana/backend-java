package com.gtech.gtechsyst.model.Error;


public class ErrorMessage {
	
	
	private String tituloErro;
	
	private Integer status;
	
	private String mensagem;
	
	

	public ErrorMessage(String tituloErro, Integer status, String mensagem) {
		this.tituloErro = tituloErro;
		this.status = status;
		this.mensagem = mensagem;
	}

	public String getTituloErro() {
		return tituloErro;
	}

	public void setTituloErro(String tituloErro) {
		this.tituloErro = tituloErro;
	}		

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
