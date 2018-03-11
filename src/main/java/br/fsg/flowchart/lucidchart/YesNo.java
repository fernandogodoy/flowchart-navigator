package br.fsg.flowchart.lucidchart;

public enum YesNo {

	S("yes") {
		@Override
		Boolean toBooleanValue() {
			return true;
		}

	},
	N("no") {
		@Override
		Boolean toBooleanValue() {
			return false;
		}

	};

	private String value;
	
	abstract Boolean toBooleanValue();

	private YesNo(String value) {
		this.value = value;
	}

	public static YesNo toObject(String yesNo) {
		String option = yesNo.toUpperCase();
		switch (option) {
		case "S":
			return S;
		case "N":
			return N;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return value;
	}
}
