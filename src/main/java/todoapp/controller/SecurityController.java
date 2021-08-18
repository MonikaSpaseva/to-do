package todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import todoapp.model.UserAccount;
import todoapp.repo.AccountRepo;

@Controller
public class SecurityController {


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);

        return "security/register";
    }


    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        accountRepo.save(user);
        return "redirect:/to-do";
    }

}
