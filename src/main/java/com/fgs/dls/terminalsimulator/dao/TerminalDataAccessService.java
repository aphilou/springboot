package com.fgs.dls.terminalsimulator.dao;

import com.fgs.dls.terminalsimulator.model.Terminal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class TerminalDataAccessService implements TerminalDao{

    @Override
    public int insertTerminal(UUID id, Terminal terminal) {
        return 0;
    }

    @Override
    public List<Terminal> selectAllTerminal() {
        return List.of(new Terminal(UUID.randomUUID(), "ELITE", "1.2.3.4", 1234));
    }

    @Override
    public Optional<Terminal> selectTerminalById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteTerminal(UUID id) {
        return 0;
    }

    @Override
    public int updateTerminalById(UUID id, Terminal terminal) {
        return 0;
    }
}
