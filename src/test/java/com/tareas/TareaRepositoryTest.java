package com.tareas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.tareas.dao.Tarea;
import com.tareas.repository.TareaRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TareaRepositoryTest {
	
	Date date = new Date(0);
	@Autowired
	TareaRepository repo;
	
	@Test
	void TareaSaveTest(){
		
		Tarea tarea = new Tarea("2","test",date,true);
		Tarea savedTarea = repo.save(tarea);
		assertNotNull(savedTarea);
	}
	
	@Test
	void tareaFindByIdTest() {

	  String id = "1";
	  Optional<Tarea> tareaList = repo.findById(id);
	  assertTrue(tareaList.isPresent());
	}
	
	@Test
	@Rollback(false)
	void tareaUpdateTest() {
		
		String idUpdate = "1";
		Tarea tarea = new Tarea(null,"test7",date,false);
		tarea.setIdTarea("1");
		repo.save(tarea);
		
		Optional<Tarea> tareaUpdate = repo.findById(idUpdate);
		
		assertThat(tareaUpdate.orElseThrow().getIdTarea()).isEqualTo(idUpdate);
	}
	
	@Test
	void tareaFindAllTest() {
		
		List<Tarea> listTarea = (List<Tarea>) repo.findAll();
		
		for(Tarea tarea : listTarea) {
			
			System.out.println(tarea);
		}
		
		assertThat(listTarea.size()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	void tareaDeleteTest() {
		
		String id = "2";
		boolean existeAntesEliminar = repo.findById(id).isPresent();
		repo.deleteById(id);
		boolean noExisteDespuesEliminar = repo.findById(id).isPresent();
		
		assertTrue(existeAntesEliminar);
		assertFalse(noExisteDespuesEliminar);
	}
	
	
}
