package com.notas.demo.repocitory;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.notas.demo.entities.Nota;


@Repository("repocitorio")
public interface NotaRepocitorio extends JpaRepository<Nota, Serializable> {


	public abstract Nota findByNombre(String nombre);
	
	
	public abstract Nota findByNombreAndId(String nombre , long id);


	public abstract List<Nota> findByTitulo(String titulo); 


	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);

}
