/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service.impl;

import cineProject.DAO.PeliculaDAO;
import cineProject.entity.Pelicula;
import cineProject.service.IPeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PeliculaServiceImpl implements IPeliculaService{

    @Autowired
    private PeliculaDAO serviceDAO;
    
    @Override
    public List<Pelicula> listarPeliculas() {
        return (List<Pelicula>) serviceDAO.findAll();
    }

    @Override
    public Pelicula buscarPelicula(Pelicula pelicula) {
        return serviceDAO.findById(pelicula.getIdPelicula()).orElse(null);
    }

    @Override
    public void insertarPelicula(Pelicula pelicula) {
        serviceDAO.save(pelicula);
    }

    @Override
    public void eliminarPelicula(int id) {
        serviceDAO.deleteById(id);
    }

    @Override
    public List<Pelicula> listarPeliculasPorCategoria(String categoria) {
       return (List<Pelicula>) serviceDAO.findByCategoria(categoria);
    }
    
}
