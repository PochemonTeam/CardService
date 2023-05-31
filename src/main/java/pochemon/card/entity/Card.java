package pochemon.card.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;
	
	String description;
	
	String family;
	
	String affinity;
	
	String imgUrl;
	
	String smallImgUrl;
	
	Float energy;
	
	Float hp;
	
	Float defence;
	
	Float attack;

	Integer userId;
	
}
