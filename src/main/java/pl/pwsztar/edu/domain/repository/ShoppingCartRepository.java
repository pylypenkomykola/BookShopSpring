package pl.pwsztar.edu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pwsztar.edu.domain.entity.ShoppingCart;
import pl.pwsztar.edu.domain.entity.key.ShoppingCartKey;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKey>, CrudRepository<ShoppingCart, ShoppingCartKey> {
}
