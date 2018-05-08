package com.cassino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carta {
	
	private Naipe naipe;
	private Valor valor;
	private int value;
	
	public Carta(String carta) {
		String stringvalor = carta.substring(0, 1);
		String stringnaipe = carta.substring(1, 2);
		
		valor = Valor.getValor(stringvalor);
		naipe = Naipe.getNaipe(stringnaipe);
	}
	
	public Carta() {
	}
	
	public int intValue() {
		return value;
	}
	
	public Naipe getNaipe() {
		return naipe;
	}
	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	public Valor getValor() {
		return valor;
	}
	public void setValor(Valor valor) {
		this.valor = valor;
	}
	
	public static List<Carta> getPokerHand(String hand){
		List<String> cartas = Arrays.asList(hand.split(" "));
		List<Carta> listaCartas = new ArrayList<Carta>();
		for (String carta : cartas) {
			listaCartas.add(new Carta(carta));
		}
		
		return listaCartas;
	}

	public static int[] getValores(List<Carta> list){
		int[] val = new int[list.size()];
		for (int i = 0; i < val.length; i++) {
			val[i] = list.get(i).getValor().intValue();			
		}
		
		return val;
	}

	public static String[] getNaipes(List<Carta> list){
		String[] val = new String[list.size()];
		for (int i = 0; i < val.length; i++) {
			val[i] = list.get(i).getNaipe().getValue();			
		}
		
		return val;
	}
	
	public int compareTo(Carta c) {
		int result = 0;
		
		if (this.intValue() > c.intValue()) {
			result = 1;
		} else if (c.intValue() > this.intValue()) {
			result = -1;
		} else {
			// Let it be.
		}
		
		return result;
	}

}
