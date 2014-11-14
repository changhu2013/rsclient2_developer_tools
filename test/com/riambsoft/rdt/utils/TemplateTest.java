package com.riambsoft.rdt.utils;

import java.io.IOException;

import biz.source_code.miniTemplator.MiniTemplator.TemplateSyntaxException;

import com.riambsoft.rdt.model.CardPanel;
import com.riambsoft.rdt.model.CardPanelRegion;
import com.riambsoft.rdt.template.CardPanelTemplator;

public class TemplateTest {

	public static void main(String[] args) throws TemplateSyntaxException,
			IOException {

		CardPanelRegion cpr = new CardPanelRegion();

		cpr.setDataIndex("itemCode");
		cpr.setFieldLabel("ŒÔ¡œ±‡¬Î");
		cpr.setFontSize(36);
		cpr.setValue("XXXX_XXXX");
		cpr.setColor("RED");

		CardPanel cp = new CardPanel();
		cp.setJsClassName("rs.inv.BillCardPanel");

		cp.setHeaderCenter(cpr);
		
		cp.setHeaderLeft(cpr);
		
		CardPanelTemplator ct = new CardPanelTemplator();
		String str = ct.generateOutput(cp);

		System.out.println(str);
	}

}
