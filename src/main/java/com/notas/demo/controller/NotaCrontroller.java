package com.notas.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.demo.converter.Convertidor;
import com.notas.demo.entities.Nota;
import com.notas.demo.model.MNota;
import com.notas.demo.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaCrontroller {

	// Autowired es injectar // @Qualifier como se llama el bean
	@Autowired
	@Qualifier("notaServicio")
	private NotaService service;

	@Autowired
	@Qualifier("convertidor")
	Convertidor convertidor;

	// @RequestBody sirve para
	// @Valid
	@PutMapping("/create")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		System.out.println("nota" + nota);
		return service.create(nota);
	}

	@PostMapping("/update")
	private boolean actulizar(@RequestBody @Valid Nota nota) {
		// sebe enviar el id
		return service.update(nota);

	}

	// @PathVariable asignar variables
	@DeleteMapping("/delete/{id}/{nombre}")
	public Boolean eliminarNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre) {
		return service.delete(nombre, id);
	}

	// lsitar con paginacion

	
	@GetMapping("/notas")
	public List<MNota> listarNotas(Pageable pageable) {
		return service.PaginacionNota(pageable);}
 /*
		// return convertidor.convertirLista(service.PaginacionNota(pageable));
	
	

	/*
	 * @GetMapping("/titulos") public List<MNota> listarTitulos(String titulo){
	 * return service.listaTitulo(titulo); }
	 */

}
