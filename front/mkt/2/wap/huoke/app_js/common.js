$(function () {
	//微信分享初始化
	// common.getCusToken();
});
var common = {
		custToken:'',
		clearTime:function(){
			clearTimeout(window.toTimeoutPageId);
			clearTimeout(window.flowIntervalId);
		},
		
		/**
		 *获取cusToken
		 */
		// getCusToken : function(){
		// 	$.ajax({
		// 		type : "POST",
		// 		url : "/do/rsploan/getCusToken",
		// 		dataType : "text",
		// 		success : function(data) {
		// 			data = $.parseJSON(data);
		// 			common.custToken = data.cusToken;
		// 			common.initWxShare();
		// 		}
		// 	});
		// },
		
		sessionTimeoutStart : function(flowid,notFirstTime,source){
			window.toTimeoutPageId = setTimeout(function(){//启动会话超时计时，并保存该计时ID,30分钟 30*60*1000=1800000
				var wt = common.getMediaSouce();
			        	if(wt != null){
			        		window.location.href = '../microWebsite/error.html';
			        	} else {
			        		window.location.href = '../microWebsite/error.html';
			        	}
			},180000);
			if(!notFirstTime){
				//启动保持流程计时器
				common.keepFlow(flowid,source)
				//用户点击了页面，清除两个之前的计时器，重新计时
				$("body").bind("click",function(){
					clearTimeout(toTimeoutPageId);
					//clearTimeout(tipToUserTimeout);
					common.sessionTimeoutStart(flowid,true);
				});
			}
			
		},
		/**
		*	保持流程，每30秒发一次
		*/
		keepFlow : function(flowid){
			if(flowid!=''&&flowid!=null){
				window.flowIntervalId = setInterval(function(){
					$.ajax({
						url : "/do/keep-flow-ctx.do?flowId="+flowid,
						dataType:"json",
						success:function(data){
							if(data.resultCode!='0'){
								 clearInterval(flowIntervalId);
							}
						},
						error:function(){
							window.location.href = '/microWebsite/error.html';
						}
					});
				},30000);
			}
		},
		getMediaSouceUrl : function(){
			var theUrl = window.location.href;
            var paramIndex = theUrl.indexOf("WT.mc_id=");
            var mediaSource;
            if(paramIndex != -1) {
                  mediaSource = theUrl.substring(paramIndex);
                  var pIndex = mediaSource.indexOf("&");
                  if(pIndex != -1) {
                           mediaSource = mediaSource.substring(0,pIndex);
                  }
                  mediaSource = mediaSource.substring(9);
                  mediaSource = common.unhtml(mediaSource,null);
            }else {
                  mediaSource = "";
            }


            // 若cookie中为空，则默认为 'CXX-ZHITONGSEO-'
            if(!mediaSource || mediaSource =='direct' || mediaSource=='null') {
                  mediaSource = 'CXX-ZHITONGSEO-';
            }
		
			return mediaSource;
		},
		getMediaSouce : function() {
            // 先从mc_id中取
            var theUrl = window.location.href;
            var paramIndex = theUrl.indexOf("WT.mc_id=");
            var mediaSource;
            if(paramIndex != -1) {
                  mediaSource = theUrl.substring(paramIndex);
                  var pIndex = mediaSource.indexOf("&");
                  if(pIndex != -1) {
                           mediaSource = mediaSource.substring(0,pIndex);
                  }
                  mediaSource = mediaSource.substring(9);
                  mediaSource = common.unhtml(mediaSource,null);
            }else {
                  mediaSource = "";
            }


            // 若cookie中为空，则默认为 'CXX-ZHITONGSEO-'
            if(!mediaSource || mediaSource =='direct' || mediaSource=='null') {
                  mediaSource = 'CXX-ZHITONGSEO-';
            }
            $('#mediaSource').val(mediaSource);
        },
        
        getInnerMedia : function() {
            var innerMedia = this.getCookie('inner_media');
            innerMedia = decodeURI(innerMedia);

            // 若cookie中为空，则默认为 'qianpapa'
            if(!innerMedia) {
                  innerMedia = 'qianpapa';
            }

            $('#innerMedia').val(innerMedia);          
        },
        getLpPage : function() {
            var localurl = window.document.referrer;
            if(localurl.indexOf("?") > 0) {
                localurl = localurl.substring(0, localurl.indexOf("?"));
            }
            if(localurl.length > 150) {
                  localurl = localurl.substring(0, 150);
            }
            $('#lpPage').val(localurl);
        },
         
        getCookie : function(name) { 
        	var strCookie = document.cookie;
        	var arrCookie = strCookie.split(";");

        	for ( var i = 0; i < arrCookie.length; i++) {
        		var arr = arrCookie[i].split("=");
        		if ($.trim(arr[0]) == name)
        			return $.trim(arr[1]);
        	}
           return "";
        },
        getWeChatId: function(){
        	 // 先从mc_id中取
            var url = window.location.href;
            var paramIndex = url.indexOf("weChatId=");
            var weChatId;
            if(paramIndex != -1) {
                  weChatId = url.substring(paramIndex);
                  var pIndex = weChatId.indexOf("&");
                  if(pIndex != -1) {
                           weChatId = weChatId.substring(0,pIndex);
                  }
                  weChatId = weChatId.substring(9);
            }else {
                  weChatId = "";
            }
            return weChatId;
        },
        phoneVerif:function(phone, b){
			var phoneVal = phone.val(), sendCode = $("#sendCode");
			var repeat = 1;
			var seque = 1;
			/*for ( var i = 1; i < phoneVal.length; i++) {
				if (phoneVal.charAt(i) == phoneVal.charAt(i - 1)) {
						repeat++;
						if (repeat >= 5) {
							break;
						}
				} else {
						repeat = 1;
				}
				if (phoneVal.charAt(i)- phoneVal.charAt(i - 1) == '1') {
						seque++;
						if (seque >= 6) {
							break;
						}
				} else {
						seque = 1;
				}
			}*/
			if(!phoneVal){
				common.showError(phone, "请输入您的手机号码", b);
				return false;
			}else if(phoneVal && !/^(13|14|15|16|17|18|19)[0-9]{1}[0-9]{4}[0-9]{4}$/.test(phoneVal)){
				common.showError(phone, "手机号码格式有误！", b);
				return false;
			}else if(phoneVal && (repeat>='5'||seque>='6')){
				common.showError(phone, "手机号码不合规范！", b);
				return false;
			}else{
				sendCode.addClass("active");
				$(".error").css("display","none");
				return true;
			}
		},
		nameVerif : function(name, b){
			var nameVal = name.val();
			if(!nameVal){
				common.showError(name, "请输入您的姓名", b);
				return false;
			}else if(nameVal && !/^([\u4e00-\u9fa5\s]{2}|[a-zA-Z]{4})([\u4e00-\u9fa5\s]{0,18}|[. ]{0,36}|[• ]{0,36}|[a-zA-Z]{0,36})*$/.test(nameVal)){
				common.showError(name, "姓名不符合规范！", b);
				return false;
			}else if (nameVal == '不详' || nameVal == '不祥'|| nameVal == '未知'|| nameVal == '不知道'|| nameVal == '姓名'|| nameVal.indexOf('测试') > -1|| nameVal.indexOf('test') > -1){
				common.showError(name, "姓名不符合规范！", b);
				return false;
			}else{
				$(".error").css("display","none");
				return true;
			}
		},
		
		//初始化微信分享
		initWxShare : function(){
			var localUrl = window.location.href;
			
			//朋友圈标题
			var titleFCircle = "钱爸爸好贷贷款服务，无抵押贷款，最快24小时到账。";
			//好友标题
			var titleFriend = "马上贷款50万";
			var link = "/wap/huoke/yiduanshi.html";
			link = window.encodeURIComponent(link);
			//好友标题描述
			var desc = "无抵押贷款 最快24小时到账。";
			var picUrl = "/wap/huoke/app_img/wxShare.JPG";
			picUrl = window.decodeURIComponent(picUrl);
			var openId = this.getCookie("clentNo");
			if(!openId){
				openId = '1111111111111111';
			}
			
			if(localUrl.indexOf('huoke/yiduanshi-bdd.html') != -1){
				titleFCircle = "无抵押无担保，有保单就可来贷款！最快24小时到账哦~";
				titleFriend = "保单新功能上线";
				desc = "有保单就能贷，最高50万额度！";
				link = window.encodeURIComponent("/wap/huoke/yiduanshi-bdd.html?WT.mc_id=ZTXYD-weixing-bdd");
				picUrl = window.decodeURIComponent("/wap/huoke/app_img/yds-bdd.jpg");
			}else if(localUrl.indexOf('huoke/yiduanshi-gjjd.html') != -1){
				titleFCircle = "点击这里>>申请简单，只要你有公积金，最高可贷50万！";
				titleFriend = "公积金信用贷全新上线";
				desc = "公积金新功能全新上线，最快24小时放款";
				link = window.encodeURIComponent("/wap/huoke/yiduanshi-gjjd.html?WT.mc_id=ZTXYD-weixing-gjjd");
				picUrl = window.decodeURIComponent("/wap/huoke/app_img/yds-gjjd.jpg");
			}else if(localUrl.indexOf('huoke/yiduanshi-fdygd.html') != -1){
				titleFCircle = "有房贷月供压力大？来这里不怕没钱花！";
				titleFriend = "月供后消费，钱从何来？";
				desc = "房贷月供贷贷款，消费新主张，最高50万！";
				link = window.encodeURIComponent("/wap/huoke/yiduanshi-fdygd.html?WT.mc_id=ZTXYD-weixing-fdygd");
				picUrl = window.decodeURIComponent("/wap/huoke/app_img/yds-fdygd.jpg");
			}else if(localUrl.indexOf('wap/huoke/yiduanshiQR.html') != -1){
				titleFCircle = "你的好友@你>>全新贷款方案，不押车、不装GPS、最快24小时到账~";
				titleFriend = "车主贷全新上线，最高可贷50万！";
				desc = "不押车、不装GPS、全程0申请手续费，最快24小时放款~";
				link = window.encodeURIComponent("/wap/huoke/yiduanshiQR.html");
				picUrl = window.decodeURIComponent("/wap/huoke/app_img/wxShare-yds-QR.jpg");
			}else if(localUrl.indexOf('wap/huoke/yiduanshiZYT.html') != -1){
				titleFCircle = "点击这里>>全程0申请手续费，随借随还，最高可贷1000万！";
				titleFriend = "缺大额资金？房屋抵押最高可贷1000万！";
				desc = "多种用途，专业客户经理1对1线上服务，让您贷款无忧~";
				link = window.encodeURIComponent("/wap/huoke/yiduanshiZYT.html");
				picUrl = window.decodeURIComponent("/wap/huoke/app_img/wxShare-yds-ZYT.jpg");
			}else if(localUrl.indexOf('wap/huoke/yiduanshiYZT.html') != -1){
				link = window.encodeURIComponent("/wap/huoke/yiduanshiYZT.html");
			}
			wxShare.share(titleFCircle,titleFriend,link,desc,picUrl,openId,common.custToken,"1");
		},
		showError:function(target, str, b){
			alert(str);
		},
		unhtml :function(str, reg) {
			if(str){
		         return str ? str.replace(reg || /[&<">'](?:(amp|lt|quot|gt|#39|nbsp);)?/g, function (a, b) {
		                   if (b) {return a;} 
		                   else {
		                            return {
		                                     '<':'&lt;',
		                                     '&':'&amp;',
		                                     '"':'&quot;',
		                                     '>':'&gt;',
		                                     "'":'&#39;'
		                            }[a]
		                   }
		         }) : '';
			}
		}

}
//百度可以统计按键量
// var _hmt = _hmt || [];
// (function() {
//   var hm = document.createElement("script");
//   hm.src = "https://hm.baidu.com/hm.js?5cc92e7a9a37a0546a5bf7d217afb282";
//   var s = document.getElementsByTagName("script")[0];
//   s.parentNode.insertBefore(hm, s);
// })();
//wap版webtrends代码
function loadWTScript(a, b) {
	var c = document.createElement("script");
	c.type = "text/javascript",
	c.async = !0, c.id='wtjs',
	c.src = a,
	dcsReady(c, b),
	document.getElementsByTagName("head")[0].appendChild(c)
}
function dcsReady(a, b) {
	a.readyState ? a.onreadystatechange = function() { ("loaded" == a.readyState || "complete" == a.readyState) && (a.onreadystatechange = null, b())
	}: a.onload = function() {
		b()
	}
} 
if(document.getElementById("wtjs")==null)
loadWTScript(window.location.protocol.indexOf('https:')==0?'https://pa-ssl.qianpapa.com/app_js/sdc/prd/sdc9_m.js':'http://www.qianpapa.com/app_js/sdc/prd/sdc9_m.js', function(){
    if (typeof(_tag) != "undefined"){
      _tag.dcsid="dcs82b9ujitigdu3gaykxw0hn_5p6b";  //dcsid参数用于设置日志记录在哪个文件里
        _tag.DCSext.platform="xxxx";  //平台名字
        var s=_tag.dcsGetIdAsync();
        if(s) 
            dcsReady(s,function(){_tag.dcsCollect()});
        else
            _tag.dcsCollect();
    }
})