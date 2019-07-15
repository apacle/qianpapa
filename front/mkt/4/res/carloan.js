function carLoan(){
    var CarLoanPage = {
		executors: [
			// 今日头条-康赛
			{
				paramSource: 'sa0000467',
				paramOuterid: 'ou0000073',
				run: function () {
					meteor.track("form", {
						convert_id: "1599900727051284"
					})
				}
			},
			//广点通-车主贷科达1
			{
				paramSource: 'sa0001616',
				paramOuterid: 'ou0001358',
				run: function () {
					gdt('track', 'RESERVATION', {
						'key1': 'value1',
						'key2': 'value2'
					});
				}
			},
			//今日头条-车主贷科达1
			{
				paramSource: 'sa0001617',
				paramOuterid: 'ou0001359',
				run: function () {
					meteor.track("form", {
						convert_id: "1628336485622787"
					})
				}
			},
			//今日头条-车主贷科达2
			{
				paramSource: 'sa0001618',
				paramOuterid: 'ou0001360',
				run: function () {
					meteor.track("form", {
						convert_id: "1628337096888328"
					})
				}
			},
			//今日头条-车主贷科达3
			{
				paramSource: 'sa0001619',
				paramOuterid: 'ou0001361',
				run: function () {
					meteor.track("form", {
						convert_id: "1628337260488711"
					})
				}
			},
			//今日头条-车主贷科达4
			{
				paramSource: 'sa0001620',
				paramOuterid: 'ou0001362',
				run: function () {
					meteor.track("form", {
						convert_id: "1628337378050056"
					})
				}
			},
			//广点通-车主贷
			{
				paramSource: 'sa0001630',
				paramOuterid: 'ou0001393',
				run: function () {
					gdt('track', 'RESERVATION', {
						'key1': 'value1',
						'key2': 'value2'
					});
				}
			}
		],
        submitData : {
            userName: '',//用户姓名
            userPhone:'',//用户电话
            city: '',//所在城市
            cityCode:'',//城市编码
            insurance: '',
        },
        init : function(){
            this.initPicker();
            this.bindEvent();
            this.submitAjax();
		},
        getUrlParam : function(){
            var url = window.location.href;
            this.arr = [];
            this.submitData['pageType'] = 'f-carloan';//页面类型
            this.submitData.channelSource = this.getQueryString(url,'channel_source')? this.getQueryString(url,'channel_source'):'';//渠道来源
            this.submitData.source = this.getQueryString(url,'source')? this.getQueryString(url,'source'):'';//获客渠道
            this.submitData.outerSource = this.getQueryString(url,'outerSource')? this.getQueryString(url,'outerSource'):'';//获客路径
            //this.submitData.downapp_id = this.getQueryString(url,'downapp_id')?this.getQueryString(url,'downapp_id'):'';//app分包下载情况
            this.submitData.channelSource!=''? this.arr.push('channel_source='+this.submitData.channelSource):null;
            this.submitData.source!=''? this.arr.push('source='+this.submitData.source) :null;
            this.submitData.outerSource!=''? this.arr.push('outerSource='+this.submitData.outerSource) :null;
           // this.submitData.downapp_id!=''? this.arr.push('downapp_id='+this.submitData.downapp_id) :null;
            url.indexOf('openid')!== -1?this.submitData['openId'] = this.getQueryString(url,'openid') :null;//微信openid
            url.indexOf('downapp_id') !== -1 ? this.arr.push('downapp_id='+this.getQueryString(url,'downapp_id')) :null;
            url.indexOf('qz_gdt') !== -1 ? this.arr.push('qz_gdt=' + this.getQueryString(url,'qz_gdt')):null;
            url.indexOf('show') !== -1 ? this.arr.push('show=' + this.getQueryString(url,'show')):null;//返回官网按钮显示
            url.indexOf('outerid') !== -1 ? this.arr.push('outerid=' + this.getQueryString(url,'outerid')):null;
            url.indexOf('cid') !== -1 ? this.arr.push('cid=' + this.getQueryString(url,'cid')):null;

            url.indexOf('bd_vid') !== -1 ? this.submitData['bd_vid'] = this.getQueryString(url,'bd_vid'):null;//百度推广，添加提交字段
            url.indexOf('bd_vid') !== -1 ? this.arr.push('bd_vid=' + this.getQueryString(url,'bd_vid')):null;//push到arr中，提交到成功页面的时候拼接url

            var newUrl = (this.arr.length !== 0?'?':'') + this.arr.join('&');
            return newUrl
        },
        initPicker : function (){
            var that = this;
            if(window.getCity){
                getCity({
                    cb: function(init_city_picker){
                        that.city_picker1 = new mui.PopPicker({layer:2});
                        that.city_picker1.setData(init_city_picker);
                        $("#city_text1").on("tap", function(){
                            setTimeout(function(){
                                that.city_picker1.show(function(items){
                                    $('[data-type="city"]').parents('.input-group').find('.input-error').hide();
                                    $('.input-select').addClass('active');
                                    $("#city_text1").html((items[0] || {}).text + ' - ' +(items[1] || {}).text);
                                    that.submitData.city = (items[0] || {}).text +'-' +(items[1] || {}).text;
                                    that.submitData.cityCode = (items[1] || {}).value;
                                });
                            },200);
                        });
                    },
                    cb2:function(init_city_picker,position){
                        if(window._tag)_tag.trackEvent('获取定位成功');
                        var reg = new RegExp('\\{"text":"'+position.city.replace('市','')+'","value":"\\d{6}"\\}');
                        var citydata = JSON.stringify(init_city_picker);
                        if(reg.test(citydata)){
                            $("#city_text1").addClass('active').html('<span>' + position.province.replace(/省|市|壮族自治区/,'') + '</span> - <span>' + position.city.replace('市','') + '</span>');
                            that.submitData.city = position.province.replace(/省|市|壮族自治区/,'')+'-'+position.city.replace('市','');
                            that.submitData.cityCode = JSON.parse(citydata.match(reg)[0]).value;
                        }else{
                            if(window._tag)_tag.trackEvent('不在城市列表内');
                            console.log('不在城市列表内')
                        }
                    }
                })
            }
        },
        showError : function(){
            var flag = true;
            var arry = [];
            for(items in this.submitData){
                arry.push(this.submitData[items])
            }
            var arr = arry.slice(0,3)
            for (var i = 0; i <arr.length; i++) {
                if(arr[i]==''){
                    $("[data-type]").eq(i).parents('.input-group').find('.input-error').show()
                    flag = false;
                }else{
                    if(i==0&&!(/^[\u4E00-\u9FFF]{2,}$/).test(arr[i])){
                        flag=false;
                    }
                    if(i==1&&!(/^(((13[0-9]{1})|14[5,7,9]{1}|(15[0-3,5-9]{1})|166|(17[0,1,3,5,6,7,8])|(18[0-9]{1})|(19[8,9]{1}))+\d{8})$/).test(arr[i])){
                        flag=false;
                    }
                }
            }
            return flag
        },
        getQueryString : function(url, name){
            var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*|$)", "i");
            var l = decodeURI(url);
            var r = l.substr(1).match(reg);
            if (r != null){
                return unescape(r[2]);
            }
            return null;
        },
        bindEvent : function(){
            var that = this;
            $('input').on('focus',function(){
                that.city_picker1.panel.style.display = 'none';
            }).on('blur',function(){
                that.city_picker1.panel.style.display = 'block';
            })
            $('[data-type="userName"]').on('blur',function(){
                userName = $('[data-type="userName"]').val().trim();
                that.submitData.userName = userName;
                if(/^[\u4E00-\u9FFF]{2,}$/.test(userName)){
                    $(this).parents('.input-group').find('.input-error').hide();
                }else{
                    $(this).parents('.input-group').find('.input-error').show();
                }
            })
            $('[data-type="userPhone"]').on('blur',function(){
                userPhone = $('[data-type="userPhone"]').val();
                that.submitData.userPhone = userPhone; 
                if(/^(((13[0-9]{1})|14[5,7,9]{1}|(15[0-3,5-9]{1})|166|(17[0,1,3,5,6,7,8])|(18[0-9]{1})|(19[8,9]{1}))+\d{8})$/.test(userPhone)){
                    $(this).parents('.input-group').find('.input-error').hide();
                }else{
                    $(this).parents('.input-group').find('.input-error').show();
                }
            }) 
        },
        submitAjax : function(){
            var that = this;
            $('.btn-primary').on('click',function () {
                // 提交按钮埋点
                if(window._tag)_tag.trackEvent('按钮-提交申请');

                that.getUrlParam();
                if(!that.preventSign){
                    if (that.showError()){
                        that.preventSign = true;
                        that.submitData.encryptFlag = 'YES';
                        that.submitData.insurance = 'NO';
                        $.ajax({
                            url:PAB.domain.rsbDomain + '/brop/ma/cust/app/market/loan/applySSLLoanF.do',
                            type: 'POST',
                            data:that.paramZh(),
                            dataType:'json',
                            xhrFields:{
                                withCredentials: true
                            },
                            success:function(res){
                                if (res.responseCode == '000000') {
                                	var url = window.location.search;
                                	var paramSource = that.getQueryString(url, 'source') ? that.getQueryString(url, 'source') : '';
                                	var paramOuterid = that.getQueryString(url, 'outerid') ? that.getQueryString(url, 'outerid') : '';

									for (var i = 0; i < that.executors.length; i++) {
										var executor = that.executors[i]
										if (executor.paramSource === paramSource || executor.paramOuterid === paramOuterid) {
											executor.run()
											break
										}
									}

                                    var applyNo = res.data == undefined ? "" : res.data.applyNo
                                    window.authDialog.show(applyNo,function(){
                                        let phoneNum = that.submitData.userPhone;
                                        that.reset();
                                        location.href = APP.successUrl + that.appendPhoneNum(that.getUrlParam(), phoneNum);
                                    },"#ad9260");

                                }else if(res.responseCode == '900114'||res.responseCode == '900115' ){
                                    window.location.href = APP.config.errorUrl;
                                }else{
                                    $(".toast-area").show();
                                    setTimeout('$(".toast-area").hide()',2000);
                                }
                                that.preventSign = false;
                            },
                            error:function(res){
                                $(".toast-area").show();
                                setTimeout('$(".toast-area").hide()',2000);
                                that.preventSign = false;
                            }
                        })
                    }
                }
            })
        },
        /**
         * 将手机号拼接到成功页面(登录注册组件中到参数是phoneNum)
         * urlParam : 成功页拼接到参数
         */
        appendPhoneNum: function (urlParam, phoneNum) {
            return urlParam + (urlParam ? '&' : '?') + ('phoneNum=' + phoneNum)
        },
        reset:function(){
            $('.input-radio').children().removeClass('active');
            $('[data-type="userName"]').val('');
            $('[data-type="userPhone"]').val('');
            $('[data-type="city"]').html('请选择您所在的城市').removeClass('active');
            this.submitData = {
                userName: '',//用户姓名
                userPhone:'',//用户电话
                city: '',//所在城市
                cityCode:'',//城市编码
                insurance: ''
            }
        },
        paramZh:function(){
            var param = {};
            var submitData = this.submitData;
            param['encryptParam'] = this.encrypt(submitData['userName'] + '|' + submitData['userPhone']);
            for(var i in submitData){
                if(i !== 'userName' && i !== 'userPhone' && submitData[i] !== '' && submitData[i] !== null){
                    param[i] = submitData[i];
                }
            }
            return param;
        },
        encrypt:function(str){
            if(typeof(JSEncrypt) !== 'undefined'){
                if(!this.encryptEl){
                    this.encryptEl = new JSEncrypt();
                }
                this.encryptEl.setPublicKey(APP.pKey);
                return encodeURIComponent(this.encryptEl.encrypt(str));
            }else{
                return str;
            }
        }
    }
    CarLoanPage.init();
}