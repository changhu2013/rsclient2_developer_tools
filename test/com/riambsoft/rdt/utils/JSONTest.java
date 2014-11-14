package com.riambsoft.rdt.utils;

import net.sf.json.JSONObject;

import com.riambsoft.rdt.model.CardPanel;
import com.riambsoft.rdt.model.CardPanelRegion;

public class JSONTest {

	public static void main(String[] args) {
		
		
		CardPanelRegion cpr = new CardPanelRegion();
		
		cpr.setDataIndex("itemCode");
		cpr.setFieldLabel("ŒÔ¡œ±‡¬Î");
		cpr.setFontSize(36);
		cpr.setValue("XXXX_XXXX");
		cpr.setColor("RED");
		
		CardPanel cp = new CardPanel();
		cp.setJsClassName("rs.inv.BillCardPanel");
		
		cp.setHeaderCenter(cpr);
		
		JSONObject jo = JSONObject.fromObject(cp);
		String json = jo.toString();
		
		System.out.println(json);
		
		CardPanel cp2 = (CardPanel) JSONObject.toBean(jo, CardPanel.class);
		System.out.println(cp2);
		System.out.println(cp2.getHeaderCenter());
	}
	
}
