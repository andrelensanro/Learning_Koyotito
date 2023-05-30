package com.koyotito.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koyotito.project.model.RelTutoradoGrupo;
import com.koyotito.project.model.RelTutoradoInvitacion;
import com.koyotito.project.model.Tutor;
import com.koyotito.project.model.Tutorado;
import com.koyotito.project.services.RelTutoradoGrupoService;
import com.koyotito.project.services.RelTutoradoInvitacionService;
import com.koyotito.project.services.TutorService;
import com.koyotito.project.services.TutoradoService;

@RestController
@RequestMapping("/tutor")
@CrossOrigin(origins = "http://localhost:4200")
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	@Autowired
	private TutoradoService tutoradoService;
	@Autowired
	private RelTutoradoInvitacionService rtiService;
	@Autowired
	private RelTutoradoGrupoService rtgService;
	
	
	@GetMapping("/{idTutor}/crear-tutorado")
	public void crearTutor(@PathVariable("idTutor") Long idTutor, @RequestParam("pseudonimo") String pseudonimo) {
		Tutor tutor = new Tutor();
		tutor = tutorService.findById(idTutor);
		
		Tutorado tutorado = new Tutorado();
		tutorado.setTutor(tutor);
		tutor.setNumTutorados(tutor.getNumTutorados()+1);
		tutorado.setPseudonimo(pseudonimo);
		tutorado.setNivel(1);
		tutorado.setPuntos(10L);
		tutorado.setTutor(tutor);
		tutoradoService.save(tutorado);
	}
	
	
	@GetMapping("/{idTutor}/eliminar-tutorado/{idTutorado}")
	public void eliminarTutorado(@PathVariable("idTutor") Long idTutor, @PathVariable("idTutorado") Long idTutorado ) {
		Tutorado tutorado = new Tutorado();
		tutorado = tutoradoService.findById(idTutorado);
		
		List<RelTutoradoInvitacion> lr = rtiService.findByTutoradoIdTutorado(idTutorado);
		
		for(RelTutoradoInvitacion r: lr) {
			rtiService.delete(r);			
		}
		
		List<RelTutoradoGrupo> lrr = rtgService.findByTutoradoIdTutorado(idTutorado);
		
		for(RelTutoradoGrupo r: lrr) {
			rtgService.delete(r);		
		}
		
		Tutor tutor = tutorService.findById(idTutor);
		tutor.setNumTutorados(tutor.getNumTutorados()-1);
		
		tutoradoService.delete(tutorado);
		
	}
	
	
	
	
}
