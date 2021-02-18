/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineProject.controller;

import cineProject.entity.Galeria;
import cineProject.entity.GaleriaPelicula;
import cineProject.entity.Pelicula;
import cineProject.entity.Rol;
import cineProject.entity.Usuario;
import cineProject.service.IGaleriaPeliculaService;
import cineProject.service.IPeliculaService;
import cineProject.service.IUsuarioService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

    @Autowired
    private IPeliculaService peliculaService;
    
    @Autowired
    private IGaleriaPeliculaService GaleriaPeliculaService;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("peliculas",peliculaService.listarPeliculas());
        return "index";
    }

    @RequestMapping(value = "/peliculas")
    public String peliculas(Pelicula pelicula, Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculasPorCategoria("Pelicula"));
        return "peliculas";
    }

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    public String series(Pelicula pelicula, Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculasPorCategoria("Serie"));
        return "series";
    }

    @PostMapping("/peliculas")
    public String agregarPelicula(@Valid Pelicula pelicula, Errors error, @RequestParam("file") MultipartFile file, RedirectAttributes flash, @RequestParam(name = "url") String url) {

        if (error.hasErrors()) {
            if (url.equals("/peliculas")) {
                flash.addFlashAttribute("error", "No se ha subido correctamente la pelicula" + file.getOriginalFilename());
                return "redirect:/peliculas";
            } else {
                flash.addFlashAttribute("error", "No se ha subido correctamente la serie" + file.getOriginalFilename());
                return "redirect:/series";
            }
        }
        if (!file.isEmpty()) {
            Path directorio = Paths.get("src//main//resources//static/img");//=>RutaDeLasImg
            String path = directorio.toFile().getAbsolutePath();//=>ruta absoluta desde el proyecto
            try {
                byte[] bytes = file.getBytes();
                Path fullPath = Paths.get(path + "//" + file.getOriginalFilename());
                Files.write(fullPath, bytes);
                flash.addFlashAttribute("succes", "Se ha subido correctamente la pelicula" + file.getOriginalFilename());
                pelicula.setRutaImg(file.getOriginalFilename());

            } catch (IOException e) {
                System.out.println("ERROR AL AGREGAR PELICULA: ".concat(e.toString()));
                flash.addFlashAttribute("error", "No se ha subido correctamente la pelicula" + file.getOriginalFilename());
                return "redirect:/peliculas";
            }
        }
        if (pelicula.getRutaImg() == null) {
            System.out.println("LA IMG ES NULL");
        }
        if (pelicula.getRutaImg() == null && pelicula.getIdPelicula() > 0) {
            Pelicula pelicula2 = peliculaService.buscarPelicula(pelicula);
            pelicula.setRutaImg(pelicula2.getRutaImg());
            System.out.println("ENTRO A LA CONDICIÓN DE IMG NULL Y ID >0");
        }
        peliculaService.insertarPelicula(pelicula);
        return "redirect:".concat(url);
    }

    @RequestMapping(value = "/peliculaE")
    public String peliculas(@RequestParam(name = "id") int id, Pelicula pelicula, Model model) {
        pelicula.setIdPelicula(id);
        pelicula = peliculaService.buscarPelicula(pelicula);
        if (pelicula != null) {
            model.addAttribute("pelicula", pelicula);
        }
        model.addAttribute("peliculas", peliculaService.listarPeliculasPorCategoria("Pelicula"));
        return "peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(name = "id") String id) {
        peliculaService.eliminarPelicula(Integer.parseInt(id));
        return "redirect:/peliculas";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam("name") String user, @RequestParam("pass") String pass, @RequestParam("url") String url, RedirectAttributes flash, Usuario usuario) {

        if (!user.isBlank() && !pass.isBlank()) {
            flash.addFlashAttribute("registro", "Registro exitoso");
            usuario.setUsuario(user);
            usuario.setClave(this.passwordEncode.encode(pass));
            Rol rol = new Rol();
            Galeria galeria = new Galeria();
            rol.setIdRol(2);
            usuario.setRol(rol);
            galeria.setIdUsuario(usuario);
            usuario.setGaleria(galeria);
            usuarioService.registrar(usuario);
        } else {
            flash.addFlashAttribute("registro", "No se pudo hacer el registro");
        }

        return "redirect:".concat(url);
    }
    @GetMapping("/ver")
    public String verPelicula(@RequestParam(name = "idPelicula") int id, @RequestParam(name = "ruta") String ruta,Pelicula pelicula,Model model){
        pelicula.setIdPelicula(id);
        pelicula = peliculaService.buscarPelicula(pelicula);
        model.addAttribute("pelicula",pelicula);
        model.addAttribute("ruta",ruta);
        return "ver";
    }
    @RequestMapping(value = "/verMas")
    public String verMasTarde(Usuario usuario,Model model, Authentication aut){
        usuario = usuarioService.buscarUsuarioByName(aut.getName());
        model.addAttribute("usuarioVer",usuario);
        return "verMas";
    }
    @RequestMapping(value = "/reproduccion/{id}")
    public String addReproduccion(@PathVariable(name = "id") int id,Usuario usuario,Authentication aut){
        GaleriaPelicula galeria = new GaleriaPelicula();
        Pelicula pelicula = new Pelicula();
        usuario = usuarioService.buscarUsuarioByName(aut.getName());
        pelicula.setIdPelicula(id);
        galeria.setIdGaleria(usuario.getGaleria());
        galeria.setIdPelicula(pelicula);
        if(id >0){
            GaleriaPeliculaService.agregarPelicula(galeria);
        }
        return "redirect:/";//.concat(url);
    }
    @GetMapping(value = "/eliminarVer")
    public String eliminarGaleria(@RequestParam(name = "idPelicula") int id){
        System.out.println("Entro en \"EliminarVer\"");
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(id);
        GaleriaPeliculaService.eliminarDeGaleria(pelicula);
        return "redirect:/verMas";
    }
    
}
