package pochemon.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pochemon.card.entity.Card;
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

		Card card = cardService.getCard(cardDto.getId());

		card.setName(cardDto.getName());
		card.setDescription(cardDto.getDescription());
		card.setFamily(cardDto.getFamily());
		card.setAffinity(cardDto.getAffinity());
		card.setImgUrl(cardDto.getImgUrl());
		card.setSmallImgUrl(cardDto.getSmallImgUrl());
		card.setEnergy(cardDto.getEnergy());
		card.setHp(cardDto.getHp());
		card.setDefence(cardDto.getDefence());
		card.setAttack(cardDto.getAttack());

		return cardService.addCard(card);
	}

	@DeleteMapping("/{id}")
	public Boolean removeCard(@PathVariable Integer id) {
		return cardService.deleteCard(id);
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
