var wxShare = {
	appid:'',
	redirect_uri:'',
	shareLink:'',
	weappNo:'',
	signatureUrl:'',
	link:'',
	//titleFCircle:分享朋友圈标题      titleFriend:分享朋友标题   link:分享返回链接
	//imgUrl:分享图片URL          desc:分享描述                            openid:微信号
	share : function(titleFCircle,titleFriend,link,desc,imgUrl,openid,custToken,source){
		var this_ = this;
		var localUrl = window.location.host;
		var protocol = window.location.protocol;
		if(localUrl.indexOf('test-haodai.qianpapa.com') != -1){
			if ("https:" == protocol) {
				this_.redirect_uri = 'https%3A%2F%2Feim-talk-stg1.qianpapa.com.cn%2Fits-pir%2F';
				this_.link = 'https%3A%2F%2Ftest-haodai.qianpapa.com' + link;
				this_.shareLink = 'https://test-haodai.qianpapa.com';
				this_.weappNo = 'qianpapa_HD_01';
				this_.appid = 'wx1fab99773ab4588d';
				this_.signatureUrl = 'https://eim-talk-stg1.qianpapa.com.cn/its-pir/getSignature';
			} else {
				this_.redirect_uri = 'http%3A%2F%2Feim-talk-stg.dmzstg.qianpapa.com.cn%2Fits-pir%2F';
				this_.link = 'http%3A%2F%2Ftest-haodai.qianpapa.com' + link;
				this_.shareLink = 'http://test-haodai.qianpapa.com';
				this_.weappNo = 'qianpapa_HD_01';
				this_.appid = 'wx1fab99773ab4588d';
				this_.signatureUrl = 'http://eim-talk-stg.dmzstg.qianpapa.com.cn/its-pir/getSignature';
			}
		}else if(localUrl.indexOf('haodai.qianpapa.com') != -1){
			if("https:" == protocol){
				this_.redirect_uri = 'https%3A%2F%2Feim.qianpapa.com.cn%2Fits%2F';
				this_.shareLink = 'https://haodai.qianpapa.com';
				this_.link = 'https%3A%2F%2Fhaodai.qianpapa.com' + link;
				this_.weappNo = 'qianpapa_HD_01';
				this_.appid = 'wxea8c2a184f6288c4';
				this_.signatureUrl = 'https://eim.qianpapa.com.cn/its/getSignature';
			}else{
				this_.redirect_uri = 'http%3A%2F%2Feim.qianpapa.com.cn%2Fits%2F';
				this_.shareLink = 'http://haodai.qianpapa.com';
				this_.link = 'http%3A%2F%2Fhaodai.qianpapa.com' + link;
				this_.weappNo = 'qianpapa_HD_01';
				this_.appid = 'wxea8c2a184f6288c4';
				this_.signatureUrl = 'http://eim.qianpapa.com.cn/its/getSignature';
			}
		 }
		/*微信分享功能*/
		$.ajax({
		    //生产
		    url : this_.signatureUrl,
		    data : {
				openid: openid,
		        weappNo:this_.weappNo
		     },
		     type : 'GET',
		     dataType : 'jsonp',
		     error: function(){
		     },
		     success : function(data) {
		        data=JSON.parse(data);
		         wx.config({
		                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		                appId: this_.appid, // 必填，公众号的唯一标识
		                timestamp:data['timestamp'], // 必填，生成签名的时间戳
		                nonceStr:data['nonce'], // 必填，生成签名的随机串
		                signature:data['signature']  ,// 必填，签名，见附录1
		                jsApiList: ['checkJsApi',
		        	                'onMenuShareTimeline',
		                            'onMenuShareAppMessage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		            });

		     }
		});

		wx.ready(function(){
	       wx.checkJsApi({
	             jsApiList: [
	                 'onMenuShareTimeline',
	                 'onMenuShareAppMessage'
	             ]
	         });

	       /*分享到朋友圈*/
	       wx.onMenuShareTimeline({
	             title: titleFCircle, // 分享标题
	             link: this_.shareLink +'/wap/commonShare-ucp.html?redirect_uri='+this_.redirect_uri+'&appid='+this_.appid+'&weappNo='+this_.weappNo+'&link='+this_.link , // 分享链接
	             imgUrl: this_.shareLink + imgUrl, // 分享图标
	             success: function () {
	            	 wxShare.gainShareIntegral(custToken, openid, source);
		         }
	       });
	       /*分享给朋友*/
	       wx.onMenuShareAppMessage({
	             title: titleFriend, // 分享标题
	             desc: desc, // 标题描述
	             link: this_.shareLink +'/wap/commonShare-ucp.html?redirect_uri='+this_.redirect_uri+'&appid='+this_.appid+'&weappNo='+this_.weappNo+'&link='+this_.link , // 分享链接
	             imgUrl: this_.shareLink + imgUrl, // 分享图标
	             success: function () {
	            	 wxShare.gainShareIntegral(custToken, openid, source);
	             }
	       });
		});
	},

	gainShareIntegral : function(token, openid, source){
		if(token && openid){
			var awardCode = "JF001";
			var activiCode = "";
			var localUrl = window.location.host;
			if(source === "1"){
				//来源微信一段式
				activiCode = "04A20180516184";
			}else if(source === "2"){
				//来源好贷官网
				activiCode = "04A20180516187";
			}else if(source === "3"){
				//贷款材料须知分享
				activiCode = "04A20180516186";
			}

			if(localUrl.indexOf('test-haodai.qianpapa.com') != -1){
				if(source === "1"){
					//来源微信一段式
					activiCode = "04A20180515122";
				}else if(source === "2"){
					//来源好贷官网
					activiCode = "04A20180515125";
				}else if(source === "3"){
					//贷款材料须知分享
					activiCode = "04A20180515124";
				}
			}
    		$.ajax({
				type : "POST",
				url : "/do/rsploan/gainIntegralByOpenID",
				data : {
					token : token,
					openid : openid,
					awardCode : awardCode,
					activiCode : activiCode
				},
				dataType : "text",
				success : function(data) {
					window.location.reload();
				}
			});
    	}
	}

}


