package sia.tacos.repository;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.data.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {}
