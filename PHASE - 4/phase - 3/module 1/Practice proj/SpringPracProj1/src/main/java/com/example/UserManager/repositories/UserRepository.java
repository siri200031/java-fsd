package com.example.UserManager.repositories;

import java.util.Optional;

import javax.management.loading.ClassLoaderRepository;

import org.springframework.stereotype.Repository;
import com.example.UserManager.entities.User;
@Repository
public interface UserRepository extends ClassLoaderRepository {
public User findByName(String name);

public Iterable<User> findAll();

public Optional<User> findById(Integer id);

public User save(User userToUpdate);
}
