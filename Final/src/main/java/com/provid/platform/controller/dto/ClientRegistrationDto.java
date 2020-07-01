package com.provid.platform.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClientRegistrationDto {

	@NotEmpty(message = "Debe ingresar el nombre de la empresa.")
	private String empresa;

	@NotEmpty(message = "Debe ingresar la razón social de la empresa.")
	private String razon;

	@Pattern(regexp = "[2][0][0-9]{9}", message = "El RUC debe ser un valor numerico de 11 dígitos, y debe empezar con el sufijo '20'.")
	@Size(min = 11, max = 11, message = "Número del RUC inválido.")
	private String ruc;

	@NotEmpty(message = "Debe ingresar una contraseña.")
	private String contra;

	public ClientRegistrationDto() {

	}

	public ClientRegistrationDto(String empresa, String razon, String ruc, String contra) {
		super();
		this.empresa = empresa;
		this.razon = razon;
		this.ruc = ruc;
		this.contra = contra;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
}
