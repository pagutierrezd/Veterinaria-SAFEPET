package co.safepet.veterinaria.mapper;

import co.safepet.veterinaria.dto.RegistroAtencionDTO;
import co.safepet.veterinaria.modelo.entidades.Atencion;
import co.safepet.veterinaria.modelo.entidades.Cita;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T19:23:06-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class RegistroAtencionMapperImpl implements RegistroAtencionMapper {

    @Override
    public RegistroAtencionDTO toRegistroAtencionDto(Atencion atencion) {
        if ( atencion == null ) {
            return null;
        }

        String diagnostico = null;
        String tratamiento = null;
        String notasMedicas = null;
        Integer codigo = null;
        Integer codigoCita = null;

        diagnostico = atencion.getDiagnostico();
        tratamiento = atencion.getTratamiento();
        notasMedicas = atencion.getNotasMedicas();
        codigo = atencion.getCodigo();
        codigoCita = atencionCitaCodigo( atencion );

        RegistroAtencionDTO registroAtencionDTO = new RegistroAtencionDTO( codigo, diagnostico, tratamiento, notasMedicas, codigoCita );

        return registroAtencionDTO;
    }

    @Override
    public Atencion toAtencion(RegistroAtencionDTO registroAtencionDTO) {
        if ( registroAtencionDTO == null ) {
            return null;
        }

        Atencion atencion = new Atencion();

        atencion.setCita( registroAtencionDTOToCita( registroAtencionDTO ) );
        atencion.setDiagnostico( registroAtencionDTO.diagnostico() );
        atencion.setTratamiento( registroAtencionDTO.tratamiento() );
        atencion.setNotasMedicas( registroAtencionDTO.notasMedicas() );
        atencion.setCodigo( registroAtencionDTO.codigo() );

        return atencion;
    }

    @Override
    public List<RegistroAtencionDTO> toRegistroAtencionDtos(List<Atencion> atencions) {
        if ( atencions == null ) {
            return null;
        }

        List<RegistroAtencionDTO> list = new ArrayList<RegistroAtencionDTO>( atencions.size() );
        for ( Atencion atencion : atencions ) {
            list.add( toRegistroAtencionDto( atencion ) );
        }

        return list;
    }

    private Integer atencionCitaCodigo(Atencion atencion) {
        if ( atencion == null ) {
            return null;
        }
        Cita cita = atencion.getCita();
        if ( cita == null ) {
            return null;
        }
        Integer codigo = cita.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    protected Cita registroAtencionDTOToCita(RegistroAtencionDTO registroAtencionDTO) {
        if ( registroAtencionDTO == null ) {
            return null;
        }

        Cita cita = new Cita();

        cita.setCodigo( registroAtencionDTO.codigoCita() );

        return cita;
    }
}
