package databaserelationships.onetomany.repository;

import databaserelationships.onetomany.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
