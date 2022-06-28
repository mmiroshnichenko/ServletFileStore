package org.mmyroshnychenko.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    public File() {
    }

    public File(Long id, String name, String path, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!id.equals(file.id)) return false;
        if (!name.equals(file.name)) return false;
        if (!path.equals(file.path)) return false;
        if (!created.equals(file.created)) return false;
        return updated != null ? updated.equals(file.updated) : file.updated == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + path.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
