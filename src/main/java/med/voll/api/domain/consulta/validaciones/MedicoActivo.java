package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MedicoActivo implements ValidadorDeConsultas{
    @Autowired
    private MedicoRepository medicoRepository;
    public void validar(DatosAgendarConsulta datos){
        if (datos.idMedico() == null) {
            return;
        }

        var medicoActivo = medicoRepository.findByActivoById(datos.idMedico());

        if (!medicoActivo) {
            throw new ValidacionDeIntegridad("No se pueden permitir agendar citas con medicos inactivos en el sistema");
        }
    }
}
