package com.databaseT2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_producto")
@Getter
@Setter
public class Producto {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "stock_actual")
	private Integer stockActual;
	
	@Column(name = "stock_maximo")
	private Integer stockMaximo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	public Integer getResultadoStock() {
		return stockMaximo - stockActual;
	}
	
	
}
