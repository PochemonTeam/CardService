package pochemon.card.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pochemon.card.entity.Card;
import pochemon.dto.CardDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

	@Mapping(target = "userId", source = "user.id")
	public CardDTO toCardDTO(Card card);
	
	public Card toCard(CardDTO cardDTO);
	
	@Mapping(target = "userId", source = "user.id")
	public List<CardDTO> toCardDTO(List<Card> card);
	
	public List<Card> toCard(List<CardDTO> cardDTO);
	
}
