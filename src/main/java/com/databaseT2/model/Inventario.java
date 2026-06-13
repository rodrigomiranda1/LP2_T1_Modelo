package com.databaseT2.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_inventario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Inventario {

	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroInventario;
	
	@Column(name = "fecha_vencimiento")
	private LocalDate fechaVencimiento;
	
	@Column(name = "costo_ingreso")
	private Double costoIngreso;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "lote")
	private String lote;
	
	@Column(name = "cod_estado")
	private String codEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public String getEstadoNombre() {
		if (codEstado == null) {
			return "";
		}
		switch (codEstado) {
		case "A": return "Activo";
		case "V": return "Vencido";
		case "T": return "En tránsito";
		case "B": return "Bloqueado";
		default:
			return "nada";
		}
	}
}
