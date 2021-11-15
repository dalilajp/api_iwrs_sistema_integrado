package api.iwrssistemaintegrado.model;

public class Visita {

    Long id;
    String data_visita;
    String nome_paciente;
    String ano_nascimento;
    String numero_medicamento_dun;

    public Visita(String data_visita, String nome_paciente, String ano_nascimento, String numero_medicamento_dun){
        this.data_visita = data_visita;
        this.nome_paciente = nome_paciente;
        this.ano_nascimento = ano_nascimento;
        this.numero_medicamento_dun = numero_medicamento_dun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_visita() {
        return data_visita;
    }

    public void setData_visita(String data_visita) {
        this.data_visita = data_visita;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(String ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public String getNumero_medicamento_dun() {
        return numero_medicamento_dun;
    }

    public void setNumero_medicamento_dun(String numero_medicamento_dun) {
        this.numero_medicamento_dun = numero_medicamento_dun;
    }
}
