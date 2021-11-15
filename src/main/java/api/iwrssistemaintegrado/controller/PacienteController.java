package api.iwrssistemaintegrado.controller;

import api.iwrssistemaintegrado.dto.PacienteDTO;
import api.iwrssistemaintegrado.form.AtualizarPacienteForm;
import api.iwrssistemaintegrado.form.PacienteForm;
import api.iwrssistemaintegrado.model.Paciente;
import api.iwrssistemaintegrado.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacientesRepository pacientesRepository;

    @GetMapping
    @Cacheable(value = "listaDePacientes")
    public Page<PacienteDTO> listarTodosPacientes(@PageableDefault(sort = "id", page = 0, size = 10) Pageable paginacao) {
        Page<Paciente> pacientes = pacientesRepository.findAll(paginacao);
        return PacienteDTO.converter(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> listarPacienteEspecifico(@PathVariable Long id) {
        Optional<Paciente> Paciente = pacientesRepository.findById(id);
        if (Paciente.isPresent()) {
            return ResponseEntity.ok(new PacienteDTO(Paciente.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDePacientes", allEntries = true)
    public ResponseEntity<PacienteDTO> cadastrarPaciente(@RequestBody @Valid PacienteForm form, UriComponentsBuilder uriBuilder) {
        Paciente Paciente = form.cadastrarPaciente(pacientesRepository);
        pacientesRepository.save(Paciente);

        URI uri = uriBuilder.path("/Pacientes/{id}").buildAndExpand(Paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteDTO(Paciente));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDePacientes", allEntries = true)
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable Long id, @RequestBody @Valid AtualizarPacienteForm form) {
        Optional<Paciente> optional = pacientesRepository.findById(id);
        if (optional.isPresent()) {
            Paciente Paciente = form.atualizarPaciente(id, pacientesRepository);
            return ResponseEntity.ok(new PacienteDTO(Paciente));
        }
        return ResponseEntity.notFound().build();
    }

}
