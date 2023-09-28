package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DatosDetallesConsulta(Long id, Long idPaciente, Long idMedico, LocalDateTime fecha) {
    public DatosDetallesConsulta(DatosAgendarConsulta datosAgendarConsulta){
        this(datosAgendarConsulta.id(), datosAgendarConsulta.idPaciente(), datosAgendarConsulta.idMedico(), datosAgendarConsulta.fecha());
    }
}
