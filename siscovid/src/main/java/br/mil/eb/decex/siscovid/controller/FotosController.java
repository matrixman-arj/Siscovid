package br.mil.eb.decex.siscovid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.mil.eb.decex.siscovid.dto.FotoDTO;
import br.mil.eb.decex.siscovid.storage.FotoStorage;
import br.mil.eb.decex.siscovid.storage.FotoStorageRunnable;


@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		
		Thread thred = new Thread(new FotoStorageRunnable(files, resultado, fotoStorage));
		thred.start();
		System.out.println(">>> files: " + files[0].getSize());
		return resultado;
	}
	
	
	@GetMapping("/temp/{nome:.*}")
	public byte[] recuperarFotoTemporaria(@PathVariable String nome) {
		return fotoStorage.recuperarFotoTemporaria(nome);
	}
	
	@GetMapping("/{nome:.*}")
	public byte[] recuperarFoto(@PathVariable String nome) {
		return fotoStorage.recuperarFoto(nome);
	}
	
//	@PostMapping
//	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
//		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
//		
//		Thread thread = new Thread(new FotoStorageRunnable(files, resultado, fotoStorage));
//		thread.start();		
//		
//		return resultado;
//	}
//	
//	
//	@GetMapping("/{nome:.*}")
//	public byte[] recuperar(@PathVariable String nome) {
//		return fotoStorage.recuperar(nome);
//	}

}
