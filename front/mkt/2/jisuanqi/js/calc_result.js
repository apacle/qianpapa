$(function () {
    //页面初始化
    jisuan.init();
    //重新检测
    var _againWidth = $('.head_again').width();
    var _screenWidth = $(window).width();
    var _againLeft = _screenWidth / 2 - _againWidth / 2;
    $(".head_again").css("margin-left", _againLeft + "px");

    window.history.forward(1);
});

/**
 * 计算器页面对象 jisuan
 */
var jisuan = {
    globalLoan: null,
    custToken: '',
    title: '【贷款计算器】邀您来做额度测试！',
    desc: '想知道您的贷款额度有多高吗？点我马上估算！',
    picUrl: 'images/sharelogo.jpg',//待定
    initLink: 'jisuanqi/calculate.html',
    link: '',
    openId: null,
    mediaSourceId: null,
    init: function () {
        var this_ = this;
        this_.openId = this_.getCookie("clentNo");
        this_.mediaSourceId = this_.getUrlParams("WT.mc_id");
        this_.globalLoan = this_.changeShow(this_.getUrlParams("totalLoan"));

        $("#showResult").html(jisuan.escapeHTML(this_.globalLoan));
        // this_.getCusToken();
        // this_.showInfo();
        this_.bind();
    },

    escapeHTML: function (a) {
        a = "" + a;
        return a.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;");
    },

    initShare: function () {
        var this_ = this;
        this_.link = this_.initLink;
        if (this_.is_weixn()) {
            if (!this_.openId) {
                wxShare.share(this_.title, this_.title, this_.link, this_.desc, this_.picUrl, '1111111111111111', this_.custToken);
            } else {
                wxShare.share(this_.title, this_.title, this_.link, this_.desc, this_.picUrl, this_.openId, this_.custToken);
            }
        }
    },
    bind: function () {
        var this_ = this;
        $("#loanRequest").click(function () {
            var checkSwitch = this_.getUrlParams("addPlus");
            if (this_.mediaSourceId) {
                window.location.href = "../wap/huoke/yiduanshi.html?checkSwitch=" + checkSwitch + "&WT.mc_id=" + this_.mediaSourceId;
                return;
            }
            window.location.href = "../wap/huoke/yiduanshi.html?checkSwitch=" + checkSwitch;
        });
        $("#again").click(function () {
            if (this_.openId) {
                if (this_.mediaSourceId) {
                    window.location.href = "calculate.html?openid=" + this_.openId + "&WT.mc_id=" + this_.mediaSourceId;
                    ;
                    return;
                }
                window.location.href = "calculate.html?openid=" + this_.openId;
                return;
            }
            if (this_.mediaSourceId) {
                window.location.href = "calculate.html?WT.mc_id=" + this_.mediaSourceId;
                ;
                return;
            }
            window.location.href = "calculate.html";
        });

        $(".service").click(function () {
            if (this_.is_weixn()) {//跳转微信绑定页面
                var localUrl = window.location.host;
                if (localUrl.indexOf('test-haodai.qianpapa.com') != -1) {//新域名
                    window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1fab99773ab4588d&redirect_uri=http%3A%2F%2Feim-talk-stg.dmzstg.qianpapa.com.cn%2Fits-pir%2Fredirect%3FbackUrl%3Dhttp%3A%2F%2Ftest-haodai.qianpapa.com%2Fjisuanqi%2FmiddleJump-ucp.html%26weappNo%3Dqianpapa_HD_01&response_type=code&scope=snsapi_base&state=sig#wechat_redirect";
                } else if (localUrl.indexOf('haodai.qianpapa.com') != -1) {
                    window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxea8c2a184f6288c4&redirect_uri=http%3A%2F%2Feim.qianpapa.com.cn%2Fits%2Fredirect%3FbackUrl%3Dhttp%3A%2F%2Fhaodai.qianpapa.com%2Fjisuanqi%2FmiddleJump-ucp.html%26weappNo%3Dqianpapa_HD_01&response_type=code&scope=snsapi_base&state=sig#wechat_redirect";
                }
            } else
                alert("请在微信中打开");
        });
        $('.cal_black').click(function () {//关闭云
            $('.cal_tag').css('display', 'none');
        });
        $('.cal_share').click(function () {
            $('.cal_tag').css('display', 'none');
        });
        $("#share").click(function () {
            if (this_.is_weixn()) {//提示微信右上角分享
                $('.cal_tag').css('display', 'block');//显示云
            } else {//如果是浏览器打开
                this_.setCookie("isShare", "Y", 120);
                var url = "calculate.html";
                if (this_.openId) {
                    url = url + "?openid=" + this_.openId;
                    if (this_.mediaSourceId) {
                        url = url + "&WT.mc_id=" + this_.mediaSourceId;
                    }
                } else if (this_.mediaSourceId) {
                    url = url + "?WT.mc_id=" + this_.mediaSourceId;
                }
                window.location.href = url;
            }
        });
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
        var strCookie = document.cookie;
        var arrCookie = strCookie.split(";");
        for (var i = 0; i < arrCookie.length; i++) {
            var arr = arrCookie[i].split("=");
            if ($.trim(arr[0]) == name)
                return $.trim(arr[1]);
        }
        return "";
    },
    showInfo: function () {
        var params = {
            pictrueType: "6"
        };
        $.ajax({
            type: 'POST',
            url: '/do/rsploan/queryPictureInfo',//调名单下发接口
            data: params,
            dataType: 'json',
            success: function (response) {
                if (response != null && response.dataList != null && response.dataList.length > 0) {
                    var dtl = response.dataList;
                    for (var i = 0; i < dtl.length; i++) {
                        var dt = dtl[i];
                        if ('Y' == dt.isEffect) {
                            var text = "<a href='" + dt.pictureTargetLink + "' target='_blank'otype='button' otitle='dkjsq.article" + i + "'><div class='cal_con_box fix'>" +
                                "<div class='mgm fl'><img src='/do/rsploan/viewhomepicture?imgType=11&fileName=" + dt.pictureName + "&switch=newloan' alt='' /></div>" +
                                "<div class='mgm_tit fl'>" +
                                "<div class='mgm_tit_txt'>" + dt.pictureTitle + "</div>" +
                                "<div class='mgm_date'>" + dt.createdDateStr + "</div>" +
                                "</div></div></a>";
                            $("#xiangguanzhishi").append(text);
                        }
                    }
                } else {
                    var text = "<div class='cal_con_box fix'>" +
                        "<div class='mgm fl'><img src='images/mgm.jpg' alt='' /></div>" +
                        "<div class='mgm_tit fl'>" +
                        "<div class='mgm_tit_txt'>邀请好友得奖金，上千奖金送不停</div>" +
                        "<div class='mgm_date'>2017-06-08 &nbsp;22:00:06</div>" +
                        "</div></div>";
                    $("#xiangguanzhishi").append(text);
                    $("#xiangguanzhishi").append(text);
                }
            }
        });
    },
    is_weixn: function () {
        var ua = navigator.userAgent.toLowerCase();
        var isw = ua.match(/MicroMessenger/i);
        if (isw && isw.join("") === "micromessenger") {
            return true;
        }
        return false;
    },
    changeShow: function (value) {
        return value.split('').reverse().join('').replace(/(\d{3})/g, '$1,').replace(/\,$/, '').split('').reverse().join('');
    },
    getUrlParams: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    },

    /**
     *获取cusToken
     */
    getCusToken: function () {
        $.ajax({
            type: "POST",
            url: "/do/rsploan/getCusToken",
            dataType: "text",
            success: function (data) {
                data = $.parseJSON(data);
                jisuan.custToken = data.cusToken;
                jisuan.initShare();
            }
        });
    }
}
