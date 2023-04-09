package platform.controllers.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.services.CodeService;
import java.time.LocalDateTime;


@Controller
@RequestMapping("code")
public class WebCodeController {
    @Autowired
    private CodeService codeService;
    LocalDateTime now = LocalDateTime.now();

    @GetMapping()
    public String getCode(Model model){
        if(codeService.getCodes().size() == 0) {
            model.addAttribute("code", "");
            model.addAttribute("date", "");
            return "singleCode";
        }
        model.addAttribute("code", codeService.getCodeById(1).getContent());
        model.addAttribute("date", codeService.getCodeById(1).getLastUpdate());

        return "singleCode";
    }

    @GetMapping("new")
    public String postCode(Model model) {
        return "newCode";
    }
}
