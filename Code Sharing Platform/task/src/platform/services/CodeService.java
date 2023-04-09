package platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.models.Code;
import platform.repositories.CodeRepository;

import java.util.List;

@Service
public class CodeService {
    @Autowired
    private CodeRepository codeRepository;

    public Code saveCode(Code code){
        return codeRepository.save(code);
    }

    public List<Code> getCodes() {
        return codeRepository.getAllCodes();
    }

    public Code getCodeById(long id) {
        return codeRepository.findById(id);
    }

    public String deleteCode(long id) {
        codeRepository.delete(id);
        return "Code removed. id = " + id;
    }

    public Code updateCode (Code code) {
        return codeRepository.update(code);
    }

    public List<Code> getLatestCodes() {
        return codeRepository.getLatestCodes();
    }
}
