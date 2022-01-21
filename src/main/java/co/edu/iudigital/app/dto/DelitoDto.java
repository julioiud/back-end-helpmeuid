package co.edu.iudigital.app.dto;

import lombok.Builder;
import lombok.Data;

@Data //getteres y setteres
@Builder //construcción un objeto
public class DelitoDto {
	private Long id;
	private String nombre;
	private String descripcion;
}
