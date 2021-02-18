/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service;

import cineProject.entity.Usuario;


public interface IUsuarioService {
    
    public void registrar(Usuario usuario);
    
    public Usuario buscarUsuario(Usuario usuario);
    
    public Usuario buscarUsuarioByName(String name);
    
    public void deleteUsuario(int id);
    
}
