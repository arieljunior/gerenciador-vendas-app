package br.edu.infnet.gerenciador_vendas_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.gerenciador_vendas_app.model.service.BebidaService;
import br.edu.infnet.gerenciador_vendas_app.model.service.ProdutoService;
import br.edu.infnet.gerenciador_vendas_app.model.service.VendedorService;
import br.edu.infnet.gerenciador_vendas_app.model.service.VestimentaService;


@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private VestimentaService vestimentaService;

	@GetMapping(value = "/")
	public String showHome(Model model) {

		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());

		return "home";
	}

	@GetMapping(value = "/vendedor/lista")
	public String obterListaVendedor(Model model) {

		model.addAttribute("titulo", "Vendedores:");
		model.addAttribute("listagem", vendedorService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {

		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/bebida/lista")
	public String obterListaAlimenticio(Model model) {

		model.addAttribute("titulo", "Produtos Bebidas:");
		model.addAttribute("listagem", bebidaService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/vestimenta/lista")
	public String obterListaEletronico(Model model) {

		model.addAttribute("titulo", "Produtos Vestimentas:");
		model.addAttribute("listagem", vestimentaService.obterLista());

		return showHome(model);
	}
}