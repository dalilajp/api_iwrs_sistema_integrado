package api.iwrssistemaintegrado.repository;

import api.iwrssistemaintegrado.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Paciente, Long> {
}
