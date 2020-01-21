package com.livenet.livenet.mensaje;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MensajeRESTController {


    @Autowired
    private mensajesDAO pd;


    @RequestMapping(value="mensajes/{destino}", method = RequestMethod.GET)
    public ResponseEntity<List<Mensaje>> findByDestino(@PathVariable("destino") String destino){
        List<Mensaje> m = pd.findByDestino(destino);

        for(Mensaje ms : m){
            pd.delete(ms);
        }
        return ResponseEntity.ok(m);

    }

    @RequestMapping(value="enviarmensaje",method = RequestMethod.POST)
    public ResponseEntity<Mensaje> create(@RequestBody Mensaje mensaje){
        Mensaje m = pd.save(mensaje);

        return ResponseEntity.ok(m);
    }

}
