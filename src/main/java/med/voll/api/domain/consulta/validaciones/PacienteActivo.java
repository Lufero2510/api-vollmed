package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{
    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DatosAgendarConsulta datos){
        if (datos.idPaciente() == null) {
            return;
        }

        var pacienteActivo = pacienteRepository.findByActivoById(datos.idPaciente());

        if (!pacienteActivo) {
            throw new ValidacionDeIntegridad("No se pueden permitir agendar citas con pacientes inactivos en el sistema");
        }
    }
}
