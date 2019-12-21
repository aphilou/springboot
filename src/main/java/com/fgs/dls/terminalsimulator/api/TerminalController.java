package com.fgs.dls.terminalsimulator.api;

import com.fgs.dls.terminalsimulator.model.Terminal;
import com.fgs.dls.terminalsimulator.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/terminal")
public class TerminalController {

    private TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {

        this.terminalService = terminalService;
    }

    @PostMapping
    public void addTerminal(
            @RequestBody
            @Valid
            @NotNull Terminal terminal) {

        terminalService.addTerminal(terminal);
    }

    @GetMapping
    public List<Terminal> getAllTerminal() {
        return terminalService.getAllTerminal();
    }

    @GetMapping(path = "{id}")
    public Terminal getTerminalById(@PathVariable UUID id) {

        return terminalService.getTerminalByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTerminalById(@PathVariable UUID id) {

        terminalService.deleteTerminal(id);
    }

    @PutMapping(path = "{id}")
    public void updateTerminal(@PathVariable UUID id,
                               @RequestBody
                               @Valid
                               @NotNull Terminal terminal) {

        terminalService.updateTerminal(id, terminal);
    }
}
