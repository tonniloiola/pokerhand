package com.cassino;

public enum Valor {

	_2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"), T("T"), J("J"), Q("Q"), K("K"), A("A");

	private int value;
	private String valor;

	Valor(String v) {
		this.valor = v;
		
		if (v.equals("2") || v.equals("3") || v.equals("4") || v.equals("5") || v.equals("6") || v.equals("7") || v.equals("8") || v.equals("9") || v.equals("10") || v.equals("11") || v.equals("12") || v.equals("13") || v.equals("14")) {
			value = Integer.parseInt(v);
		} else {
			if (v.equals("J")) {
				value = 11;
			} else if (v.equals("Q")) {
				value = 12;
			} else if (v.equals("K")) {
				value = 13;
			} else if (v.equals("A")) {
				value = 14;
			}
		}
		
	}
	
	public String getValue() {
		return valor;
	}

	public static Valor getValor(String value) {
		for (Valor e : Valor.values()) {
			if (e.valor.equals(value)) {
				return e;
			}
		}
		return null;// not found
	}
	
	public int intValue() {
		return value;
	}
}
