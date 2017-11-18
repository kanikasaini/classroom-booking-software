package application;

import java.io.Serializable;

//class to create Timetable object which is essentially the schedule of a single day

public class Timetable implements Serializable {
	private String eightThirtyNine;
	private String nineNineThirty;
	private String nineThirtyTen;
	private String tenTenThirty;
	private String tenThirtyEleven;
	private String elevenElevenThirty;
	private String elevenThirtyTwelve;
	private String twelveTwelveThirty;
	private String twelveThirtyOne;
	private String oneOneThirty;
	private String oneThirtyTwo;
	private String twoTwoThirty;
	private String twoThirtyThree;
	private String threeThreeThirty;
	private String threeThirtyFour;
	private String fourFourThirty;
	private String fourThirtyFive;
	private String fiveFiveThirty;
	private String fiveThirtySix;
	
	public String getEightThirtyNine() {
		return eightThirtyNine;
	}

	public void setEightThirtyNine(String eightThirtyNine) {
		this.eightThirtyNine = eightThirtyNine;
	}

	public String getNineNineThirty() {
		return nineNineThirty;
	}

	public void setNineNineThirty(String nineNineThirty) {
		this.nineNineThirty = nineNineThirty;
	}

	public String getNineThirtyTen() {
		return nineThirtyTen;
	}

	public void setNineThirtyTen(String nineThirtyTen) {
		this.nineThirtyTen = nineThirtyTen;
	}

	public String getTenTenThirty() {
		return tenTenThirty;
	}

	public void setTenTenThirty(String tenTenThirty) {
		this.tenTenThirty = tenTenThirty;
	}

	public String getTenThirtyEleven() {
		return tenThirtyEleven;
	}

	public void setTenThirtyEleven(String tenThirtyEleven) {
		this.tenThirtyEleven = tenThirtyEleven;
	}

	public String getElevenElevenThirty() {
		return elevenElevenThirty;
	}

	public void setElevenElevenThirty(String elevenElevenThirty) {
		this.elevenElevenThirty = elevenElevenThirty;
	}

	public String getElevenThirtyTwelve() {
		return elevenThirtyTwelve;
	}

	public void setElevenThirtyTwelve(String elevenThirtyTwelve) {
		this.elevenThirtyTwelve = elevenThirtyTwelve;
	}

	public String getTwelveTwelveThirty() {
		return twelveTwelveThirty;
	}

	public void setTwelveTwelveThirty(String twelveTwelveThirty) {
		this.twelveTwelveThirty = twelveTwelveThirty;
	}

	public String getTwelveThirtyOne() {
		return twelveThirtyOne;
	}

	public void setTwelveThirtyOne(String twelveThirtyOne) {
		this.twelveThirtyOne = twelveThirtyOne;
	}

	public String getOneOneThirty() {
		return oneOneThirty;
	}

	public void setOneOneThirty(String oneOneThirty) {
		this.oneOneThirty = oneOneThirty;
	}

	public String getOneThirtyTwo() {
		return oneThirtyTwo;
	}

	public void setOneThirtyTwo(String oneThirtyTwo) {
		this.oneThirtyTwo = oneThirtyTwo;
	}

	public String getTwoTwoThirty() {
		return twoTwoThirty;
	}

	public void setTwoTwoThirty(String twoTwoThirty) {
		this.twoTwoThirty = twoTwoThirty;
	}

	public String getTwoThirtyThree() {
		return twoThirtyThree;
	}

	public void setTwoThirtyThree(String twoThirtyThree) {
		this.twoThirtyThree = twoThirtyThree;
	}

	public String getThreeThreeThirty() {
		return threeThreeThirty;
	}

	public void setThreeThreeThirty(String threeThreeThirty) {
		this.threeThreeThirty = threeThreeThirty;
	}

	public String getThreeThirtyFour() {
		return threeThirtyFour;
	}

	public void setThreeThirtyFour(String threeThirtyFour) {
		this.threeThirtyFour = threeThirtyFour;
	}

	public String getFourFourThirty() {
		return fourFourThirty;
	}

	public void setFourFourThirty(String fourFourThirty) {
		this.fourFourThirty = fourFourThirty;
	}

	public String getFourThirtyFive() {
		return fourThirtyFive;
	}

	public void setFourThirtyFive(String fourThirtyFive) {
		this.fourThirtyFive = fourThirtyFive;
	}

	public String getFiveFiveThirty() {
		return fiveFiveThirty;
	}

	public void setFiveFiveThirty(String fiveFiveThirty) {
		this.fiveFiveThirty = fiveFiveThirty;
	}

	public String getFiveThirtySix() {
		return fiveThirtySix;
	}

	public void setFiveThirtySix(String fiveThirtySix) {
		this.fiveThirtySix = fiveThirtySix;
	}

	@Override
	public String toString() {
		return "Timetable [eightThirtyNine=" + eightThirtyNine + ", nineNineThirty=" + nineNineThirty
				+ ", nineThirtyTen=" + nineThirtyTen + ", tenTenThirty=" + tenTenThirty + ", tenThirtyEleven="
				+ tenThirtyEleven + ", elevenElevenThirty=" + elevenElevenThirty + ", elevenThirtyTwelve="
				+ elevenThirtyTwelve + ", twelveTwelveThirty=" + twelveTwelveThirty + ", twelveThirtyOne="
				+ twelveThirtyOne + ", oneOneThirty=" + oneOneThirty + ", oneThirtyTwo=" + oneThirtyTwo
				+ ", twoTwoThirty=" + twoTwoThirty + ", twoThirtyThree=" + twoThirtyThree + ", threeThreeThirty="
				+ threeThreeThirty + ", threeThirtyFour=" + threeThirtyFour + ", fourFourThirty=" + fourFourThirty
				+ ", fourThirtyFive=" + fourThirtyFive + ", fiveFiveThirty=" + fiveFiveThirty + ", fiveThirtySix="
				+ fiveThirtySix + "]";
	}

	public Timetable(String eightThirtyNine, String nineNineThirty, String nineThirtyTen, String tenTenThirty,
			String tenThirtyEleven, String elevenElevenThirty, String elevenThirtyTwelve, String twelveTwelveThirty,
			String twelveThirtyOne, String oneOneThirty, String oneThirtyTwo, String twoTwoThirty,
			String twoThirtyThree, String threeThreeThirty, String threeThirtyFour, String fourFourThirty,
			String fourThirtyFive, String fiveFiveThirty, String fiveThirtySix) {
		super();
		this.eightThirtyNine = eightThirtyNine;
		this.nineNineThirty = nineNineThirty;
		this.nineThirtyTen = nineThirtyTen;
		this.tenTenThirty = tenTenThirty;
		this.tenThirtyEleven = tenThirtyEleven;
		this.elevenElevenThirty = elevenElevenThirty;
		this.elevenThirtyTwelve = elevenThirtyTwelve;
		this.twelveTwelveThirty = twelveTwelveThirty;
		this.twelveThirtyOne = twelveThirtyOne;
		this.oneOneThirty = oneOneThirty;
		this.oneThirtyTwo = oneThirtyTwo;
		this.twoTwoThirty = twoTwoThirty;
		this.twoThirtyThree = twoThirtyThree;
		this.threeThreeThirty = threeThreeThirty;
		this.threeThirtyFour = threeThirtyFour;
		this.fourFourThirty = fourFourThirty;
		this.fourThirtyFive = fourThirtyFive;
		this.fiveFiveThirty = fiveFiveThirty;
		this.fiveThirtySix = fiveThirtySix;
	}
	
}


