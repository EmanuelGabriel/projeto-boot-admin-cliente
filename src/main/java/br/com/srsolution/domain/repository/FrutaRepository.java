package br.com.srsolution.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.srsolution.domain.model.Fruta;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta, Long> {

}
