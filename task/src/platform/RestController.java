package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final CodeService codeService;

    @Autowired
    public RestController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/api/code/{id}")
    public Code getJsonCode(@PathVariable String id) {
        return codeService.getCodeWithId(id);
    }

    @PostMapping("/api/code/new")
    public Map<String, String> onNewCode(@RequestBody Code code) {
        Code savedCode = codeService.saveCode(code);
        return Map.of("id", String.valueOf(savedCode.getId()));
    }

    @GetMapping("/api/code/latest")
    public List<Code> getLatest() {
        return codeService.getLatest();
    }
}
