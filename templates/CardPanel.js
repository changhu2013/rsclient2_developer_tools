
Rs.define('${jsclassname}', {
	
	extend : Ext.Panel,
	
	mixins : [Rs.app.Main],
	
	constructor : function(config){
		
		// ����ģ��
		var bill = new Rs.ext.app.Model({
			data : {}
		});
		
		// ��Ƭҳ��
		var card = new Rs.ext.app.CardPanel(bill, {
			// ��ͷ
			formHeader : {
				left : ${headerleft},
				right : ${headerright},
				center : ${headercenter},
				bottom : ${headerbottom}
			},
			
			// �ֶ�
			formBody : {
				fields : [[{
					dataIndex : 'itemCode',
					fieldLabel : '���ϱ���',
					readOnly : true,
					// ռ�п����
					columnWidth: .25
				}, {
					dataIndex : 'itemName',
					fieldLabel : '��������',
					readOnly : true,
					columnWidth: .25
				}, {
					dataIndex : 'itemNorm',
					fieldLabel : '���Ϲ��',
					readOnly : true,
					columnWidth: .25
				}, {
					xtype : 'datefield',
					dataIndex : 'fahuoshijian',
					fieldLabel : '����ʱ��',
					columnWidth : .25,
					format : 'Y/m/d',
	                altFormats:"Y/m/d|Ymd|Y/n/j|Ynj|Y/M/D|YMD"
				}], [{
					xtype : 'textarea',
					dataIndex : 'itemMsg',
					fieldLabel : '������Ϣ',
					height : 95,
					columnWidth: 1
				}], [{
					dataIndex : 'itemName',
					allowBlank : false,
					fieldLabel : '��������',
					columnWidth: .4
				}, {
					dataIndex : 'itemNorm',
					fieldLabel : '���Ϲ��',
					columnWidth: .6
				}], [new Rs.ext.form.Telescope({
	                dataIndex : 'kehuXinxi',
					fieldLabel: '�ͻ���Ϣ',
        			singleSelect : true,
        			progCode : 'psVenCusCode',
        			valueField: 'VENDOR_CUSTOMER_CODE',
        			displayField: 'VENDOR_CUSTOMER_NAME',
        			buildProgCondtion : function(condition){
        				return (Ext.isEmpty(condition, false) ? '' : condition + ' and ')
        					+  'company_code=\'01\' and customer_flag = \'Y\' and valid_flag = \'Y\'';
        			},
        			columnWidth: .5
        		}), {
					xtype : 'textfield',
					allowBlank : false,
					dataIndex : 'hetonghao',
                	maxLength: 15,
	                fieldLabel: '��ͬ��',
	                regex : /^[a-z|A-Z|0-9|_]+$/,
					regexText : '��ͬ������ĸ�����֣��»��ߵ����',
					columnWidth : .3
				}, {
					xtype : 'combo',
					readOnly : false,
					dataIndex : 'payWay',
					fieldLabel: '���ʽ',
    				triggerAction : 'all',
    				editable : false,
    				lazyRender : true,
    				mode : 'local',
    				valueField: 'payWay',
    				displayField: 'payWayName',
    				store : new Ext.data.ArrayStore({
    					fields : ['payWay', 'payWayName'],
    					data : [['A', 'һ��ȫ��'],['S', '�ֽ׶θ���']]
    				}),
    				columnWidth: .2,
    				listeners : {
    					'change' : {
    						fn : function(f, v){
    							if(v == 'S'){
    								card.setFieldReadOnly('hetonghao', false);
    								card.setFieldReadOnly('kehuXinxi', false);
    							}else {
    								card.setFieldReadOnly('hetonghao', true);
    								card.setFieldReadOnly('kehuXinxi', true);
    							}
    						},
    						scope : this
    					}
    				}
				}]]
			},
			
			// ���½���Ϣ
			formFooter : {
				left : ${footerleft},
				center : ${footercenter},
				right : ${footerright}
			}
		});
		
		Ext.apply(config, {
			layout : 'fit',
			items : [card],
		});
		
		${jsclassname}.superclass.constructor.apply(this, arguments);
	}

});
