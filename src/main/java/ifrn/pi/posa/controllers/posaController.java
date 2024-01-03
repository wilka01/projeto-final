package ifrn.pi.posa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.posa.models.Item;
import ifrn.pi.posa.models.Pedido;
import ifrn.pi.posa.repositories.ItemRepository;
import ifrn.pi.posa.repositories.PedidoRepository;
import ifrn.pi.posa.repositories.UsuarioRepository;

@Controller
@RequestMapping("/posa")
public class posaController {
	
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private ItemRepository ir;
	@Autowired
	private PedidoRepository pr;
	
	@GetMapping("/addItem")
	public ModelAndView form(Item item) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("posa/itensAdd");
		List<Item> itens = ir.findAll();
		md.addObject("itens", itens);
		
		return md;
	}

	
	@GetMapping("/pedido")
	@PreAuthorize("hasRole('CLIENTE')")
	public ModelAndView pedido(Item pedido) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("posa/pedido");
		List<Pedido> pedidos = pr.findAll();
		md.addObject("pedidos", pedidos);
		
		return md;
	}

	// public ModelAndView admin(@Valid Cliente admin, BindingResult result) {
    //      ModelAndView mv = new ModelAndView("login");

    //      String hashSenha = PasswordUtil.encoder(admin.getSenha());
    //     admin.setSenha(hashSenha);
    //     mv.addObject("admin", admin);

	// 	if (result.hasErrors()) {
	// 		return admin(admin);
	// 	}
		
	// 		ad.save(admin);
	// 		System.out.println("admin Salvo!");
		

	// 	return mv;
	// }
	
	
}

