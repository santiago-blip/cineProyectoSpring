/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service;

import cineProject.entity.Pelicula;
import java.util.List;


public interface IPeliculaService {
    
    public List<Pelicula> listarPeliculas();
    
    public List<Pelicula> listarPeliculasPorCategoria(String categoria);
    
    public Pelicula buscarPelicula(Pelicula pelicula);
    
    public void insertarPelicula(Pelicula pelicula);
    
    public void eliminarPelicula(int id);
    
    
}
