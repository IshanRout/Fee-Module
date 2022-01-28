package com.cutm.erp.fees.controller;

import com.cutm.erp.fees.entity.User;
import com.cutm.erp.fees.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "list")
    public @ResponseBody List<User> getAllBranches(){
        return userService.findAll();
    }

    @PostMapping(value = "search")
    public @ResponseBody User getUserByUserId(@RequestParam(value = "userId")Integer userId){
        return userService.getUserByUserId(userId);
    }
}