package com.livenet.livenet.amigos;

import com.livenet.livenet.localizacion.Localizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface amigosDAO extends JpaRepository<Amigo, Long> {

    List<Amigo> findAllByAlias1OrAlias2(String alias1, String alias2);


}
