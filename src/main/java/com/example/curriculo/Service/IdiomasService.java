package com.example.curriculo.Service;

import com.example.curriculo.Model.Idiomas;
import com.example.curriculo.Repository.IdiomasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class IdiomasService {

    @Autowired
    private IdiomasRepository idiomasRepository;

    public List<Idiomas> getAllIdiomas() {
        return idiomasRepository.findAll();
    }

    public Optional<Idiomas> getIdiomasById(Long id) {
        return idiomasRepository.findById(id);
    }

    @Transactional
    public Idiomas criarIdiomas(Idiomas idiomas) {
        return idiomasRepository.save(idiomas);
    }

    @Transactional
    public Idiomas atualizarIdiomas(Long id, Idiomas idiomasDetails) throws Exception {
        Optional<Idiomas> Idiomas = idiomasRepository.findById(id);

        if (Idiomas.isPresent()) {
            Idiomas idiomas = Idiomas.get();

            idiomas.setNome(idiomasDetails.getNome());
            idiomas.setNivel(idiomasDetails.getNivel());
            return idiomasRepository.save(idiomas);
        }
        else {
            throw new Exception("Idiomas não encontrado com o id: " + id);
        }
    }
    @Transactional
    public void deletarIdiomas(@PathVariable Long id) {
        Optional<Idiomas> optionalIdioma = idiomasRepository.findById(id);

        if (optionalIdioma.isPresent()) {
            Idiomas idiomas= optionalIdioma.get();
           idiomasRepository.delete(idiomas);
        }
    }

}