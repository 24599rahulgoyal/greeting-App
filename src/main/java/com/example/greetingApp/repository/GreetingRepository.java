package com.example.greetingApp.repository;
import com.example.greetingApp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    // UC5 - Find Greeting Message by ID
    @Query("SELECT g.message FROM Greeting g WHERE g.id = :id")
    String findMessageById(Long id);
}
