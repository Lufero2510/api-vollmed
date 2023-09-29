package med.voll.api.domain.consulta.validaciones;

import lombok.AllArgsConstructor;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorCancelamientoDeConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;
    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getData()).toHours();

        if (diferenciaEnHoras < 24) {
            throw new ValidacionDeIntegridad("Consulta solamente puede ser cancelada cn antecedencia minima de 24h!");
        }
    }
}
