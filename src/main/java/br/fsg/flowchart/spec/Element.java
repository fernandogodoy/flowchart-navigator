package br.fsg.flowchart.spec;

/**
 * Representation for element existing in Diagram
 * 
 * @author Godoy
 *
 */
public interface Element {

	Integer getId();

	Type getType();

	Integer getSource();

	Integer getTarget();

	String getText();
	
	boolean isLine();

	boolean isFinal();

}
