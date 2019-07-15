(function (window) {
	var applyNo = ""
	var callback = undefined
	var okBtnColor = "#ee6359"
	var dialogEl = document.createElement('div');
	var isLoading = false

	var dialog = {
		// number为申请编码，cb为回调函数, btnColor为授权按钮背景色
		show: function (number, cb, btnColor) {
			applyNo = number
			callback = cb
			okBtnColor = btnColor
			createDialog()
			bindEvent()
		}
	}

	function createDialog(){
		dialogEl.innerHTML = '<div class="auth-dialog-area auth-dialog-sq"> ' +
		'<div class="auth-dialog-main">' +
		'<div class="auth-dialog-content">' +
		'<h2 class="auth-tit">赠险个人信息使用授权条款</h2>' +
		'<div class="auth-info"><ul>' +
		'<li>1.钱爸爸银行将赠送您一份“百万随行”的意外险，此保险由中国钱爸爸人寿保险股份有限公司（以下简称“钱爸爸人寿”）承保。为完善您的承保信息，需要您按照第2点向钱爸爸银行及钱爸爸人寿进行相应授权。如您不同意授权，请点击“取消”按钮且不影响您此次申请钱爸爸银行贷款，钱爸爸银行将继续审核您的贷款申请。</li><br/>' +
		'<li>2.本人授权钱爸爸银行、钱爸爸人寿：除法律另有规定外，将本人信息，包括“姓名”，“手机号”，“城市”等个人信息提供给钱爸爸人寿。钱爸爸人寿有权使用本人个人信息用于完善承保信息、将本人加入钱爸爸行俱乐部（包含为本人提供7*24小时在线保险服务、不定期享受钱爸爸人寿提供的意外、健康等保障服务）。</li><br/>' +
		'<li>3.为确保您个人信息的安全，钱爸爸银行及钱爸爸人寿对上述信息负有保密义务，并采取各种措施保证信息安全。本条款自您点击“授权”按钮时产生法律效力。如您将来不同意上述全部或部分授权条款，可（致电客服热线（95511）或亲临钱爸爸银行网点）取消或变更相应授权。</li>' +
		'</ul></div>' +
		'</div><div class="auth-dialog-button">' +
		'<a class="auth-dialog-button-cancel" href="javascript:;" otitle="按钮-取消">取消</a><a class="auth-dialog-button-ok" style="background-color:' + okBtnColor + ';" href="javascript:;" otitle="按钮-授权">授权</a>' +
		'</div></div></div>';
		document.body.appendChild(dialogEl)
	}

	function bindEvent() {
		$('.auth-dialog-button-cancel').on('click', function () {
			document.body.removeChild(dialogEl)
			if (callback != undefined) {
				callback()
			}
		})
		$('.auth-dialog-button-ok').on('click', function () {
			if(isLoading){
				return
			}
			isLoading = true
			updateLoanState()
		})
	}

	function updateLoanState() {
		$.ajax({
			type: 'POST',
			url: APP.config.baseURI + '/brop/ma/cust/app/market/loan/updateInsurance.do',
			data: {
				applyCarLoanId: applyNo,
				insurance: "YES"
			},
			dataType: 'json',
			timeout:2000,
			success: function (res) {
				if (res.responseCode == '000000') {
					console.info("授权成功")
				} else {
					console.info(res.responseMsg)
				}
			},
			complete:function(){
				isLoading = false
				document.body.removeChild(dialogEl)
				if (callback != undefined) {
					callback()
				}
			},
			error: function () {
				console.info("授权接口错误")
			}
		})

	}

	window.authDialog = dialog;

})(window)
