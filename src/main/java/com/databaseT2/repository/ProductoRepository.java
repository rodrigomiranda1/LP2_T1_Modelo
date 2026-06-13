package com.databaseT2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.databaseT2.model.Producto;

@Service
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
