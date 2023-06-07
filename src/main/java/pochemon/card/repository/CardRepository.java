package pochemon.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pochemon.card.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAll();

    List<Card> findAllByUserId(Integer id);
}
