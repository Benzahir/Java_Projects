package com.tecma.admin.controllers;

import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecma.dto.ChangePasswordForm;
import com.tecma.entities.User;
import com.tecma.repositories.UserRepository;
import com.tecma.services.UserService;
import com.tecma.util.MyUtil;

@Controller
public class UserController {

	private UserRepository userRepository;
	private UserService userService;

	@Autowired
	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
	public String create(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/admin/users/create";
	}

	@RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("user") User user, @RequestParam("role") int role, BindingResult result) {
		userService.save(user, role);
		return "redirect:/admin/user/list";
	}

	@RequestMapping(value = "/admin/user/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "/admin/users/create";
	}

	@RequestMapping(value = "/admin/user/{id}/edit", method = RequestMethod.POST)
	public String edit(@PathVariable("id") Long id, @ModelAttribute("user") User user, @RequestParam("role") int role,
			BindingResult result) {
		userService.update(id, user, role);
		return "redirect:/admin/user/list";
	}

	@RequestMapping("/admin/user/list")
	public String list(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "/admin/users/list";
	}

	@RequestMapping("/admin/user/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		userRepository.delete(id);
		return "redirect:/admin/user/list";
	}

	@RequestMapping(value = "/admin/user/change-password", method = RequestMethod.GET)
	public String changePassword(Model model) {
		model.addAttribute("changePasswordForm", new ChangePasswordForm());
		return "admin/users/change-password";
	}

	@RequestMapping(value = "/admin/user/change-password", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePasswordForm") @Valid ChangePasswordForm changePasswordForm,
			BindingResult result, RedirectAttributes redirectAttributes, Model model) {

		if (result.hasErrors()) {
			return "admin/users/change-password";
		}
		userService.updatePassword(changePasswordForm);
		MyUtil.flash(redirectAttributes, "success", "yourPasswordChange");
		return "redirect:/admin/user/change-password";
	}

	@RequestMapping("admin/user/resend")
	public String reverify(HttpServletRequest request) throws ServletException, MessagingException {
		Principal principal = request.getUserPrincipal();
		String userName = "not logged in"; // Any default user name
		User repo = new User();

		if (principal != null) {
			userName = principal.getName();
			repo = userRepository.findByEmail(userName);
			repo.setVerificationCode(RandomStringUtils.randomAlphanumeric(16));
			userRepository.save(repo);
		}
		return "redirect:/";
	}

}
