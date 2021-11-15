package api.iwrssistemaintegrado.controller;

import api.iwrssistemaintegrado.dto.MedicamentoDTO;
import api.iwrssistemaintegrado.model.Medicamento;
import api.iwrssistemaintegrado.repository.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentosRepository medicamentosRepository;

    @GetMapping
    @Cacheable(value = "listaDeMedicamentos")
    public Page<MedicamentoDTO> listarTodosMedicamentos(@PageableDefault(sort = "id", page = 0, size = 10) Pageable paginacao) {
        Page<Medicamento> medicamentos = medicamentosRepository.findAll(paginacao);
        return MedicamentoDTO.converter(medicamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> listarMedicamentoEspecifico(@PathVariable Long id) {
        Optional<Medicamento> Medicamento = medicamentosRepository.findById(id);
        if (Medicamento.isPresent()) {
            return ResponseEntity.ok(new MedicamentoDTO(Medicamento.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
