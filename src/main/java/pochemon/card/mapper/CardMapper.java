package pochemon.card.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pochemon.card.entity.Card;
import pochemon.dto.CardDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

	public CardDTO toCardDTO(Card card);
	
	public Card toCard(CardDTO cardDTO);
	
	public List<CardDTO> toCardDTO(List<Card> card);
	
	public List<Card> toCard(List<CardDTO> cardDTO);
	
}
