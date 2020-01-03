package com.tecma.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecma.dto.ForgotPasswordForm;
import com.tecma.dto.ResetPasswordForm;
import com.tecma.dto.SignUpForm;
import com.tecma.services.RootService;
import com.tecma.util.MyUtil;
import com.tecma.validators.ForgotPasswordFormValidator;
import com.tecma.validators.SignUpFormValidator;

@Controller
public class RootController {
	
	private RootService rootService;
	private SignUpFormValidator signupFormValidator;
	private ForgotPasswordFormValidator forgotPasswordFormValidator;
	
	@Autowired
	public RootController(RootService rootService, SignUpFormValidator signupFormValidator){
		this.rootService = rootService;
		this.signupFormValidator = signupFormValidator;
	}
	
	@InitBinder("forgotPasswordForm")
	protected void initForgotPasswordBinder(WebDataBinder binder) {
		binder.setValidator(forgotPasswordFormValidator);
	}
	
	@InitBinder("signupForm")
	protected void initSignupBinder(WebDataBinder binder) {
		binder.setValidator(signupFormValidator);
	}
	
	@Autowired
	public void setRootService(RootService rootService){
		this.rootService = rootService;
	}
	
	@RequestMapping("")
	public String home() {
		if (MyUtil.getSessionUser() != null) {
			return "/admin/index";
		} 
		return "redirect:/products";
	}
	
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("signupForm", new SignUpForm());
		return "signup";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signUp(@ModelAttribute("signupForm") @Valid SignUpForm signupForm, 
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "signup";
		}
		rootService.signUp(signupForm);
		return "redirect:/login";
	}

	@RequestMapping("/admin/users/{verificationCode}/verify")
	public String verify(@PathVariable("verificationCode") String verificationCode,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
			throws ServletException {
		
		if(!rootService.verify(verificationCode)){
			MyUtil.flash(redirectAttributes, "danger", "alreadyVerified");
		} else {
			MyUtil.flash(redirectAttributes, "success", "verificationSuccess");
		}		
		request.logout();
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/forgot-password")
	public String forgotPassword(Model model) {
		model.addAttribute(new ForgotPasswordForm());
		return "forgotpassword";
	}	

	/**
	 * Forgot password
	 */
	@RequestMapping(value="/forgot-password", method=RequestMethod.POST)
	public String forgotPassword(@ModelAttribute("forgotPasswordForm") @Valid ForgotPasswordForm forgotPasswordForm,
			BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "forgotpassword";
		}
		rootService.forgotPassword(forgotPasswordForm);
		MyUtil.flash(redirectAttributes, "info", "checkMailResetPassword");
		return "redirect:/";
	}
	
	/**
     * Reset password
     */
    @RequestMapping(value="/resetpassword/{forgotPasswordCode}")
    public String resetPassword(@PathVariable("forgotPasswordCode") String forgotPasswordCode,
    		Model model) {
     	model.addAttribute(new ResetPasswordForm());
     	model.addAttribute(forgotPasswordCode);
    	return "resetpassword";
    }
    
	@RequestMapping(value="/resetpassword/{forgotPasswordCode}",
			method=RequestMethod.POST)
	public String resetPassword(@PathVariable("forgotPasswordCode") String forgotPasswordCode,
			@ModelAttribute("resetPasswordForm")
				@Valid ResetPasswordForm resetPasswordForm,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		rootService.resetPassword(forgotPasswordCode, resetPasswordForm, result);
		
		if (result.hasErrors()) {
			return "resetpassword";
		}
		MyUtil.flash(redirectAttributes, "success", "passwordChanged");
		return "redirect:/login";
	}
}