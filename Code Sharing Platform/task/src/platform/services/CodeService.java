package platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.models.Code;
import platform.repositories.CodeRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class CodeService {
    private final CodeRepository codeRepository;
    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code saveCode(Code code) {
        return codeRepository.save(code);
    }

    public Code findCodeById(long id) {
        return codeRepository.findCodeById(id);
    }

    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    public List<Code> findLatestCodes() {
        return codeRepository.findTop10ByOrderByIdDesc();
    }
}
