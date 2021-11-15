package api.iwrssistemaintegrado.dto;

import api.iwrssistemaintegrado.model.Medicamento;
import org.springframework.data.domain.Page;

public class MedicamentoDTO {

    Long id;
    String numero_medicamento_dun;
    String nome_medicamento;

    public MedicamentoDTO(Long id, String numero_medicamento_dun, String nome_medicamento) {
        this.id = id;
        this.numero_medicamento_dun = numero_medicamento_dun;
        this.nome_medicamento = nome_medicamento;
    }

    public Long getId() {
        return id;
    }

    public String getNumero_medicamento_dun() {
        return numero_medicamento_dun;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public static Page<MedicamentoDTO> converter(Page<Medicamento> medicamentos) {
        return medicamentos.map(MedicamentoDTO::new);
    }
}
