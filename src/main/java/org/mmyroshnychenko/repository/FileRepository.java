package org.mmyroshnychenko.repository;

import org.mmyroshnychenko.model.File;

public interface FileRepository extends GenericRepository<File, Long> {
    File getByNameAndPath(String name, String path);
}
