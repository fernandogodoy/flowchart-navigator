package br.fsg.flowchart.spec;

import br.fsg.flowchart.lucidchart.YesNo;

/**
 * Specification for navigable in flowchart
 * 
 * @author Godoy
 *
 */
public interface FlowchartNavigable {

	void start();

	void next();

	Element getCurrent();

	void selectOption(YesNo option);

}
