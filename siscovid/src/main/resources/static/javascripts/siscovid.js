var Siscovid = Siscovid || {};

Siscovid.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return MaskMoney;
	
}());

Siscovid.MaskPhoneNumber = (function() {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	
	return MaskPhoneNumber;
	
}());

Siscovid.MaskIdentidade = (function() {
	
	function MaskIdentidade() {
		this.inputIdentidade = $('.js-idt');
		
	}
	
	MaskIdentidade.prototype.enable = function() {
		this.inputIdentidade.mask('000.000.000-0');
	}
	
	return MaskIdentidade;
	
}());

$(function() {
	var maskMoney = new Siscovid.MaskMoney();
	maskMoney.enable();
	
	var maskPhoneNumber = new Siscovid.MaskPhoneNumber();
	maskPhoneNumber.enable();
	
	var maskIdentidade = new Siscovid.MaskIdentidade();
	maskIdentidade.enable();
	
});
