var Siscovid = Siscovid || {};

Siscovid.UmsCadastroRapido = (function() {
	
	function UmsCadastroRapido() {
		
		this.modal = $('#modalCadastroRapidoUMS');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-ums-salvar-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');	
		this.inputSiglaUms = $('#siglaUms');
		this.inputDescricaoUms = $('#descricaoUms');
		this.inputEnderecoUms = $('#enderecoUms');
		
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-ums');

	}
	
	UmsCadastroRapido.prototype.iniciar = function(){
		this.form.on('submit', function(event) {event.preventDefault(); });	
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}
	
	function onModalShow() {
		this.inputSiglaUms.focus();
	}
	
	function onModalClose() {
		this.inputSiglaUms.val('');
		this.inputDescricaoUms.val('');
		this.inputEnderecoUms.val('');
		
		this.containerMensagemErro.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
		
	}
	
	function onBotaoSalvarClick() {
		
		var siglaUms = this.inputSiglaUms.val().trim();
		var descricaoUms = this.inputDescricaoUms.val().trim();
		var enderecoUms = this.inputEnderecoUms.val().trim();
		
		
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({sigla: siglaUms, 
								  descricao: descricaoUms, 
								  endereco: enderecoUms 								  										
								  
}),
			error: onErroSalvandoUms.bind(this),
			success: onUmsSalva.bind(this)
		});		
	}
	
	function onErroSalvandoUms(obj) {
		var mensagemErro = obj.responseText;
		this.containerMensagemErro.removeClass('hidden');
		this.containerMensagemErro.html('<span>'+mensagemErro+ '</span>');
		this.form.find('.form-group').addClass('has-error');
	}
			
	function onUmsSalva(ums) {
		var comboUms = $('#ums');
		comboUms.append('<option value=' + ums.codigo + '>' + ums.sigla + '</option>');
		comboUms.val(ums.codigo);
		this.modal.modal('hide');
	}
	
	return UmsCadastroRapido;
	
}());

$(function() {	
	var umsCadastroRapido = new Siscovid.UmsCadastroRapido();
	umsCadastroRapido.iniciar();
		
});
