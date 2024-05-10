package eus.birt.dam.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="diskak")
public class Diska {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String izena;
	
	@Column
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@Column
	private String artista;
	
	@Column
	private String disketxea;	
	
	@JsonManagedReference
	@OneToMany (mappedBy = "diska",cascade = CascadeType.ALL)
	List <Abestia> abestiak = new ArrayList<>();
	
}
