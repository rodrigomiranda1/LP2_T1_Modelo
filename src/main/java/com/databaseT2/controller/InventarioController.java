package com.databaseT2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.databaseT2.model.Inventario;
import com.databaseT2.service.CategoriaService;
import com.databaseT2.service.InventarioService;
import com.databaseT2.service.ProductoService;
import com.databaseT2.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("inventario")
public class InventarioController {

	private final InventarioService inventarioService;
	private final CategoriaService categoriaService;
	private final ProductoService productoService;
	
	@GetMapping("listadoMiranda")
	public String listado(Model model) {
		model.addAttribute("lstInventario", inventarioService.getAll());
		
		return "/inventario/listadoMiranda";
	}
	
	@GetMapping("nuevoMiranda")
	public String nuevo(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("inventario", new Inventario());
		
		return "/inventario/nuevoMiranda";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Inventario inventario, Model model, RedirectAttributes flash) {
		
		var response = inventarioService.create(inventario);
		
		if (!response.success()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("productos", productoService.getAll());
			model.addAttribute("inventario", inventario);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			
			return "/inventario/nuevoMiranda";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast",toast);
		
		return "redirect:/inventario/listadoMiranda";
	}
	
	
	@GetMapping("edicionMiranda/{id}")
	public String nuevo(@PathVariable Integer id,Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("inventario", inventarioService.getOne(id));
		
		return "/inventario/edicionMiranda";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute Inventario inventario, Model model, RedirectAttributes flash) {
		
		var response = inventarioService.update(inventario);
		
		if (!response.success()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("productos", productoService.getAll());
			model.addAttribute("inventario", inventario);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			
			return "/inventario/edicionMiranda";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast",toast);
		
		return "redirect:/inventario/listadoMiranda";
	}
	
	
	
}
