package by.epam.bookspace.controller;

import by.epam.bookspace.model.User;
import by.epam.bookspace.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        if (userRepository.findByLoginOrNicknameOrEmail(user.getLogin(), user.getNickname(), user.getEmail()).isEmpty()) {
            return "redirect:/login";
        }
        return "registration";
    }
}
