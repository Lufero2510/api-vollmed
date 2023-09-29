package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas{
    @Autowired
    public ConsultaRepository consultaRepository;
    public void validar(DatosAgendarConsulta datos){
        if (datos.idMedico() == null){
            return;
        }

        var medicoConConsulta = consultaRepository.existsByMedicoIdAndData(datos.idMedico(), datos.fecha());

        if (medicoConConsulta){
            throw new ValidacionDeIntegridad("Este medico ya tiene una consulta en ese horario");
        }

    }
}
