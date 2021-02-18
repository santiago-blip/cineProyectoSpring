/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_galeria")
public class Galeria implements Serializable{
    
    @Id
    @Column(name="id_galeria")
    private int idGaleria;
    
   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "idGaleria")
//    @JoinColumn(name ="id_galeria")
    private List<GaleriaPelicula> listarPeliculas;
    
    public Galeria(){
        
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }


    public List<GaleriaPelicula> getListarPeliculas() {
        return listarPeliculas;
    }

    public void setListarPeliculas(List<GaleriaPelicula> listarPeliculas) {
        this.listarPeliculas = listarPeliculas;
    }
    public void addListarPeliculas(GaleriaPelicula galeriaPelicula){
        this.listarPeliculas.add(galeriaPelicula);
    }
}
