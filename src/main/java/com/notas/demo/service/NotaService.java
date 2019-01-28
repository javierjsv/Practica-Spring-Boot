package com.notas.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.notas.demo.converter.Convertidor;
import com.notas.demo.entities.Nota;
import com.notas.demo.model.MNota;
import com.notas.demo.repocitory.NotaRepocitorio;


@Service("notaServicio")
@Transactional
public class NotaService {

	@Autowired
	@Qualifier("repocitorio")
	private NotaRepocitorio respocitorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;


	@Transactional
	public boolean create(Nota nota) {
		try {
			respocitorio.save(nota);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	@Transactional
	public boolean update(Nota nota) {
		try {
			respocitorio.save(nota);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean delete(String nombre) {
		try {
			Nota nota = respocitorio.findByNombre(nombre);
			respocitorio.delete(nota);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean delete(String nombre, long id) {
		try {
			Nota nota = respocitorio.findByNombreAndId(nombre, id);
			respocitorio.delete(nota);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	public List<MNota> obtener() {
		return convertidor.convertirLista(respocitorio.findAll());
	}
	

	@Transactional
	public MNota nombreAndTitulo(String nombre, String titulo) {
		return new MNota(respocitorio.findByNombreAndTitulo(nombre, titulo));
	}

	@Transactional
	public List<MNota> listaTitulo(String titulo) {
		return convertidor.convertirLista(respocitorio.findByTitulo(titulo));
	}
	
	@Transactional
	public List<MNota> PaginacionNota(Pageable pageable){
	 return	convertidor.convertirLista(respocitorio.findAll(pageable).getContent());
	}/*
	*/
}
