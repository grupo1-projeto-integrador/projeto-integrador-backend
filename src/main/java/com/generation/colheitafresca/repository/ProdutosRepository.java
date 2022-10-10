package com.generation.colheitafresca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.colheitafresca.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long>{
	
	public List <Produtos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
