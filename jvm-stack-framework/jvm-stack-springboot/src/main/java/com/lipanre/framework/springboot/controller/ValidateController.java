package com.lipanre.framework.springboot.controller;

import com.lipanre.framework.springboot.dto.ValidateDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiPan
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    @PostMapping
    @ResponseBody
    public String validate(@Valid @RequestBody ValidateDTO validateDTO) {
        return "校验成功";
    }

}
