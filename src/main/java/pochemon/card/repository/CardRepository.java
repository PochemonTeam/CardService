package pochemon.card.repository;

import org.springframework.data.repository.CrudRepository;
import pochemon.card.entity.Card;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findAll();

    List<Card> findAllByUserId(Integer id);
}
