package br.fsg.flowchart.lucidchart;

import org.apache.commons.lang3.StringUtils;

import br.fsg.flowchart.spec.Element;
import br.fsg.flowchart.spec.Type;

public class LucidchartElement implements Element {

	private Integer id;
	public Type type;
	private Integer source;
	private Integer target;
	private String text;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Integer getSource() {
		return source;
	}

	@Override
	public Integer getTarget() {
		return target;
	}

	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public boolean isLine() {
		return type.equals(LucidchartElementType.LINE);
	}
	
	@Override
	public boolean isFinal() {
		return type.equals(LucidchartElementType.TERMINATOR);
	}
	
	public static final class Builder {

		public LucidchartElement element;

		public Builder() {
			this.element = new LucidchartElement();
		}

		public Builder withId(String id) {
			this.element.id = Integer.valueOf(id);
			return this;
		}

		public Builder withType(String type) {
			this.element.type = LucidchartElementType.getElement(type);
			return this;
		}

		public Builder withLineSource(String source) {
			if (StringUtils.isNotBlank(source)) {
				this.element.source = Integer.valueOf(source);
			}
			return this;
		}

		public Builder withLineDestination(String target) {
			if (StringUtils.isNotBlank(target)) {
				this.element.target = Integer.valueOf(target);
			}
			return this;
		}

		public Builder withText(String text) {
			this.element.text = text;
			return this;
		}

		public Element build() {
			return element;
		}
	}

	
	@Override
	public String toString() {
		return "[ id: " + id + ", type: " + type + ", text: " + text + "]";
	}
}
