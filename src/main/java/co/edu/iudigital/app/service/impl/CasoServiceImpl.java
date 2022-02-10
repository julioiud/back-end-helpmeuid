package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.CasoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Caso;
import co.edu.iudigital.app.repository.ICasoRepository;
import co.edu.iudigital.app.service.iface.ICasoService;

@Service
public class CasoServiceImpl implements ICasoService{

	@Autowired
	private ICasoRepository casoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<CasoDto> findAll() throws RestException {
		List<Caso> casos = casoRepository.findAll();
		// TODO: Refactorizar con mapeo
		List<CasoDto> casosDto = new ArrayList<>();
		casos.stream().forEach(c -> {
			CasoDto casoDto = new CasoDto();
			casoDto.setId(c.getId());
			casoDto.setFechaHora(c.getFechaHora());
			casoDto.setLatitud(c.getLatitud());
			casoDto.setLongitud(c.getLongitud());
			casoDto.setVisible(c.getVisible());
			casoDto.setDescripcion(c.getDescripcion());
			casoDto.setUrlMap(c.getUrlMap());
			casoDto.setRmiUrl(c.getRmiUrl());
			casoDto.setUsuarioId(c.getUsuario().getId());
			casoDto.setImage(c.getUsuario().getImage());
			casoDto.setNombre(c.getUsuario().getNombre());
			casosDto.add(casoDto);
		});
		return casosDto;
	}

	@Transactional
	@Override
	public Caso save(Caso caso) throws RestException {
		return casoRepository.save(caso);
	}

	@Transactional
	@Override
	public Boolean visible(Boolean visible, Long id) throws RestException {
		return casoRepository.setVisible(visible, id);
	}

	@Transactional(readOnly = true)
	@Override
	public Caso findById(Long id) throws RestException {
		return casoRepository.findById(id).get();// TODO: VALIDAR CON ISPRESENT
	}

}
