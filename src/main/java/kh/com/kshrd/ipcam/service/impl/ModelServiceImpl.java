package kh.com.kshrd.ipcam.service.impl;

import kh.com.kshrd.ipcam.entity.camera.Model;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.ModelInputer;
import kh.com.kshrd.ipcam.entity.camera.inputerEntity.ModelModifier;
import kh.com.kshrd.ipcam.repository.Camera.ModelRepository;
import kh.com.kshrd.ipcam.service.extend.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rina on 12/21/16.
 */
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepository modelRepository;


    @Override
    public Model getModelById(int id) {
        return modelRepository.findOne(id);
    }

    @Override
    public List<Model> getAllModel() {
        return modelRepository.getAllModel();
    }

    @Override
    public boolean remove(int id) {
        return modelRepository.removeModle(id);
    }

    @Override
    public boolean update(ModelModifier object) {
        return update(object);
    }

    @Override
    public boolean save(ModelInputer object) {
        return modelRepository.addModel(object);
    }
}
