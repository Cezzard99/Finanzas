package com.provid.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_bono")
public class DetalleBono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "valor_soles")
	private Double valorSoles;

	@Column(name = "tir_bonista")
	private Double tirBonista;

	@Column(name = "tir_emisor")
	private Double tirEmisor;

	@Column(name = "tcea")
	private Double tcea;

	@Column(name = "trea")
	private Double trea;

	@OneToOne
	@JoinColumn(name = "bono_id", nullable = false)
	private Bono bonoId;

	public DetalleBono() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorSoles() {
		return valorSoles;
	}

	public void setValorSoles(Double valorSoles) {
		this.valorSoles = valorSoles;
	}

	public Double getTcea() {
		return tcea;
	}

	public void setTcea(Double tcea) {
		this.tcea = tcea;
	}

	public Double getTirBonista() {
		return tirBonista;
	}

	public void setTirBonista(Double tirBonista) {
		this.tirBonista = tirBonista;
	}

	public Double getTirEmisor() {
		return tirEmisor;
	}

	public void setTirEmisor(Double tirEmisor) {
		this.tirEmisor = tirEmisor;
	}

	public Double getTrea() {
		return trea;
	}

	public void setTrea(Double trea) {
		this.trea = trea;
	}

	public Bono getBonoId() {
		return bonoId;
	}

	public void setBonoId(Bono bonoId) {
		this.bonoId = bonoId;
	}

	public double aprox7digit(double result) {
		return (double) Math.round(result * 10000000d) / 10000000;
	}

	public double aprox2digit(double result) {
		return (double) Math.round(result * 100d) / 100;
	}

	public Double tirEmisor() {
		tirEmisor = bonoId.tirEmisor();
		return tirEmisor;
	}

	public Double tirBonista() {
		tirBonista = bonoId.tirBonista();
		return tirBonista;
	}

	public Double treaBonista() {
		trea = bonoId.treaBonista();
		return trea;
	}

	public Double tceaEmisor() {
		tcea = bonoId.tceaEmisor();
		return tcea;
	}

	public Double precio() {
		valor = bonoId.precio();
		return valor;
	}
}