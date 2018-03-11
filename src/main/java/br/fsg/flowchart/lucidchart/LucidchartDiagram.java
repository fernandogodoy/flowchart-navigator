package br.fsg.flowchart.lucidchart;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import br.fsg.flowchart.lucidchart.LucidchartElement.Builder;
import br.fsg.flowchart.spec.Diagram;
import br.fsg.flowchart.spec.Element;

public class LucidchartDiagram implements Diagram {

	private static final int MAX_INDEX = LucidchartColumns.TEXT_AREA_1.ordinal();
	private List<Element> elements = new LinkedList<>();

	public LucidchartDiagram(List<List<String>> allLines) {
		create(allLines);
	}

	private void create(List<List<String>> allLines) {
		allLines.stream()
		.map(this::createElement)
		.collect(Collectors.toCollection(() -> elements));
	}
	
	private Element createElement(List<String> lines) {
		List<String> clonedLine = normalizeSize(lines);
		return new Builder()
				.withId(clonedLine.get(LucidchartColumns.ID.ordinal()))
				.withType(clonedLine.get(LucidchartColumns.NAME.ordinal()))
				.withLineSource(clonedLine.get(LucidchartColumns.LINE_SOURCE.ordinal()))
				.withLineDestination(clonedLine.get(LucidchartColumns.LINE_DESTINATION.ordinal()))
				.withText(clonedLine.get(LucidchartColumns.TEXT_AREA_1.ordinal()))
				.build();
	}
	
	private List<String> normalizeSize(List<String> line) {
		List<String> clone = new LinkedList<>(line);
		IntStream.range(line.size() - 1, MAX_INDEX).forEach(i -> {
			clone.add(StringUtils.EMPTY);
		});
		return clone;
	}

	@Override
	public List<Element> getElements() {
		return new LinkedList<>(elements);
	}

}
