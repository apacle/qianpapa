webpackJsonp([4], {
    ZdT7: function (e, t, i) {
        "use strict";
        Object.defineProperty(t, "__esModule", {value: !0});
        var o = {
            render: function () {
                var e = this, t = e.$createElement, i = e._self._c || t;
                return i("div", {staticClass: "policy-state"}, [i("f-click", {
                    attrs: {
                        title: "保单情况",
                        code: "12",
                        option: e.policyState
                    }, on: {"on-click": e.policyClick}
                }), e._v(" "), i("div", {
                    directives: [{
                        name: "show",
                        rawName: "v-show",
                        value: "22" === e.policyCurrCode,
                        expression: "policyCurrCode==='22'"
                    }]
                }, [i("f-select", {
                    attrs: {title: "缴费期限", state: e.policyCurrCode, code: "13", option: e.paymentTerm},
                    on: {"on-select": e.paymentTermClick}
                })], 1), e._v(" "), i("f-button", {on: {"on-click": e.nextStep}}, [e._v("下一步")])], 1)
            }, staticRenderFns: []
        }, c = i("C7Lr")({
            name: "policy-state", data: function () {
                return {
                    policyCurrCode: "",
                    policyState: [{name: "有", code: "22", limit: 5}, {name: "无", code: "23"}],
                    paymentTerm: [{name: "缴费期满1年", code: "24"}, {name: "缴费期满1-2年", code: "25"}, {
                        name: "缴费期满2-3年",
                        code: "26"
                    }, {name: "缴费期满3年以上", code: "27"}]
                }
            }, created: function () {
                this.$calcLimit(this.$route.name, 0, 0)
            }, methods: {
                policyClick: function (e) {
                    this.policyCurrCode = e.code, this.$calcLimit(this.$route.name, 0, e.limit)
                }, paymentTermClick: function (e) {
                    this.$calcLimit(this.$route.name, 1, e.limit)
                }, nextStep: function () {
                    if (this.policyState.some(function (e) {
                        return e.click
                    })) if ("22" === this.policyCurrCode) {
                        var e = this.$copy(this.paymentTerm);
                        e.splice(0, 1), e.some(function (e) {
                            return e.choose
                        }) ? this.$router.push("/person-info") : this.$toast("请选择缴费期限")
                    } else this.$router.push("/person-info"); else this.$toast("请选择保单情况")
                }
            }
        }, o, !1, null, null, null);
        t.default = c.exports
    }
});
//# sourceMappingURL=4.839d6b688f6b9e1902c5.js.map