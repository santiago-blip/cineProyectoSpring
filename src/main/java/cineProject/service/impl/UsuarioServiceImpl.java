/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service.impl;

import cineProject.DAO.UsuarioDAO;
import cineProject.entity.Usuario;
import cineProject.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private UsuarioDAO serviceDAO;

    @Override
    public void registrar(Usuario usuario) {
        this.serviceDAO.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
       return this.serviceDAO.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public void deleteUsuario(int id) {
        this.serviceDAO.deleteById(id);
    }

    @Override
    public Usuario buscarUsuarioByName(String name) {
         return this.serviceDAO.findByUsuario(name);
    }
    
    
}
