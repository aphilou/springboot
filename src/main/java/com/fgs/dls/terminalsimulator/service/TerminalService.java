package com.fgs.dls.terminalsimulator.service;

import com.fgs.dls.terminalsimulator.dao.TerminalDao;
import com.fgs.dls.terminalsimulator.model.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TerminalService {

    private final TerminalDao terminalDao;

    @Autowired
    public TerminalService(@Qualifier("postgres") TerminalDao terminalDao) {

        this.terminalDao = terminalDao;
    }

    public int addTerminal(Terminal terminal) {

        return terminalDao.insertTerminal(terminal);
    }

    public List<Terminal> getAllTerminal() {
        return terminalDao.selectAllTerminal();
    }

    public Optional<Terminal> getTerminalByID(UUID id) {
        return terminalDao.selectTerminalById(id);
    }

    public int deleteTerminal(UUID id) {
        return terminalDao.deleteTerminal(id);
    }

    public int updateTerminal(UUID id, Terminal terminal) {
        return terminalDao.updateTerminalById(id, terminal);
    }
}
