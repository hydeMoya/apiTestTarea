package com.tareas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tareas.dao.Tarea;
import com.tareas.service.TareaService;

@RestController
@RequestMapping("tarea")
public class TareaController {

	@Autowired
	private TareaService tareaService;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getTareas() {
		List<Tarea> tareas = tareaService.findAll();
		return new ResponseEntity<>(tareas, HttpStatus.OK);
	}

	@RequestMapping(value = "{tareaId}")
	public ResponseEntity<?> getTareaById(@PathVariable("tareaId") String tareaId) {
		Tarea tarea = tareaService.findById(tareaId);
		if (tarea != null) {
			return new ResponseEntity<>(tarea, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Tarea no encontrada. ", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTarea(@RequestBody Tarea tarea) {
		Map<String, Object> response = new HashMap<>();

		tarea = tareaService.save(tarea);
		if (tarea != null) {
			return new ResponseEntity<>(tarea, HttpStatus.CREATED);
		} else {
			response.put("mensaje", "Error a realizar transaccion a la base de datos");
			response.put("id", "-1");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "{tareaId}")
	public ResponseEntity<?> deleteTarea(@PathVariable("tareaId") String tareaId) {

		Tarea tarea = tareaService.findById(tareaId);

		if (tarea != null) {
			tareaService.deleteById(tareaId);
			return new ResponseEntity<>("tarea borrada. ", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("tarea no encontrada.", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "{tareaId}")
	public ResponseEntity<?> updateTarea(@PathVariable("tareaId") String id, @RequestBody Tarea tarea) {

		Tarea tareaUpdate = tareaService.findById(id);

		if (tareaUpdate != null) {
			Tarea updateTarea = tareaUpdate;
			updateTarea.setIdTarea(tarea.getIdTarea());
			updateTarea.setDescripcion(tarea.getDescripcion());
			updateTarea.setFechaCreacion(tarea.getFechaCreacion());
			updateTarea.setVigente(tarea.getVigente());
			tareaService.save(updateTarea);

			return new ResponseEntity<>(updateTarea, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("tarea no actualizada. ", HttpStatus.NOT_FOUND);
		}
	}
}