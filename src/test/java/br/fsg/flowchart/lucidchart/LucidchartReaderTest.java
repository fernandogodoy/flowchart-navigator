package br.fsg.flowchart.lucidchart;


import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import br.fsg.flowchart.spec.Diagram;
import br.fsg.flowchart.spec.FlowchartReader;

public class LucidchartReaderTest {
	
	private static final String FILE = "lucidchart/mapeamento.csv";
	private Path path;

	@Before
	public void init() throws URISyntaxException {
		 path = Paths.get(ClassLoader.getSystemResource(FILE).toURI());
	}

	@Test
	public void testBuildDiagram() {
		FlowchartReader reader = new LucidchartReader(path);
		Diagram diagram = reader.build();
		assertEquals(42, diagram.getElements().size());
	}

}
