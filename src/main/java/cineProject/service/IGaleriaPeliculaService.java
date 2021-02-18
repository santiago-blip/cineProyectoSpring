/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service;

import cineProject.entity.GaleriaPelicula;
import cineProject.entity.Pelicula;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IGaleriaPeliculaService {
    
    public List<Pelicula> listarPelicula(GaleriaPelicula galeria);
    
    public void agregarPelicula(GaleriaPelicula galeria);
    
    public void eliminarDeGaleria(Pelicula idPelicula);
    
}
