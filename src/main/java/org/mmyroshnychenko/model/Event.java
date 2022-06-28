package org.mmyroshnychenko.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "fileId")
    private File file;

    @Column(name = "created")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EventType type;

    public Event() {
    }

    public Event(Long id, User user, File file, Date created, EventType type) {
        this.id = id;
        this.user = user;
        this.file = file;
        this.created = created;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!id.equals(event.id)) return false;
        if (!user.equals(event.user)) return false;
        if (!file.equals(event.file)) return false;
        if (!created.equals(event.created)) return false;
        return type == event.type;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + file.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user=" + user +
                ", file=" + file +
                ", created=" + created +
                ", type=" + type +
                '}';
    }
}
