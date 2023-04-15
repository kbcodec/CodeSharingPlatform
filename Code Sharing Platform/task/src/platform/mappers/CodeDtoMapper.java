package platform.mappers;

import org.springframework.stereotype.Component;
import platform.models.Code;
import platform.models.DTOs.CodeApiDto;
import platform.models.DTOs.CodeApiGetDto;
import platform.models.DTOs.CodeIdDto;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeDtoMapper {

    public static CodeIdDto codeEntityToIdDtoMapper(Code code) {
        CodeIdDto codeIdDto = new CodeIdDto();
        codeIdDto.setId(code.getId());
        return codeIdDto;
    }

    public static CodeApiDto codeEntityToApiDtoMapper(Code code) {
        CodeApiDto codeApiDto = new CodeApiDto();
        codeApiDto.setContent(code.getContent());
        codeApiDto.setTimeRestriction(code.getTimeRestriction());
        codeApiDto.setViewsRestriction(code.getViewsRestriction());
        return codeApiDto;
    }

    public static Code codeApiDtoToCodeEntityMapper(CodeApiDto codeApiDto) {
        Code code = new Code();
        code.setContent(codeApiDto.getContent());
        code.setTimeRestriction(codeApiDto.getTimeRestriction());
        code.setViewsRestriction(codeApiDto.getViewsRestriction());
        return code;
    }

    public static CodeApiGetDto codeEntityToApiGetDtoMapper(Code code) {
        CodeApiGetDto codeApiGetDto = new CodeApiGetDto();
        codeApiGetDto.setContent(code.getContent());
        codeApiGetDto.setLastUpdate(DateTimeFormatter.ofPattern(CodeApiGetDto.DATE_FORMAT).format(code.getLastUpdate()));
        codeApiGetDto.setTimeRestriction(code.getTimeRestriction());
        codeApiGetDto.setViewsRestriction(code.getViewsRestriction());
        return codeApiGetDto;
    }

    public static List<CodeApiGetDto> codeEntitiesToApiGetDtosMapper(List<Code> codes) {
        return codes.stream()
                .map(code -> new CodeApiGetDto(code.getContent(), DateTimeFormatter.ofPattern(CodeApiGetDto.DATE_FORMAT).format(code.getLastUpdate()), code.getTimeRestriction(), code.getViewsRestriction()))
                .collect(Collectors.toList());
    }

}
