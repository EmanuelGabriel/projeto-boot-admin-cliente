package br.com.srsolution.domain.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.srsolution.domain.model.Fruta;
import br.com.srsolution.domain.service.FrutaService;

public class FrutaMapRepository implements FrutaService {

	private Map<Long, Fruta> mapFruta;

	public FrutaMapRepository() {
		this.mapFruta = new HashMap<>();
	}

	@Override
	public void salvar(Fruta fruta) {
		this.mapFruta.put(fruta.getCodigo(), fruta);
	}

	@Override
	public Fruta findByCodigo(Long codigo) {
		return this.mapFruta.get(codigo);
	}

	@Override
	public List<Fruta> findAll() {
		return new ArrayList<Fruta>(this.mapFruta.values());
	}
}
