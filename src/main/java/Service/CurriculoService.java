package Service;


import Model.Curriculo;
import Repository.CurriculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> getAllCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculoById(Long id) {
        return curriculoRepository.findById(id);
    }

    @Transactional
    public Curriculo criarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    @Transactional
    public Curriculo atualizarCurriculo(Long id, Curriculo curriculoDetails) throws Exception {
        Optional<Curriculo> Curriculo = curriculoRepository.findById(id);

        if (Curriculo.isPresent()) {
            Curriculo curriculo = Curriculo.get();

            curriculo.setNome(curriculoDetails.getNome());
            curriculo.setEmail(curriculoDetails.getEmail());
            curriculo.setIdade(curriculoDetails.getIdade());
            curriculo.setCursos(curriculoDetails.getCursos());
            return curriculoRepository.save(curriculo);
        }
        else {
            throw new Exception("Curriculo não encontrado com o id: " + id);
        }
    }
    @Transactional
    public void deletarCurriculo(@PathVariable Long id) {
        Optional<Curriculo> Curriculo = curriculoRepository.findById(id);

        if (Curriculo.isPresent()) {
            Curriculo curriculo = Curriculo.get();
            curriculoRepository.delete(curriculo);
        }
}
}
