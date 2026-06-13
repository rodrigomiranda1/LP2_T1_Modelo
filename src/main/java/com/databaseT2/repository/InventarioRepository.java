package com.databaseT2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databaseT2.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

	List<Inventario> findAllByOrderByNumeroInventarioDesc();
}
