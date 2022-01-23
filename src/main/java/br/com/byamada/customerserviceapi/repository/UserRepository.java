package br.com.byamada.customerserviceapi.repository;

import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
