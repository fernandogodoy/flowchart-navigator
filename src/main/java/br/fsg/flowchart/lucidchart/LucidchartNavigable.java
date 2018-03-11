package br.fsg.flowchart.lucidchart;

import br.fsg.flowchart.exception.ElementNotFoundException;
import br.fsg.flowchart.spec.Diagram;
import br.fsg.flowchart.spec.Element;
import br.fsg.flowchart.spec.FlowchartNavigable;

public class LucidchartNavigable implements FlowchartNavigable {

	private static final int START_ELEMENT = 1;
	
	private Element current;
	private Diagram diagram;

	public LucidchartNavigable(Diagram diagram) {
		this.diagram = diagram;
	}

	@Override
	public void start() {
		current = diagram.getElements().get(START_ELEMENT);
	}

	@Override
	public Element getCurrent() {
		return current;
	}

	@Override
	public void next() {
		Element element = findRelationship();
		goTo(element);
	}
	
	@Override
	public void selectOption(YesNo option) {
		Element element = findRelationship(option);
		goTo(element);
		
	}
	
	private void goTo(Element element) {
		current = diagram.getElements().parallelStream()
				.filter(elem -> elem.getId().equals(element.getTarget()))
				.findFirst()
				.orElseThrow(ElementNotFoundException::new);
	}

	private Element findRelationship() {
		return diagram.getElements().stream()
				.filter(Element::isLine)
				.filter(elem -> elem.getSource().equals(current.getId()))
				.findFirst()
				.orElseThrow(ElementNotFoundException::new);
	}


	private Element findRelationship(YesNo yesNo) {
		return diagram.getElements().stream()
				.filter(Element::isLine)
				.filter(elem -> elem.getSource().equals(current.getId()))
				.filter(elem -> elem.getText().equalsIgnoreCase(yesNo.toString()))
				.findFirst()
				.orElseThrow(ElementNotFoundException::new);
	}
}
