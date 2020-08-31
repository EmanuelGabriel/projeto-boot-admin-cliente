package br.com.srsolution.domain.service;

import java.util.List;

import br.com.srsolution.domain.model.Fruta;

public interface FrutaService {

	void salvar(Fruta fruta);

	Fruta findByCodigo(Long codigo);

	List<Fruta> findAll();
}
