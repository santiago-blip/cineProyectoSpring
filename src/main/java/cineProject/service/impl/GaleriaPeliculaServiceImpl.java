/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service.impl;

import cineProject.DAO.GaleriaPeliculaDAO;
import cineProject.entity.GaleriaPelicula;
import cineProject.entity.Pelicula;
import cineProject.service.IGaleriaPeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaleriaPeliculaServiceImpl implements IGaleriaPeliculaService{

    @Autowired
    private GaleriaPeliculaDAO serviceDAO;
    
    
    @Override
    public List<Pelicula> listarPelicula(GaleriaPelicula galeria) {
        return (List<Pelicula>)serviceDAO.findById(galeria.getIdGaleria().getIdGaleria()).orElse(null);
    }

    @Override
    public void agregarPelicula(GaleriaPelicula galeria) {
        serviceDAO.save(galeria);
    }

    @Override
    public void eliminarDeGaleria(Pelicula idPelicula) {
        serviceDAO.deleteByIdPelicula(idPelicula);
    }
    
}
