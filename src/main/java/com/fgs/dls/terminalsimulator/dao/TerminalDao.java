package com.fgs.dls.terminalsimulator.dao;

import com.fgs.dls.terminalsimulator.model.Terminal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TerminalDao {

    int insertTerminal(UUID id, Terminal terminal);

    default int insertTerminal(Terminal terminal) {
        UUID id = UUID.randomUUID();
        return insertTerminal(id, terminal);
    }

    List<Terminal> selectAllTerminal();

    Optional<Terminal> selectTerminalById(UUID id);

    int deleteTerminal(UUID id);

    int updateTerminalById(UUID id, Terminal terminal);
}
