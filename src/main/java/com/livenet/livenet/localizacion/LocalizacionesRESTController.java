package com.livenet.livenet.localizacion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")    // Definimos la url o entrada de la API REST, este caso la raíz: localhost:8080/
public class LocalizacionesRESTController {

    /**
     * //@RequestMapping @GetMapping @PostMapping, etc (estos dos últimos no redirigen la URL, si no toman la url base
     * //@GetMapping Consume el servicio en la url raiz usando GET localhots:8080/
     * // @RequestMapping(value = "hola", method = RequestMethod.GET) de esta manera indicamos el protocolo y la URL de entrada
     * // localhost:8080/hola
     */

    // Inyección de dependecias para CRUD con ProductosDAO, JDataObject
    // https://www.baeldung.com/spring-dao-jpa
    @Autowired
    private localizacionesDAO pd;

    // Función de TEST

    //@GetMapping
    @RequestMapping(value = "prueba", method = RequestMethod.GET)
    public String hola() {
        return "Esto es una prueba";
    }

    //*** Comenzado los servicios rest


    /**
     * Lista todos las localizaciones. Protocolo GET
     * GET: http://localhost:8080/localizaciones
     *
     * @return Lista de localizaciones
     */
    @RequestMapping(value = "localizaciones", method = RequestMethod.GET)
    public ResponseEntity<List<Localizacion>> findAll() {

        // Nos conectamos y realizamos el select
        List<Localizacion> l = pd.findAll();
        // Devolvemos la ista de localizaciones
        return ResponseEntity.ok(l);
    }

    /**
     * Devuelve un localizacion dado su ID protocolo GET
     * GET: http://localhost:8080/localizaciones/{alias}
     *
     * @param alias ID del localizacion
     * @return Producto
     */
/* // manera de buscar por alias poco eficiente ya que me traigo toda la lista de localiazciones
        // por ahora solo lo puedo hacer así ya que no hay metodo fillbyString(), hay fill by id que recibe long.
        Localizacion l = null;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAlias().equals(alias))
                l = lista.get(i);
        }
        if (l != null) {
            return ResponseEntity.ok(l);
        } else {
            return ResponseEntity.noContent().build();
        }*/

    //para @query poner value= y la select
    @RequestMapping(value = "localizaciones/{alias}", method = RequestMethod.GET)
    public ResponseEntity<Localizacion> findByAlias(@PathVariable("alias") String alias) {
        // Buscamos el localizacion por alias
        Localizacion loc = pd.findByAlias(alias);

        if (loc != null) {
            return ResponseEntity.ok(loc);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    /**
     * Crea un nuevo localizacion. Protocolo POST
     * POST: http://localhost:8080/localizaciones
     *
     * @param localizacion Producto a crear mendiante JSON
     * @return Producto creado si lo consigue
     */
    @RequestMapping(value = "insertarloc", method = RequestMethod.POST)
    public ResponseEntity<Localizacion> create(@RequestBody Localizacion localizacion) {
        // Creamos un nuevo localizacion a partir de los datos una vez insertado
        Localizacion p = pd.save(localizacion);
        //devolvemos el nuevo localizacion
        return ResponseEntity.ok(p);
    }

    /**
     * Borra un localizacion de la base de datos. Protocolo DELETE
     * DELETE: http://localhost:8080/localizaciones/{alias}
     *
     * @param alias, alias del localizacion a eliminar
     * @return
     */
    @RequestMapping(value = "localizaciones/{alias}", method = RequestMethod.DELETE)
    public ResponseEntity<Localizacion> delete(@PathVariable("alias") Long alias) {
        // Buscamos el localizacion por alias
        Optional<Localizacion> op = pd.findById(alias);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Localizacion p = op.get();
            pd.deleteById(alias);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Actualiza un localizacion de la base de datos. Protocolo PUT
     * PUT: http://localhost:8080/localizaciones/{alias}
     *
     * @param localizacion localizacion a actualizar
     * @return Producto actualizado
     */
    @RequestMapping(value = "localizaciones/{alias}", method = RequestMethod.PUT)
    public ResponseEntity<Localizacion> update(@PathVariable("alias") String alias, @RequestBody Localizacion localizacion) {
        // Buscamos el localizacion por alias
        Optional<Localizacion> op = Optional.ofNullable(pd.findByAlias(alias));
        // Devolvemos el localizacion si existe.
        if (op.isPresent()) {
            // Le pasamos los datos
            Localizacion p = op.get();
            p.setLatitud(localizacion.getLatitud());
            pd.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "long/{longitud}", method = RequestMethod.GET)
    public ResponseEntity<Localizacion> findByLongitud(@PathVariable("longitud") String longitud){
        Localizacion loc = pd.findByLongitud(Float.parseFloat(longitud));

        if (loc != null) {
            return ResponseEntity.ok(loc);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @RequestMapping(value = "fechahora/{fecha_hora}", method = RequestMethod.GET)
    public ResponseEntity<Localizacion> findByFechaHora(@PathVariable("fecha_hora") String fecha_hora) {
        // Buscamos el localizacion por alias
        Localizacion loc = pd.findByFechaHora(fecha_hora);

        if (loc != null) {
            return ResponseEntity.ok(loc);
        } else {
            return ResponseEntity.noContent().build();
        }

    }



}
