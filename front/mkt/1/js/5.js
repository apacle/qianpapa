webpackJsonp([5], {
    "q+R1": function (t, e, o) {
        "use strict";
        Object.defineProperty(e, "__esModule", {value: !0});
        var i = {
            name: "job-type", data: function () {
                return {
                    jobCurrCode: "",
                    jobType: [{name: "上班族", code: "01", limit: 5}, {name: "企业主", code: "02", limit: 10}],
                    moneyType: [{name: "现金流水", code: "04"}, {name: "打卡资金", code: "03"}],
                    monthlyIncome: [{name: "0-1500", code: "05", limit: .4}, {
                        name: "1500-3000",
                        code: "06",
                        limit: .8
                    }, {name: "3000-6000", code: "07", limit: 1.5}, {
                        name: "6000-9000",
                        code: "08",
                        limit: 2.3
                    }, {name: "9000-12000", code: "09", limit: 3}, {name: "12000以上", code: "10", limit: 6}],
                    accumulationFund: [{name: "有", code: "11", limit: 10}, {name: "无", code: "12"}]
                }
            }, created: function () {
                sessionStorage.setItem("cn", this.$route.query.cn), this.$store.commit("CHANGECHANID", this.$route.query.cn), this.$calcLimit(this.$route.name, 0, 0), document.title = "额度评估"
            }, watch: {
                $route: function (t, e) {
                    "create-success" === e.name && "job-type" === t.name && location.reload()
                }
            }, methods: {
                jobClick: function (t) {
                    custJob = t.name;
                    this.jobCurrCode = t.code || "", this.$calcLimit(this.$route.name, 0, t.limit)
                }, moneyClick: function (t) {
                    this.$calcLimit(this.$route.name, 1, t.limit)
                }, monthlyIncomeClick: function (t) {
                    this.$calcLimit(this.$route.name, 2, t.limit)
                }, accumulationFundClick: function (t) {
                    this.$calcLimit(this.$route.name, 3, t.limit)
                }, nextStep: function () {
                    if (this.jobType.some(function (t) {
                        return t.click
                    })) if ("01" !== this.jobCurrCode || this.moneyType.some(function (t) {
                        return t.click
                    })) {
                        var t = this.$copy(this.monthlyIncome);
                        t.splice(0, 1), t.some(function (t) {
                            return t.choose
                        }) ? "01" === this.jobCurrCode ? this.accumulationFund.some(function (t) {
                            return t.click
                        }) ? this.$router.push("/house-state") : this.$toast("请选择公积金") : this.$router.push("/house-state") : this.$toast("请选择月收入/流水")
                    } else this.$toast("请选择资金类型"); else this.$toast("请选择职业特征")
                }
            }
        }, n = {
            render: function () {
                var t = this, e = t.$createElement, o = t._self._c || e;
                return o("div", {staticClass: "job-type"}, [o("f-click", {
                    attrs: {
                        title: "职业特征",
                        code: "01",
                        option: t.jobType
                    }, on: {"on-click": t.jobClick}
                }), t._v(" "), o("div", {
                    directives: [{
                        name: "show",
                        rawName: "v-show",
                        value: t.jobCurrCode,
                        expression: "jobCurrCode"
                    }]
                }, ["01" === t.jobCurrCode ? o("f-click", {
                    attrs: {title: "资金类型", code: "02", option: t.moneyType},
                    on: {"on-click": t.moneyClick}
                }) : t._e(), t._v(" "), o("f-select", {
                    attrs: {
                        title: "月收入/流水",
                        state: t.jobCurrCode,
                        code: "03",
                        option: t.monthlyIncome
                    }, on: {"on-select": t.monthlyIncomeClick}
                }), t._v(" "), "01" === t.jobCurrCode ? o("f-click", {
                    attrs: {
                        title: "公积金",
                        code: "04",
                        option: t.accumulationFund
                    }, on: {"on-click": t.accumulationFundClick}
                }) : t._e()], 1), t._v(" "), o("f-button", {on: {"on-click": t.nextStep}}, [t._v("下一步")])], 1)
            }, staticRenderFns: []
        }, c = o("C7Lr")(i, n, !1, null, null, null);
        e.default = c.exports
    }
});
//# sourceMappingURL=5.b94d48b7420b46607272.js.map