package api.iwrssistemaintegrado.form;

import api.iwrssistemaintegrado.model.Paciente;
import api.iwrssistemaintegrado.repository.PacientesRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarPacienteForm {

    @NotNull
    @NotEmpty
    @Length(min = 10)
    String nome_paciente;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    String data_nascimento;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    String status_paciente;

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getStatus_paciente() {
        return status_paciente;
    }

    public void setStatus_paciente(String status_paciente) {
        this.status_paciente = status_paciente;
    }

    public Paciente atualizarPaciente(Long id, PacientesRepository pacientesRepository) {
        Paciente paciente = pacientesRepository.getOne(id);

        paciente.setNome_paciente(this.nome_paciente);
        paciente.setData_nascimento(this.data_nascimento);
        paciente.setStatus_paciente(this.status_paciente);

        return paciente;
    }

}