var Siscovid = Siscovid || {};

	Siscovid.PessoaCadastroRapido = (function() {
		
		function PessoaCadastroRapido() {
		this.modal = $('#modalCadastroRapidoPaciente');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-pessoa-salvar-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.inputIdentidadePaciente = $('#identidadePaciente');
		this.inputNomePaciente = $('#nomePaciente');
		this.inputNomeGuerraPaciente = $('#nomeGuerraPaciente');
		this.inputEmailPaciente = $('#emailPaciente');
		this.selectPostoPaciente = $('#postoPaciente');
		this.selectOmPaciente = $('#omPaciente');
		this.selectTipoPaciente = $('#tipoPaciente');
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-pessoa');		
	}
	
	PessoaCadastroRapido.prototype.iniciar = function() {
		this.form.on('submit', function(event) {event.preDefault() });	
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}	
	
	function onModalShow() {
		this.inputIdentidadePaciente.focus();
	}
	
	function onModalClose(){
		 this.inputIdentidadePaciente.val('');
		 this.inputNomePaciente.val('');
		 this.inputNomeGuerraPaciente.val('');
		 this.inputEmailPaciente.val('');
		 this.selectPostoPaciente.val('');
		 this.selectOmPaciente.val('');
		 this.selectTipoPaciente.val('');
		 this.containerMensagemErro.addClass('hidden');
		 this.form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick(){
		var identidadePaciente = this.inputIdentidadePaciente.val().trim();
		var nomePaciente = this.inputNomePaciente.val().trim();
		var nomeGuerraPaciente = this.inputNomeGuerraPaciente.val().trim();
		var emailPaciente = this.inputEmailPaciente.val().trim();
		var postoPaciente = this.selectPostoPaciente.val().trim();
		var omPaciente = this.selectOmPaciente.val().trim();
		var tipoPaciente = this.selectTipoPaciente.val().trim();
		
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({identidade: identidadePaciente,
								  nome: nomePaciente,
								  nomeGuerra: nomeGuerraPaciente,
								  email: emailPaciente,
								  posto: postoPaciente,
								  om: {codigo: omPaciente},
								  tipoPaciente: tipoPaciente 
}),
			error: onErroSalvandoPaciente.bind(this),
			success: onPessoaSalva.bind(this)
		});
	}
	
	function onErroSalvandoPaciente(obj){
		var mensagemErro = obj.responseText;
		this.containerMensagemErro.removeClass('hidden');
		this.containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		this.form.find('.form-group').addClass('has-error');
		
	}
	
	function onPessoaSalva(paciente){
		var comboPaciente = $('#paciente');
		comboPaciente.append('<option value =' + paciente.codigo + '>' + paciente.nomeGuerra + '</option>');
		comboPaciente.val(paciente.codigo);
		this.modal.modal('hide');
	}
	
	return PessoaCadastroRapido;
	
}());

	
$(function() {
	
	var pessoaCadastroRapido = new Siscovid.PessoaCadastroRapido();
	pessoaCadastroRapido.iniciar();
		
});
