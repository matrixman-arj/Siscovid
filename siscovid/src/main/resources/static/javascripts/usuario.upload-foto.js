var Siscovid = Siscovid || {};

Siscovid.UploadFoto = (function() {
	
	function UploadFoto() {		
		this.inputNomeFoto = $('input[name=foto]');
		this.inputContentType = $('input[name=contentType]');
		
		this.htmlFotoUsuarioTemplate = $('#foto-usuario').html();
		this.template = Handlebars.compile(this.htmlFotoUsuarioTemplate);
		
//		this.htmlFotoUsuario = template({nomeFoto: resposta.nome});
		
		this.containerFotoUsuario = $('.js-container-foto-usuario');
		this.uploadDrop = $('#upload-drop');
		
	}
	
	UploadFoto.prototype.iniciar = function () {
		
		var settings = {
				type: 'json',
				filelimit: 1,
				allow: '*.(jpg|jpeg|png)',
				action: this.containerFotoUsuario.data('url-fotos'),
				complete: onUploadCompleto.bind(this),
		}
		
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
		
		if (this.inputNomeFoto.val()) {
			onUploadCompleto.call(this, {nome: this.inputNomeFoto.val(), contentType: this.inputContentType.val()});
		}
		
	}
	
	function onUploadCompleto(resposta) {
		this.inputNomeFoto.val(resposta.nome);
		this.inputContentType.val(resposta.contentType);
		
		this.uploadDrop.addClass('hidden');
		var htmlFotoUsuario = this.template({nomeFoto: resposta.nome})
		this.containerFotoUsuario.append(htmlFotoUsuario);
		
		$('.js-remove-foto').on('click', onRemoverFoto.bind(this));
	}
	
	function onRemoverFoto() {
		$('.js-foto-usuario').remove();
		this.uploadDrop.removeClass('hidden');
		this.inputNomeFoto.val('');
		this.inputContentType.val('');
	}
	 
	
	return UploadFoto;
	
}());

$(function(){
	var uploadFoto = new Siscovid.UploadFoto();
	uploadFoto.iniciar();
	
});