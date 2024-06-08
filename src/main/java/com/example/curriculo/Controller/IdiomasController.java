package com.example.curriculo.Controller;

import com.example.curriculo.Model.Idiomas;
import com.example.curriculo.Service.IdiomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idiomas")
public class IdiomasController {

    @Autowired
    private IdiomasService idiomasService;

    @GetMapping
    public List<Idiomas> getAllIdiomas() {
        return idiomasService.getAllIdiomas();
    }

    @GetMapping("/{id}")
    public Idiomas getIdiomasById(@PathVariable Long id) {
        return idiomasService.getIdiomasById(id).orElse(null);
    }

    @PostMapping
    public Idiomas criarIdiomas(@RequestBody Idiomas idiomas) {
        return idiomasService.criarIdiomas(idiomas);
    }

    @PutMapping("/{id}")
    public Idiomas atualizarIdioma(@PathVariable Long id, @RequestBody Idiomas idiomasDetails) throws Exception {
        return idiomasService.atualizarIdiomas(id,idiomasDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarIdiomas(@PathVariable Long id) {
       idiomasService.deletarIdiomas(id);
    }
}
