package com.riambsoft.rdt.template;

import java.io.IOException;

import net.sf.json.JSONObject;

import biz.source_code.miniTemplator.MiniTemplator;
import biz.source_code.miniTemplator.MiniTemplator.TemplateSyntaxException;

import com.riambsoft.rdt.model.CardPanel;
import com.riambsoft.rdt.model.CardPanelRegion;

public class CardPanelTemplator {

	private static final String templateFileName = "templates/CardPanel.js";

	public String generateOutput(CardPanel panel)
			throws TemplateSyntaxException, IOException {

		MiniTemplator t = new MiniTemplator(templateFileName);
		t.setVariable("jsclassname", panel.getJsClassName());

		String json = "{}";
		CardPanelRegion cpl = panel.getHeaderLeft();
		if (cpl != null) {
			json = JSONObject.fromObject(cpl).toString();
		}
		t.setVariable("headerleft", json);

		String json1 = "{}";
		CardPanelRegion cpr = panel.getHeaderRight();
		if (cpr != null) {
			json1 = JSONObject.fromObject(cpr).toString();
		}
		t.setVariable("headerright", json1);

		String json2 = "{}";
		CardPanelRegion cpc = panel.getHeaderCenter();
		if (cpc != null) {
			json2 = JSONObject.fromObject(cpc).toString();
		}
		t.setVariable("headercenter", json2);

		String json3 = "{}";
		CardPanelRegion cpb = panel.getHeaderBottom();
		if (cpb != null) {
			json3 = JSONObject.fromObject(cpb).toString();
		}
		t.setVariable("headerbottom", json3);

		String json4 = "{}";
		CardPanelRegion cpfl = panel.getFooterLeft();
		if (cpfl != null) {
			json4 = JSONObject.fromObject(cpfl).toString();
		}
		t.setVariable("footerleft", json4);

		String json5 = "{}";
		CardPanelRegion cpfc = panel.getFooterCenter();
		if (cpfc != null) {
			json5 = JSONObject.fromObject(cpfc).toString();
		}
		t.setVariable("footercenter", json5);

		String json6 = "{}";
		CardPanelRegion cpfr = panel.getFooterRight();
		if (cpfr != null) {
			json6 = JSONObject.fromObject(cpfr).toString();
		}
		t.setVariable("footerright", json6);

		return t.generateOutput();
	}

}
