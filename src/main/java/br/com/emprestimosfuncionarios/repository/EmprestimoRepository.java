package br.com.emprestimosfuncionarios.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emprestimosfuncionarios.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	@Query("select e.id from Emprestimo e")
	List<Long> findAllIds();
	
	@Query("select e from Emprestimo e inner join e.funcionario f where f.id = :id and e.valorPago = 0")
	List<Emprestimo> findAllByIdFuncionario(@Param("id") Long id);
	
	@Query("select e from Emprestimo e where e.vencimento between :inicio and :fim")
	List<Emprestimo> findAllByInicioFim(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}
