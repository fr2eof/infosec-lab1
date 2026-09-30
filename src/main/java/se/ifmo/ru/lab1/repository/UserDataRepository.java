package se.ifmo.ru.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ifmo.ru.lab1.model.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
