package br.fsg.flowchart.lucidchart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import br.fsg.flowchart.spec.Diagram;
import br.fsg.flowchart.spec.FlowchartNavigable;
import br.fsg.flowchart.spec.FlowchartReader;

public class LucidchartNavigableTest {

	private static final String FILE = "lucidchart/mapeamento.csv";
	private Diagram diagram;

	@Before
	public void init() throws URISyntaxException {
		Path path = Paths.get(ClassLoader.getSystemResource(FILE).toURI());
		FlowchartReader reader = new LucidchartReader(path);
		this.diagram = reader.build();
	}

	@Test
	public void testStart() {
		FlowchartNavigable navigable = new LucidchartNavigable(diagram);
		navigable.start();
		
		assertSame(2, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.PROCESS, navigable.getCurrent().getType());
		assertEquals("Iniciar teste", navigable.getCurrent().getText());
	}
	
	@Test
	public void testNextToDecision() {
		FlowchartNavigable navigable = new LucidchartNavigable(diagram);
		navigable.start();
		
		assertSame(2, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.PROCESS, navigable.getCurrent().getType());
		assertEquals("Iniciar teste", navigable.getCurrent().getText());
		
		navigable.next();
		assertSame(3, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.DECISION, navigable.getCurrent().getType());
		assertEquals("Gosta de ganhar dinheiro?", navigable.getCurrent().getText());
		
	}
	
	@Test
	public void testSelectDecisionNo() {
		FlowchartNavigable navigable = new LucidchartNavigable(diagram);
		navigable.start();
		
		assertSame(2, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.PROCESS, navigable.getCurrent().getType());
		assertEquals("Iniciar teste", navigable.getCurrent().getText());
		
		navigable.next();
		assertSame(3, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.DECISION, navigable.getCurrent().getType());
		assertEquals("Gosta de ganhar dinheiro?", navigable.getCurrent().getText());
		
		navigable.selectOption(YesNo.toObject("n"));
		assertEquals("Você não é normal", navigable.getCurrent().getText());
	}

	@Test
	public void testSelectDecisionYes() {
		FlowchartNavigable navigable = new LucidchartNavigable(diagram);
		navigable.start();
		
		assertSame(2, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.PROCESS, navigable.getCurrent().getType());
		assertEquals("Iniciar teste", navigable.getCurrent().getText());
		
		navigable.next();
		assertSame(3, navigable.getCurrent().getId());
		assertEquals(LucidchartElementType.DECISION, navigable.getCurrent().getType());
		assertEquals("Gosta de ganhar dinheiro?", navigable.getCurrent().getText());
		
		navigable.selectOption(YesNo.toObject("s"));
		assertEquals("Temos algo em comum ;)", navigable.getCurrent().getText());
	}

}
