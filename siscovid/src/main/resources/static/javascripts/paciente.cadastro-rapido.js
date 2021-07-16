$(function() {
	
	var modal = $('#modalCadastroRapidoPaciente');
	var botaoSalvar = modal.find('.js-modal-cadastro-pessoa-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) {event.preventDefault() });	
	var url = form.attr('action');
	var inputIdentidadePaciente = $('#identidadePaciente');
	var inputNomePaciente = $('#nomePaciente');
	var inputNomeGuerraPaciente = $('#nomeGuerraPaciente');
	var inputEmailPaciente = $('#emailPaciente');
	var selectPostoPaciente = $('#postoPaciente');
	var selectOmPaciente = $('#omPaciente');
	var selectTipoPaciente = $('#tipoPaciente');
	var radioStatusPaciente = $('#status');

	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		inputIdentidadePaciente.focus();
	}
	
	function onModalClose() {
		inputIdentidadePaciente.val('');
		inputNomePaciente.val('');
		inputNomeGuerraPaciente.val('');
		inputEmailPaciente.val('');
		selectPostoPaciente.val('');
		selectOmPaciente.val('');
		selectTipoPaciente.val('');
		radioStatusPaciente.val('');
		
	}
	
	function onBotaoSalvarClick() {
		
		var identidadePaciente = inputIdentidadePaciente.val().trim();
		var nomePaciente = inputNomePaciente.val().trim();
		var nomeGuerraPaciente = inputNomeGuerraPaciente.val().trim();
		var emailPaciente = inputEmailPaciente.val().trim();
		var postoPaciente = selectPostoPaciente.val().trim();
		var omPaciente = selectOmPaciente.val().trim();
		var tipoPaciente = selectTipoPaciente.val().trim();
		var status = radioStatusPaciente.val().trim();
		
		console.log('Identidade: ', identidadePaciente);
		console.log('Nome: ', nomePaciente);
		console.log('Nome de Guerra: ', nomeGuerraPaciente);
		console.log('Email: ', emailPaciente);
		console.log('Posto: ', postoPaciente);
		console.log('OM: ', omPaciente);
		console.log('Status: ', status);
		
	}
});