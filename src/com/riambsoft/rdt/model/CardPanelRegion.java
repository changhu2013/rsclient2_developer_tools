package com.riambsoft.rdt.model;

public class CardPanelRegion {

	private String dataIndex;

	private String fieldLabel;

	private String value;

	private int fontSize;

	private String color;

	private String style;

	public CardPanelRegion() {
		super();
	}

	public String getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String toString() {
		return "CardPanelRegion [dataIndex=" + dataIndex + ", fieldLabel="
				+ fieldLabel + ", value=" + value + ", fontSize=" + fontSize
				+ ", color=" + color + ", style=" + style + "]";
	}

}
