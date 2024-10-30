package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM people WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO people(full_name, born_year) VALUES(?, ?)",
                person.getFullName(), person.getBornYear());
    }
    public void update(Person updatedPerson, int id) {
        jdbcTemplate.update("UPDATE people SET full_name=?, born_year=? WHERE id=?",
                updatedPerson.getFullName(), updatedPerson.getBornYear(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }

    // Для валидации уникальности ФИО
    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM people WHERE full_name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    // Для получения книг по id читателя
    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE person_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
