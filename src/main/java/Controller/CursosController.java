package Controller;



import Model.Cursos;
import Model.User;
import Service.CursosService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> getAllCursos() {
        return cursosService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Optional<Cursos> getCursoById(@PathVariable Long id) {
        return cursosService.getCursosById(id);
    }

    @PostMapping
    public Cursos criarCurso(@RequestBody Cursos cursos) {
        return cursosService.criarCurso(cursos);
    }

    @PutMapping("/{id}")
    public Cursos atualizarCurso(@PathVariable Long id, @RequestBody Cursos cursoDetails) throws Exception {
        return cursosService.atualizarCurso(id, cursoDetails);
    }


    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Long id) {
        cursosService.deletarCurso(id);
    }
}