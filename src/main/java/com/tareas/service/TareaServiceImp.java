package com.tareas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tareas.dao.Tarea;
import com.tareas.repository.TareaRepository;

@Service
public class TareaServiceImp implements TareaService{

	@Autowired
	TareaRepository repo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return (List<Tarea>) repo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Tarea findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tarea save(Tarea tarea) {
		// TODO Auto-generated method stub
		return repo.save(tarea);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	

}
