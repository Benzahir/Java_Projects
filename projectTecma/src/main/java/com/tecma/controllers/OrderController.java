package com.tecma.controllers;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecma.entities.Booking;
import com.tecma.entities.Order;
import com.tecma.entities.Product;
import com.tecma.mail.SmtpMailSender;
import com.tecma.repositories.BookingRepository;
import com.tecma.repositories.ProductRepository;
import com.tecma.services.OrderService;
import com.tecma.util.MyUtil;

@Controller
@SessionAttributes("orders")
public class OrderController {
	
	private ProductRepository productRepository;
	private BookingRepository bookingRepository;
	private SmtpMailSender smtpMailSender;
	private OrderService orderService;
	
	@Autowired
	public OrderController(ProductRepository productRepository, 
			BookingRepository bookingRepository, SmtpMailSender smtpMailSender,
			OrderService orderService) {
		this.productRepository = productRepository;
		this.bookingRepository = bookingRepository;
		this.smtpMailSender = smtpMailSender;
		this.orderService = orderService;
	}
	
	@RequestMapping("/product/{id}/detail")
	public String detail(@PathVariable("id") Long id,Model model) {
		model.addAttribute("product", productRepository.findOne(id));
		if (!model.containsAttribute("orders")) {
			ArrayList<Product> l = new ArrayList<Product>();
			model.addAttribute("orders", l);
		}
		return "details";
	}
	
	@RequestMapping(value="/product/{id}/detail", method=RequestMethod.POST)
	public String detail(@ModelAttribute Product product,
			@ModelAttribute("orders") ArrayList<Product> orders,
			RedirectAttributes redirectAttributes) {
		System.out.println("product " + product.getName() + " " + "id" + product.getId());
		orders.add(product);
		return "redirect:/order";
	}

	@RequestMapping(value = { "/order" })
	public String list(@ModelAttribute Product product, Model model,
			RedirectAttributes redirectAttributes) {
		return "order";
	}
	
	@RequestMapping(value = { "/order/{id}" })
	public String remove(@PathVariable("id") long id,
			@ModelAttribute Product product,
			@ModelAttribute("orders") ArrayList<Product> orders, Model model,
			RedirectAttributes redirectAttributes) {
		orders.remove((int)id);
		MyUtil.flash(redirectAttributes, "success", "deleteSuccess");
		return "redirect:/order";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String booking(Model model) {
		model.addAttribute("booking", new Booking());
		return "booking";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String booking(@ModelAttribute("booking") @Valid Booking booking, BindingResult result,
			@ModelAttribute("orders") @Valid ArrayList<Product> cart, 
			BindingResult results, @Valid Model model,
			RedirectAttributes redirectAttributes) throws MessagingException {
		if (result.hasErrors()) {
			MyUtil.flash(redirectAttributes, "success", "transactionFail");
			return "booking";
		}
		String body = "";
		for (int i = 0; i < cart.size(); i++) {
			body += "<tr><td width='50%' style='text-align:center'>" + cart.get(i).getQuantityOfMeasure()  + "</td>" + "<td width='25%' style='text-align:center'>" + cart.get(i).getQuantityOfMeasure()  +"</td>" + "<td width='25%' style='text-align:center'> $" + cart.get(i).getSellingPrice()  + "</td></tr>";
		}
		Order o = orderService.save(cart);
		booking.setOrderNumber(o.getOrderNumber());
		// EmailTemplate emailTemplate = new EmailTemplate();
		bookingRepository.save(booking);
		smtpMailSender.send(booking.getEmail(), "Your order is booked on pharmacypark.com",body);
		MyUtil.flash(redirectAttributes, "success", "transactionSuccess");
		return "redirect:/product";
	}

}
