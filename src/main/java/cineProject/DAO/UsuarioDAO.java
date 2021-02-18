/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.DAO;

import cineProject.entity.Galeria;
import cineProject.entity.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
    
    public Usuario findByUsuario(String username);
}
