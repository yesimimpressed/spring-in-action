package sia.tacos.repository;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.data.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long>{}
