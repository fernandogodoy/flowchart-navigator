package br.fsg.flowchart.lucidchart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import br.fsg.flowchart.exception.FileErrorException;
import br.fsg.flowchart.spec.Diagram;
import br.fsg.flowchart.spec.FlowchartReader;

public class LucidchartReader implements FlowchartReader {

	private static final int HEADER_INDEX = 0;
	private List<List<String>> allLines;

	public LucidchartReader(Path path) {
		try {
			allLines = readAllLines(path);
			allLines.remove(HEADER_INDEX);
		} catch (IOException ex) {
			throw new FileErrorException(ex);
		}
	}

	@Override
	public Diagram build() {
		return new LucidchartDiagram(allLines);
	}

	private List<List<String>> readAllLines(Path path) throws IOException {
		return Files.readAllLines(path).stream()
				.map(line -> line.split(","))
				.map(Arrays::asList)
				.collect(Collectors.toCollection(LinkedList::new));
	}

}
