
package com.login.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.entity.Producto;
import com.login.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        List<Producto> lista = productoRepository.findAll();
        return lista;
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> obtenerPorNombre(String np){
        return productoRepository.findByNombreProducto(np);
    }

    public void guardar(Producto producto){
        productoRepository.save(producto);
    }

    public void borrar(Long id){
        productoRepository.deleteById(id);
    }

    public boolean existePorNombre(String np){
        return productoRepository.existsByNombreProducto(np);
    }

    public boolean existePorId(Long id){
        return productoRepository.existsById(id);
    }
}