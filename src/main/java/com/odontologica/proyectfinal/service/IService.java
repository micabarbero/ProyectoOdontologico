package com.odontologica.proyectfinal.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    public T guardar(T t) throws Exception;
    public Optional<T> buscar(Integer id) throws Exception;
    public List<T> buscarTodos() throws Exception;
    public boolean eliminar(Integer id) throws Exception;
    public T actualizar(T t) throws Exception;
}
