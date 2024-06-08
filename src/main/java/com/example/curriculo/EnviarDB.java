package com.example.curriculo;

import com.example.curriculo.Model.Cursos;
import com.example.curriculo.Model.Idiomas;
import com.example.curriculo.Model.User;
import com.example.curriculo.Repository.CursosRepository;
import com.example.curriculo.Repository.IdiomasRepository;
import com.example.curriculo.Repository.UserRepository;
import com.example.curriculo.Service.CursosService;
import com.example.curriculo.Service.IdiomasService;
import com.example.curriculo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnviarDB implements CommandLineRunner{

@Autowired
    UserService userService;

@Autowired
    UserRepository userRepository;
@Autowired
    IdiomasService idiomasService;
@Autowired
    IdiomasRepository idiomasRepository;
@Autowired
    CursosService cursosService;
@Autowired
    CursosRepository cursosRepository;

    @Override
    public void run(String... args)  throws Exception {



       User user =new User();
       user.setNome("Patrícia");
      user.setIdade(21);
      user.setEmail("paty@gmail.com");
      user.setTelefone("81 99999-9999");
               userService.criarUser(user);
               userRepository.save(user);

        Cursos cursos = new Cursos();
        cursos.setNome("sistemas para internet");
        cursos.setInstituicao("UNICAP");
        cursos.setInicio("agosto de 2022");
        cursos.setFim("dezembro de 2024");
        cursos.setDescricao("Curso com foco em programação para web");
        cursosService.criarCurso(cursos);
        cursos.setUser(user);
        cursosRepository.save(cursos);

        Idiomas idiomas = new Idiomas();
        idiomas.setNome("Inglês");
        idiomas.setNivel("Intermediário");
        idiomasService.criarIdiomas(idiomas);
        idiomas.setUser(user);
        idiomasRepository.save(idiomas);
    }
}

