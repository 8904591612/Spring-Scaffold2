package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.model.Payment_reg;
import com.example.service.Payment_regService;

@Controller
@RequestMapping("/payment_regs")
public class Payment_regController {

	private static final String MSG_SUCESS_INSERT = "Payment_reg inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Payment_reg successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Payment_reg successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private Payment_regService payment_regService;
	
	@GetMapping
	public String index(Model model) {
		//List<Payment_reg> all = payment_regService.findAll();
		//model.addAttribute("listPayment_reg", all);
		return "payment_reg/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Payment_reg payment_reg = payment_regService.findOne(id);
			model.addAttribute("payment_reg", payment_reg);
		}
		return "payment_reg/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Payment_reg entity) {
		model.addAttribute("payment_reg", entity);
		return "payment_reg/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Payment_reg entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Payment_reg payment_reg = null;
		try {
			payment_reg = payment_regService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/payment_regs/" + payment_reg.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Payment_reg entity = payment_regService.findOne(id);
				model.addAttribute("payment_reg", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "payment_reg/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Payment_reg entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Payment_reg payment_reg = null;
		try {
			payment_reg = payment_regService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/payment_regs/" + payment_reg.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Payment_reg entity = payment_regService.findOne(id);
				payment_regService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/payment_regs/index";
	}

}
