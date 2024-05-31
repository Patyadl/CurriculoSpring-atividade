package Controller;


import Model.Idiomas;
import Service.IdiomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/idiomas")
public class IdiomasController {

    @Autowired
    private IdiomasService idiomasService;

    @GetMapping
    public List<Idiomas> getAllIdiomas() {
        return idiomasService.getAllIdiomas();
    }

    @GetMapping("/{id}")
    public Optional<Idiomas> getIdiomasById(@PathVariable Long id) {
        return idiomasService.getIdiomasById(id);
    }

    @PostMapping
    public Idiomas criarIdiomas(@RequestBody Idiomas idiomas) {
        return idiomasService.criarIdiomas(idiomas);
    }

    @PutMapping("/{id}")
    public Idiomas atualizarIdiomas(@PathVariable Long id, @RequestBody Idiomas idiomasDetails) throws Exception {
        return idiomasService.atualizarIdiomas(id, idiomasDetails);
    }


    @DeleteMapping("/{id}")
    public void deletarIdiomas(@PathVariable Long id) {
        idiomasService.deletarIdiomas(id);
    }
}