package br.fsg.flowchart.lucidchart;

public enum LucidchartColumns {

    // @formatter:off
	ID("Id"),
	NAME("Name"),
	SHAPE_LIBRARY("Shape Library"),
	PAGE_ID("Page ID"),
	CONTAINED_BY("Contained By"),
	LINE_SOURCE("Line Source"),
	LINE_DESTINATION("Line Destination"),
	SOURCE_ARROW("Source Arrow"), 
	DESTINATION_ARROW("Destination Arrow"),
	TEXT_AREA_1("Text Area 1");
    // @formatter:on
	
	private String decription;

	private LucidchartColumns(String decription) {
		this.decription = decription;
	}
	
	@Override
	public String toString() {
		return decription;
	}
}
