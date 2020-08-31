package br.com.srsolution.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.srsolution.domain.model.Fruta;
import br.com.srsolution.domain.repository.FrutaRepository;

@Service
public class FrutaServiceImpl implements FrutaService {

	@Autowired
	private FrutaRepository frutaRepository;

	@Override
	public void salvar(Fruta fruta) {
		this.frutaRepository.save(fruta);
	}

	@Override
	public Fruta findByCodigo(Long codigo) {
		return this.frutaRepository.findById(codigo).get();

	}

	@Override
	public List<Fruta> findAll() {
		return this.frutaRepository.findAll();
	}

}
