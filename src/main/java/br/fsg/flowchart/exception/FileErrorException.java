package br.fsg.flowchart.exception;

/**
 * 
 * @author Godoy
 *
 */
public class FileErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FileErrorException(Exception ex) {
	  super("File error" , ex);
	}

}
