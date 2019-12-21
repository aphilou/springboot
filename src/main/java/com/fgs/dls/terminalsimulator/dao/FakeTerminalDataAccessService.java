package com.fgs.dls.terminalsimulator.dao;

import com.fgs.dls.terminalsimulator.model.Terminal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakeTerminalDataAccessService implements TerminalDao {

    private static List<Terminal> DB = new ArrayList<>();

    @Override
    public int insertTerminal(UUID id, Terminal terminal) {
        DB.add(new Terminal(id, terminal.getPlatform(), terminal.getIp(), terminal.getServicePort()));
        return 1;
    }

    @Override
    public List<Terminal> selectAllTerminal() {
        return DB;
    }

    @Override
    public Optional<Terminal> selectTerminalById(UUID id) {
        return DB.stream()
                .filter(term -> term.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTerminal(UUID id) {
        Optional<Terminal> terminalMaybe = selectTerminalById(id);
        if (terminalMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(terminalMaybe.get());
        return 1;
    }

    @Override
    public int updateTerminalById(UUID id, Terminal terminal) {
        return selectTerminalById(id)
                .map(p -> {
                    int indexOfTerminalToUpdate = DB.indexOf(p);
                    if (indexOfTerminalToUpdate >= 0) {
                        DB.set(indexOfTerminalToUpdate, new Terminal(id, terminal.getPlatform(), terminal.getIp(), terminal.getServicePort()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
