package platform;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public List<Code> getLatest() {
       return codeRepository.findTop10ByRestrictedOrderByLoadDateDesc(false);
    }

    public Code getCodeWithId(String id) {
        Code code = codeRepository.findCodeById(id);
        if(code == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(code.isRestricted()) {
            if(code.getTime() > 0)
                calculateTimeLeft(code);
            if(code.getViews() > 0)
                updateAndDeleteIfNeeded(code);
        }
        return code;
    }

    private void calculateTimeLeft(Code code) {
        int secondsPassed = (int) ChronoUnit.SECONDS.between(LocalDateTime.now(), code.getLoadDate());
        int timeLeft = code.getTime() + secondsPassed;
        code.setTime(timeLeft);
        if(timeLeft <= 0) {
            codeRepository.delete(code);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        codeRepository.save(code);
    }

    private void updateAndDeleteIfNeeded(Code code) {
        code.setViewsRestricted(true);
        int views = code.getViews();
        --views;
        System.out.println("Views: " + views);
        code.setViews(views);
        if(views == 0) {
            codeRepository.delete(code);
        } else {
            codeRepository.save(code);
        }
    }


    public Code saveCode(Code code) {
         code.setId(UUID.randomUUID().toString());
         code.setRestricted(code.getTime() != 0 || code.getViews() != 0);
         return codeRepository.save(code);
    }
}
