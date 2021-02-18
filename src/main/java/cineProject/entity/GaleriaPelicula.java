/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_galeria_pelicula")
public class GaleriaPelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id_galeriaPelicula")
    private int idGaleriaPelicula;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula idPelicula;

    @ManyToOne()
    @JoinColumn(name = "id_galeria")
    private Galeria idGaleria;

    public GaleriaPelicula(){
        
    }

    public int getIdGaleriaPelicula() {
        return idGaleriaPelicula;
    }

    public void setIdGaleriaPelicula(int idGaleriaPelicula) {
        this.idGaleriaPelicula = idGaleriaPelicula;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Galeria getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(Galeria idGaleria) {
        this.idGaleria = idGaleria;
    }

    

   

   
    
}
