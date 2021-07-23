var Siscovid = Siscovid || {};

Siscovid.UcsCadastroRapido = (function() {
	
	function UcsCadastroRapido() {
		
		this.modal = $('#modalCadastroRapidoUCS');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-ucs-salvar-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');	
		this.inputSiglaUcs = $('#siglaUcs');
		this.inputDescricaoUcs = $('#descricaoUcs');
		this.inputEnderecoUcs = $('#enderecoUcs');
		
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-ucs');

	}
	
	UcsCadastroRapido.prototype.iniciar = function(){
		this.form.on('submit', function(event) {event.preventDefault(); });	
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}
	
	function onModalShow() {
		this.inputSiglaUcs.focus();
	}
	
	function onModalClose() {
		this.inputSiglaUcs.val('');
		this.inputDescricaoUcs.val('');
		this.inputEnderecoUcs.val('');
		
		this.containerMensagemErro.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
		
	}
	
	function onBotaoSalvarClick() {
		
		var siglaUcs = this.inputSiglaUcs.val().trim();
		var descricaoUcs = this.inputDescricaoUcs.val().trim();
		var enderecoUcs = this.inputEnderecoUcs.val().trim();
		
		
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({sigla: siglaUcs, 
								  descricao: descricaoUcs, 
								  endereco: enderecoUcs 								  										
								  
}),
			error: onErroSalvandoUcs.bind(this),
			success: onUcsSalva.bind(this)
		});		
	}
	
	function onErroSalvandoUcs(obj) {
		var mensagemErro = obj.responseText;
		this.containerMensagemErro.removeClass('hidden');
		this.containerMensagemErro.html('<span>'+mensagemErro+ '</span>');
		this.form.find('.form-group').addClass('has-error');
	}
			
	function onUcsSalva(ucs) {
		var comboUcs = $('#ucs');
		comboUcs.append('<option value=' + ucs.codigo + '>' + ucs.sigla + '</option>');
		comboUcs.val(ucs.codigo);
		this.modal.modal('hide');
	}
	
	return UcsCadastroRapido;
	
}());

$(function() {	
	var ucsCadastroRapido = new Siscovid.UcsCadastroRapido();
	ucsCadastroRapido.iniciar();
		
});
