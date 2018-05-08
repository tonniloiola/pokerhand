package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cassino.PokerHand;
import com.cassino.Resultado;

public class PokerHandTest {


	private PokerHand straightFlush;
	private PokerHand royalFlush;
	private PokerHand twoPairCards;
	private PokerHand pair;
	private PokerHand flush;

	public PokerHandTest() {
		royalFlush = new PokerHand("TC JC QC KC AC");
		straightFlush = new PokerHand("9C TC JC QC KC");
		twoPairCards = new PokerHand("TC TH 5C 5H KH");
		pair = new PokerHand("TC TH 5C 3S KD");
		flush = new PokerHand("2C 4C 7C TC KC");
	}

	@Test
	public void isRoyalFlush() {
		assertEquals(9.0, royalFlush.getRanking());
	}

	@Test
	public void isStraightFlush() {
		assertTrue(straightFlush.getRanking() > 8.0);
	}
	
	@Test
	public void isTwoPairCards() {
		assertTrue(twoPairCards.getRanking() > 2.0);
	}

	@Test
	public void isPair() {
		assertTrue(pair.getRanking() > 1.0);
	}
	
	@Test
	public void isFlush() {
		assertEquals(5.13, flush.getRanking());
	}


	@Test
	public void teste1() {
		PokerHand PokerHand = new PokerHand("9C TC JC QC KC");
		PokerHand royal = new PokerHand("9C 9H 5C 5H AC");
		Resultado result = PokerHand.compareWith(royal);

		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TC TH 5C 5H KH" | "9C 9H 5C 5H AC"
	public void teste2() {// deu erro
		PokerHand PokerHand = new PokerHand("TC TH 5C 5H KH");
		PokerHand royal = new PokerHand("9C 9H 5C 5H AC");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TS TD KC JC 7C" | "JS JC AS KC TD"
	public void teste3() {
		PokerHand PokerHand = new PokerHand("TS TD KC JC 7C");
		PokerHand royal = new PokerHand("JS JC AS KC TD");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "7H 7C QC JS TS" | "7D 7C JS TS 6D"
	public void teste4() {// deu erro
		PokerHand PokerHand = new PokerHand("7H 7C QC JS TS");
		PokerHand royal = new PokerHand("7D 7C JS TS 6D");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS"
	public void teste5() {
		PokerHand PokerHand = new PokerHand("5S 5D 8C 7S 6H");
		PokerHand royal = new PokerHand("7D 7S 5S 5D JS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "AS AD KD 7C 3D" | "AD AH KD 7C 4S"
	public void teste6() {// deu erro
		PokerHand PokerHand = new PokerHand("AS AD KD 7C 3D");
		PokerHand royal = new PokerHand("AD AH KD 7C 4S");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "TS JS QS KS AS" | "AC AH AS AS KS"
	public void teste7() {
		PokerHand PokerHand = new PokerHand("TS JS QS KS AS");
		PokerHand royal = new PokerHand("AC AH AS AS KS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TS JS QS KS AS" | "TC JS QC KS AC"
	public void teste8() {// deu erro
		PokerHand PokerHand = new PokerHand("TS JS QS KS AS");
		PokerHand royal = new PokerHand("TC JS QC KS AC");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TS JS QS KS AS" | "QH QS QC AS 8H"
	public void teste9() {
		PokerHand PokerHand = new PokerHand("TS JS QS KS AS");
		PokerHand royal = new PokerHand("QH QS QC AS 8H");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TS JS QS KS AS" | "QH QS QC AS 8H"
	public void teste10() {
		PokerHand PokerHand = new PokerHand("TS JS QS KS AS");
		PokerHand royal = new PokerHand("QH QS QC AS 8H");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "AC AH AS AS KS" | "TC JS QC KS AC"
	public void teste11() {// deu erro
		PokerHand PokerHand = new PokerHand("AC AH AS AS KS");
		PokerHand royal = new PokerHand("TC JS QC KS AC");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "AC AH AS AS KS" | "QH QS QC AS 8H"
	public void teste12() {
		PokerHand PokerHand = new PokerHand("AC AH AS AS KS");
		PokerHand royal = new PokerHand("QH QS QC AS 8H");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TC JS QC KS AC" | "QH QS QC AS 8H"
	public void teste13() {
		PokerHand PokerHand = new PokerHand("TC JS QC KS AC");
		PokerHand royal = new PokerHand("QH QS QC AS 8H");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7H 8H 9H TH JH" | "JH JC JS JD TH"
	public void teste14() {// deu erro
		PokerHand PokerHand = new PokerHand("7H 8H 9H TH JH");
		PokerHand royal = new PokerHand("JH JC JS JD TH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7H 8H 9H TH JH" | "4H 5H 9H TH JH"
	public void teste15() {// deu erro
		PokerHand PokerHand = new PokerHand("7H 8H 9H TH JH");
		PokerHand royal = new PokerHand("4H 5H 9H TH JH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7H 8H 9H TH JH" | "7C 8S 9H TH JH"
	public void teste16() {
		PokerHand PokerHand = new PokerHand("7H 8H 9H TH JH");
		PokerHand royal = new PokerHand("7C 8S 9H TH JH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7H 8H 9H TH JH" | "TS TH TD JH JD"
	public void teste17() {// deu erro
		PokerHand PokerHand = new PokerHand("7H 8H 9H TH JH");
		PokerHand royal = new PokerHand("TS TH TD JH JD");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7H 8H 9H TH JH" | "JH JD TH TC 4C"
	public void teste18() {
		PokerHand PokerHand = new PokerHand("7H 8H 9H TH JH");
		PokerHand royal = new PokerHand("JH JD TH TC 4C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "JH JC JS JD TH" | "4H 5H 9H TH JH"
	public void teste19() {
		PokerHand PokerHand = new PokerHand("JH JC JS JD TH");
		PokerHand royal = new PokerHand("4H 5H 9H TH JH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "JH JC JS JD TH" | "7C 8S 9H TH JH"
	public void teste20() {
		PokerHand PokerHand = new PokerHand("JH JC JS JD TH");
		PokerHand royal = new PokerHand("7C 8S 9H TH JH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "JH JC JS JD TH" | "TS TH TD JH JD"
	public void teste21() {
		PokerHand PokerHand = new PokerHand("JH JC JS JD TH");
		PokerHand royal = new PokerHand("TS TH TD JH JD");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "4H 5H 9H TH JH" | "7C 8S 9H TH JH"
	public void teste23() {
		PokerHand PokerHand = new PokerHand("4H 5H 9H TH JH");
		PokerHand royal = new PokerHand("7C 8S 9H TH JH");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "4H 5H 9H TH JH" | "TS TH TD JH JD"
	public void teste24() {
		PokerHand PokerHand = new PokerHand("4H 5H 9H TH JH");
		PokerHand royal = new PokerHand("TS TH TD JH JD");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "4H 5H 9H TH JH" | "JH JD TH TC 4C"
	public void teste25() {
		PokerHand PokerHand = new PokerHand("4H 5H 9H TH JH");
		PokerHand royal = new PokerHand("JH JD TH TC 4C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "7C 8S 9H TH JH" | "TS TH TD JH JD"
	public void teste26() {
		PokerHand PokerHand = new PokerHand("7C 8S 9H TH JH");
		PokerHand royal = new PokerHand("TS TH TD JH JD");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "7C 8S 9H TH JH" | "JH JD TH TC 4C"
	public void teste27() {// deu erro
		PokerHand PokerHand = new PokerHand("7C 8S 9H TH JH");
		PokerHand royal = new PokerHand("JH JD TH TC 4C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TS TH TD JH JD" | "JH JD TH TC 4C"
	public void teste28() {// deu erro
		PokerHand PokerHand = new PokerHand("TS TH TD JH JD");
		PokerHand royal = new PokerHand("JH JD TH TC 4C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "2S 3H 4D 5H 6D" | "5H 6D 7H 8C 9C"
	public void teste29() {
		PokerHand PokerHand = new PokerHand("2S 3H 4D 5H 6D");
		PokerHand royal = new PokerHand("5H 6D 7H 8C 9C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "2S 3H 4H 5H 6D" | "2S 3H 4D 5H 6C"
	public void teste30() {
		PokerHand PokerHand = new PokerHand("2S 3H 4H 5H 6D");
		PokerHand royal = new PokerHand("2S 3H 4D 5H 6C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.DRAW, result);
	}

	@Test
	// "2H 3H 4H 5H 7H" | "2D 3D 4D 5D 8D"
	public void teste31() {
		PokerHand PokerHand = new PokerHand("2H 3H 4H 5H 7H");
		PokerHand royal = new PokerHand("2D 3D 4D 5D 8D");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "2S 2H 2D 5H 6D" | "5H 5D 5H 8C 9C"
	public void teste32() {
		PokerHand PokerHand = new PokerHand("2S 2H 2D 5H 6D");
		PokerHand royal = new PokerHand("5H 5D 5H 8C 9C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "2H 3H 4H 5H 6H" | "5H 6H 7H 8H 9H"
	public void teste33() {
		PokerHand PokerHand = new PokerHand("2H 3H 4H 5H 6H");
		PokerHand royal = new PokerHand("5H 6H 7H 8H 9H");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "TH JH QH KH AH" | "TC JC QC KC AC"
	public void teste34() {
		PokerHand PokerHand = new PokerHand("TH JH QH KH AH");
		PokerHand royal = new PokerHand("TC JC QC KC AC");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.DRAW, result);
	}

	@Test
	// "TH TH TH TH AS" | "9C 9C 9C 9C 2S"
	public void teste35() {// deu erro
		PokerHand PokerHand = new PokerHand("TH TH TH TH AS");
		PokerHand royal = new PokerHand("9C 9C 9C 9C 2S");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "TH TH TH AH AS" | "9C 9C 9C 2C 2S"
	public void teste36() {
		PokerHand PokerHand = new PokerHand("TH TH TH AH AS");
		PokerHand royal = new PokerHand("9C 9C 9C 2C 2S");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "2H 4H 6H 8H AS" | "3C 5C 6C 8C JS"
	public void teste37() {// deu erro
		PokerHand PokerHand = new PokerHand("2H 4H 6H 8H AS");
		PokerHand royal = new PokerHand("3C 5C 6C 8C JS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "2H 2H 2H AH AS" | "2C 2C 2C JC JS"
	public void teste38() {
		PokerHand PokerHand = new PokerHand("2H 2H 2H AH AS");
		PokerHand royal = new PokerHand("2C 2C 2C JC JS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

	@Test
	// "2H 2H 5H AH AS" | "2C 2C 6C AC AS"
	public void teste39() {// deu erro
		PokerHand PokerHand = new PokerHand("2H 2H 5H AH AS");
		PokerHand royal = new PokerHand("2C 2C 6C AC AS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "2H 3C 3D 3S 6H" | "2C 3D 4D 5C 6C"
	public void teste40() {// deu erro
		PokerHand PokerHand = new PokerHand("2H 3C 3D 3S 6H");
		PokerHand royal = new PokerHand("2C 3D 4D 5C 6C");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.LOSS, result);
	}

	@Test
	// "AS 2S 5S 8S QS" | "KS JS 5S 8S QS"
	public void teste41() {// deu erro
		PokerHand PokerHand = new PokerHand("AS 2S 5S 8S QS");
		PokerHand royal = new PokerHand("KS JS 5S 8S QS");
		Resultado result = PokerHand.compareWith(royal);
		assertEquals(Resultado.WIN, result);
	}

}