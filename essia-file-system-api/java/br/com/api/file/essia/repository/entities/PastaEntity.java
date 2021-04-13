package br.com.api.file.essia.repository.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
@Entity
@Table(name = "pasta")
public class PastaEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
		
	private String nomePasta;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPastaPai")
	private PastaEntity pai;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pai")
	@Cascade(CascadeType.DELETE)
	private Set<PastaEntity> filhos;
		
}
