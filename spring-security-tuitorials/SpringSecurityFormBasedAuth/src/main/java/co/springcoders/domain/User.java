package co.springcoders.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String username;
	private String password;
	private String[] roles;
}
