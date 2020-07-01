package com.provid.platform.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "client", uniqueConstraints = @UniqueConstraint(columnNames = { "ruc" }))
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empresa", nullable = false)
	private String empresa;

	@Column(name = "razon", nullable = false)
	private String razon;

	@Column(name = "ruc", length = 11, nullable = false)
	private String ruc;

	@Column(name = "contra", nullable = false)
	private String contra;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "clients_roles", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	@OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bono> bonos;

	public Client() {
		bonos = new ArrayList<>();
	}

	public Client(String empresa, String razon, String ruc, String contra, Collection<Role> roles) {
		super();
		this.empresa = empresa;
		this.razon = razon;
		this.ruc = ruc;
		this.contra = contra;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Bono> getBonos() {
		return bonos;
	}

	public void setBonos(List<Bono> bonos) {
		this.bonos = bonos;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
