package com.dsebproj.recipesite.siteuser;

import com.dsebproj.recipesite.recipe.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SiteUserController {

    @Autowired
    private SiteUserRepository siteUserRepo;

    private static List<SiteUser> users = new ArrayList<>();


//    @GetMapping("/login")
//    public ModelAndView userLogin() {
//        ModelAndView mv = new ModelAndView("users/login");
//        return mv;
//    }

//    This route gets all the users from the database, and adds them to the ModelAndView to be
//    returned.
    @GetMapping("/users")
    public ModelAndView showUsers() {
        ModelAndView mv = new ModelAndView("users/allUsers");
        mv.addObject("pageTitle", "users");
        mv.addObject("siteUsers", siteUserRepo.findAll());
//        System.out.println((siteUserRepo.findAll()));
        return mv;
    }

//    This route is the signup form for users
    @GetMapping("/users/signup")
    public ModelAndView newUserForm(SiteUser newUser) {
        ModelAndView mv = new ModelAndView("users/signup");
        mv.addObject("pageTitle", "Member Signup");
        return mv;
    }

//    This route handles the submission of the new user signup form.
    @PostMapping("/users/signup")
    public ModelAndView addNewUser(SiteUser siteUser) {
        ModelAndView mv = new ModelAndView("users/addUserResult");
        mv.addObject("pageTitle", "New User Registration");
        SiteUser newUser = siteUserRepo.save(siteUser);
        mv.addObject("newUser", newUser);
        return mv;
    }

    //    This route is the signup form for users
    @GetMapping("/users/detail/{id}")
    public ModelAndView userDetail(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("users/detail");
        Optional<SiteUser> found = siteUserRepo.findById(id);
        if(found.isPresent()){
            mv.addObject("pageTitle", "Member Info");
            mv.addObject("siteUser", found.get());
        } else {
            mv.addObject("pageTitle", "Unable to locate member");
            mv.addObject("siteUser", new SiteUser());
        }
        return mv;
    }
}

