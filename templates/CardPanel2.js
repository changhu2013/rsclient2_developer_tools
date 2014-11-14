
Rs.define('rs.inv.BillCardPanel', {

	extend : Ext.Panel,
	
	mixins : [Rs.app.Main],
	
	constructor : function(config){
		
		//数据模型
		var bill = new Rs.ext.app.Model({
			data : {}
		});
		
		//卡片页面
		var card = new Rs.ext.app.CardPanel(bill, {
			//表单头
			formHeader : {
				left : {
					dataIndex : 'fanghao',
					fieldLabel : '仓库',
					value : '10-00R3-01-0013-0'
				},
				right : {
					dataIndex : 'jingshouren',
					fieldLabel : '经手人',
					value : 'XXXXXX'
				},
				center : {
					dataIndex : 'biaoti',
					value : '入库单'
				},
				bottom : {
					dataIndex : 'fubiaoti',
					value : 'XX公司12号成品库'
				}
			},
			
			//字段
			formBody : {
				fields : [[{
					dataIndex : 'itemCode',
					fieldLabel : '物料编码',
					readOnly : true,
					//占行宽比例
					columnWidth: .25
				}, {
					dataIndex : 'itemName',
					fieldLabel : '物料名称',
					readOnly : true,
					columnWidth: .25
				}, {
					dataIndex : 'itemNorm',
					fieldLabel : '物料规格',
					readOnly : true,
					columnWidth: .25
				}, {
					xtype : 'datefield',
					dataIndex : 'fahuoshijian',
					fieldLabel : '发货时间',
					columnWidth : .25,
					format : 'Y/m/d',
	                altFormats:"Y/m/d|Ymd|Y/n/j|Ynj|Y/M/D|YMD"
				}], [{
					xtype : 'textarea',
					dataIndex : 'itemMsg',
					fieldLabel : '物料信息',
					height : 95,
					columnWidth: 1
				}], [{
					dataIndex : 'itemName',
					allowBlank : false,
					fieldLabel : '物料名称',
					columnWidth: .4
				}, {
					dataIndex : 'itemNorm',
					fieldLabel : '物料规格',
					columnWidth: .6
				}], [new Rs.ext.form.Telescope({
	                dataIndex : 'kehuXinxi',
					fieldLabel: '客户信息',
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
	                fieldLabel: '合同号',
	                regex : /^[a-z|A-Z|0-9|_]+$/,
					regexText : '合同号由字母，数字，下划线等组成',
					columnWidth : .3
				}, {
					xtype : 'combo',
					readOnly : false,
					dataIndex : 'payWay',
					fieldLabel: '付款方式',
    				triggerAction : 'all',
    				editable : false,
    				lazyRender : true,
    				mode : 'local',
    				valueField: 'payWay',
    				displayField: 'payWayName',
    				store : new Ext.data.ArrayStore({
    					fields : ['payWay', 'payWayName'],
    					data : [['A', '一次全付'],['S', '分阶段付款']]
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
			
			//右下角信息
			formFooter : {
				left : {
					fieldLabel : '年月',
					dataIndex : 'nianyue',
					value : '2014.09.02'
				},
				center : {
					fieldLabel : '打印日期',
					dataIndex : 'dayinriqi',
					value : '2014.09.02'
				},
				right : {
					fieldLabel : '注',
					dataIndex : 'zhu',
					value : '务必在45天内缴费'
				}
			}
		});
		
		Ext.apply(config, {
			layout : 'fit',
			items : [card],
		});
		
		rs.inv.TestPanel.superclass.constructor.apply(this, arguments);
	}

});
