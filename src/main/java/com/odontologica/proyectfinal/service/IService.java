package com.odontologica.proyectfinal.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    public T guardar(T t);
    public Optional<T> buscar(Integer id);
    public List<T> buscarTodos();
    public boolean eliminar(Integer id);
    public T actualizar(T t);
}
