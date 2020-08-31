package br.com.srsolution.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.srsolution.domain.model.Fruta;
import br.com.srsolution.domain.service.FrutaService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/v1/frutas", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FrutaResource {

	private final FrutaService frutaService;

	public FrutaResource(FrutaService frutaService) {
		this.frutaService = frutaService;
	}

	@GetMapping
	public ResponseEntity<List<Fruta>> findAll() {
		List<Fruta> lista = this.frutaService.findAll();
		log.info("Exibe a lista de frutas {}", lista);
		return lista != null ? ResponseEntity.ok().body(lista) : ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/{frutaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fruta> findByCodigo(@PathVariable Long frutaId) {
		Fruta fruta = this.frutaService.findByCodigo(frutaId);
		return fruta != null ? ResponseEntity.ok().body(fruta) : ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Fruta> criar(@RequestBody Fruta fruta) {
		this.frutaService.salvar(fruta);
		URI location = getUri(fruta.getCodigo());
		log.info("Fruta criada com sucesso {}", fruta);
		return ResponseEntity.created(location).build();
	}

	private URI getUri(Long codigo) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(codigo).toUri();
	}

}
