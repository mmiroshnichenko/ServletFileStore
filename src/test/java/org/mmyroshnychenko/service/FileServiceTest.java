package org.mmyroshnychenko.service;

import org.junit.Test;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.repository.FileRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileServiceTest {
    private FileRepository mockFileRepository = Mockito.mock(FileRepository.class);
    private FileService fileService = new FileService(mockFileRepository);
    private Date date = new Date();

    private File getFile() {
        return new File(1L, "testName", "testPath", date, date);
    }

    private List<File> getAllFiles() {
        List<File> files = new ArrayList<>();
        files.add(getFile());
        return files;
    }

    @Test
    public void shouldSaveFileTest() {
        File newFile = new File();
        newFile.setName("testName");
        newFile.setPath("testPath");

        Mockito.when(mockFileRepository.save(newFile)).thenReturn(getFile());
        File savedMockFile = fileService.save(newFile);

        assertEquals(savedMockFile, getFile());
    }

    @Test
    public void shouldUpdateFileTest() {
        File updatedFile = new File(1L, "updatedName", "updatedPath", date, new Date());
        Mockito.when(mockFileRepository.update(getFile())).thenReturn(updatedFile);
        File updatedMockFile = fileService.update(getFile());

        assertEquals(updatedFile, updatedMockFile);
    }

    @Test
    public void shouldGetByIdTest() {
        Mockito.when(mockFileRepository.getById(getFile().getId())).thenReturn(getFile());
        File mockFile = fileService.getById(getFile().getId());

        assertEquals(getFile(), mockFile);
    }

    @Test
    public void shouldGetByNameAndPathTest() {
        Mockito.when(mockFileRepository.getByNameAndPath(getFile().getName(), getFile().getPath())).thenReturn(getFile());
        File mockFile = fileService.getByNameAndPath(getFile().getName(), getFile().getPath());

        assertEquals(getFile(), mockFile);
    }

    @Test
    public void shouldGetAllTest() {
        Mockito.when(mockFileRepository.getAll()).thenReturn(getAllFiles());
        List<File> mockFiles = fileService.getAll();

        assertEquals(getAllFiles(), mockFiles);
    }
}
