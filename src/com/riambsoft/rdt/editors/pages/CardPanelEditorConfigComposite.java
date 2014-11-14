package com.riambsoft.rdt.editors.pages;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.riambsoft.rdt.model.CardPanel;
import com.riambsoft.rdt.model.CardPanelRegion;

//�̳�ScrolledComposite ʵ�ֹ����� 
public class CardPanelEditorConfigComposite extends ScrolledComposite {

	private static final int LABEL_WIDTH = 70;

	private static final int FIELD_WIDTH = 150;

	private CardPanel cardPanel;

	public CardPanelEditorConfigComposite(Composite parent, int style,
			CardPanel cardPanel) {
		super(parent, style);
		this.cardPanel = cardPanel;

		Composite main = new Composite(this, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		main.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		main.setLayoutData(data);

		initProperties(main);

		setExpandHorizontal(true);
		setExpandVertical(true);
		setLayoutData(new GridData(GridData.FILL_BOTH));

		setContent(main);
		setMinSize(main.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public void initProperties(Composite main) {

		// ����
		addNameProperty(main);

		// ����
		addHeaderCenterProperty(main);

		// �������Ͻ�
		addHeaderLeftProperty(main);

		// �������Ͻ�
		addHeaderRightProperty(main);

		// ������
		addHeaderBottomProperty(main);

		// ���ҳ��
		addFooterLeftProperty(main);

		// �м�ҳ��
		addFooterCenterProperty(main);

		// �ұ�ҳ��
		addFooterRightProperty(main);
	}

	// ����һ�����е�����
	private Composite createDefaultComposite(Composite parent) {

		Composite composite = new Composite(parent, SWT.BORDER);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		
		composite.setLayout(layout);

		GridData data = new GridData();

		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		
		composite.setLayoutData(data);
		
		return composite;
	}

	// �ָ���
	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gd);
	}

	// ����
	private void addNameProperty(Composite parent) {
		
		Composite composite = createDefaultComposite(parent);
		
		//������Ϣ
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("������Ϣ");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		//gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);
		
		
		//JS����
		Label label = new Label(composite, SWT.RIGHT);
		label.setText("JS����:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		label.setLayoutData(gd1);

		Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gd2 = new GridData();
		gd2.widthHint = FIELD_WIDTH;

		text.setLayoutData(gd2);
		String name = cardPanel.getJsClassName();
		if (name != null) {
			text.setText(name);
		}
	}

	// ����
	private void addHeaderCenterProperty(Composite parent) {

		CardPanelRegion headerCenter = cardPanel.getHeaderCenter();
		
		Composite composite = createDefaultComposite(parent);
		
		//����
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("����");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);
		
		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (headerCenter != null) {
			String dataIndex = headerCenter.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (headerCenter != null) {
			String value = headerCenter.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (headerCenter != null) {
			int fontSize = headerCenter.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (headerCenter != null) {
			String color = headerCenter.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (headerCenter != null) {
			String style = headerCenter.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// ��Ƭͷ���Ͻ�-������Ϣ
	private void addHeaderLeftProperty(Composite parent) {

		CardPanelRegion headerLeft = cardPanel.getHeaderLeft();
		Composite composite = createDefaultComposite(parent);
		
		//����
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("�����Ͻ�");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (headerLeft != null) {
			String dataIndex = headerLeft.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (headerLeft != null) {
			String value = headerLeft.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (headerLeft != null) {
			int fontSize = headerLeft.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (headerLeft != null) {
			String color = headerLeft.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (headerLeft != null) {
			String style = headerLeft.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// �����Ͻ�
	private void addHeaderRightProperty(Composite parent) {

		CardPanelRegion headerRight = cardPanel.getHeaderRight();
		Composite composite = createDefaultComposite(parent);
		
		//����
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("�����Ͻ�");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (headerRight != null) {
			String dataIndex = headerRight.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (headerRight != null) {
			String value = headerRight.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (headerRight != null) {
			int fontSize = headerRight.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (headerRight != null) {
			String color = headerRight.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (headerRight != null) {
			String style = headerRight.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// ������
	private void addHeaderBottomProperty(Composite parent) {

		CardPanelRegion headerBottom = cardPanel.getHeaderBottom();
		Composite composite = createDefaultComposite(parent);
		
		//
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("������");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (headerBottom != null) {
			String dataIndex = headerBottom.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (headerBottom != null) {
			String value = headerBottom.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (headerBottom != null) {
			int fontSize = headerBottom.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (headerBottom != null) {
			String color = headerBottom.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (headerBottom != null) {
			String style = headerBottom.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// ���ҳ��
	private void addFooterLeftProperty(Composite parent) {

		CardPanelRegion footerLeft = cardPanel.getFooterLeft();
		Composite composite = createDefaultComposite(parent);
		//
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("���ҳ��");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (footerLeft != null) {
			String dataIndex = footerLeft.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (footerLeft != null) {
			String value = footerLeft.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (footerLeft != null) {
			int fontSize = footerLeft.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (footerLeft != null) {
			String color = footerLeft.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (footerLeft != null) {
			String style = footerLeft.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// �м�ҳ��
	private void addFooterCenterProperty(Composite parent) {

		CardPanelRegion footerCenter = cardPanel.getFooterCenter();
		Composite composite = createDefaultComposite(parent);
		
		//
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("�м�ҳ��");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (footerCenter != null) {
			String dataIndex = footerCenter.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (footerCenter != null) {
			String value = footerCenter.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (footerCenter != null) {
			int fontSize = footerCenter.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (footerCenter != null) {
			String color = footerCenter.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (footerCenter != null) {
			String style = footerCenter.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

	// �ұ�ҳ��
	private void addFooterRightProperty(Composite parent) {

		CardPanelRegion footerRight = cardPanel.getFooterRight();
		Composite composite = createDefaultComposite(parent);
		
		//
		Label headerCenterLabel = new Label(composite, SWT.CENTER);
		headerCenterLabel.setText("�ұ�ҳ��");
		headerCenterLabel.setFont(new Font(parent.getDisplay(), "����", 14,
				SWT.BOLD));
		GridData gd0 = new GridData();
		gd0.horizontalSpan = 2;
		headerCenterLabel.setLayoutData(gd0);

		// �ֶ�
		Label l1 = new Label(composite, SWT.RIGHT);
		l1.setText("�ֶ�:");
		GridData gd1 = new GridData();
		gd1.widthHint = LABEL_WIDTH;
		l1.setLayoutData(gd1);

		Text t1 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt1 = new GridData();
		gdt1.widthHint = FIELD_WIDTH;
		t1.setLayoutData(gdt1);

		if (footerRight != null) {
			String dataIndex = footerRight.getDataIndex();
			if (dataIndex != null) {
				t1.setText(dataIndex);
			}
		}

		// ֵ
		Label l2 = new Label(composite, SWT.RIGHT);
		l2.setText("ֵ:");
		GridData gd2 = new GridData();
		gd2.widthHint = LABEL_WIDTH;
		gd2.horizontalSpan = 1;
		l2.setLayoutData(gd2);

		Text t2 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt2 = new GridData();
		gdt2.widthHint = FIELD_WIDTH;
		gdt2.horizontalSpan = 1;
		t2.setLayoutData(gdt2);

		if (footerRight != null) {
			String value = footerRight.getValue();
			if (value != null) {
				t2.setText(value);
			}
		}

		// �����С
		Label l3 = new Label(composite, SWT.RIGHT);
		l3.setText("�ֺ�:");
		GridData gd3 = new GridData();
		gd3.widthHint = LABEL_WIDTH;
		gd3.horizontalSpan = 1;
		l3.setLayoutData(gd3);

		Text t3 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt3 = new GridData();
		gdt3.widthHint = FIELD_WIDTH;
		gdt3.horizontalSpan = 1;
		t3.setLayoutData(gdt3);
		t3.addKeyListener(new KeyListener() {
			public boolean checkDate(int n) {
				if (48 == n || 49 == n || 50 == n || 51 == n || 52 == n
						|| 53 == n || 54 == n || 55 == n
						|| 56 == n
						|| 57 == n
						// С��������
						|| 16777264 == n || 16777265 == n || 16777266 == n
						|| 16777267 == n || 16777268 == n || 16777269 == n
						|| 16777270 == n || 16777271 == n || 16777272 == n
						|| 16777273 == n) {
					return true;
				}
				return false;
			}

			public void keyPressed(KeyEvent e) {
				if (!checkDate(e.keyCode)) {
					e.doit = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

		});

		if (footerRight != null) {
			int fontSize = footerRight.getFontSize();
			if (fontSize > 0) {
				t3.setText("" + fontSize);
			}
		}

		// ��ɫ
		Label l4 = new Label(composite, SWT.RIGHT);
		l4.setText("��ɫ:");
		GridData gd4 = new GridData();
		gd4.widthHint = LABEL_WIDTH;
		l4.setLayoutData(gd4);

		Text t4 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt4 = new GridData();
		gdt4.widthHint = FIELD_WIDTH;
		t4.setLayoutData(gdt1);

		if (footerRight != null) {
			String color = footerRight.getColor();
			if (color != null) {
				t4.setText(color);
			}
		}

		// ��ɫ
		Label l5 = new Label(composite, SWT.RIGHT);
		l5.setText("��չ��ʽ(CSS):");
		GridData gd5 = new GridData();
		gd5.widthHint = LABEL_WIDTH;
		l5.setLayoutData(gd5);

		Text t5 = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gdt5 = new GridData();
		gdt5.widthHint = FIELD_WIDTH;
		t5.setLayoutData(gdt1);

		if (footerRight != null) {
			String style = footerRight.getStyle();
			if (style != null) {
				t5.setText(style);
			}
		}
	}

}
