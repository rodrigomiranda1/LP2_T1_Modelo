package com.databaseT2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.databaseT2.model.Categoria;

@Service
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
