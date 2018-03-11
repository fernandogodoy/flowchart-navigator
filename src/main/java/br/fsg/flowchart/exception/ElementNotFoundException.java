package br.fsg.flowchart.exception;

/**
 * 
 * @author Godoy
 *
 */
public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ElementNotFoundException() {
		super("Element not found");
	}

}
