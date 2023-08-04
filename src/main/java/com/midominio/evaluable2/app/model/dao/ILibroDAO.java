package com.midominio.evaluable2.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.midominio.evaluable2.app.model.entity.Libro;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILibroDAO extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long> {
}
