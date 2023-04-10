package platform.controllers.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.services.CodeService;

@Controller
@RequestMapping("code")
public class WebCodeController {
    @Autowired
    private CodeService codeService;

    @GetMapping("{id}")
    public String getCode(Model model, @PathVariable long id){
        model.addAttribute("code", codeService.getCodeById(id).getContent());
        model.addAttribute("date", codeService.getCodeById(id).getLastUpdate());
        return "singleCode";
    }

    @GetMapping("new")
    public String postCode(Model model) {
        return "newCode";
    }

    @GetMapping("latest")
    public String getLatest(Model model) {
        model.addAttribute("codes", codeService.getLatestCodes());
        return "latestCodes";
    }
}
