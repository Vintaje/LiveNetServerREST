package com.livenet.livenet.sesion;

import com.livenet.livenet.localizacion.Localizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
@RequestMapping
public class SesionesRESTController {

    @Autowired
    private sesionesDAO pd;

    @RequestMapping(value="sesion/{alias}", method = RequestMethod.GET)
    public ResponseEntity<Sesion> findByAlias(@PathVariable("alias") String alias){
        Sesion s = pd.findByAlias(alias);

        if (s != null) {
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "insertsesion", method = RequestMethod.POST)
    public ResponseEntity<Sesion> create(@RequestBody Sesion sesion){
        Sesion s = pd.save(sesion);

        return ResponseEntity.ok(s);
    }


    @RequestMapping(value = "cerrarsesion/{alias}", method = RequestMethod.DELETE)
    public ResponseEntity<Sesion> delete(@PathVariable("alias") Long alias) {
        // Buscamos el localizacion por alias
        Optional<Sesion> op = pd.findById(alias);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Sesion s = op.get();
            pd.deleteById(alias);
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
