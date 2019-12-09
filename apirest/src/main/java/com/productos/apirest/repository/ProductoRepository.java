package com.productos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.apirest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	
	
	Producto findById(long id);
	

}
