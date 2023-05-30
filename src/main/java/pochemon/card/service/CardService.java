package pochemon.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pochemon.card.entity.Card;
import pochemon.card.repository.CardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;

	// TODO : Changer pour remplacer par le service de la lib
	@Autowired
	StoreOrderRepository storeOrderRepository;

	public Boolean addCard(Card card) {
		if (card != null) {
			cardRepository.save(card);
			return true;
		}
		return false;
	}
	
	
	public Boolean deleteCard(Card card) {
		if (card != null) {
			cardRepository.delete(card);
			return true;
		}
		return false;
	}
	
	public Card getCard(Integer cardId) {
		return cardRepository.findById(cardId).orElse(null);
	}
	
	public List<Card> getAllCards() {
		return cardRepository.findAll();
	}
	
	public List<Card> getAllCardsForSale() {
		List<StoreOrder> listStoreOrder = storeOrderRepository.findAll();
		return listStoreOrder.stream().map(StoreOrder::getCard).collect(Collectors.toList());
	}

    public List<Card> getAllCardsByUser(Integer id) {
		return cardRepository.findAllByUserId(id);
    }
    
}
