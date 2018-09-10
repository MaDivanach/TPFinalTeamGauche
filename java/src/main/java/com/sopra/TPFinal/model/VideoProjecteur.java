package com.sopra.TPFinal.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="videoProjecteur")
//@SequenceGenerator(name = "seqVideoProjecteur", sequenceName = "seq_videoProjecteur", initialValue = 1, allocationSize = 1)

public class VideoProjecteur extends Materiel {
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVideoProjecteur")
	
	@Version
	private int version;
	
	public VideoProjecteur(Long id, Double coutUtilisation) {
		super(id, coutUtilisation);
		// TODO Auto-generated constructor stub
	}

}
