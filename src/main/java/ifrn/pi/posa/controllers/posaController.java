package ifrn.pi.posa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.posa.models.Item;
import ifrn.pi.posa.repositories.ItemRepository;
import ifrn.pi.posa.repositories.UsuarioRepository;

@Controller
@RequestMapping("/posa")
public class posaController {
	
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private ItemRepository ir;
	
	@GetMapping("/addItem")
	public ModelAndView form(Item item) {
		ModelAndView md = new ModelAndView();
		
		md.setViewName("posa/itensAdd");
		List<Item> itens = ir.findAll();
		md.addObject("itens", itens);
		
		return md;
	}

}

