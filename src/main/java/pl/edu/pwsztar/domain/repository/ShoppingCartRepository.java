package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.entity.ShoppingCart;
import pl.edu.pwsztar.domain.entity.key.ShoppingCartKey;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartKey>, CrudRepository<ShoppingCart, ShoppingCartKey> {
}
