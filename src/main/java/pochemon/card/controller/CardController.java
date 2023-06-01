package pochemon.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pochemon.card.mapper.CardMapper;
import pochemon.card.service.CardService;
import pochemon.dto.CardDTO;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CardMapper cardMapper;
	
	@GetMapping("/{id}")
	public CardDTO getCard(@PathVariable Integer id) {
		return cardMapper.toCardDTO(cardService.getCard(id));
	}
	
	@PutMapping
	public Boolean editCard(@RequestBody CardDTO cardDto) {
		return cardService.addCard(cardMapper.toCard(cardDto));
	}
	
	@DeleteMapping
	public Boolean removeCard(@RequestBody CardDTO cardDto) {
		return cardService.deleteCard(cardMapper.toCard(cardDto));
	}
	
	@PostMapping
	public Boolean addCard(@RequestBody CardDTO cardDto) {
		return cardService.addCard(cardMapper.toCard(cardDto));
	}
	
	@GetMapping("/shop")
	public List<CardDTO> getAllCardsToSell() {
		return cardMapper.toCardDTO(cardService.getAllCardsForSale());
	}
	
	@GetMapping()
	public List<CardDTO> getAllCards() {
		return cardMapper.toCardDTO(cardService.getAllCards());
	}

	@GetMapping("/user/{id}")
	public List<CardDTO> getAllCardsByUser(@PathVariable Integer id) {
		return cardMapper.toCardDTO(cardService.getAllCardsByUser(id));
	}

}
