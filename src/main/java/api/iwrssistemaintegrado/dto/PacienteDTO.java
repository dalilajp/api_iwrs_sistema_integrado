package api.iwrssistemaintegrado.dto;

import api.iwrssistemaintegrado.model.Paciente;
import org.springframework.data.domain.Page;

public class PacienteDTO {

    Long id;
    String nome_paciente;
    String data_nascimento;
    String status_paciente;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome_paciente = paciente.getNome_paciente();
        this.data_nascimento = paciente.getData_nascimento();
        this.status_paciente = paciente.getStatus_paciente();
    }

    public Long getid() {
        return id;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getStatus_paciente() {
        return status_paciente;
    }

    public static Page<PacienteDTO> converter(Page<Paciente> pacientes) {
        return pacientes.map(PacienteDTO::new);
    }
}
