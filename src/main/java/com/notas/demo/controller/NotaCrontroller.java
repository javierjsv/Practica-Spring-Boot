package com.notas.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.demo.entities.Nota;
import com.notas.demo.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaCrontroller{

	// Autowired es injectar // @Qualifier como se llama el bean
	@Autowired
	@Qualifier("notaServicio")
	NotaService service;
	
	
	// @RequestBody sirve para
	// @Valid para devolver un Json

	@PutMapping("/create")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		System.out.println("nota"+nota);
		return service.create(nota);
	}
	
	@PostMapping("/update")
	private boolean actulizar( @RequestBody @Valid Nota nota) {
		//sebe enviar el id
		return service.update(nota);

	}
	
	//@PathVariable asignar variables
	@DeleteMapping("/delete/{id}/{nombre}")
	public Boolean eliminarNota(@PathVariable("id") long id ,@PathVariable("nombre") String nombre) {
		return service.delete(nombre,id);
	}
	
	

}
