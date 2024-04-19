CREATE DATABASE  IF NOT EXISTS `library_nestech`;
USE `library_nestech`;


    -- Book table
    CREATE TABLE if not exists book (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        pages INT,
        genre VARCHAR(255),
        add_date DATE,
        image VARCHAR(255),
        description TEXT
    );

    -- User table
    CREATE TABLE if not exists user (
        id VARCHAR(255) PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        name VARCHAR(255),
        birthday DATE,
        card_number VARCHAR(255),
        phone_number VARCHAR(255),
        address VARCHAR(255),
        image VARCHAR(255)
    );

    -- Linking table for many-to-many relationship
    CREATE TABLE if not exists book_user (
        book_id BIGINT not null ,
        user_id VARCHAR(255) not null,
        PRIMARY KEY (book_id, user_id),
        FOREIGN KEY (book_id) REFERENCES book(id),
        FOREIGN KEY (user_id) REFERENCES user(id)
    );

