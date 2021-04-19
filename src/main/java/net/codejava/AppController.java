package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private QuestionService service;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@GetMapping("/new")
	public String showQuestionForm(Model model) {
		Question question = new Question();
		model.addAttribute("question", question);

		return "question_form";
	}

	@PostMapping(value = "/save")
	public String saveQuestion(@ModelAttribute("question") Question question) {
		service.save(question);
		
		return "redirect:/";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

	@GetMapping("/questions")
	public String listQuestions(Model model) {
		List<Question> listQuestions = service.listAll();
		model.addAttribute("listQuestions", listQuestions);
		
		return "questions";
	}

}
