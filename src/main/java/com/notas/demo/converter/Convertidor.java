package com.notas.demo.converter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.notas.demo.entities.Nota;
import com.notas.demo.model.*;

@Component("convertidor")
public class Convertidor {

	public List<MNota> convertirLista(List<Nota> notas) {
		List<MNota> mnotas = new ArrayList<>();

		// crear foreach para crear las mnotas
		//creamos una lista de notas a una lista de Mnotas

		for (Nota nota : notas) {
			mnotas.add(new MNota(nota));
		}

		return mnotas;
	}
}
