package com.databaseT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.databaseT2.model.Producto;
import com.databaseT2.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

	
	private final ProductoRepository productoRepository;
	
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}
}
