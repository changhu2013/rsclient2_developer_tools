package com.riambsoft.rdt.model;

public class CardPanel {

	private String jsClassName;

	private CardPanelRegion headerLeft;

	private CardPanelRegion headerCenter;

	private CardPanelRegion headerRight;

	private CardPanelRegion headerBottom;

	private CardPanelRegion footerLeft;

	private CardPanelRegion footerCenter;

	private CardPanelRegion footerRight;

	public CardPanel() {
		super();
	}

	public String getJsClassName() {
		return jsClassName;
	}

	public void setJsClassName(String jsClassName) {
		this.jsClassName = jsClassName;
	}

	public CardPanelRegion getHeaderLeft() {
		return headerLeft;
	}

	public void setHeaderLeft(CardPanelRegion headerLeft) {
		this.headerLeft = headerLeft;
	}

	public CardPanelRegion getHeaderCenter() {
		return headerCenter;
	}

	public void setHeaderCenter(CardPanelRegion headerCenter) {
		this.headerCenter = headerCenter;
	}

	public CardPanelRegion getHeaderRight() {
		return headerRight;
	}

	public void setHeaderRight(CardPanelRegion headerRight) {
		this.headerRight = headerRight;
	}

	public CardPanelRegion getHeaderBottom() {
		return headerBottom;
	}

	public void setHeaderBottom(CardPanelRegion headerBottom) {
		this.headerBottom = headerBottom;
	}

	public CardPanelRegion getFooterLeft() {
		return footerLeft;
	}

	public void setFooterLeft(CardPanelRegion footerLeft) {
		this.footerLeft = footerLeft;
	}

	public CardPanelRegion getFooterCenter() {
		return footerCenter;
	}

	public void setFooterCenter(CardPanelRegion footerCenter) {
		this.footerCenter = footerCenter;
	}

	public CardPanelRegion getFooterRight() {
		return footerRight;
	}

	public void setFooterRight(CardPanelRegion footerRight) {
		this.footerRight = footerRight;
	}

	public String toString() {
		return "CardPanel [jsClassName=" + jsClassName + ", headerLeft="
				+ headerLeft + ", headerCenter=" + headerCenter
				+ ", headerRight=" + headerRight + ", headerBottom="
				+ headerBottom + ", footerLeft=" + footerLeft
				+ ", footerCenter=" + footerCenter + ", footerRight="
				+ footerRight + "]";
	}

}
