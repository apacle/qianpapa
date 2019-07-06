$(function () {
    inv.init();
    $(document).bind("keydown", function (e) {
        e = window.event || e;

        //禁止空格键翻页
        if (event.keyCode == 32) {
            return false;
        }

        //屏蔽F5刷新键
        if (event.keyCode == 116) {
            e.keyCode = 0; //IE下需要设置为keyCode为false
            return false;
        }

        //屏蔽 Alt+ 方向键 ←
        //屏蔽 Alt+ 方向键 →
        if ((event.altKey) && ((event.keyCode == 37) || (event.keyCode == 39))) {
            event.returnValue = false;
            return false;
        }

        /* //屏蔽退格删除键
        if(event.keyCode==8){
            return false;
        }  */

        //屏蔽ctrl+R
        if ((event.ctrlKey) && (event.keyCode == 82)) {
            e.keyCode = 0;
            return false;
        }

//		$('.main_input').focus(function(){
//			$(this).parent('.main_box').css('border','1px solid #63c6ed');
//		})
//		$('.main_input').blur(function(){
//			$(this).parent('.main_box').css('border','1px solid #cacaca');
//		})
    });

    $(document).bind("contextmenu", function (event) {
        return false;
    });
    window.history.forward(1);
});
var inv = {
    addPlus: null,
    custToken: '',
    nameInput: $("#userName"),
    tel: $("#telphone"),
    totalLoan: 0,
    mediaSourceId: null,
    openId: null,
    title: '【贷款计算器】邀您来做额度测试！',
    desc: '想知道您的贷款额度有多高吗？点我马上估算！',
    picUrl: 'images/sharelogo.jpg',//待定
    initLink: 'jisuanqi/calculate.html',
    init: function () {
        var this_ = this;
        this_.openId = this_.getUrlParams("openid");
        // this_.getCusToken();
        this_.addPlus = this_.getUrlParams("addPlus");
        if (!this_.addPlus)//控制姓名与手机号输入框显示 0：不显示;1:显示
            this_.addPlus = 1;
        this_.bind();
        this_.initMedia();
        var formCode = this_.getUrlParams("formCode");
        if (formCode) {
            $('#formCode').val(formCode);
        }
        var now = new Date();
        $('.up_date').text("测试时间：" + now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate());
        if (this_.addPlus == 1) {
            $(".main_box").css('display', "block");
        }
        //取cookie中的姓名手机号
        this.setUserInfo();
        this.isShare();
    },

    bind: function () {
        var this_ = this;
        $("#calculate").click(function () {
            this_._calculateLoanLimit();
        });
        //选择框右对齐的问题
        var selectWidth = $('.box_select').width();
        $('.box_select').change(function () {
            var options = $(".box_select option:selected");  //获取选中的项
            var opt_txt = options.text()   //拿到选中项的文本
            var opt_txt_width = opt_txt.length;
            var s = $(this).css('font-size');
            s = s.substring(0, s.length - 2);
            var p_left = (selectWidth - 10) - opt_txt_width * s;
//  		$(this).css('padding-left',p_left);
        })
        $('.box_select').trigger('change');

        //关闭分享
        $('.mgm_close').click(function () {
            $('.d_share').css('display', 'none');
        });
        //弹窗分享微信，QQ
        $('.mgm_close').click(function () {
            $('.d_share').css('display', 'none');
        })

        $('.cal_black').click(function () {//关闭云
            $('.cal_tag').css('display', 'none');
        });
        $('.cal_share').click(function () {
            $('.cal_tag').css('display', 'none');
        });

        $("#shareToWX").click(function () {
            alert("请在微信中打开");
        });
        $("#shareToPeople").click(function () {
            alert("请在微信中打开");
        });
        $("#telphone").blur(function () {
            inv._leakTelValidator();
        });
        $('#shareToQq').bind("click", function () {
            var localUrl = window.location.host;
            if (localUrl.indexOf('test-haodai.pingan.com') != -1) {//新域名
                link = 'http://test-haodai.pingan.com/' + this_.link;
                picUrl = 'https://test-haodai.pingan.com/jisuanqi/' + this_.picUrl;
            } else if (localUrl.indexOf('haodai.pingan.com') != -1) {
                link = 'http://haodai.pingan.com/' + this_.link;
                picUrl = 'https://haodai.pingan.com/jisuanqi/' + this_.picUrl;
            }
            var shareqqzonestring = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?desc=' + this_.desc + '&title=' + this_.title + '&summary=' + this_.title + '&url=' + window.encodeURIComponent(link) + '&pics=' + window.encodeURIComponent(picUrl);
            window.open(shareqqzonestring, 'newwindow', 'height=400,width=400,top=100,left=100');
        });
    },
    initMedia: function () {
        var this_ = this;
        this_.mediaSourceId = this_.getUrlParams("WT.mc_id");

        if (this_.getUrlParams("idMedia")) {
            var mediaSource = this_.getUrlParams("idMedia");
            mediaSource = base64_decode(mediaSource);
            var mediaSourceList = mediaSource.split("&");
            if (mediaSourceList.length > 1) {
                $('#idMediaSourceSence').val(mediaSourceList[0]);
                $('#mediaSource').val(mediaSourceList[1]);
                $('#sourceType').val("2");
                if (mediaSourceList[2]) {
                    $('#sourceType').val("3");
                }
            }
        } else if (this_.mediaSourceId) {
            $('#mediaSource').val(this_.mediaSourceId);
        }

        if (this_.openId) {
            $.ajax({
                type: 'POST',
                url: '/do/rsploan/getMediaSouceInfoByOpenId',
                data: {
                    "openId": this_.openId
                },
                dataType: 'json',
                success: function (data) {
                    if (data && data.mediaSourceId) {
                        $('#mediaSource').val(data.mediaSourceId);
                        $('#campaignCode').val("XX_CAMP_WXWX");
                        $('#sourceType').val("1");
                        var idMediaSourceSence = data.idMediaSourceSence ? data.idMediaSourceSence : "";
                        $('#idMediaSourceSence').val(idMediaSourceSence);
                    }
                }
            });
            this_.setCookie("clentNo", this_.openId, 60);
        }
    },
    _calculateLoanLimit: function () {
        var this_ = this;
        if (this_._checkIncome($("#income"))) {
            if (this_.addPlus == 1) {// 进行姓名和手机号校验，校验通过存cookies
                if (this_._inputNameValidator() && this_._inputTelValidator()) {
                    this_.setCookie("name", $("#userName").val(), 60);
                    this_.setCookie("tel", $("#telphone").val(), 60);
                    this_.setCookie("userName", $("#userName").val(), 5);
                    this_.setCookie("telphone", $("#telphone").val(), 5);
                    //名单下发
                    if (!$("#calculate").hasClass('lodging')) {
                        $("#calculate").addClass('lodging');
                        var params = {
                            name: inv.trim($("#userName").val(), "g"),
                            mobile: $("#telphone").val(),
                            campaignName: $('#campaignName').val(),
                            campaignCode: $('#campaignCode').val(),
                            pageType: $('#pageType').val(),
                            isDirectForm: $('#isDirectForm').val(),
                            formCode: $('#formCode').val(),
                            smsAuthor: $('#smsAuthor').val(),
                            lpPage: $('#lpPage').val(),
                            innerMedia: $('#innerMedia').val(),
                            mediaSourceId: $('#mediaSource').val(),
                            sourceType: $('#sourceType').val(),
                            custSrc: $('#custSrc').val(),
                            openId: this_.openId,
                            idMediaSourceSence: $('#idMediaSourceSence').val(),
                            netCampaignCode: $('#netCampaignCode').val()
                        };

                        $.ajax({
                            type: 'POST',
                            url: '/do/rsploan/newYdsModifyFirstStep',//调名单下发接口
                            data: params,
                            dataType: 'json',
                            success: function (response) {
                                if (response != null && response.error != null)
                                    $("#calculate").removeClass('lodging');
                            }
                        });
                    }
                } else
                    return;
            }
            if (this_._loanLimit()) {
                if (this_.openId) {//获取openId
                    //本次计算入库
                    var params = {
                        openId: this_.openId,
                        name: $("#userName").val(),
                        telphone: $("#telphone").val(),
                        career: $("#workKind").find("option:selected").text(),
                        income: $("#income").val(),
                        maxloan: inv.totalLoan
                    };
                    // $.ajax({
                    //     type: 'POST',
                    //     data: params,
                    //     url: '/do/rsploan/saveLoanLimitInfo',
                    //     dataType: 'json',
                    //     success: function (response) {
                    //     }
                    // });
                }
                window.localStorage.setItem('customerIncome', $("#income").val());
                window.localStorage.setItem('customerJob', $("#workKind").find("option:selected").text());
                //跳转
                window.location.href = "calculateResult.html?totalLoan=" + this_.totalLoan + "&addPlus=" + this_.addPlus + "&WT.mc_id=" + $('#mediaSource').val();
            }
        }
    },
    _checkIncome: function (object) {//收入规则校验
        var value = object.val();
        var status = true;
        if ($("#income").is(object)) {
            if (value == null || value == "") {
                $("#incomeError").html("请输入您的月收入");
                status = false;
            } else if (!inv._checkNumber(object)) {
                $("#incomeError").html("请输入正整数");
                status = false;
            } else if (!inv._checkMax(object)) {
                $("#incomeError").html("请核实您的月收入信息");
                status = false;
            } else {
                if (value == 0)
                    object.val("0");
                else
                    object.val(value.replace(/\b(0+)/gi, ""));//去除左边多余的0
                $("#incomeError").html("");
                return true;
            }
            if (!status) {
                //object.val("");
                object.focus();
                return status;
            }
        }
    },

    _checkNumber: function (object) {
        var patrn = /^[1-9]\d*$/;//不允许输入空格
        var Reg_No = object.val().replace(/^\s*/g, "").replace(/\s*$/g, "");
        var result = true;
        if (!patrn.exec(Reg_No)) {
            result = false;
        }
        return result;
    },
    _checkMax: function (object) {
        var result = true;
        if (object.val() > 9999999999.9999)
            result = false;
        return result;
    },
    trim: function (str, is_global) {
        var result;
        result = str.replace(/(^\s+)|(\s+$)/g, "");
        if (is_global.toLowerCase() == "g") {
            result = result.replace(/\s/g, "");
        }
        return result;

    },
    // 手机号码验证并捡漏
    _leakTelValidator: function () {
        var phoneVal = $("#telphone").val();
        var nameVal = $("#userName").val();
        if (!phoneVal) {
            return false;
        } else if (!/^(13|14|15|16|17|18|19)[0-9]{1}[0-9]{4}[0-9]{4}$/.test(phoneVal)) {
            return false;
        } else {
            $("#incomeError").html("");
            $.ajax({
                type: 'POST',
                data: {
                    "teleNum": phoneVal,
                    "name": nameVal,
                    "mediaSourceName": $('#idMediaSourceSence').val(),
                    "mediaSourceId": $('#mediaSource').val()
                },
                url: '/do/rspLeakPool/addLeakPoolMobile',
                dataType: 'json',
                success: function (response) {
                }
            });
            return true;
        }
    },
    // 手机号码验证
    _inputTelValidator: function () {
        var phoneVal = $("#telphone").val();
        var nameVal = $("#userName").val();
        if (!phoneVal) {
            $("#incomeError").html("请输入您的手机号");
            $("#telphone").focus();
            return false;
        } else if (!/^(13|14|15|16|17|18|19)[0-9]{1}[0-9]{4}[0-9]{4}$/.test(phoneVal)) {
            $("#incomeError").html("请输入正确的手机号");
            $("#telphone").val("");
            $("#telphone").focus();
            return false;
        } else {
            /*var repeat = 1;
            var seque = 1;
            for (var i = 1; i < phoneVal.length; i++) {
                if (phoneVal.charAt(i) == phoneVal.charAt(i - 1)) {
                    repeat++;
                    if (repeat >= 5) {
                    	$("#incomeError").html("请输入正确的手机号");
                    	$("#telphone").val("");
                    	$("#telphone").focus();
                        return false;
                    }
                } else {
                    repeat = 1;
                }
                if (phoneVal.charAt(i) - phoneVal.charAt(i - 1) == '1') {
                    seque++;
                    if (seque >= 6) {
                    	$("#incomeError").html("请输入正确的手机号");
                    	$("#telphone").val("");
                    	$("#telphone").focus();
                        return false;
                    }
                } else if (phoneVal.charAt(i) - phoneVal.charAt(i - 1) == '-1') {
                    seque2++;
                    if (seque2 >= 6) {
                    	$("#incomeError").html("请输入正确的手机号");
                    	$("#telphone").val("");
                    	$("#telphone").focus();
                        return false;
                    }
                } else {
                    seque = 1;
                    seque2 = 1;
                }
            }*/
            $("#incomeError").html("");
            return true;
        }
    },
    _inputNameValidator: function () {
        var nameVal = $("#userName").val();
        if (!nameVal) {
            $("#incomeError").html("姓名只能为中文，且不能有空格。");
            $("#userName").val("");
            $("#userName").focus();
            return false;
        } else if (nameVal && !(/^([\u4e00-\u9fa5\s]{2})([\u4e00-\u9fa5\s]{0,18}|[. ]{0,36}|[? ]{0,36})?$/.test(nameVal))) {
            $("#incomeError").html("姓名只能为中文，且不能有空格。");
            $("#userName").val("");
            $("#userName").focus();
            return false;
        } else if (nameVal == '不详' || nameVal == '不祥' || nameVal == '未知' || nameVal == '不知道' || nameVal == '姓名' || nameVal.indexOf('测试') > -1 || nameVal.indexOf('test') > -1) {
            $("#incomeError").html("请输入正确的姓名。");
            $("#userName").val("");
            $("#userName").focus();
            return false;
        } else {
            $("#incomeError").html("");
            return true;
        }
    },

    _loanLimit: function () {//贷款额度计算规则
        //计算1
        var limit1 = 0;
        var income = $("#income").val();
        if ($("#workKind").val() == 'companeyEmployee') {
            inv.totalLoan = income * 12;
        } else if ($("#workKind").val() == 'govermentEmployee') {
            inv.totalLoan = income * 40;
        } else if ($("#workKind").val() == 'businessman') {
            inv.totalLoan = income * 10;
        } else if ($("#workKind").val() == 'selfEmployed') {
            inv.totalLoan = income * 12;
        } else {
            return false;
        }
        if (inv.totalLoan > 500000)
            inv.totalLoan = 500000;
        return true;
    },
    // 获取URL参数
    getUrlParams: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    },
    setCookie: function (name, value, minute) {
        var d = new Date();
        d.setTime(d.getTime() + (60 * 1000 * minute));
        expires = d.toGMTString();
        value = escape(value);//中文姓名解析
        document.cookie = name + "=" + value + ";"
            + (expires != -1 ? " expires=" + expires + ";" : "")
            + ("path=/");
    },
    getCookie: function (name) {
        var strCookie = unescape(document.cookie);
        var arrCookie = strCookie.split(";");
        for (var i = 0; i < arrCookie.length; i++) {
            var arr = arrCookie[i].split("=");
            if ($.trim(arr[0]) == name)
                return $.trim(arr[1]);
        }
        return "";
    },
    setUserInfo: function () {
        var userName = this.getCookie("userName")
        var telphone = this.getCookie("telphone");
        if (userName) {
            $("#userName").val(userName);
        }
        if (telphone) {
            $("#telphone").val(telphone);
        }
    },
    is_weixn: function () {
        var ua = navigator.userAgent.toLowerCase();
        var isw = ua.match(/MicroMessenger/i);
        if (isw && isw.join("") === "micromessenger") {
            return true;
        }
        return false;
    },
    initShare: function () {
        var this_ = this;
        this_.link = this_.initLink;
        if (this_.is_weixn()) {
            if (!this_.openId) {
                wxShare.share(this_.title, this_.title, this_.initLink, this_.desc, this_.picUrl, '1111111111111111', this_.custToken);
            } else {
                wxShare.share(this_.title, this_.title, this_.initLink, this_.desc, this_.picUrl, this_.openId, this_.custToken);
            }
        }
    },
    isShare: function () {
        var isShare = this.getCookie("isShare");
        //分享控件
        if (isShare == 'Y') {
            if (this.is_weixn()) {//提示微信右上角分享
                //$('.cal_tag').css('display','block');
            } else {//如果是浏览器打开
                $('.d_share').css('display', 'block');
            }
        }
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
    // 			inv.custToken = data.cusToken;
    // 			inv.initShare();
    // 		}
    // 	});
    // }
}
