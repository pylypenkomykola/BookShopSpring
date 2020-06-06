package pl.pwsztar.edu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pwsztar.edu.domain.entity.Order;
import pl.pwsztar.edu.domain.entity.key.OrderKey;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderKey>, CrudRepository<Order, OrderKey> {
}
