package sia.tacos.data;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {}
