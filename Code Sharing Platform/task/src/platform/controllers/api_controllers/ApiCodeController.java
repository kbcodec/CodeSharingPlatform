package platform.controllers.api_controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.models.Code;
import platform.models.EmptyJsonBody;
import platform.services.CodeService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    @Autowired
    private CodeService codeService;

    @GetMapping
    public ResponseEntity<?> getAllCodes() {
        return new ResponseEntity<>(codeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<?> createNewCode(@RequestBody Code code) {
        Code createdCode = codeService.saveCode(new Code(code.getContent()));
        return new ResponseEntity<>(createdCode.getIdAsJson(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCodeById(@PathVariable long id) {
        return new ResponseEntity<>(codeService.findCodeById(id), HttpStatus.OK);
    }

    @GetMapping("latest")
    public ResponseEntity<?> getLatestCodes() {
        return new ResponseEntity<>(codeService.findLatestCodes(), HttpStatus.OK);
    }

}
