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
	
	function MaskIdentidade(){
		this.inputIdentidade = $('.js-identidade');
	}
	
	MaskIdentidade.prototype.enable = function() {
		this.inputIdentidade.mask('000.000.000-0' , {reverse: true});
	}
	
	return MaskIdentidade;
	
}());

Siscovid.MaskCep = (function() {
	
	function MaskCep() {
		this.inputCep = $('.js-cep');
	}
	
	MaskCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}
	
	return MaskCep;
	
}());

Siscovid.MaskDate = (function() {
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}
	
	return MaskDate;
	
}());

Siscovid.Security = (function() {
	
	function Security() {
		this.token = $('input[name=_csrf]').val();
		this.header = $('input[name=_csrf_header]').val();
	}
	
	Security.prototype.enable = function() {
		$(document).ajaxSend(function(event, jqxhr, settings) {
			jqxhr.setRequestHeader(this.header, this.token);
		}.bind(this));
	}
	
	return Security;
	
}());

numeral.language('pt-br');

Siscovid.formatarMoeda = function(valor) {
	return numeral(valor).format('0,0.00');
}

Siscovid.recuperarValor = function(valorFormatado) {
	return numeral().unformat(valorFormatado);
}

$(function() {
	var maskMoney = new Siscovid.MaskMoney();
	maskMoney.enable();
	
	var maskPhoneNumber = new Siscovid.MaskPhoneNumber();
	maskPhoneNumber.enable();
	
	var maskIdentidade = new Siscovid.MaskIdentidade();
	maskIdentidade.enable();
	
	var maskCep = new Siscovid.MaskCep();
	maskCep.enable();
	
	var maskDate = new Siscovid.MaskDate();
	maskDate.enable();
	
	var security = new Siscovid.Security();
	security.enable();
	
});
