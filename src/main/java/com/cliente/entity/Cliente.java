package com.cliente.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table (name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_cliente;
	private String nom_cliente;
	private String ape_cliente;
	private int dni_cliente;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fec_nac_cliente;
	
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getApe_cliente() {
		return ape_cliente;
	}
	public void setApe_cliente(String ape_cliente) {
		this.ape_cliente = ape_cliente;
	}
	public int getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(int dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	public Date getFec_nac_cliente() {
		return fec_nac_cliente;
	}
	public void setFec_nac_cliente(Date fec_nac_cliente) {
		this.fec_nac_cliente = fec_nac_cliente;
	}
	
	
}

