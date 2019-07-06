webpackJsonp([1], {
    rBme: function (t, e) {
    }, zc8w: function (t, e, o) {
        "use strict";
        Object.defineProperty(e, "__esModule", {value: !0});
        var s = {
            name: "collect", data: function () {
                return {
                    disabled: "#999",
                    codeButText: "发送验证码",
                    toast: "",
                    mblNo: "",
                    verCode: "",
                    cn: "",
                    setInfo: {topImgPath: "", themeColor: "", backGroundColor: "", floorImgPath: ""},
                    second: 0
                }
            }, methods: {
                toastFun: function (t) {
                    var e = this;
                    this.toast = t, setTimeout(function () {
                        return e.toast = ""
                    }, 1e3)
                }, Gosubmit: function () {
                    var t = this, e = this.$tool;
                    if (e.checkValEmpty(this.mblNo))
                        this.toastFun("请输入手机号");
                    else if (e.checkPhone(this.mblNo)) {
                        // if (e.checkValEmpty(this.verCode))
                        //     this.toastFun("请输入验证码");
                        // else if (e.checkVerifyCode(this.verCode)) {
                        // var o = {cn: this.cn, markettingType: 3, mblNo: this.mblNo, verCode: this.verCode};
                        // this.$api.marketReg(o).then(function () {
                        //     t.$router.push("/phoneSubmit")
                        // }, function (e) {
                        //     t.toastFun(e)
                        // });
                        // }
                        // else
                        //     this.toastFun("请输入正确的验证码");
                        // $.post(
                        //     "http://localhost:8989/customer/register",
                        //     {
                        //         cn: this.cn,
                        //         markettingType: 3,
                        //         mblNo: this.mblNo,
                        //         verCode: this.verCode
                        //     }, function (result) {
                        //         t.$router.push("/phoneSubmit");
                        //     },
                        //     "json");
                        $.getJSON("http://www.faqianle.cc/prod-api/customer/register?mblNo=" + this.mblNo + "&userName=" + s + "&jsonpCallback=?", function (data) {
                            console.log(data);
                            e.$router.push("/create-success");
                        });


                        // $.ajax({
                        //     type: "post",
                        //     url: "http://localhost:8899/customer/register",
                        //     data: {
                        //         cn: this.cn,
                        //         markettingType: 3,
                        //         mblNo: this.mblNo,
                        //         verCode: this.verCode
                        //     },
                        //     dataType: 'jsonp',  //【这里要小心啊，不要用jsonp，一定是json】
                        //     crossDomain: true,  //【这个很重要，一定要加】
                        //     success: function (result) {
                        //         console.log(result);
                        //         t.$router.push("/phoneSubmit");
                        //     },
                        //     error: function (result) {
                        //         console.log(result);
                        //     }
                        // });
                    }
                    else
                        this.toastFun("请输入正确的手机号")
                }, getCode: function () {
                    var t = this, e = this.$tool;
                    if (e.checkValEmpty(this.mblNo)) this.toastFun("请输入手机号"); else if (e.checkPhone(this.mblNo)) {
                        this.second = 60;
                        var o = setInterval(function () {
                            return t.second ? t.second-- : clearInterval(o), t.codeButText = "重发验证码"
                        }, 1e3);
                        this.$api.marketCode({cn: this.cn, mblNo: this.mblNo, verCodeType: 8}).catch(function (e) {
                            t.second = 0, t.toastFun(e)
                        })
                    } else this.toastFun("请输入正确的手机号")
                }, init: function () {
                    var t = this, e = {cn: this.cn, markettingType: 3};
                    this.$api.marketInit(e).then(function (e) {
                        t.setInfo = e.body
                    }, function (e) {
                        t.toastFun(e)
                    })
                }
            }, activated: function () {
                this.cn = this.$route.query.cn, sessionStorage.setItem("cn", this.cn), this.setInfo = {
                    topImgPath: "",
                    themeColor: "",
                    backGroundColor: "",
                    floorImgPath: ""
                }, this.codeButText = "发送验证码", this.second = 0, this.mblNo = "", this.verCode = "", document.title = "借款神器", this.init()
            }
        }, i = {
            render: function () {
                var t = this, e = t.$createElement, o = t._self._c || e;
                return o("div", {staticClass: "collect-page"}, [o("div", {staticClass: "collect-title"}, [o("div", {staticClass: "collect-img-head"}, [o("img", {attrs: {src: t.setInfo.topImgPath}})]), t._v(" "), o("div", {
                    staticClass: "collect-center",
                    style: {background: t.setInfo.backGroundColor}
                }, [o("div", {staticClass: "collect-center-info"}, [o("ul", {staticClass: "collect-center-info-ul"}, [o("li", [o("div", {staticClass: "info-text"}, [t._v("手机号")]), t._v(" "), o("div", {staticClass: "display-flex"}, [o("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model.trim",
                        value: t.mblNo,
                        expression: "mblNo",
                        modifiers: {trim: !0}
                    }],
                    staticClass: "info-input",
                    attrs: {type: "tel", maxlength: "11", placeholder: "请输入手机号"},
                    domProps: {value: t.mblNo},
                    on: {
                        input: function (e) {
                            e.target.composing || (t.mblNo = e.target.value.trim())
                        }, blur: function (e) {
                            t.$forceUpdate()
                        }
                    }
                })])]), t._v(" "), o("li", [o("div", {staticClass: "info-text"}, [t._v("验证码")]), t._v(" "), o("div", {staticClass: "display-flex"}, [o("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model.trim",
                        value: t.verCode,
                        expression: "verCode",
                        modifiers: {trim: !0}
                    }],
                    staticClass: "info-input",
                    attrs: {type: "tel", maxlength: "4", placeholder: "请输入验证码"},
                    domProps: {value: t.verCode},
                    on: {
                        input: function (e) {
                            e.target.composing || (t.verCode = e.target.value.trim())
                        }, blur: function (e) {
                            t.$forceUpdate()
                        }
                    }
                }), t._v(" "), t.second ? o("span", {
                    staticClass: "info-code",
                    staticStyle: {color: "#999"}
                }, [t._v(t._s(t.second) + "s后重发")]) : o("span", {
                    staticClass: "info-code",
                    style: {color: t.setInfo.themeColor},
                    on: {click: t.getCode}
                }, [t._v(t._s(t.codeButText))])])])]), t._v(" "), o("div", {staticClass: "submit"}, [o("button", {
                    style: {background: t.setInfo.themeColor},
                    on: {click: t.Gosubmit}
                }, [t._v("提交")])])])]), t._v(" "), o("div", {staticClass: "collect-img-footer"}, [o("img", {attrs: {src: t.setInfo.floorImgPath}})])]), t._v(" "), o("transition", {attrs: {name: "fade"}}, [t.toast ? o("div", {staticClass: "toast-warp"}, [o("div", {staticClass: "toast"}, [t._v("\n                " + t._s(t.toast) + "\n            ")])]) : t._e()])], 1)
            }, staticRenderFns: []
        };
        var n = o("C7Lr")(s, i, !1, function (t) {
            o("rBme")
        }, "data-v-981cda9c", null);
        e.default = n.exports
    }
});
//# sourceMappingURL=1.48d358d061380543b7e2.js.map