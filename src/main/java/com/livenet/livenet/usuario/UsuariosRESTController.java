package com.livenet.livenet.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")    // Definimos la url o entrada de la API REST, este caso la raíz: localhost:8080/
public class UsuariosRESTController {



    @Autowired
    private usuariosDAO usuarioDao;

    // Función de TEST

    //@GetMapping
    @RequestMapping(value = "prueba", method = RequestMethod.GET)
    public String hola() {
        return "Esto es una prueba";
    }

    //*** Comenzado los servicios rest




    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {

        // Nos conectamos y realizamos el select
        List<Usuario> u = usuarioDao.findAll();
        // Devolvemos la ista de usuarios
        return ResponseEntity.ok(u);
    }

    //para @query poner value= y la select
    @RequestMapping(value = "usuarios/{alias}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByAlias(@PathVariable("alias") String alias) {
        // Buscamos el usuario por alias
        Usuario u = usuarioDao.findByAlias(alias);

        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.noContent().build();
        }

    }


    @RequestMapping(value = "insertar_usuario", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario u) {

        Usuario p = usuarioDao.save(u);

        return ResponseEntity.ok(p);
    }

    @RequestMapping(value = "usuarios/{alias}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("alias") String alias) {
        // Buscamos el usuario por alias
        Optional<Usuario> op = Optional.ofNullable(usuarioDao.findByAlias(alias));
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            Usuario u = op.get();
            usuarioDao.deleteById(u.getId());
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "usuarios/{alias}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@PathVariable("alias") String alias, @RequestBody Usuario u) {
        // Buscamos el localizacion por alias
        Optional<Usuario> op = Optional.ofNullable(usuarioDao.findByAlias(alias));
        // Devolvemos el localizacion si existe.
        if (op.isPresent()) {
            // Le pasamos los datos
            Usuario us = op.get();
            usuarioDao.save(us);
            return ResponseEntity.ok(us);
        } else {
            return ResponseEntity.noContent().build();
        }
    }







}
