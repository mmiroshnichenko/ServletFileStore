package org.mmyroshnychenko.service;

import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.repository.FileRepository;
import org.mmyroshnychenko.repository.impl.HibernateFileRepositoryImpl;

import java.util.Date;
import java.util.List;

public class FileService {
    private final FileRepository fileRepository;

    public FileService() {
        fileRepository = new HibernateFileRepositoryImpl();
    }

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveNewFile(String name, String path) {
        File file = new File();
        file.setName(name);
        file.setPath(path);
        file.setCreated(new Date());
        file.setUpdated(new Date());
        return this.save(file);
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File getByNameAndPath(String name, String path) {
        return fileRepository.getByNameAndPath(name, path);
    }

    public File getById(Long id) {
        return fileRepository.getById(id);
    }

    public File update(File file, String name, String path) {
        file.setName(name);
        file.setPath(path);
        file.setUpdated(new Date());
        return fileRepository.update(file);
    }

    public void delete(File file) {
        fileRepository.deleteById(file.getId());
    }

    public List<File> getAll() {
        return fileRepository.getAll();
    }
}
