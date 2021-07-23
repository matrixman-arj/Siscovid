$(function() {
	
	var modal = $('#modalCadastroRapidoPaciente');
	var botaoSalvar = modal.find('.js-modal-cadastro-pessoa-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) {event.preDefault() });
	var url = form.attr('action');
	var inputIdentidadePaciente = $('#identidadePaciente');
	var inputNomePaciente = $('#nomePaciente');
	var inputNomeGuerraPaciente = $('#nomeGuerraPaciente');
	var inputEmailPaciente = $('#emailPaciente');
	var selectPostoPaciente = $('#postoPaciente');
	var selectOmPaciente = $('#omPaciente');
	var selectTipoPaciente = $('#tipoPaciente');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-pessoa');
	
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		inputIdentidadePaciente.focus();
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onModalClose(){
	 inputIdentidadePaciente.val('');
	 inputNomePaciente.val('');
	 inputNomeGuerraPaciente.val('');
	 inputEmailPaciente.val('');
	 selectPostoPaciente.val('');
	 selectOmPaciente.val('');
	 selectTipoPaciente.val('');
	}
	
	function onBotaoSalvarClick(){
		var identidadePaciente = inputIdentidadePaciente.val().trim();
		var nomePaciente = inputNomePaciente.val().trim();
		var nomeGuerraPaciente = inputNomeGuerraPaciente.val().trim();
		var emailPaciente = inputEmailPaciente.val().trim();
		var postoPaciente = selectPostoPaciente.val().trim();
		var omPaciente = selectOmPaciente.val().trim();
		var tipoPaciente = selectTipoPaciente.val().trim();
		
		$.ajax({
			url: url,
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
			error: onErroSalvandoPaciente,
			success: onPessoaSalva
		});
	}
	
	function onErroSalvandoPaciente(obj){
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
		
	}
	
	function onPessoaSalva(paciente){
		var comboPaciente = $('#paciente');
		comboPaciente.append('<option value =' + paciente.codigo + '>' + paciente.nomeGuerra + '</option>');
		comboPaciente.val(paciente.codigo);
		modal.modal('hide');
	}
		
});
