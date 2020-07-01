package com.provid.platform.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.provid.platform.model.Bono;
import com.provid.platform.model.Client;
import com.provid.platform.model.DetalleBono;
import com.provid.platform.service.BonoService;
import com.provid.platform.service.ClientService;

@Controller
@SessionAttributes("bono")
@RequestMapping("/bonos")
public class BonoController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private BonoService bonoService;

	@GetMapping("/nuevo/{clientId}")
	public String bonoNuevo(@PathVariable(value = "clientId") Long clientId, Model model) {
		try {
			Optional<Client> client = clientService.findById(clientId);
			if (!client.isPresent()) {
				model.addAttribute("info", "Cliente no existe");
				return "redirect:/clients/list";
			} else {
				Bono bono = new Bono();
				bono.setClientId(client.get());
				model.addAttribute("bono", bono);
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "bono";
	}

	@GetMapping("/detalle/{id}")
	public String detalleBonos(@PathVariable(value = "id") Long id, Model model) {
		try {
			Optional<Bono> bono = bonoService.fetchByBonoIdWithClient(id);
			if (!bono.isPresent()) {
				model.addAttribute("info", "Bono no existe");
				return "redirect:/clients/list";
			}
			model.addAttribute("bono", bono.get());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "detalle";
	}

	@PostMapping("/save")
	public String saveBono(@Valid Bono bono, @RequestParam(name = "item_id[]", required = false) Long[] itemId,
			BindingResult result, Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "bono";
		} else {

			DetalleBono detalle=new DetalleBono();
			detalle.setTcea(bono.tceaEmisor());
			detalle.setTirBonista(bono.tirBonista());
			detalle.setTirEmisor(bono.tirEmisor());
			detalle.setTrea(bono.treaBonista());
			detalle.setValor(bono.precio());
			detalle.setValorSoles(bono.precioSoles());
			detalle.setBonoId(bono);
			bono.setDetalle(detalle);
			bonoService.save(bono);
			status.setComplete();
			model.addAttribute("success", "Bono Generado");
			model.addAttribute("bonos", bonoService.findAll());
			return "redirect:/clients/bonos/"+bono.getClientId().getId();
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editBono(@PathVariable(value = "id") Long id, Model model) {
		try {
			Optional<Bono> bono = bonoService.findById(id);
			if (bono.isPresent()) {
				model.addAttribute("bono", bono.get());
				//return "redirect:/clients/bonos/"+bono.get().getClientId().getId();
			}else {
				return "redirect:/clients/bonos/"+bono.get().getClientId().getId();
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "edit";
	}
}
