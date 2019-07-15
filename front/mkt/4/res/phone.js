(function(){
	function styleInject(css, ref) {
		if (ref === void 0) ref = {};
		var insertAt = ref.insertAt;

		if (!css || typeof document === 'undefined') {
			return;
		}

		var head = document.head || document.getElementsByTagName('head')[0];
		var style = document.createElement('style');
		style.type = 'text/css';

		if (insertAt === 'top') {
			if (head.firstChild) {
				head.insertBefore(style, head.firstChild);
			} else {
				head.appendChild(style);
			}
		} else {
			head.appendChild(style);
		}
		if (style.styleSheet) {
			style.styleSheet.cssText = css;
		} else {
			style.appendChild(document.createTextNode(css));
		}
	}
	var css = ".loantrust-contact-icon b,.loantrust-contact-icon em,.loantrust-contact-icon i,.loantrust-contact-icon span{background:url(\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAACMCAMAAAAOTxbWAAABJlBMVEVHcEz/////////////////+On/////////9d3/////5Kb/////7sb/////////////////////////////////////////////////5KX/////////////5Kb/5Kb/////////////////5KX/////////5Kb/5Kb/5KX/5KX/////////////////////5Kb/////////////////////////5Kb/5KX/5KX/5Kb/////////////////////////////5Kb/////5Kb/////////5Kb/5Kb/5KX/5Kb/5Kb/////5Kb/////5KX/5Kb/5Kb/5KX/////5KX/////5Kb/46X/+ev/5Kb/////5KX/46X/5KX/5Kb/5Kb/////5Kb/46UorUbhAAAAX3RSTlMA/FgsMgH4/gIJrZ4FztwoHqyyFYEM5ZkSFyX07DL237ek8HtewtBsK/p4x1QP0xBBGYdHY6iRovENOXSSb3vYanJLIE8hybRcJtiPRr1AOGTBjL096VE5xGfep4WfuogBpCQAAAfDSURBVBgZ7cCHUhtZGgXgo9CtnHMCSSAQQRLJIJMzmOAYyp50/vv+L7GAPDPeWaVWU1fTW3x48W9nXMT8cL7A3iw564XTeaN8lM3A2TZL7DmGo3lL/CECJwtH+ZciHOyAfzuAg83ybwk4l4c/KRuwKn/sTuFfwHDzZzFY5I+Qvsb3AKZujz/bhEXrfFLeC2PKlvkTXxEWGQ32tL2Yru/8yQYsC7hDZT5yfcdUufmXlU1MJLza5qM0pmmXPWbIC+vW97YuAPi/l/hgGVOUZ48bE/C3SV/j3ABiRyR9q5iiWT45xgTyfNKIAak2yXoc01PjI98KJpHkk9I5sD5LMonp2WKPBxMIn4bKfOBaBXZdJDcxNes+PglhMq0Nk6TpBT6SbGB6GnxirsOq1N5WCsBulmQ0gFadpAdTs8WeW1hkREgz1wI8dZKHwAbJDUxNpsQnZhzWtPhoNgbMk6xnECPZxvTk2FODRUk+8GVTQIPkPHBE+vKYmqKLT3xrsMZ/muCDGrBKMgGESK5hemrsaQdg1ZaPdF0g4CKzwDLJeUxP0WTPR1gWInkAREgGsEVyD1P0kT2+NVj1mWQCqJJch5vkMqYo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\") no-repeat;background-size:2rem 1.4rem}.loantrust-contact,.loantrust-contact-box{height:23.04px;height:1.44rem}.loantrust-contact-box{position:fixed;left:0;right:0;bottom:0;z-index:10;background:#bb891f}.loantrust-contact-box ul{width:120px;width:7.5rem;height:23.04px;height:1.44rem;margin:0 auto;color:#fff;font-size:3.52px;font-size:.22rem;position:relative;padding:4.96px 0;padding:.31rem 0;text-align:center}.loantrust-contact-icon{width:13.6px;width:.85rem;height:13.28px;height:.83rem;vertical-align:middle;display:inline-block;position:relative}.loantrust-contact-icon b{display:block;width:14.4px;width:.9rem;height:14.4px;height:.9rem;background-position:.48px -8.8px;background-position:.03rem -.55rem;position:absolute;left:50%;top:50%;margin:-7.2px 0 0 -6.88px;margin:-.45rem 0 0 -.43rem;-webkit-animation:a 2s ease infinite 1.6s;animation:a 2s ease infinite 1.6s;opacity:0}.loantrust-contact-icon span{display:block;width:8px;width:.5rem;height:8px;height:.5rem;position:absolute;left:50%;top:50%;margin:-3.68px 0 0 -4.32px;margin:-.23rem 0 0 -.27rem;-webkit-animation:b 2s ease infinite 1.6s;animation:b 2s ease infinite 1.6s}.loantrust-contact-icon em{position:absolute;width:13.44px;width:.84rem;height:13.44px;height:.84rem;display:block;left:50%;top:50%;margin:-6.72px 0 0 -6.72px;margin:-.42rem 0 0 -.42rem;background-position:-15.68px -9.28px;background-position:-.98rem -.58rem;-webkit-animation:c 2s ease infinite 1.6s;animation:c 2s ease infinite 1.6s}.loantrust-contact-icon i{display:block;width:8px;width:.5rem;height:8px;height:.5rem;position:absolute;top:1.76px;top:.11rem;left:4px;left:.25rem;background-position:-8px 0;background-position:-.5rem 0}.loantrust-contact-txt{font-size:3.84px;font-size:.24rem;line-height:4.8px;line-height:.3rem;margin:0 4.8px 0 3.2px;margin:0 .3rem 0 .2rem;vertical-align:middle;display:inline-block}.loantrust-contact-tel{vertical-align:middle;display:inline-block;font-size:9.28px;font-size:.58rem;line-height:9.6px;line-height:.6rem;-webkit-animation:d 2s ease infinite .5s;animation:d 2s ease infinite .5s}@-webkit-keyframes a{0%{opacity:0}5%{opacity:.9}10%{opacity:.7}15%{opacity:.9}20%{opacity:0}}@keyframes a{0%{opacity:0}5%{opacity:.9}10%{opacity:.7}15%{opacity:.9}20%{opacity:0}}@-webkit-keyframes b{0%{-webkit-transform:rotate(20deg) scale(1.01);transform:rotate(20deg) scale(1.01)}5%{-webkit-transform:rotate(-20deg) scale(1.03);transform:rotate(-20deg) scale(1.03)}10%{-webkit-transform:rotate(20deg) scale(1);transform:rotate(20deg) scale(1)}15%{-webkit-transform:rotate(-20deg) scale(1.01);transform:rotate(-20deg) scale(1.01)}20%{-webkit-transform:rotate(20deg) scale(1.03);transform:rotate(20deg) scale(1.03)}25%{-webkit-transform:rotate(-20deg) scale(1);transform:rotate(-20deg) scale(1)}30%{-webkit-transform:rotate(20deg) scale(1.01);transform:rotate(20deg) scale(1.01)}35%{-webkit-transform:rotate(0) scale(1.03);transform:rotate(0) scale(1.03)}}@keyframes b{0%{-webkit-transform:rotate(20deg) scale(1.01);transform:rotate(20deg) scale(1.01)}5%{-webkit-transform:rotate(-20deg) scale(1.03);transform:rotate(-20deg) scale(1.03)}10%{-webkit-transform:rotate(20deg) scale(1);transform:rotate(20deg) scale(1)}15%{-webkit-transform:rotate(-20deg) scale(1.01);transform:rotate(-20deg) scale(1.01)}20%{-webkit-transform:rotate(20deg) scale(1.03);transform:rotate(20deg) scale(1.03)}25%{-webkit-transform:rotate(-20deg) scale(1);transform:rotate(-20deg) scale(1)}30%{-webkit-transform:rotate(20deg) scale(1.01);transform:rotate(20deg) scale(1.01)}35%{-webkit-transform:rotate(0) scale(1.03);transform:rotate(0) scale(1.03)}}@-webkit-keyframes c{0%{-webkit-transform:scale(1);transform:scale(1)}15%{-webkit-transform:scale(1.05);transform:scale(1.05)}30%{-webkit-transform:scale(1);transform:scale(1)}}@keyframes c{0%{-webkit-transform:scale(1);transform:scale(1)}15%{-webkit-transform:scale(1.05);transform:scale(1.05)}30%{-webkit-transform:scale(1);transform:scale(1)}}@-webkit-keyframes d{0%{-webkit-transform:scale(1);transform:scale(1)}30%{-webkit-transform:scale(1.13);transform:scale(1.13)}60%{-webkit-transform:scale(1);transform:scale(1)}}@keyframes d{0%{-webkit-transform:scale(1);transform:scale(1)}30%{-webkit-transform:scale(1.13);transform:scale(1.13)}60%{-webkit-transform:scale(1);transform:scale(1)}}";
	styleInject(css);
	window.inbound = {
		el: null,
		init: function() {
			var that = this;
			if (addEventListener) {
				window.addEventListener('load', function() {
					that.quest();
				})
			}
		},
		quest: function() {
			var that = this;
			xhr.init({
				url: APP.config.baseURI + '/brop/ma/cust/app/market/inbound/queryInboundSource.do',
				type: 'GET',
				data: {
					source: xhr.getQueryString(location.search, 'source'),
					outerId: xhr.getQueryString(location.search, 'outerid'),
					inboundType: window.inboundType || '02',
				},
				success: function(res) {
					res = JSON.parse(res);
					if (res.responseCode == '000000' && res.data.inboundPhone && res.data.validStatus == 'Y') {
						that.appendEl(res.data.inboundPhone);
					}
				},
				error: function() {
					var ele = document.querySelector('.toast-area');
					if (ele) {
						ele.style.display = 'block';
						setTimeout(function() {
							ele.style.display = 'none';
						}, 2000);
					} else {
						that.hint()
					}
				}
			})
		},
		// 重置号码
		resetPhone: function() {
			this.el.parentNode.removeChild(this.el);
			this.quest();
		},
		// 展示提示
		hint: function(str, cb) {
			var a = document.createElement('span');
			a.innerHTML = str || '网络异常，请稍后再试！';
			a.style.cssText = 'min-width: 260px;height: 40px;font-size:16px;line-height:40px;background-color: rgba(0,0,0,0.5);border-radius: 10px;position: fixed;top: 36%;left: 50%;margin: -25px 0 0 -130px;text-align: center;color: #fff;animation: yaohuang .1s;padding:0 30px;'
			document.body.appendChild(a);
			setTimeout(function() {
				a.remove();
				if (cb) cb();
			}, 1000);
		},
		// 添加元素
		appendEl: function(phone) {
			var str = phone.slice(0, 3) + '-' + phone.slice(3, 6) + '-' + phone.slice(6);
			var dom = document.createElement('div');
			dom.className = 'loantrust-contact';
			dom.innerHTML = '<a class="loantrust-contact-box" style="background-color:'+this.getColor()+'" href="tel:' + phone + '" otitle="贷款申请服务专线"><ul><li><div class="loantrust-contact-icon"><b></b><span></span><em></em><i></i></div><span class="loantrust-contact-txt">贷款申请<br>点击拨打</span>' +
				'<span class="loantrust-contact-tel">' + str + '</span></li></ul></a>';
			document.body.appendChild(dom);
			dom.addEventListener('click', function() {
				console.log(arguments.callee)
				if (location.href.indexOf('loan/i-newloan') !== -1 && App) {
					talkingData('点击“拨打电话”按钮', '新一贷贷款申请页面');
				}
			})
			this.el = dom;
		},
		// 获取颜色
		getColor:function(){
			var c = '#bb891f';
			// 地址栏路径
			var pt = location.pathname;
			// 类型
			var tp = pt.match(/[a-z0-9]+(?=\-(newloan|newloan-1|carloan)\/)/); // 增加对于newloan-1 的校验
			if(pt.match('/carloan/'))
				return '#b78e12';
			if(tp){
				tp = tp[0];
				if(pt.match('newloan')){
					switch(tp){
						case 'a':
						case 'b':
						case 'c':
							c = '#ee6359';
							break;
						case 'd':
							c = '#bb891f';
							break;
						case 'e':
							c = '#aa7d1d';
							break;
						case 'f':
							c = '#fa3a00';
							break;
						case 'g':
							c = '#282224';
							break;
						case 'i':
							c = '#aa7d1d';
							break;
						case 'j':
						case 'jbm':
						case 'jdm1':
						case 'jdm2':
						case 'jgm1':
						case 'jgm2':
						case 'jsm1':
						case 'jsm2':
							c = '#f37938';
							break;
						case 'k':
							c = '#f37938';
							break;
						case 'l':
							c = '#282224';
							break;
						case 'm':
							c = '#f37938';
							break;
						case 'n':
							c = '#aa7d1d';
							break;
						case 'o':
							c = '#f37938';
							break;
						case 'p':
							c = '#f37938';
							break;
						case 'q':
							c = '#f37938';
							break;
						case 'r':
							c = '#354869';
							break;
						case 's':
							c = '#aa7d1d';
							break;
						case 't':
						case 'u':
						case 'v':
						case 'w':
						case 'x':
						case 'yxa':
						case 'yxb':
						case 'yxc':
						case 'yxd':
						case 'ma':
							c = '#f37938';
							break;
					}
				}else{
					switch(tp){
						case 'a':
							c = '#1e79fe';
							break;
						case 'b':
							c = '#fb6327';
							break;
						case 'c':
							c = '#ad9260';
							break;
						case 'd':
							c = '#2c465d';
							break;
						case 'e':
							c = '#b78e12';
							break;
						case 'f':
						case 'i':
							c = '#ad9260';
							break;
						case 'g':
							c = '#ad9260';
							break;
					}
				}
			}
			return c;
		}

	}
	inbound.init();
})();