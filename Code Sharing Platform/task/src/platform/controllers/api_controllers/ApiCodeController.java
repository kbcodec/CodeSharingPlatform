package platform.controllers.api_controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.models.Code;
import platform.models.DTOs.CodeApiDto;
import platform.models.DTOs.CodeApiGetDto;
import platform.services.CodeService;

import java.util.UUID;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    private final CodeService codeService;

    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }
    @PostMapping("new")
    public ResponseEntity<?> createNewCode(@RequestBody CodeApiDto codeApiDto) {
        return ResponseEntity.ok(codeService.saveCode(codeApiDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCodeById(@PathVariable("id") final UUID id) {
        CodeApiGetDto code = codeService.findCodeById(id);
        if (code == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("code with {id} was not found.");
        }
        return ResponseEntity.ok(code);
    }

    @GetMapping("latest")
    public ResponseEntity<?> getLatestTenCodes() {
        return ResponseEntity.ok(codeService.findLatestTenCodes());
    }

}
