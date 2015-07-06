Ext.onReady(function() {
			var loginForm = Ext.create('Ext.form.Panel', {
						xtype : 'form',
						id : 'loginForm',
						title : '登录',
						frame : true,
						width : 300,
						height : 180,
						border : false,
						defaultType : 'textfield',
						defaults : {
							anchor : '100%'
						},

						items : [{
									allowBlank : false,
									fieldLabel : '账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号',
									labelWidth : '6',
									id : 'username',
									name : 'username',
									margin : '10 10 10 10'
								}, {
									allowBlank : false,
									fieldLabel : '密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码',
									labelWidth : '6',
									name : 'password',
									margin : '20 10 10 10',
									id : 'password',
									inputType : 'password',
									listeners : {
										specialkey : function(field, e) {
											if (e.getKey() == e.ENTER) {
												login();
											}
										}
									}
								}],

						buttons : [{
									text : '重置',
									margin : '20 5 1 10',
									handler : function() {
										this.up('form').getForm().reset();
									}
								}, {
									text : '登录',
									type : 'submit',
									margin : '20 10 1 10',
									id : 'login',
									handler : login
								}]
					});
			function login() {
				var username = Ext.get("username").value;
				var password = Ext.get("password").value;
				// 验证合法后使用加载进度条
				if (loginForm.form.isValid()) {
					// 提交到服务器操作
					loginForm.form.submit({
								waitMsg : '正在进行登录验证,请稍后...',
								url : 'back/user/loginAdmin',
								method : 'post',
								standardSubmit : true,
								params : {
									username : username,
									password : password
								},
								// 提交失败的回调函数
								failure : function(form, action) {
									switch (action.failureType) {
										case Ext.form.Action.CLIENT_INVALID :
											Ext.Msg.alert('错误提示',
													'表单数据非法请核实后重新输入！');
											break;
										case Ext.form.Action.CONNECT_FAILURE :
											Ext.Msg.alert('错误提示', '网络连接异常！');
											break;
										case Ext.form.Action.SERVER_INVALID :
											Ext.Msg.alert('错误提示',
													"您的输入用户信息有误，请核实后重新输入！");
											loginForm.form.reset();
									}
								}
							});
				}
			}
			var win = new Ext.Window({
				id : 'win',
				layout : 'fit', // 自适应布局
				align : 'center',
				width : 300,
				height : 180,
				resizable : false,
				draggable : false,
				border : false,
				maximizable : false,// 禁止最大化
				closeAction : 'close',
				closable : false,// 禁止关闭,
				items : loginForm
					// 将表单作为窗体元素嵌套布局
				});
			win.show();// 显示窗体
		});