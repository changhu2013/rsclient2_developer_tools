package com.riambsoft.rdt.editors.pages;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.editors.text.TextEditor;

import com.riambsoft.rdt.model.CardPanel;

public class CardPanelEditorSourceEditor extends TextEditor {

	private CardPanel cardPanel;

	public CardPanelEditorSourceEditor(CardPanel cardPanel) {
		super();
		this.cardPanel = cardPanel;
	}
	
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
		System.out.println("±£´æ");
	}

	public void doSaveAs() {
		super.doSaveAs();
		System.out.println("Áí´æÎª");
	}
	
	
	
}
