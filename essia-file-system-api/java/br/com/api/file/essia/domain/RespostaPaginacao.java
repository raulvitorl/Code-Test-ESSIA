package br.com.api.file.essia.domain;

import java.util.List;

public class RespostaPaginacao<T> {

	private long totalRegistros;
	private List<T> registros;

	public RespostaPaginacao(long totalRegistros, List<T> registros) {
		this.totalRegistros = totalRegistros;
		this.registros = registros;		
	}

	public long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public List<T> getRegistros() {
		return registros;
	}

	public void setRegistros(List<T> registros) {
		this.registros = registros;
	}
	
	
}

