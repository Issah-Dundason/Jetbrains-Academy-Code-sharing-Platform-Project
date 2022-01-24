package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WebController {
    private final CodeService codeService;

    @Autowired
    public WebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code/{id}")
    public String getCode(Model model, @PathVariable String id) {
        Code code = codeService.getCodeWithId(id);
        model.addAttribute("code", code);
        return "code";
    }

    @GetMapping(value = "/code/new")
    public String onNewCode() {
        return "new";
    }

    @GetMapping("/code/latest")
    public String getLatest(Model model) {
        List<Code> codes = codeService.getLatest();
        model.addAttribute("codes", codes);
        return "latest";
    }

}
