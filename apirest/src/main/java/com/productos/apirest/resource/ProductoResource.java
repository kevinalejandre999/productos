package com.productos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.apirest.model.Producto;
import com.productos.apirest.repository.ProductoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Productos")
@CrossOrigin(origins="*")
public class ProductoResource {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	@ApiOperation(value="Retorna una lista de productos")
	public List<Producto> listarProductos(){
		return productoRepository.findAll();
	}
	
	
	@GetMapping("/producto/{id}")
	@ApiOperation(value="Retorna un solo producto")
	public Producto listarProductoUnico(@PathVariable(value="id")long id){
		return productoRepository.findById(id);
	}
	
	@PostMapping("/producto")
	@ApiOperation(value="Este metodo guarda un nuevo producto")
	public Producto salvarProducto(@RequestBody Producto producto){
		return productoRepository.save(producto);
	}
	
	@DeleteMapping("/producto")
	@ApiOperation(value="Este metodo elimina un prodcuto")
	public void deletaProducto(@RequestBody Producto producto){
		productoRepository.delete(producto);
	}
	
	@PutMapping("/producto")
	@ApiOperation(value="Este metodo actualiza un producto")
	public Producto actualizaProducto(@RequestBody Producto producto){
		return productoRepository.save(producto);
	}
	

}
