package com.notas.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		System.out.println("ssss");
		return service.create(nota);
	}

}
