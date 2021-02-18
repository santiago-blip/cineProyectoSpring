/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.DAO;

import cineProject.entity.Pelicula;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface PeliculaDAO extends CrudRepository<Pelicula,Integer>{
    
    public List<Pelicula> findByCategoria(String categoria);
    
}
