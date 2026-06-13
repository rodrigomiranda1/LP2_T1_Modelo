package com.databaseT2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.databaseT2.dto.ResultadoResponse;
import com.databaseT2.model.Inventario;
import com.databaseT2.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

	private final InventarioRepository inventarioRepository;
	
	public List<Inventario> getAll() {
		return inventarioRepository.findAllByOrderByNumeroInventarioDesc();
	}
	
	public ResultadoResponse create(Inventario inventario) {
		try {
			var registro = inventarioRepository.save(inventario);
			var mensaje = String.format("Inventario con ID %s registrado", registro.getNumeroInventario());
			
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
	
	public Inventario getOne(Integer idInventario) {
		return inventarioRepository.findById(idInventario).orElseThrow();
	}
	
	public ResultadoResponse update(Inventario inventario) {
		try {
			var registro = inventarioRepository.save(inventario);
			var mensaje = String.format("Inventario con ID %s actualizado", registro.getNumeroInventario());
			
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
}
