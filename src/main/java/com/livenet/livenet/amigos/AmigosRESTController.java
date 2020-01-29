package com.livenet.livenet.amigos;


import com.livenet.livenet.usuario.Usuario;
import com.livenet.livenet.usuario.usuariosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController         // Definimos la clase como controlador REST
@RequestMapping("/")
public class AmigosRESTController {

    @Autowired
    private amigosDAO pd;

    @Autowired
    private usuariosDAO ud;

    @RequestMapping(value="amigos/{alias}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String[]>> findAllByAlias(@PathVariable("alias") String alias){
        ArrayList<String[]> users = new ArrayList<String[]>();
        List<Amigo> rest = pd.findAllByAlias1OrAlias2(alias,alias);

        for(Amigo a : rest){
            if(a.getAlias1().equals(alias)){

                Usuario user = ud.findByAlias(a.getAlias2());
                users.add(new String[]{a.getAlias2(), user.getFoto(), user.getToken()});
            }else if(a.getAlias2().equals(alias)){
                Usuario user = ud.findByAlias(a.getAlias1());
                users.add(new String[]{a.getAlias1(), user.getFoto(), user.getToken()});

            }

        }

        return ResponseEntity.ok(users);
    }

}
