package com.tareas.service;

import java.util.List;
import java.util.Optional;

import com.tareas.dao.Tarea;

public interface TareaService{
	
	public List<Tarea> findAll();
	
	public Tarea findById(String id);
	
	public Tarea save(Tarea tarea);
	
	public void deleteById(String id);

}
