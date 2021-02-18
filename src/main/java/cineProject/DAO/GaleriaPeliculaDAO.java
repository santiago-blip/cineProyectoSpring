/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.DAO;

import cineProject.entity.GaleriaPelicula;
import cineProject.entity.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface GaleriaPeliculaDAO extends CrudRepository<GaleriaPelicula,Integer>{
    
    @Transactional
    public void deleteByIdPelicula(Pelicula idPelicula);
    
}
