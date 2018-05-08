package com.cassino;

import static com.cassino.Utils.isMaior;

import java.util.List;

public class PokerHand {

	private String hand;
	private List<Carta> cartas;
	private int[] values;
	private String[] suits;

	public PokerHand(String hand) {
		cartas = Carta.getPokerHand(hand);
		values = Carta.getValores(cartas);
		suits = Carta.getNaipes(cartas);
	}

	public String getHand() {
		return hand;
	}

	public Resultado compareWith(PokerHand anotherPokerHand) {
		
//		double rankingThis = this.getRanking();
//		double anotherHand = anotherPokerHand.getRanking();
		
        int retval = Double.compare(this.getRanking(), anotherPokerHand.getRanking());
		
		if(retval > 0) {
			return Resultado.WIN;
	      } else if(retval < 0) {
	    	  return Resultado.LOSS;
	      } else {
	    	  return Resultado.DRAW;
	      }
		
//		
//		if(this.getRanking() > anotherPokerHand.getRanking()) {
//			return Resultado.WIN;
//		} else if (this.getRanking() < anotherPokerHand.getRanking()) {
//			return Resultado.LOSS;
//		} else if (this.getRanking() == anotherPokerHand.getRanking()) {
//			return Resultado.DRAW;
//		}else {
//			return Resultado.NO_RESULT;
//		}
		
	}

	public  List<Carta> getCartas() {
		return cartas;
	}
	
    public double isStraightFlush() {
        double result = 0.0;
        
        if (isStraight() > 4.0 && isFlush() > 5.0) {
            result = 8.0 + isStraight() - 4.0;
        }
        
        return result;
    }
    
    public boolean isRoyalFlush() {
    	boolean isRoyal = false;
    	
    	for (Carta carta : cartas) {
    		String valor = carta.getValor().getValue();

    		if (valor.equals("T")) {
				isRoyal = true;
			}else if (valor.equals("J")) {
				isRoyal = true;
			} else if (valor.equals("Q")) {
				isRoyal = true;
			} else if (valor.equals("K")) {
				isRoyal = true;
			} else if (valor.equals("A")) {
				isRoyal = true;
			}else {
				return false;
			}
		}
    	
    	return isRoyal;
    }
    
    public double isStraight() {
        double result = 0.0;
            
        for (int i = 0; i < values.length - 1; i++){
            if (values[i] == values[i + 1] - 1) {
                result = 4.0 + (values[i + 1] * 0.01);
            } else {
                result = 0.0;
            }
        }
        
        return result;
    }
    
    public double isFlush() {
        double result = 0.0;
        
        String suit = suits[0];
        
        for (int i = 0; i < suits.length; i++) {
            result = 5.0 + (values[i] * 0.01);

            if (suits[i].equals(suit) == false) {
                result = 0.0;
            }
        }
        
        return result;
    }
	
	public double getRanking() {
        double ranking = 0;
//        
        if (isMaior(isStraightFlush(), 8.0)) {
        	if(isRoyalFlush()) {
        		ranking = 9.0;
        		System.out.println("isRoyalFlush");
        	}else {
        		ranking = isStraightFlush();
        		System.out.println("isStraightFlush");
        	}
        } else if (isMaior(isFourOfAKind(), 7.0)) {
            ranking = isFourOfAKind();
            System.out.println("isFourOfAKind");
        } else if (isMaior(isFullHouse(), 6.0)) {
            ranking = isFullHouse();
            System.out.println("isFullHouse");
        } else if (isMaior(isFlush(), 5.0)) {
            ranking = isFlush();
            System.out.println("isFlush");
        } else if (isMaior(isStraight(), 4.0)) {
            ranking = isStraight();
            System.out.println("isStraight");
        } else if (isMaior(isThreeOfAKind(), 3.0)) {
            ranking = isThreeOfAKind();
            System.out.println("isThreeOfAKind");
        } else if (isMaior(isTwoPair(), 2.0)) {
            ranking = isTwoPair();
            System.out.println("isTwoPair");
        }   else if (isMaior(isPair(), 1.0)) {
            ranking = isPair();
            System.out.println("isPair");
        } else {
            // WTF?
        	System.out.println("wtf");
        }
        
        return ranking;
    }
	
    public double isPair() {
        double result = 0.0;
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                result = 1.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
	
    public double isFourOfAKind() {
        double result = 0.0;

        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                result = 7.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
    
    public double isThreeOfAKind() {
        double result = 0.0;
       
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                result = 3.0 + (values[i] * 0.01);
            }
        }
        
        return result;
    }
	
    public int compareTo(PokerHand other) {
        int result = 0;
        
        int thisIntRank = (int)this.getRanking();
        int otherIntRank = (int)other.getRanking();
        
        double tempThisHighCard = this.getRanking() - thisIntRank;
        double tempOtherHighCard = other.getRanking() - otherIntRank;
        
        int thisHighCard = (int)tempThisHighCard;
        int otherHighCard = (int)tempOtherHighCard;
        
        if (thisIntRank == otherIntRank){ // If the same rank.
            if (thisHighCard > otherHighCard) {
                result = 1;
            } else if (otherHighCard > thisHighCard) {
                result = -1;
            } else {
                result = 0;
            }
        } else if (thisIntRank > otherIntRank) { // If this is of greater rank.
            result = 1;
        } else if (otherIntRank > thisIntRank) { // If the other is of greater rank.
            result = -1;
        } else { // Something different?
            result = 0;
        }
        
        return result;
    }
    
    public double isTwoPair() {
        double result = 0.0;
        double value = 0.0;
        int counter = 0; // Number of pairs.
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                counter++;
                
                value = values[i] * 0.01;
            }
        }
        
        if (counter == 2) {
            result = 2.0 + value;
        }
        
        return result;
    }

    public double isFullHouse() {
        double result = 0.0;
        boolean one = false;
        boolean two = false;
        
        for (int i = 0; i < values.length - 2; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2]) {
                one = true;
            }
        }
        
        if (values[3] == values[4]) {
            two = true;
        }
        
        if (one && two) {
            result = 6.0 + (values[values.length - 1] * 0.01);
        }
        
        return result;
    }
}
