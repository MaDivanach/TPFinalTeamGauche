/**
 * 
 */
package com.sopra.TPFinal.model;

/**
 * @author ajc
 *
 */
public class Stagiaire extends User{
	
	public Stagiaire() {
		super();
		super.setRole(Role.STAGIAIRE);
	}
}
