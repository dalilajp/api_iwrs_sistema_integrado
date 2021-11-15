package api.iwrssistemaintegrado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String numero_medicamento_dun;
    String nome_medicamento;

    public Medicamento(){}

    public Medicamento(String numero_medicamento_dun, String nome_medicamento){
        this.numero_medicamento_dun = numero_medicamento_dun;
        this.nome_medicamento = nome_medicamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_medicamento_dun() {
        return numero_medicamento_dun;
    }

    public void setNumero_medicamento_dun(String numero_medicamento_dun) {
        this.numero_medicamento_dun = numero_medicamento_dun;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }
}
