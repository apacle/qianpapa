webpackJsonp([2], {
    ACbq: function (e, t, s) {
        "use strict";
        Object.defineProperty(t, "__esModule", {value: !0});
        var a = {
            name: "person-info", data: function () {
                return {name: "", phone: "", code: "", second: 0}
            }, activated: function () {
                this.name = "", this.phone = "", this.code = "", this.second = 0
            }, methods: {
                sendCodeFun: function () {
                    var e = this, t = this.$tool, s = this.phone;
                    if (t.checkValEmpty(s)) this.$toast("请输入手机号"); else if (t.checkPhone(s)) {
                        this.second = 60;
                        var a = setInterval(function () {
                            return e.second ? e.second-- : clearInterval(a)
                        }, 1e3);
                        this.$api.marketCode({
                            cn: this.$store.state.cn,
                            mblNo: s,
                            verCodeType: "9"
                        }).catch(function (t) {
                            return e.second = 0
                        })
                    } else this.$toast("请输入正确的手机号")
                }, createPlan: function () {
                    var e = this, t = this.$tool, s = this.name, a = this.phone, i = this.code;
                    if (t.checkValEmpty(s))
                        this.$toast("请输入姓名");
                    else if (t.checkName(s))
                        if (t.checkValEmpty(a))
                            this.$toast("请输入手机号");
                        else if (t.checkPhone(a)) {
                            // if (t.checkValEmpty(i))
                            //     this.$toast("请输入验证码");
                            // else if (t.checkVerifyCode(i)) {
                            // var n = {
                            //     cn: this.$store.state.cn || sessionStorage.getItem("cn"),
                            //     mblNo: a,
                            //     userName: s,
                            //     verCode: i,
                            //     markettingType: "4",
                            //     answers: this.$store.state.answer
                            // };
                            // this.$api.marketReg(n).then(function () {
                            //     e.$router.push("/create-success")
                            // })
                            // }
                            // else
                            //     this.$toast("请输入正确的验证码");

                            // $.post(
                            //     "http://localhost:8899/customer/register",
                            //     {
                            //         cn: this.$store.state.cn || sessionStorage.getItem("cn"),
                            //         mblNo: a,
                            //         userName: s,
                            //         verCode: i,
                            //         markettingType: "4",
                            //         answers: this.$store.state.answer
                            //     }, function (result) {
                            //         e.$router.push("/create-success");
                            //     },
                            //     "json");
                            var baseUrl = "http://www.qianpapa.com/prod-api/";
                            if (window.location.href.indexOf("localhost") != -1) {
                                baseUrl = "http://localhost:8899/";
                            } else if (window.location.href.indexOf("faqianle.cc") != -1) {
                                baseUrl = "http://www.faqianle.cc/prod-api/";
                            }
                            var regexp = /\/[0-9]+\//g;
                            var nums = window.location.href.match(regexp);
                            var marketingId = 1;
                            if (nums.length > 0) {
                                marketingId = nums[0].replace("/", "").replace("/", "");
                            }

                            $.ajax({
                                type: "post",
                                url: baseUrl + "customer/register",
                                // url: "http://www.faqianle.cc/prod-api/customer/register",
                                data: {
                                    userId: GetQueryString("userId"),
                                    marketingId: marketingId,
                                    // cn: this.$store.state.cn || sessionStorage.getItem("cn"),
                                    customerPhone: a,
                                    customerName: s,
                                    customerJob: custJob,
                                    // verCode: i,
                                    // markettingType: "4",
                                    // answers: this.$store.state.answer
                                },
                                dataType: 'json',  //【这里要小心啊，不要用jsonp，一定是json】
                                crossDomain: true,  //【这个很重要，一定要加】
                                success: function (result) {
                                    e.$router.push("/create-success");
                                },
                                error: function (result) {
                                    console.log(result);
                                }
                            });
                        }
                        else
                            this.$toast("请输入正确的手机号");
                    else
                        this.$toast("请输入真实的姓名")
                }
            }
        }, i = {
            render: function () {
                var e = this, t = e.$createElement, s = e._self._c || t;
                return s("div", {staticClass: "person-info"}, [s("div", {staticClass: "infoWarp"}, [s("div", {staticClass: "title"}, [e._v("个人信息")]), e._v(" "), s("ul", {staticClass: "infoUl"}, [s("li", {staticClass: "infoLi"}, [s("label", {staticClass: "label"}, [e._v("姓名")]), e._v(" "), s("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model.trim",
                        value: e.name,
                        expression: "name",
                        modifiers: {trim: !0}
                    }],
                    staticClass: "input",
                    attrs: {placeholder: "请填写您的姓名", type: "text", maxlength: "4"},
                    domProps: {value: e.name},
                    on: {
                        input: function (t) {
                            t.target.composing || (e.name = t.target.value.trim())
                        }, blur: function (t) {
                            e.$forceUpdate()
                        }
                    }
                })]), e._v(" "), s("li", {staticClass: "infoLi"}, [s("label", {staticClass: "label"}, [e._v("手机号")]), e._v(" "), s("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model.trim",
                        value: e.phone,
                        expression: "phone",
                        modifiers: {trim: !0}
                    }],
                    staticClass: "input",
                    attrs: {placeholder: "请填写您的手机号", type: "tel", maxlength: "11"},
                    domProps: {value: e.phone},
                    on: {
                        input: function (t) {
                            t.target.composing || (e.phone = t.target.value.trim())
                        }, blur: function (t) {
                            e.$forceUpdate()
                        }
                    }
                })]), e._v(" "), s("li", {staticClass: "infoLi sendLi"}, [s("label", {staticClass: "label"}, [e._v("验证码")]), e._v(" "), s("input", {
                    directives: [{
                        name: "model",
                        rawName: "v-model.trim",
                        value: e.code,
                        expression: "code",
                        modifiers: {trim: !0}
                    }],
                    staticClass: "input",
                    attrs: {placeholder: "请填写短信验证码", type: "tel", maxlength: "4"},
                    domProps: {value: e.code},
                    on: {
                        input: function (t) {
                            t.target.composing || (e.code = t.target.value.trim())
                        }, blur: function (t) {
                            e.$forceUpdate()
                        }
                    }
                }), e._v(" "), s("span", {staticClass: "line"}), e._v(" "), e.second ? s("span", {staticClass: "sendCode"}, [e._v(e._s(e.second) + "s后重发")]) : s("span", {
                    staticClass: "sendCode",
                    on: {click: e.sendCodeFun}
                }, [e._v("发送验证码")])])])]), e._v(" "), s("f-button", {on: {"on-click": e.createPlan}}, [e._v("生成方案")])], 1)
            }, staticRenderFns: []
        };
        var n = s("C7Lr")(a, i, !1, function (e) {
            s("Tz5m")
        }, "data-v-5048e307", null);
        t.default = n.exports
    }, Tz5m: function (e, t) {
    }
});
//# sourceMappingURL=2.e690826231fae3a2d80b.js.map