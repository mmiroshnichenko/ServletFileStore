package org.mmyroshnychenko.service;

import org.junit.Test;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.UserRepository;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    private UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
    private UserService userService = new UserService(mockUserRepository);

    private User getUser() {
        return new User(1L, "michael");
    }

    private List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(getUser());
        return users;
    }

    @Test
    public void shouldSaveUserTest() {
        User newUser = new User();
        newUser.setUsername("michael");

        Mockito.when(mockUserRepository.save(newUser)).thenReturn(getUser());
        User savedMockUser = userService.save(newUser);

        assertEquals(savedMockUser, getUser());
    }

    @Test
    public void shouldUpdateUserTest() {
        User updatedUser = new User(1L, "pavel");
        Mockito.when(mockUserRepository.update(updatedUser)).thenReturn(updatedUser);
        User updatedMockUser = userService.updateUser(getUser(), "pavel");

        assertEquals(updatedUser, updatedMockUser);
    }

    @Test
    public void shouldGetByIdTest() {
        Mockito.when(mockUserRepository.getById(getUser().getId())).thenReturn(getUser());
        User mockUser = userService.getById(getUser().getId());

        assertEquals(getUser(), mockUser);
    }

    @Test
    public void shouldGetByUsername() {
        Mockito.when(mockUserRepository.getByUsername(getUser().getUsername())).thenReturn(getUser());
        User mockUser = userService.getByUsername(getUser().getUsername());

        assertEquals(getUser(), mockUser);
    }

    @Test
    public void shouldGetAllTest() {
        Mockito.when(mockUserRepository.getAll()).thenReturn(getAllUsers());
        List<User> mockUsers = userService.getAll();

        assertEquals(getAllUsers(), mockUsers);
    }
}
