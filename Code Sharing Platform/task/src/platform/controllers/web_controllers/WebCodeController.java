package platform.controllers.web_controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import platform.models.Code;
import platform.models.DTOs.CodeApiGetDto;
import platform.services.CodeService;

import java.util.UUID;

@Controller
@RequestMapping("code")
public class WebCodeController {
    private final CodeService codeService;

    public WebCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("{id}")
    public String getCode(Model model, @PathVariable UUID id){
        CodeApiGetDto code = codeService.findCodeById(id);
        Code codeRestrictions = codeService.findById(id);
        if(code == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("code", code.getContent());
        model.addAttribute("date", code.getLastUpdate());
        model.addAttribute("time", code.getTimeRestriction());
        model.addAttribute("view", code.getViewsRestriction());
        model.addAttribute("isTimeRestricion", codeRestrictions.isTimeRestriction());
        model.addAttribute("isViewsRestriction", codeRestrictions.isViewsRestriction());
        return "singleCode";
    }

    @GetMapping("new")
    public String postCode(Model model) {
        return "newCode";
    }

    @GetMapping("latest")
    public String getLatest(Model model) {
        model.addAttribute("codes", codeService.findLatestTenCodes());
        return "latestCodes";
    }
}
