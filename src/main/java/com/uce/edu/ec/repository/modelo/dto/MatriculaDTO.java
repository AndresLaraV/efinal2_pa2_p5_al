package com.uce.edu.ec.repository.modelo.dto;

public class MatriculaDTO {

	private String cedulaEstudiante;
	private String codigo1;
	private String codigo2;
	private String codigo3;
	private String codigo4;

	public MatriculaDTO() {
		super();
	}

	public MatriculaDTO(String cedulaEstudiante, String codigo1, String codigo2, String codigo3, String codigo4) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigo1 = codigo1;
		this.codigo2 = codigo2;
		this.codigo3 = codigo3;
		this.codigo4 = codigo4;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(String codigo1) {
		this.codigo1 = codigo1;
	}

	public String getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
	}

	public String getCodigo3() {
		return codigo3;
	}

	public void setCodigo3(String codigo3) {
		this.codigo3 = codigo3;
	}

	public String getCodigo4() {
		return codigo4;
	}

	public void setCodigo4(String codigo4) {
		this.codigo4 = codigo4;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [cedulaEstudiante=" + cedulaEstudiante + ", codigo1=" + codigo1 + ", codigo2=" + codigo2
				+ ", codigo3=" + codigo3 + ", codigo4=" + codigo4 + "]";
	}
}
