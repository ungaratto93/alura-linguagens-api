package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

	@Autowired // essa anotacao, diz para o spring gerenciar esse repositorio
	// e criar um objeto quando a aplicacao subir, para que possamos usar, injetando
	// o objeto pronto aqui
	private LinguagemRepository repositorio;

	@GetMapping("/linguagens")
	public List<Linguagem> obterLinguagens() {
		List<Linguagem> linguagens = repositorio.findAll();
		return linguagens;
	}

	@PostMapping("/linguagens")
	public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
		Linguagem linguagemCadastrada = repositorio.save(linguagem);
		return linguagemCadastrada;
	}

}
