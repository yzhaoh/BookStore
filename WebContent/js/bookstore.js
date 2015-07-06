function frame() {
	Ext.define('mypagingtoolbar', {
				extend : 'Ext.PagingToolbar',
				doRefresh : function() {
					return false;
				}
			});
	var userStore = Ext.create('Ext.data.Store', {
				storeId : 'userStore',
				fields : [{
							name : 'userId'
						}, {
							name : 'username'
						}, {
							name : 'name'
						}, {
							name : 'sex'
						}, {
							name : 'email'
						}, {
							name : 'checkEmail'
						}, {
							name : 'phone'
						}, {
							name : 'address'
						}, {
							name : 'icon'
						}, {
							name : 'noLogin'
						}],
				proxy : {
					type : 'rest',
					url : '/BookStore/back/user/getUsers',
					reader : {
						type : 'json',
						root : 'user'
					}
				},
				autoLoad : true
			});
	Ext.define('bookModel', {
				extend : 'Ext.data.Model',
				fields : [{
							name : 'bookId'
						}, {
							name : 'categoryId',
							mapping : 'category.categoryId'
						}, {
							name : 'bookName'
						}, {
							name : 'author'
						}, {
							name : 'publisher'
						}, {
							name : 'publishDate'
						}, {
							name : 'ISBN'
						}, {
							name : 'fixedPrice'
						}, {
							name : 'currentPrice'
						}, {
							name : 'contentSummary'
						}, {
							name : 'image'
						}, {
							name : 'category',
							mapping : 'category.oneCategory'
						}, {
							name : 'collection',
							mapping : 'collectionNumber'
						}, {
							name : 'number'
						}]
			});
	var bookStore = Ext.create('Ext.data.Store', {
				storeId : 'bookStore',
				pageSize : 20,
				model : 'bookModel',
				proxy : {
					type : 'rest',
					url : '/BookStore/back/book/getAllBook',
					reader : {
						type : 'json',
						root : 'books',
						totalProperty : 'total'
					}
				},
				autoLoad : true
			});
	var bookSearchStore = Ext.create('Ext.data.Store', {
				storeId : 'bookSearchStore',
				pageSize : 5000,
				model : 'bookModel',
				proxy : {
					type : 'rest',
					url : '/BookStore/back/book/search',
					reader : {
						type : 'json',
						root : 'books',
						totalProperty : 'total'
					},
					actionMethods : {
						read : 'POST'
					}
				},
				autoLoad : true
			});
	var categoryStore = Ext.create('Ext.data.Store', {
				storeId : 'categoryStore',
				pageSize : 1000,
				fields : [{
							name : 'categoryId'
						}, {
							name : 'oneCategory'
						},{
							name:'bookNumber'
						}],
				proxy : {
					type : 'rest',
					url : '/BookStore/back/bookCategory/getCategory',
					reader : {
						type : 'json',
						root : 'bookCategory'
					}
				},
				autoLoad : true
			});
	Ext.define('salesModel', {
		extend : 'Ext.data.Model',
		fields : [{
					name : 'bookId'
				}, {
					name : 'bookName',
					mapping : 'book.bookName'
				},{
					name:'soldNumber'
				},{
					name:'nowNumber'
				},{
					name:'salesTime'
				}]
	});
	var salesStore = Ext.create('Ext.data.Store', {
		storeId : 'salesStore',
		pageSize : 20,
		model : 'salesModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/bookSales/getAllSales',
			reader : {
				type : 'json',
				root : 'bookSales'
			}
		},
		autoLoad : true
	});
	var salesSearchStore = Ext.create('Ext.data.Store', {
		storeId : 'salesSearchStore',
		pageSize : 5000,
		model : 'salesModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/bookSales/search',
			reader : {
				type : 'json',
				root : 'bookSales'
			},
			actionMethods : {
				read : 'POST'
			}
		},
		autoLoad : true
	});
	Ext.define('orderModel', {
		extend : 'Ext.data.Model',
		fields : [{
					name : 'orderId'
				}, {
					name : 'userId'
				},{
					name:'username',
					mapping : 'user.username'
				},{
					name:'address',
					mapping : 'deliveryAddress.address'
				},{
					name:'deliveryPerson',
					mapping : 'deliveryAddress.deliveryPerson'
				}, {
					name : 'postcode',
					mapping : 'deliveryAddress.postcode'
				},{
					name:'phone',
					mapping : 'deliveryAddress.phone'
				},{
					name:'ispayed'
				},{
					name:'paymode'
				},{
					name : 'totalprice'
				},{
					name:'orderDate'
				},{
					name:'book'
				}]
	});
	var orderStore = Ext.create('Ext.data.Store', {
		storeId : 'orderStore',
		pageSize : 20,
		model : 'orderModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/order/getAllOrder',
			reader : {
				type : 'json',
				root : 'order'
			}
		},
		autoLoad : true
	});
	var orderSearchStore = Ext.create('Ext.data.Store', {
		storeId : 'orderSearchStore',
		pageSize : 5000,
		model : 'orderModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/order/search',
			reader : {
				type : 'json',
				root : 'order'
			},
			actionMethods : {
				read : 'POST'
			}
		},
		autoLoad : true
	});
	var orderBookStore = Ext.create('Ext.data.Store', {
		storeId : 'orderBookStore',
		model : 'bookModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/order/getBooksByOrderId',
			reader : {
				type : 'json',
				root : 'books'
			}
		},
		autoLoad : true
	});
	Ext.define('appraiseModel', {
	extend : 'Ext.data.Model',
	fields : [{
				name : 'orderId'
			}, {
				name : 'bookId'
			},{
				name : 'userId',
				mapping : 'user.userId'
			}, {
				name : 'username',
				mapping : 'user.username'
			},{
				name:'bookName',
				mapping : 'book.bookName'
			},{
				name:'starLevel'
			},{
				name:'appraiseGrade'
			}, {
				name : 'appraiseContent'
			},{
				name:'mallAnswer'
			},{
				name:'appraiseTime'
			}]
	});
	var appraiseStore = Ext.create('Ext.data.Store', {
		storeId : 'appraiseStore',
		pageSize : 20,
		model : 'appraiseModel',
		proxy : {
			type : 'rest',
			url : '/BookStore/back/appraise/allAppraise',
			reader : {
				type : 'json',
				root : 'appraises',
				totalProperty : 'total'
			}
		},
		autoLoad : true
	});

	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [{
					region : 'north',
					html : '<h1 class="x-panel-header">&nbsp;&nbsp;&nbsp;&nbsp;图书商城系统后台管理平台</h1>',
					border : false,
					bodyStyle : "background:#E8F2FE; padding:10px;",
					margins : '0 0 5 0'
				}, {
					region : 'west',
					collapsible : true,
					title : '目录',
					width : 180,
					xtype : "treepanel",
					rootVisible : false,
					root : {
						children : [{
									text : "用户管理",
									leaf : true
								}, {
									text : "图书管理",
									leaf : false,
									children : [{
												text : "图书信息管理",
												leaf : true
											}, {
												text : "图书类别管理",
												leaf : true
											}, {
												text : "图书销售管理",
												leaf : true
											}]
								}, {
									text : "订单管理",
									leaf : true
								}, {
									text : "评价管理",
									leaf : true
								}]
					},
					listeners : {
						itemclick : function(view, record, item, index, e,
								eOpts) {
							var main = Ext.getCmp("main");
							if (record.get("text") == "用户管理") {
								if (!main.getComponent("user")) {
									var user = Ext.create('Ext.grid.Panel', {
										title : '用户管理',
										id : 'user',
										tbar : [{
											xtype : 'button',
											text : '用户修改',
											handler : function() {
												var data = user
														.getSelectionModel()
														.getLastSelected();
												if (data) {
													var alterUserWindow = Ext
															.create(
																	'Ext.window.Window',
																	{
																		title : '修改用户信息',
																		layout : "column",
																		border : false,
																		resizable : false,
																		width : 410,
																		height : 310,
																		modal : true,
																		items : [
																				{
																					bodyPadding : 5,
																					width : 400,
																					height : 270,
																					xtype : 'form',
																					url : '/BookStore/back/user/alterUser',
																					layout : 'anchor',
																					defaults : {
																						anchor : '100%'
																					},
																					defaultType : 'textfield',
																					items : [
																							{
																								fieldLabel : '用户编号',
																								name : 'userId',
																								readOnly : true,
																								value : data
																										.get("userId")
																							},
																							{
																								fieldLabel : '用&nbsp;&nbsp;户&nbsp;名',
																								name : 'username',
																								readOnly : true,
																								value : data
																										.get("username")
																							},
																							{
																								fieldLabel : '姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名',
																								name : 'name',
																								value : data
																										.get("name"),
																								allowBlank : false,
																								maxLength : 5,
																								maxLengthText : '请输入真实姓名'
																							},
																							{
																								fieldLabel : '性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别',
																								name : 'sex',
																								xtype : 'fieldcontainer',
																								defaultType : 'radiofield',
																								defaults : {
																									flex : 1
																								},
																								layout : 'hbox',
																								items : [
																										{
																											boxLabel : '男',
																											name : 'sex',
																											inputValue : '0',
																											id : 'radio1',
																											checked : data
																													.get("sex") == '0'
																													? true
																													: false
																										},
																										{
																											boxLabel : '女',
																											name : 'sex',
																											inputValue : '1',
																											id : 'radio2',
																											checked : data
																													.get("sex") == '1'
																													? true
																													: false
																										}],
																								allowBlank : false
																							},
																							{
																								fieldLabel : '邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱',
																								name : 'email',
																								value : data
																										.get("email"),
																								allowBlank : false,
																								vtype : 'email',
																								vtypeText : '邮箱格式不正确',
																								maxLength : 80,
																								maxLengthText : '邮箱不能超过80个字符'
																							},
																							{
																								fieldLabel : '验证邮箱',
																								name : 'checkEmail',
																								xtype : 'fieldcontainer',
																								defaultType : 'radiofield',
																								defaults : {
																									flex : 1
																								},
																								layout : 'hbox',
																								items : [
																										{
																											boxLabel : '是',
																											name : 'checkEmail',
																											inputValue : '0',
																											checked : data
																													.get("checkEmail") == '0'
																													? true
																													: false,
																											id : 'radio3'
																										},
																										{
																											boxLabel : '否',
																											name : 'checkEmail',
																											inputValue : '1',
																											checked : data
																													.get("checkEmail") == '1'
																													? true
																													: false,
																											id : 'radio4'
																										}],
																								allowBlank : false
																							},
																							{
																								fieldLabel : '手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机',
																								name : 'phone',
																								value : data
																										.get("phone"),
																								allowBlank : false,
																								regex : /^\d{11}$/,
																								regexText : '手机号码不正确'
																							},
																							{
																								fieldLabel : '居&nbsp;&nbsp;住&nbsp;地',
																								name : 'address',
																								value : data
																										.get("address"),
																								allowBlank : false,
																								maxLength : 50,
																								maxLengthText : '居住地不能超过50个字符'
																							}],
																					buttons : [
																							{
																								text : '重置',
																								handler : function() {
																									this
																											.up('form')
																											.getForm()
																											.reset();
																								}
																							},
																							{
																								text : '提交',
																								formBind : true,
																								disabled : true,
																								handler : function() {
																									var form = this
																											.up('form')
																											.getForm();
																									if (form
																											.isValid()) {
																										form
																												.submit(
																														{
																															success : function(
																																	form,
																																	action) {
																																userStore
																																		.load();
																																alterUserWindow
																																		.close();
																															},
																															failure : function(
																																	form,
																																	action) {
																																Ext.Msg
																																		.alert(
																																				'提示',
																																				'用户信息修改失败！');
																															}
																														});
																									}
																								}
																							}]
																				}]
																	});
													alterUserWindow.show();
												} else {
													Ext.Msg.alert("提示",
															"请选中你要修改的用户信息！");
												}
											}
										}, '-', {
											xtype : 'button',
											text : '登录设置',
											handler : function() {
												var data = user
														.getSelectionModel()
														.getLastSelected();
												if (data) {
													if (data.get("noLogin") == "1") {
														Ext.Msg
																.confirm(
																		"提示",
																		"此操作将会禁止该用户登录系统，是否继续？",
																		function(
																				buttonId) {
																			if (buttonId == "yes") {
																				Ext.Ajax
																						.request(
																								{
																									url : '/BookStore/back/user/noLogin',
																									params : {
																										noLogin : 0,
																										userId : data
																												.get("userId")
																									},
																									success : function(
																											response,
																											opts) {
																										userStore
																												.load();
																									},
																									failure : function(
																											response,
																											opts) {
																										Ext.Msg
																												.alert(
																														"提示",
																														"设置失败！");
																									}
																								});
																			}
																		});
													} else {
														Ext.Msg
																.confirm(
																		"提示",
																		"此操作后该用户将有权限登录系统，是否继续？",
																		function(
																				buttonId) {
																			if (buttonId == "yes") {
																				Ext.Ajax
																						.request(
																								{
																									url : '/BookStore/back/user/noLogin',
																									params : {
																										noLogin : 1,
																										userId : data
																												.get("userId")
																									},
																									success : function(
																											response,
																											opts) {
																										userStore
																												.load();
																									},
																									failure : function(
																											response,
																											opts) {
																										Ext.Msg
																												.alert(
																														"提示",
																														"设置失败！");
																									}
																								});
																			}
																		});
													}
												} else {
													Ext.Msg.alert("提示",
															"请选中你要操作的用户信息！");
												}
											}
										}],
										columns : [{
													text : '用户编号',
													dataIndex : 'userId'
												}, {
													text : '用户名',
													dataIndex : 'username'
												}, {
													text : '姓名',
													dataIndex : 'name'
												}, {
													text : '性别',
													dataIndex : 'sex',
													renderer : function(value) {
														return value == "0"
																? "男"
																: "女";
													}
												}, {
													text : '邮箱',
													dataIndex : 'email',
													flex : 2
												}, {
													text : '验证邮箱',
													dataIndex : 'checkEmail',
													renderer : function(value) {
														return value == "0"
																? "是"
																: "否";
													}
												}, {
													text : '电话',
													dataIndex : 'phone'
												}, {
													text : '居住地',
													dataIndex : 'address',
													flex : 4
												}, {
													text : '头像',
													id : 'icon',
													dataIndex : 'icon',
													renderer : function(value) {
														return value == ""
																? ""
																: "<a style='color: red;cursor: pointer;height: 1px;margin-top: 0px;' href='/BookStore/image/"
																		+ value
																		+ "' target='_blank'>点击查看</a>";
													}
												}, {
													text : '禁止登录',
													dataIndex : 'noLogin',
													renderer : function(value) {
														return value == "0"
																? "是"
																: "否";
													}
												}],
										store : userStore,
										height : 200,
										width : 400,
										closable : true,
										bbar : Ext.create('Ext.PagingToolbar',
												{
													store : userStore,
													displayInfo : true,
													displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
													emptyMsg : "没有数据"
												})
									});
									main.add(user);
								}
								main.setActiveTab("user");
							} else if (record.get("text") == "图书信息管理") {
								if (!main.getComponent("book")) {
									var book = Ext.create('Ext.grid.Panel', {
										title : '图书信息管理',
										id : 'book',
										tbar : [{
											xtype : 'button',
											text : '添加',
											handler : function() {
												var addBookWindow = Ext.create(
														'Ext.window.Window', {
															title : '添加图书',
															layout : "column",
															border : false,
															resizable : false,
															width : 410,
															height : 415,
															modal : true,
															items : [{
																bodyPadding : 5,
																width : 400,
																height : 380,
																xtype : 'form',
																url : '/BookStore/back/book/addBook',
																layout : 'anchor',
																defaults : {
																	anchor : '100%'
																},
																defaultType : 'textfield',
																items : [{
																	fieldLabel : '书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名',
																	name : 'bookName',
																	allowBlank : false,
																	maxLength : 30,
																	maxLengthText : '书名不能超过30个字符'
																}, {
																	fieldLabel : '作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者',
																	name : 'author',
																	allowBlank : false,
																	maxLength : 30,
																	maxLengthText : '作者不能超过30个字符'
																}, {
																	fieldLabel : '出&nbsp;&nbsp;版&nbsp;社',
																	name : 'publisher',
																	allowBlank : false,
																	maxLength : 20,
																	maxLengthText : '出版社不能超过20个字符'
																}, {
																	fieldLabel : '出版日期',
																	xtype : 'datefield',
																	name : 'publishDate',
																	format : "Y-m-d",
																	allowBlank : false
																}, {
																	fieldLabel : 'ISBN&nbsp;&nbsp;号',
																	name : 'ISBN',
																	allowBlank : false,
																	regex : /^\d{13}$/,
																	regexText : 'ISBN号不正确'
																}, {
																	fieldLabel : '类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别',
																	name : 'categoryId',
																	hiddenName : 'oneCategory',
																	xtype : 'combobox',
																	displayField : 'oneCategory',
																	valueField : 'categoryId',
																	allowBlank : false,
																	queryMode : 'local',
																	store : categoryStore,
																	editable : false
																}, {
																	fieldLabel : '定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价',
																	name : 'fixedPrice',
																	allowBlank : false,
																	regex : /^\d{1,5}\.{0,1}\d{0,2}$/,
																	regexText : '定价格式不正确'
																}, {
																	fieldLabel : '现&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价',
																	name : 'currentPrice',
																	allowBlank : false,
																	regex : /^\d{1,5}\.{0,1}\d{0,2}$/,
																	regexText : '现价格式不正确'
																}, {
																	fieldLabel : '进购数量',
																	name : 'number',
																	allowBlank : false,
																	regex : /^\d{1,8}$/,
																	regexText : '进购数量格式不正确'
																}, {
																	fieldLabel : '内容简介',
																	xtype : 'textarea',
																	name : 'contentSummary',
																	allowBlank : false
																}],
																buttons : [{
																	text : '重置',
																	handler : function() {
																		this
																				.up('form')
																				.getForm()
																				.reset();
																	}
																}, {
																	text : '提交',
																	formBind : true,
																	disabled : true,
																	handler : function() {
																		var form = this
																				.up('form')
																				.getForm();
																		if (form
																				.isValid()) {
																			form
																					.submit(
																							{
																								success : function(
																										form,
																										action) {
																									bookStore
																											.load();
																									addBookWindow
																											.close();
																								},
																								failure : function(
																										form,
																										action) {
																									Ext.Msg
																											.alert(
																													'提示',
																													'图书添加失败！');
																								}
																							});
																		}
																	}
																}]
															}]
														});
												addBookWindow.show();
											}
										}, '-', {
											xtype : 'button',
											text : '修改',
											handler : function() {
												var data = book
														.getSelectionModel()
														.getLastSelected();
												if (data) {
													var alterBookWindow = Ext
															.create(
																	'Ext.window.Window',
																	{
																		title : '修改图书信息',
																		layout : "column",
																		border : false,
																		resizable : false,
																		width : 410,
																		height : 405,
																		modal : true,
																		items : [
																				{
																					bodyPadding : 5,
																					width : 400,
																					height : 370,
																					xtype : 'form',
																					url : '/BookStore/back/book/alterBook',
																					layout : 'anchor',
																					defaults : {
																						anchor : '100%'
																					},
																					defaultType : 'textfield',
																					items : [
																							{
																								fieldLabel : '图书编号',
																								name : 'bookId',
																								readOnly : true,
																								value : data
																										.get("bookId")
																							},
																							{
																								fieldLabel : '书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名',
																								name : 'bookName',
																								allowBlank : false,
																								maxLength : 30,
																								maxLengthText : '书名不能超过30个字符',
																								value : data
																										.get("bookName")
																							},
																							{
																								fieldLabel : '作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者',
																								name : 'author',
																								value : data
																										.get("author"),
																								allowBlank : false,
																								maxLength : 30,
																								maxLengthText : '作者不能超过30个字符'
																							},
																							{
																								fieldLabel : '出&nbsp;&nbsp;版&nbsp;社',
																								name : 'publisher',
																								value : data
																										.get("publisher"),
																								allowBlank : false,
																								maxLength : 20,
																								maxLengthText : '出版社不能超过20个字符'
																							},
																							{
																								fieldLabel : '出版日期',
																								xtype : 'datefield',
																								name : 'publishDate',
																								value : Ext.util.Format
																										.substr(
																												data
																														.get("publishDate"),
																												0,
																												10),
																								format : "Y-m-d",
																								allowBlank : false
																							},
																							{
																								fieldLabel : 'ISBN&nbsp;&nbsp;号',
																								name : 'ISBN',
																								value : data
																										.get("ISBN"),
																								allowBlank : false,
																								regex : /^\d{13}$/,
																								regexText : 'ISBN号不正确'
																							},
																							{
																								fieldLabel : '类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别',
																								name : 'categoryId',
																								hiddenName : 'oneCategory',
																								xtype : 'combobox',
																								displayField : 'oneCategory',
																								valueField : 'categoryId',
																								value : data
																										.get("categoryId"),
																								allowBlank : false,
																								queryMode : 'local',
																								store : categoryStore,
																								editable : false
																							},
																							{
																								fieldLabel : '定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价',
																								name : 'fixedPrice',
																								value : data
																										.get("fixedPrice"),
																								allowBlank : false,
																								regex : /^\d{1,5}\.{0,1}\d{0,2}$/,
																								regexText : '定价格式不正确'
																							},
																							{
																								fieldLabel : '现&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价',
																								name : 'currentPrice',
																								value : data
																										.get("currentPrice"),
																								allowBlank : false,
																								regex : /^\d{1,5}\.{0,1}\d{0,2}$/,
																								regexText : '现价格式不正确'
																							},
																							{
																								fieldLabel : '内容简介',
																								xtype : 'textarea',
																								name : 'contentSummary',
																								value : data
																										.get("contentSummary"),
																								allowBlank : false
																							}],
																					buttons : [
																							{
																								text : '重置',
																								handler : function() {
																									this
																											.up('form')
																											.getForm()
																											.reset();
																								}
																							},
																							{
																								text : '提交',
																								formBind : true,
																								disabled : true,
																								handler : function() {
																									var form = this
																											.up('form')
																											.getForm();
																									if (form
																											.isValid()) {
																										form
																												.submit(
																														{
																															success : function(
																																	form,
																																	action) {
																																bookStore
																																		.load();
																																alterBookWindow
																																		.close();
																															},
																															failure : function(
																																	form,
																																	action) {
																																Ext.Msg
																																		.alert(
																																				'提示',
																																				'图书信息修改失败！');
																															}
																														});
																									}
																								}
																							}]
																				}]
																	});
													alterBookWindow.show();
												} else {
													Ext.Msg.alert("提示",
															"请选中你要修改的图书信息！");
												}
											}
										}, '-', {
											xtype : 'button',
											text : '删除',
											handler : function() {
												var data = book
														.getSelectionModel()
														.getLastSelected();
												if (data) {
													Ext.Msg
															.confirm(
																	"提示",
																	"您确定要删除该图书吗？删除后该图书的评价、订单等信息将一并删除！是否继续？",
																	function(
																			buttonId) {
																		if (buttonId == "yes") {
																			Ext.Ajax
																					.request(
																							{
																								url : '/BookStore/back/book/deleteBook',
																								params : {
																									bookId : data
																											.get("bookId")
																								},
																								success : function(
																										response,
																										opts) {
																									bookLoad();
																								},
																								failure : function(
																										response,
																										opts) {
																									Ext.Msg
																											.alert(
																													"提示",
																													"设置失败！");
																								}
																							});
																		}
																	});
												} else {
													Ext.Msg.alert("提示",
															"请选中你要删除的图书！");
												}
											}
										}, '->', {
											id : 'bookKeyword',
											xtype : 'textfield',
											width : 210,
											emptyText : "书名、作者、ISBN号或出版社",
											listeners : {
												specialkey : function(field, e) {
													if (e.getKey() == e.ENTER) {
														bookLoad();
													}
												}
											}
										}, {
											xtype : 'button',
											text : '搜索',
											handler : function() {
												bookLoad();
											}
										}],
										columns : [{
													text : '图书编号',
													dataIndex : 'bookId'
												}, {
													text : '书名',
													dataIndex : 'bookName'
												}, {
													text : '作者',
													dataIndex : 'author'
												}, {
													text : '出版社',
													dataIndex : 'publisher'
												}, {
													text : '出版日期',
													dataIndex : 'publishDate',
													renderer : function(value) {
														var date = new Date(value);
														return Ext.Date.format(
																date, "Y-m-d");
													}
												}, {
													text : 'ISBN号',
													dataIndex : 'ISBN'
												}, {
													text : '定价',
													dataIndex : 'fixedPrice'
												}, {
													text : '现价',
													dataIndex : 'currentPrice'
												}, {
													text : '内容简介',
													id : 'contentSummary',
													dataIndex : 'contentSummary',
													flex : 2,
													renderer : function(value) {
														return "<p style='color: blue;cursor: pointer;height: 1px;margin-top: 0px;'>"
																+ value
																+ "</p>";
													}
												}, {
													text : '图片',
													id : 'image',
													dataIndex : 'image',
													renderer : function(value) {
														return "<p style='color: red;cursor: pointer;height: 1px;margin-top: 0px;'>点击编辑</p>";
													}
												}, {
													text : '类别',
													dataIndex : 'category'
												}, {
													text : '收藏人数',
													dataIndex : 'collection'
												}],
										height : 200,
										width : 400,
										closable : true,
										store : bookStore,
										bbar : Ext.create('mypagingtoolbar', {
											id : 'bookBbar',
											store : bookStore,
											displayInfo : true,
											displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
											emptyMsg : "没有数据"
										})
									});
									main.add(book);
									Ext.getCmp("contentSummary").on("click",
											function() {
												var contentSummary = book
														.getSelectionModel()
														.getLastSelected()
														.get("contentSummary");
												if (contentSummary != "") {
													var contentSummaryWindow = Ext
															.create(
																	'Ext.window.Window',
																	{
																		title : '内容简介',
																		layout : 'column',
																		border : false,
																		width : 400,
																		height : 320,
																		modal : true,
																		maximizable : true,
																		html : contentSummary
																	});
													contentSummaryWindow.show();
												}
											});
									Ext.getCmp("image").on("click", function() {
										var data = book.getSelectionModel()
												.getLastSelected();
										var image = data.get("image");
										var imageWindow = Ext.create(
												'Ext.window.Window', {
													title : image,
													layout : 'column',
													border : false,
													width : 360,
													height : 570,
													modal : true,
													items : [{
														xtype : 'component',
														id : 'windowImage',
														width : 350,
														height : 450,
														autoEl : {
															tag : 'img',
															src : '/BookStore/image/'
																	+ image
																	+ ''
														}
													}, {
														bodyPadding : 5,
														width : 350,
														height : 100,
														xtype : 'form',
														frame : true,
														url : 'back/book/uploadImage',
														layout : 'anchor',
														defaults : {
															anchor : '100%'
														},
														items : [{
															xtype : 'filefield',
															id : 'imageFile',
															name : 'imageFile',
															fieldLabel : '图片',
															margin : '10,0,0,0',
															labelWidth : 30,
															width : 195,
															allowBlank : false,
															msgTarget : 'side',
															anchor : '100%',
															buttonText : '选择'
														}],
														buttons : [{
															text : '上传图片',
															xtype : 'button',
															margin : '10,0,0,0',
															handler : function() {
																var form = this
																		.up('form')
																		.getForm();
																if (form
																		.isValid()) {
																	form
																			.submit(
																					{
																						waitMsg : '上传中...',
																						params : {
																							bookId : data
																									.get("bookId")
																						},
																						success : function(
																								fp,
																								o) {
																							var value = Ext
																									.getCmp("imageFile").value;
																							data
																									.set(
																											"image",
																											value);
																							imageWindow
																									.setTitle(value);
																							Ext
																									.getCmp("windowImage")
																									.getEl().dom.src = '/BookStore/image/'
																									+ value
																									+ ''
																						},
																						failure : function(
																								fp,
																								o) {
																							Ext.Msg
																									.alert(
																											"提示",
																											"上传失败！上传的图片不能大于5M！支持的图片格式为‘image/bmp,image/png,image/gif,image/jpeg’！");
																						}
																					});
																}
															}
														}, {
															margin : '10,0,0,0',
															xtype : 'button',
															text : '删除图片',
															handler : function() {
																if (data
																		.get("image") != "") {
																	Ext.Msg
																			.confirm(
																					"提示",
																					"是否删除该图片？",
																					function(
																							buttonId) {
																						if (buttonId == "yes") {
																							Ext.Ajax
																									.request(
																											{
																												url : '/BookStore/back/book/deleteImage',
																												params : {
																													bookId : data
																															.get("bookId")
																												},
																												success : function(
																														response,
																														opts) {
																													data
																															.set(
																																	"image",
																																	"");
																													Ext
																															.getCmp("windowImage")
																															.getEl().dom.src = ''
																													imageWindow
																															.setTitle('');
																												},
																												failure : function(
																														response,
																														opts) {
																													Ext.Msg
																															.alert(
																																	"提示",
																																	"图片删除失败！");
																												}
																											});
																						}
																					});
																}
															}
														}]
													}]
												});
										imageWindow.show();
									});
								}
								bookStore.load();
								Ext.getCmp("book").reconfigure(bookStore);
								Ext.getCmp("bookBbar").bindStore(bookStore);
								Ext.getCmp("bookBbar").doRefresh();
								main.setActiveTab("book");
							} else if (record.get("text") == "图书类别管理") {
								if (!main.getComponent("bookCategory")) {
									var bookCategory = Ext.create(
											'Ext.grid.Panel', {
												title : '图书类别管理',
												id : 'bookCategory',
												tbar : [{
															text : '新增类别',
															handler : function(){
																Ext.Msg.prompt('提示', '输入类别名:', function(btn, text){
																    if (btn == 'ok'){
																        Ext.Ajax.request(
																			{
																				url : '/BookStore/back/bookCategory/addCategory',
																				params : {
																					oneCategory : text
																				},
																				success : function(response,opts) {
																					categoryStore.load();
																				},
																				failure : function(response,opts) {
																					Ext.Msg.alert("提示","类别添加失败！");
																				}
																			});
																    }
																});
															}
														},'-', {
															text : '修改类别',
															handler : function(){
																var category=bookCategory.getSelectionModel().getLastSelected();
																if(category){
																	Ext.Msg.prompt('提示', '输入类别名:', function(btn, text){
																    if (btn == 'ok'){
																        Ext.Ajax.request(
																			{
																				url : '/BookStore/back/bookCategory/alterCategory',
																				params : {
																					categoryId : category.get("categoryId"),
																					oneCategory : text
																				},
																				success : function(response,opts) {
																					categoryStore.load();
																				},
																				failure : function(response,opts) {
																					Ext.Msg.alert("提示","类别修改失败！");
																				}
																			});
																    }
																});
																}else{
																	Ext.Msg.alert("提示","请选中你要修改的类别！");
																}
															}
														},'-', {
															text : '删除类别',
															handler : function(){
																var category=bookCategory.getSelectionModel().getLastSelected();
																if(category){
																	Ext.Msg.confirm("提示","此操作将会删除该类别以及该类别下的所有图书！请谨慎操作！是否继续？",function(buttonId) {
																			if (buttonId == "yes") {
																				Ext.Ajax.request(
																				{
																					url : '/BookStore/back/bookCategory/deleteCategory',
																					params : {
																						categoryId : category.get("categoryId")
																					},
																					success : function(response,opts) {
																						categoryStore.load();
																					},
																					failure : function(response,opts) {
																						Ext.Msg.alert("提示","类别删除失败！");
																					}
																				});
																			}
																		});
																}else{
																	Ext.Msg.alert("提示","请选中你要删除的类别！");
																}
															}
														}],
												store : categoryStore,
												columns : [{
															text : '类别编号',
															dataIndex : 'categoryId',
															flex : 1
														}, {
															text : '类别名',
															dataIndex : 'oneCategory',
															flex : 2
														}, {
															text : '图书数量',
															dataIndex : 'bookNumber',
															flex : 1
														}],
												height : 200,
												width : 400,
												closable : true,
												bbar : Ext.create('Ext.PagingToolbar', {
													store : categoryStore,
													displayInfo : true,
													displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
													emptyMsg : "没有数据"
												})
											});
									main.add(bookCategory);
								}
								main.setActiveTab("bookCategory");
							} else if (record.get("text") == "图书销售管理") {
								if (!main.getComponent("bookSales")) {
									var bookSales = Ext.create(
											'Ext.grid.Panel', {
												title : '图书销售管理',
												id : 'bookSales',
												tbar : [{
															text : '修改库存数量',
															handler : function(){
																var sales=bookSales.getSelectionModel().getLastSelected();
																if(sales){
																	Ext.Msg.prompt('提示', '输入进货量:', function(btn, text){
																	    if (btn == 'ok'){
																	    	if(parseInt(text)){
																	    		Ext.Ajax.request(
																				{
																					url : '/BookStore/back/bookSales/alterNumber',
																					params : {
																						bookId : sales.get("bookId"),
																						nowNumber : parseInt(text)+parseInt(sales.get("nowNumber"))
																					},
																					success : function(response,opts) {
																						salesLoad();
																					},
																					failure : function(response,opts) {
																						Ext.Msg.alert("提示","库存数量修改失败！");
																					}
																				});
																	    	}else{
																	    		Ext.Msg.alert("提示","输入数值非法！");
																	    	}
																		}
																	});
																}else{
																	Ext.Msg.alert("提示","请选中你要修改的列！");
																}
															}
														}, '->',
														{
													id : 'salesKeyword',
													xtype : 'textfield',
													width : 210,
													emptyText : "图书编号、书名",
													listeners : {
														specialkey : function(field, e) {
															if (e.getKey() == e.ENTER) {
																salesLoad();
															}
														}
													}
												}, {
													xtype : 'button',
													text : '搜索',
													handler : function() {
														salesLoad();
													}
												}],
												store : salesStore,
												columns : [{
															text : '图书编号',
															dataIndex : 'bookId',
															flex : 1
														}, {
															text : '书名',
															dataIndex : 'bookName',
															flex : 2
														}, {
															text : '已售数量',
															dataIndex : 'soldNumber',
															flex : 1
														}, {
															text : '现存数量',
															dataIndex : 'nowNumber',
															flex : 1
														}, {
															text : '上架时间',
															dataIndex : 'salesTime',
															renderer : function(value) {
																var date = new Date(value);
																return Ext.Date.format(
																		date, "Y-m-d H:i:s");
															},
															flex : 1
														}],
												height : 200,
												width : 400,
												closable : true,
												bbar : Ext.create('mypagingtoolbar', {
													id : 'salesBbar',
													store : salesStore,
													displayInfo : true,
													displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
													emptyMsg : "没有数据"
												})
											});
									main.add(bookSales);
								}
								salesStore.load();
								Ext.getCmp("bookSales").reconfigure(salesStore);
								Ext.getCmp("salesBbar").bindStore(salesStore);
								Ext.getCmp("salesBbar").doRefresh();
								main.setActiveTab("bookSales");
							} else if (record.get("text") == "订单管理") {
								if (!main.getComponent("order")) {
									var order = Ext.create('Ext.grid.Panel', {
										title : '订单管理',
										id : 'order',
										tbar : [{
													text : '修改订单',
													handler : function() {
													var data = order
															.getSelectionModel()
															.getLastSelected();
													if (data) {
														var alterOrderWindow = Ext
																.create(
																		'Ext.window.Window',
																		{
																			title : '修改订单信息',
																			layout : "column",
																			border : false,
																			resizable : false,
																			width : 400,
																			height : 250,
																			modal : true,
																			items : [
																					{
																						bodyPadding : 5,
																						width : 390,
																						height : 210,
																						xtype : 'form',
																						url : '/BookStore/back/order/alterOrder',
																						layout : 'anchor',
																						defaults : {
																							anchor : '100%'
																						},
																						defaultType : 'textfield',
																						items : [
																								{
																									fieldLabel : '订单编号',
																									name : 'orderId',
																									readOnly : true,
																									value : data
																											.get("orderId")
																								},{
																									fieldLabel : '用户编号',
																									name : 'userId',
																									readOnly : true,
																									xtype:'hidden',
																									value : data
																											.get("userId")
																								},
																								{
																									fieldLabel : '用&nbsp;&nbsp;户&nbsp;名',
																									name : 'username',
																									readOnly : true,
																									value : data
																											.get("username")
																								},
																								{
																									fieldLabel : '收&nbsp;&nbsp;货&nbsp;人',
																									name : 'deliveryPerson',
																									value : data
																											.get("deliveryPerson"),
																									allowBlank : false,
																									maxLength : 5,
																									maxLengthText : '收货人不正确'
																								},
																								{
																									fieldLabel : '收货地址',
																									name : 'address',
																									value : data
																											.get("address"),
																									allowBlank : false,
																									maxLength : 50,
																									maxLengthText : '收货地址不能超过50个字符'
																								},
																								{
																									fieldLabel : '邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编',
																									name : 'postcode',
																									value : data
																											.get("postcode"),
																									allowBlank : false,
																									regex : /^\d{6}$/,
																									regexText : '邮编不正确'
																								},
																								{
																									fieldLabel : '联系电话',
																									name : 'phone',
																									value : data
																											.get("phone"),
																									allowBlank : false,
																									regex : /^\d{11}$/,
																									regexText : '手机号码不正确'
																								}],
																						buttons : [
																								{
																									text : '重置',
																									handler : function() {
																										this
																												.up('form')
																												.getForm()
																												.reset();
																									}
																								},
																								{
																									text : '提交',
																									formBind : true,
																									disabled : true,
																									handler : function() {
																										var form = this
																												.up('form')
																												.getForm();
																										if (form
																												.isValid()) {
																											form
																													.submit(
																															{
																																success : function(
																																		form,
																																		action) {
																																	orderStore
																																			.load();
																																	alterOrderWindow
																																			.close();
																																},
																																failure : function(
																																		form,
																																		action) {
																																	Ext.Msg
																																			.alert(
																																					'提示',
																																					'订单信息修改失败！');
																																}
																															});
																										}
																									}
																								}]
																					}]
																		});
														alterOrderWindow.show();
													} else {
														Ext.Msg.alert("提示",
																"请选中你要修改的订单信息！");
													}
												}
												},'-', {
													text : '删除订单',
													handler : function(){
																var data=order.getSelectionModel().getLastSelected();
																if(data){
																	Ext.Msg.confirm("提示","此操作将会删除该订单以及该订单的评价信息！请谨慎操作！是否继续？",function(buttonId) {
																			if (buttonId == "yes") {
																				Ext.Ajax.request(
																				{
																					url : '/BookStore/back/order/delete',
																					params : {
																						orderId : data.get("orderId")
																					},
																					success : function(response,opts) {
																						orderLoad();
																					},
																					failure : function(response,opts) {
																						Ext.Msg.alert("提示","订单删除失败！");
																					}
																				});
																			}
																		});
																}else{
																	Ext.Msg.alert("提示","请选中你要删除的订单！");
																}
															}
												}, '->',
														{
													id : 'orderKeyword',
													xtype : 'textfield',
													width : 300,
													emptyText : "订单编号、用户编号、用户名、联系电话或订单日期",
													listeners : {
														specialkey : function(field, e) {
															if (e.getKey() == e.ENTER) {
																orderLoad();
															}
														}
													}
												}, {
													xtype : 'button',
													text : '搜索',
													handler : function() {
														orderLoad();
													}
												}],
										store : Ext.data.StoreManager
												.lookup('orderStore'),
										columns : [{
													text : '订单编号',
													dataIndex : 'orderId',
													id:'orderId'
												}, {
													text : '用户编号',
													dataIndex : 'userId'
												}, {
													text : '用户名',
													dataIndex : 'username'
												}, {
													text : '收货地址',
													dataIndex : 'address',
													flex : 1
												}, {
													text : '收货人',
													dataIndex : 'deliveryPerson'
												}, {
													text : '邮编',
													dataIndex : 'postcode'
												}, {
													text : '联系电话',
													dataIndex : 'phone'
												}, {
													text : '是否付款',
													dataIndex : 'ispayed',
													renderer : function(value) {
														return value == "0"
																? "是"
																: "否";
													}
												}, {
													text : '付款方式',
													dataIndex : 'paymode'
												}, {
													text : '总价',
													dataIndex : 'totalprice'
												}, {
													text : '订单日期',
													dataIndex : 'orderDate',
													renderer : function(value) {
																var date = new Date(value);
														return Ext.Date.format(
																date,
																"Y-m-d H:i:s");
																}
												}, {
													text : '图书详情',
													id:'bookDetail',
													dataIndex : 'book',
													renderer : function(value) {
														return "<p style='color: red;cursor: pointer;height: 1px;margin-top: 0px;'>查看</p>";
													}
												}],
										height : 200,
										width : 400,
										closable : true,
										bbar : Ext.create('mypagingtoolbar', {
													id : 'orderBbar',
													store : orderStore,
													displayInfo : true,
													displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
													emptyMsg : "没有数据"
												})
									});
									main.add(order);
								}
								Ext.getCmp("bookDetail").on("click", function() {
										var order = Ext.getCmp("order").getSelectionModel()
												.getLastSelected();
										orderBookLoad();
										var bookDetailWindow = Ext.create(
												'Ext.window.Window', {
													title : '图书详情',
													layout : 'fit',
													border : false,
													width : 760,
													height : 360,
													modal : true,
													items:[{
														xtype : 'gridpanel',
														width : 755,
														height : 355,
														id : 'bookDetailGrid',
														columns : [{
																text : '图书编号',
																dataIndex : 'bookId'
															}, {
																text : 'ISBN号',
																dataIndex : 'ISBN'
															}, {
																text : '书名',
																dataIndex : 'bookName',
																flex : 1
															}, {
																text : '作者',
																dataIndex : 'author'
															}, {
																text : '出版社',
																dataIndex : 'publisher'
															}, {
																text : '现价',
																dataIndex : 'currentPrice'
															},{
																text : '购买数量',
																dataIndex : 'number'
															}],
															store : orderBookStore
														}]
												});
										bookDetailWindow.show();
									});
								orderStore.load();
								Ext.getCmp("order").reconfigure(orderStore);
								Ext.getCmp("orderBbar").bindStore(orderStore);
								Ext.getCmp("orderBbar").doRefresh();
								main.setActiveTab("order");
							} else if (record.get("text") == "评价管理") {
								if (!main.getComponent("appraise")) {
									var appraise = Ext.create('Ext.grid.Panel',
											{
												title : '评价管理',
												id : 'appraise',
												tbar : [ {
															text : '回复评价'
														},'-', {
															text : '删除评价'
														}],
												store : Ext.data.StoreManager
														.lookup('appraiseStore'),
												columns : [{
															text : '订单编号',
															dataIndex : 'orderId'
														}, {
															text : '图书编号',
															dataIndex : 'bookId'
														}, {
															text : '用户编号',
															dataIndex : 'userId'
														}, {
															text : '用户名',
															dataIndex : 'username',
															flex : 1
														},{
															text : '书名',
															dataIndex : 'bookName',
															flex : 1
														}, {
															text : '星级',
															dataIndex : 'starLevel'
														}, {
															text : '评价等级',
															dataIndex : 'appraiseGrade',
															renderer:function(value){
																if(value=="1"){
																	return "差评";
																}else if(value=="2"){
																	return "中评";
																}else if(value=="3"){
																	return  "好评";
																}
															}
														}, {
															text : '评价内容',
															dataIndex : 'appraiseContent',
															flex : 2
														}, {
															text : '商城回复',
															dataIndex : 'mallAnswer',
															flex : 2
														}, {
															text : '评价日期',
															dataIndex : 'appraiseTime',
															flex : 1,
															renderer : function(value) {
															var date = new Date(value);
																return Ext.Date.format(
																		date,
																		"Y-m-d H:i:s");
															}
														}],
												height : 200,
												width : 400,
												closable : true,
												bbar : Ext.create('mypagingtoolbar', {
													id : 'appraiseBbar',
													store : appraiseStore,
													displayInfo : true,
													displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
													emptyMsg : "没有数据"
												})
											});
									main.add(appraise);
								}
								main.setActiveTab("appraise");
							}
						}
					}
				}, {
					region : 'center',
					xtype : 'tabpanel',
					activeTab : 0,
					id : 'main'
				}]
	});
};
Ext.onReady(frame);
function bookLoad() {
	var keyword = Ext.getCmp("bookKeyword").value;
	if (keyword != "") {
		var bookSearchStore= Ext.data.StoreManager.lookup('bookSearchStore');
		bookSearchStore.load({
					params : {
						keyword : keyword
					}
				});
		Ext.getCmp("book").reconfigure(bookSearchStore);
		Ext.getCmp("bookBbar").bindStore(bookSearchStore);
	}
}
function salesLoad() {
	var keyword = Ext.getCmp("salesKeyword").value;
	if (keyword != "") {
		var salesSearchStore= Ext.data.StoreManager.lookup('salesSearchStore');
		salesSearchStore.load({
					params : {
						keyword : keyword
					}
				});
		Ext.getCmp("bookSales").reconfigure(salesSearchStore);
		Ext.getCmp("salesBbar").bindStore(salesSearchStore);
	}
}
function orderLoad() {
	var keyword = Ext.getCmp("orderKeyword").value;
	if (keyword != "") {
		var orderSearchStore= Ext.data.StoreManager.lookup('orderSearchStore');
		orderSearchStore.load({
					params : {
						keyword : keyword
					}
				});
		Ext.getCmp("order").reconfigure(orderSearchStore);
		Ext.getCmp("orderBbar").bindStore(orderSearchStore);
	}
}
function orderBookLoad() {
	var orderId = Ext.getCmp("order").getSelectionModel().getLastSelected().get("orderId");
	if (orderId != "") {
		var orderBookStore= Ext.data.StoreManager.lookup('orderBookStore');
		orderBookStore.load({
					params : {
						orderId : orderId
					}
				});
	}
}