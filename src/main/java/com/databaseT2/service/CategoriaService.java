package com.databaseT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.databaseT2.model.Categoria;
import com.databaseT2.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}
}
