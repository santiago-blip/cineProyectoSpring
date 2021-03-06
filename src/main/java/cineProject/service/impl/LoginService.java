/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.service.impl;

import cineProject.DAO.UsuarioDAO;
import cineProject.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceLogin")
public class LoginService implements UserDetailsService {

    @Autowired
    private UsuarioDAO serviceDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Usuario usuario = serviceDAO.findByUsuario(string);
        List<GrantedAuthority> autoritie = new ArrayList<>();
        autoritie.add(new SimpleGrantedAuthority(usuario.getRol().getRol()));
        System.out.println("Esto es el ROL QUE PASA: "+usuario.getRol().getRol());
        return new User(usuario.getUsuario(), usuario.getClave(), autoritie);
    }

}
