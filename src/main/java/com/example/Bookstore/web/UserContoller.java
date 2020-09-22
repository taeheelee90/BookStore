package com.example.Bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.SignupForm;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.repository.UserRepository;

@Controller
public class UserContoller {

	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "/signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check ps match
				String pw = signupForm.getPassword();
				BCryptPasswordEncoder bcpw = new BCryptPasswordEncoder();
				String hashedpw = bcpw.encode(pw);

				String email = signupForm.getEmail();
				
				
				User newUser = new User();
				newUser.setPasswordHash(hashedpw);
				newUser.setEmail(email);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");

				if (repository.findByUsername(signupForm.getUsername()) == null) { // check username duplication
					
					if (signupForm.getEmail().contains("@")) { // check email format
						repository.save(newUser);
					} else {
						bindingResult.rejectValue("email", "err.email", "Email format is invalid");
						return "signup";
					}

				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}

			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Password does not match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}

}
