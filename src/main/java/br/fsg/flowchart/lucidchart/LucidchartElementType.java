package br.fsg.flowchart.lucidchart;

import java.util.Arrays;

import br.fsg.flowchart.spec.Type;

public enum LucidchartElementType implements Type {

	PROCESS("Process"), DECISION("Decision"), LINE("Line"), UNDEFINED("Undeefined"), TERMINATOR("Terminator");

	private String name;

	private LucidchartElementType(String name) {
		this.name = name;
	}

	public static LucidchartElementType getElement(String name) {
		return Arrays.asList(LucidchartElementType.values()).stream()
				.filter(type -> type.name().equalsIgnoreCase(name))
				.findFirst()
				.orElse(LucidchartElementType.UNDEFINED);
	}

	@Override
	public String toString() {
		return name;
	}
}
