package com.tareas.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tareas")
public class Tarea {
	@Id
	@Column(name="id_tarea")
	@JsonProperty("id_tarea")
	private String idTarea;
	
	@Column(name="descripcion")
	@JsonProperty("descripcion")
	private String descripcion;
	
	@Column(name="fecha_creacion")
	@JsonProperty("fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name="vigente")
	@JsonProperty("vigente")
	private boolean vigente;
	
	public Tarea() {
	
	}

	public Tarea(String idTarea, String descripcion, Date fechaCreacion, boolean vigente) {
	
		this.idTarea = idTarea;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.vigente = vigente;
	}

	public String getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(String idTarea) {
		this.idTarea = idTarea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean getVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}


	
	
}