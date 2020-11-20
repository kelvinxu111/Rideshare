package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Users;

import java.util.UUID;

@Repository("usersRepository")
public interface usersRepository extends JpaRepository {
    Users findById(UUID id);
    Users findByUsername(String username);
    Users findByEmail(String email);
    Users findTopByOrderByIdDesc();
    //Users findByConfirmationToken(String confirmationToken);
}
