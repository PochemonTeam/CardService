package pochemon.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pochemon.card.entity.Card;
import pochemon.card.repository.CardRepository;
import pochemon.dto.StoreOrderDTO;
import pochemon.service.StoreWebService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {
	
	final CardRepository cardRepository;

	StoreWebService storeWebService;

	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
		this.storeWebService = new StoreWebService();
	}

	public Boolean addCard(Card card) {
		if (card != null) {
			cardRepository.save(card);
			return true;
		}
		return false;
	}
	
	
	public Boolean deleteCard(Integer id) {
		if (id != null) {
			cardRepository.deleteById(id);
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
		List<StoreOrderDTO> listStoreOrder = storeWebService.getAllOrders();
		return listStoreOrder.stream()
				.map(StoreOrderDTO::getCardId)
				.map(cardRepository::findById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

    public List<Card> getAllCardsByUser(Integer id) {
		return cardRepository.findAllByUserId(id);
    }
    
}
