(function(global) {
	'use strict'
	var APP = {
		environment: 'prd'
	};
	// 生产环境
	APP.production = {
		// 请求后台接口的基本地址
		baseURI: 'https://rsb.qianpapa.com.cn',
		// CDN域名（静态资源）
		CDN: 'https://b.qianpapa.com.cn',
		// 404页面
		errorUrl: 'https://b.qianpapa.com.cn/station/activity/common/error/index.html',
		// 公钥
		pKey: 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGDTI8/oBklUDPNKGOrKFGdLQuJZien2kXi5e3HaMivY/I/Q6CZcO3m3rXjJAzhfPXnAEPbfg1Kw9Ndd1mKRqn/0EdtF4zsoBfJHsVzg3/eb+2OEdmDvqf5OXzOn1i9AANwz8iCgkabzwrUF/RnQ7zYWw+EwkBFi2d0FAttDGWjQIDAQAB'
	};
	// 测试环境
	APP.development = {
		baseURI: 'https://rsb-stg.qianpapa.com.cn',
		CDN: 'https://b.qianpapa.com.cn',
		errorUrl: 'https://b.qianpapa.com.cn/station/activity/common/error/index.html',
		// 公钥
		pKey: 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZUO0B02dC/Bw+KdVb00EEneUffqIpDRK6uNjtuVjxfMi+NiRHRSZLfH4/5jCU+Hd3+Y5Kr46v2bnK4Iq7dpiLSicyvDIYcqZYNPdUnYpUs6Oa/HDatkxXhOjvbeIN1hxkwBCoTARBPuBNgJc9N+GNtEjrRROX5mGa9HykT2/ARQIDAQAB'
	};
	// 强制使用域名适配环境
	if (/10|127|localhost|stg|p1|test/.test(location.hostname)) {
		APP.environment = 'stg';
	} else {
		APP.environment = 'prd';
	}
	//判断微信环境
	var ua = navigator.userAgent.toLowerCase();
	if (ua.match(/MicroMessenger/i) == "micromessenger") {
		APP.successUrl = 'wxsuccess.html'
		APP.failUrl = 'wxfail.html'
	} else {
		APP.successUrl = 'loansuccess.html'
		APP.failUrl = 'loanfail.html'
	}
	switch (APP.environment) {
		case 'stg':
			APP.config = APP.development;
			APP.pKey = APP.development.pKey;
			break
		default:
			APP.config = APP.production;
			APP.pKey = APP.production.pKey;
			break
	}
	global.APP = APP;
})(window);
(function() {
	var channel = [{
		description: '综合贷款H5版',
		loanType: '02'
	}, {
		description: '综合贷款PC版',
		loanType: '02'
	}, {
		description: '新一贷H5版',
		loanType: '02'
	}, {
		description: '新一贷H5版额度测试',
		loanType: '02'
	}, {
		description: '新一贷PC版',
		loanType: '02'
	}, {
		description: '车主贷H5版',
		loanType: '01'
	}, {
		description: '车主贷PC版',
		loanType: '01'
	}, {
		description: '新一贷H5版A面',
		loanType: '02'
	}, {
		description: '新一贷H5版B面',
		loanType: '02'
	}, {
		description: '新一贷PC版A面',
		loanType: '02'
	}, {
		description: '新一贷PC版B面',
		loanType: '02'
	}, {
		description: '新一贷H5版C面',
		loanType: '02'
	}, {
		description: '新一贷H5版D面',
		loanType: '02'
	}, {
		description: '新一贷H5版E面',
		loanType: '02'
	}, {
		description: '新一贷H5版F面',
		loanType: '02'
	}, {
		description: '新一贷H5版G面',
		loanType: '02'
	}, {
		description: '新一贷H5版S面',
		loanType: '02'
	}, {
		description: '数据上传',
		loanType: '02'
	}, {
		description: '车主贷数据上传',
		loanType: '01'
	}, {
		description: '新一贷H5版J面',
		loanType: '02'
	}, {
		description: '新一贷H5版K面',
		loanType: '02'
	}, {
		description: '车主贷H5版A面',
		loanType: '01'
	}, {
		description: '车主贷H5版B面',
		loanType: '01'
	}, {
		description: '车主贷H5版C面',
		loanType: '01'
	}, {
		description: '车主贷H5版D面',
		loanType: '01'
	}, {
		description: '车主贷H5版E面',
		loanType: '01'
	}, {
		description: '车主贷H5版F面',
		loanType: '01'
	}, {
		description: '车主贷H5版G面',
		loanType: '01'
	}, {
		description: '聚合页H5版A面',
		loanType: '02'
	}, {
		description: '聚合页H5版B面',
		loanType: '02'
	}, {
		description: '贷款综合货客A面',
		loanType: '02'
	}, {
		description: '新一贷H5版M面',
		loanType: '02'
	}, {
		description: '贷款聚合PC版',
		loanType: '02'
	}];
	window.xhr = {
		// 索引值
		idx: 0,
		// xhr对象数组
		xhr: {},
		// 创建xhr对象
		crearteXhr: function() {
			if (XMLHttpRequest) {
				this.xhr[this.idx] = new XMLHttpRequest();
			} else if (ActiveXObject) {
				this.xhr[this.idx] = new ActiveXObject('Microsoft.XMLHTTP');
			}
			return this.idx++;
		},
		// 绑定回调事件
		data: function(idx, o) {
			var that = this;
			var curxhr = this.xhr[idx];
			// 如果是同步，并且readyState到达状态4
			if (!o.async || curxhr.readyState === 4) {
				if (o.success) {
					o.success(curxhr.responseText);
				}
			} else {
				curxhr.onreadystatechange = function() {
					// readyState到达状态4
					if (this.readyState === 4) {
						// 判断状态码
						if (this.status >= 200 && this.status < 300 || this.status === 304) {
							if (o.success) {
								o.success(this.responseText);
							}
						} else {
							if (o.error) {
								o.error();
							}
						}
						// 清除xhr对象
						try{
							delete that.xhr[idx];
						}catch(err){that.xhr[idx] = null;}
					}
				}
			}
		},
		// 拼接参数
		param: function(data) {
			var arr = [];
			if (/Object/.test(Object.prototype.toString.call(data))) {
				for (var i in data) {
					arr.push(i + '=' + data[i]);
				}
				return arr.join('&');
			} else if (typeof(data) === 'string') {
				return data;
			} else {
				return '';
			}
		},
		/*
		 *	初始化函数
		 * 	参数：
		 *  		url:  请求地址
		 *  		type: 请求类型
		 *  		data: 请求数据
		 *  		callback：回调函数
		 *  		async：是否是异步
		 */
		init: function(option) {
			if (typeof(option.type) === 'string') {
				// 类型值转为大写
				option.type = option.type.toUpperCase();
				// 当前请求是同步还是异步（默认异步）
				option.async = typeof(option.async) !== 'undefined' ? option.async : true;
				// 创建xhr对象, 返回索引值
				var idx = this.crearteXhr(),
					curxhr = this.xhr[idx];
				// 判断请求类型
				if (option.type === 'GET') {
					// 拼接参数
					var paramStr = this.param(option.data);
					// 开启xhr对象
					curxhr.open(option.type, (option.url + (paramStr !== '' ? '?' : '') + paramStr), option.async);
					// 是否需要带上cookie
					if (typeof(option.bringCookie) !== 'undefined' && option.bringCookie == true) {
						curxhr.withCredentials = true;
					} else {
						curxhr.withCredentials = false;
					}
					// 发送请求（带上参数）
					curxhr.send();
				} else if (option.type === 'POST') {
					// 开启xhr对象
					curxhr.open(option.type, option.url, option.async);
					// POST请求需要设置请求头
					curxhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					// 是否需要带上cookie
					if (typeof(option.bringCookie) !== 'undefined' && option.bringCookie == true) {
						curxhr.withCredentials = true;
					} else {
						curxhr.withCredentials = false;
					}
					// 发送请求（带上参数）
					curxhr.send(this.param(option.data));
				}
				// 设置回调
				this.data(idx, option);
			}
		},
		// 获取地址栏参数
		getQueryString: function(url, name) {
			var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*|$)", "i");
			var l = decodeURI(url);
			var r = l.substr(1).match(reg);
			if (r != null) {
				return unescape(r[2]);
			}
			return null;
		},
		// 获取mate标签name=“channel”的值
		getChannel: function() {
			var el = document.querySelector('meta[name="channel"]');
			this.metaEl = el;
			if (el) {
				var cnt = el.getAttribute('content'),
					pageVal = xhr.getQueryString(location.search, 'page');
				if (cnt.indexOf('聚合') !== -1 && pageVal) {
					return pageVal === '02' ? '01' : '02';
				} else {
					for (k in channel) {
						if (channel[k].description === cnt) {
							return channel[k].loanType;
						}
					}
				}
			}
			return '';
		},
		// 参数整理
		paramZh: function(data) {
			var param = {};
			for (var i in data) {
				if (data[i] !== '' && data[i] !== null) {
					param[i] = data[i];
				}
			}
			return param;
		}
	}
	var channelVal = xhr.getChannel(),
		sourceVal = xhr.getQueryString(location.search, 'source'),
		outeridVal = xhr.getQueryString(location.search, 'outerid')
	window.inboundType = channelVal;
	// 请求
	xhr.init({
		url: APP.config.baseURI + '/brop/ma/cust/app/market/loan/queryDayMax.do',
		type: 'POST',
		data: xhr.paramZh({
			loanType: channelVal,
			source: sourceVal,
			outerid: outeridVal
		}),
		async: false,
		// bringCookie: true,
		success: function(data) {
			try {
				data = JSON.parse(data);
				if (data && data.responseCode) {
					switch (data.responseCode) {
						case '000000':
							if (channelVal == '02' && !xhr.metaEl.getAttribute('content').match(/综合|聚合/)) {
								// 请求是否在跳转列表
								xhr.init({
									url: APP.config.baseURI + '/brop/ma/cust/app/market/loan/queryJumpLink.do',
									type: 'POST',
									data: xhr.paramZh({
										source: sourceVal,
										loanType: channelVal,
										outerid: outeridVal
									}),
									async: false,
									success: function(res) {
										try {
											res = JSON.parse(res);
											if (res && res.responseCode) {
												switch (res.responseCode) {
													case '000000':
														if (res.data.url.indexOf(location.origin + location.pathname) === -1) {
															location.replace(res.data.url + location.search);
														}
														break;
												}
											}
										} catch (err) {
											console.log('其他错误');
										}
									},
									error: function() {
										console.log('网络错误');
									}
								})
							}
							break;
						case '900114':
						case '900115':
							location.href = APP.config.errorUrl;
							break;
						default:
							console.log('其他错误');
							break;
					}
				}
			} catch (err) {
				console.log('其他错误');
			}
		},
		error: function() {
			console.log('网络错误');
		}
	})
})()
