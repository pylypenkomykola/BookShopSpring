package pl.edu.pwsztar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwsztar.domain.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, CrudRepository<Client, Long> {
    @Query("SELECT client FROM Client client WHERE client.email=?1 OR client.username=?1")
    Client findClientByEmailOrUsername(String email);

    @Query("SELECT client FROM Client client WHERE client.userId = ?1")
    Client findClient(Long userId);

    @Modifying
    @Query("UPDATE Client client SET client.email = ?2 WHERE client.userId = ?1")
    void changeClientEmail(Long userId, String email);

    @Modifying
    @Query("UPDATE Client client SET client.username = ?2 WHERE client.userId = ?1")
    void changeClientUsername(Long userId, String username);

    @Modifying
    @Query("UPDATE Client client SET client.password = ?2 WHERE client.userId = ?1")
    void changeClientPassword(Long userId, String password);

    @Modifying
    @Query("UPDATE Client client SET client.firstName = ?2 WHERE client.userId = ?1")
    void changeClientFirstName(Long userId, String firstName);

    @Modifying
    @Query("UPDATE Client client SET client.lastName = ?2 WHERE client.userId = ?1")
    void changeClientLastName(Long userId, String lastName);

    @Modifying
    @Query("UPDATE Client client SET client.address = ?2 WHERE client.userId = ?1")
    void changeClientAddress(Long userId, String address);

    @Modifying
    @Query("UPDATE Client client SET client.phoneNumber = ?2 WHERE client.userId = ?1")
    void changeClientPhone(Long userId, String phoneNumber);
}
