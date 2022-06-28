package org.mmyroshnychenko.repository;

import org.mmyroshnychenko.model.User;

public interface UserRepository extends GenericRepository<User, Long> {
    User getByUsername(String username);
}
