package platform.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import platform.models.Code;
import platform.models.DTOs.CodeApiDto;
import platform.models.DTOs.CodeApiGetDto;
import platform.models.DTOs.CodeIdDto;
import platform.repositories.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static platform.mappers.CodeDtoMapper.*;

@Service
public class CodeService {
    private final CodeRepository codeRepository;
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public CodeIdDto saveCode(CodeApiDto codeApiDto) {
            Code code = codeApiDtoToCodeEntityMapper(codeApiDto);
        codeRepository.save(code);
        return codeEntityToIdDtoMapper(code);
    }
    public CodeApiGetDto findCodeById(UUID id) {
        Code code = codeRepository.findCodeById(id);
        if (code.isViewsRestriction()) {
            code.setViewsRestriction(code.getViewsRestriction() - 1);
            if(code.getViewsRestriction() < 0) {
                code.setHide(true);
                return null;
            }
        }

        if (code.isTimeRestriction()) {
            if (code.getDateToHide().isAfter(LocalDateTime.now())) {
                code.setTimeRestriction(Duration.between(LocalDateTime.now(), code.getDateToHide()).toSeconds());
            } else {
                code.setHide(true);
                return null;
            }
        }
        codeRepository.save(code);
        return codeEntityToApiGetDtoMapper(code);

    }
    public List<CodeApiGetDto> findLatestTenCodes() {
        return codeEntitiesToApiGetDtosMapper(codeRepository.findLastTenCodes());
    }
    public Code findById(UUID id) {
        return codeRepository.findById(id);
    }
}
