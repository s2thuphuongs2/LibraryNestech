package com.example.librarynestech.Repository;

import com.example.librarynestech.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<User, String> {
}
