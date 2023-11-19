package br.edu.infnet.gerenciador_vendas_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.gerenciador_vendas_app.model.service.VestimentaService;
import br.edu.infnet.gerenciador_vendas_app.model.service.BebidaService;
import br.edu.infnet.gerenciador_vendas_app.model.service.InformacaoService;
import br.edu.infnet.gerenciador_vendas_app.model.service.ProdutoService;
import br.edu.infnet.gerenciador_vendas_app.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private VestimentaService vestimentaService;
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private InformacaoService informacaoService;
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		//model.addAttribute("informacoes", informacaoService.obterLista());
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeVestimenta", vestimentaService.obterQtde());
		model.addAttribute("qtdeBebida", bebidaService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/vestimenta/lista")
	public String obterListaVestimenta(Model model) {
		
		model.addAttribute("titulo", "Produtos Vestimenta:");
		model.addAttribute("listagem", vestimentaService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/bebida/lista")
	public String obterListaBebida(Model model) {
		
		model.addAttribute("titulo", "Produtos Bebidas:");
		model.addAttribute("listagem", bebidaService.obterLista());

		return showHome(model);
	}
}