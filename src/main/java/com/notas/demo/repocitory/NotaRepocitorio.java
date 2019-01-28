package com.notas.demo.repocitory;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.notas.demo.entities.Nota;

@Repository("repocitorio")
public interface NotaRepocitorio
		extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable> {

	public abstract Nota findByNombre(String nombre);

	public abstract Nota findByNombreAndId(String nombre, long id);

	public abstract List<Nota> findByTitulo(String titulo);

	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);

	// Metodo para paginacion
	// import org.springframework.data.domain.Page;
	// http://localhost:8090/v1/notas?page=0&size=5 ejemplo
	public abstract Page<Nota> findAll(Pageable pageable);

}
