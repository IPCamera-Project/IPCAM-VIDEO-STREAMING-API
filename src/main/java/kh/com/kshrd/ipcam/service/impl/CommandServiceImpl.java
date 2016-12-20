package kh.com.kshrd.ipcam.service.impl;

import kh.com.kshrd.ipcam.entity.camera.Command;
import kh.com.kshrd.ipcam.repository.camera.CommandRepository;
import kh.com.kshrd.ipcam.service.CrudService;
import kh.com.kshrd.ipcam.service.extend.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rina on 12/15/16.
 */
@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    CommandRepository commandRepository;

    @Override
    public Command findOne(int id) {
        return commandRepository.findOne(2);
    }

    @Override
    public List<Command> findAll() {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(Command object) {
        return false;
    }

    @Override
    public boolean save(Command command) {
        return commandRepository.save(command);
    }


}
