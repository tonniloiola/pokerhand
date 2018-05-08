package com.cassino;

public enum Naipe {

	S("S"), H("H"), D("D"), C("C");
	
	private String value;

	Naipe(String naipe){
		this.value = naipe;
	}

	public static Naipe getNaipe(String value) {
		for (Naipe e : Naipe.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;// not found
	}

	public String getValue() {
		return value;
	}
	
}
