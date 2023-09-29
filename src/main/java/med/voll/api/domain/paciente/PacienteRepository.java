package med.voll.api.domain.paciente;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByActivoTrue(Pageable paginacion);

    @Query("""
            select p.activo
            from Paciente p
            where p.id = :idPaciente
            """)
    Boolean findByActivoById(Long idPaciente);
}
