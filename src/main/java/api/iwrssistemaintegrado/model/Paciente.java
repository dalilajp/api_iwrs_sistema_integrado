package api.iwrssistemaintegrado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome_paciente;
    String data_nascimento;
    String status_paciente;

    public Paciente(){}

    public Paciente(String nome_paciente, String data_nascimento, String status_paciente){
        this.nome_paciente = nome_paciente;
        this.data_nascimento = data_nascimento;
        this.status_paciente = status_paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}