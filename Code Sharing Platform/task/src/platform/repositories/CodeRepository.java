package platform.repositories;

import platform.models.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class CodeRepository {
    private List<Code> codeList = new ArrayList<>();
    private final String DATE_FORMATTER = "yyyy/MM/dd HH:mm:ss";
    public List<Code> getAllCodes() {
        if(codeList.isEmpty())
        {
            return null;
        }
        return codeList;
    }
    public Code findById(long id) {
        for(int i = 0; i < codeList.size(); i++) {
            if(codeList.get(i).getId() == id) {
                return codeList.get(i);
            }
        }
        return null;
    }

    public Code save(Code newCode) {
        Code code = new Code();
        code.setId(1); //zmienic na getId
        code.setContent(newCode.getContent());
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);
        code.setLastUpdate(formatDateTime);
        codeList.add(code);
        return code;
    }

    public String delete(long id) {
        codeList.removeIf(x -> x.getId() == id);
        return null;
    }

    public Code update(Code code) {
        int idx = 0;
        long id = 0;
        for(int i = 0; i < codeList.size(); i++) {
            if(codeList.get(i).getId() == code.getId()) {
                id = code.getId();
                idx = i;
                break;
            }
        }
        Code newCode = new Code();
        newCode.setId(id);
        newCode.setContent(code.getContent());
        newCode.setLastUpdate(code.getLastUpdate());
        codeList.set(idx, newCode);
        return code;
    }

    public List<Code> getLatestCodes() {
        if(codeList.isEmpty())
        {
            return null;
        }

        List<Code> latestCodeList = new ArrayList<>();
        int idx = 1;
        for (int i = codeList.size() - 1; i >= 0; i--){
            latestCodeList.add(codeList.get(i));
            if(++idx > 10) {
                return latestCodeList;
            }
        }

        return latestCodeList;

    }
}
