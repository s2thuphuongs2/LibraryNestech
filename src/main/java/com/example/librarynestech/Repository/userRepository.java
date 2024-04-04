package com.example.librarynestech.Repository;

import com.example.librarynestech.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
}
