package com.khalifahmb.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.khalifahmb.springbootmongodb.collection.Person;

/**
 * The PersonRepository interface is used to interact with the MongoDB database.
 * It extends the MongoRepository interface and provides customized query methods.
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    /**
     * The findByFirstNameStartsWith method searches the database for all Person objects
     * where the firstName attribute starts with the given string.
     *
     * @param lastName the string to search for in the firstName attribute
     * @return a List of Person objects where the firstName attribute starts with the given string
     */
    List<Person> findByFirstNameStartsWith(String lastName);

    /**
     * The findByAgeBetween method searches the database for all Person objects
     * where the age attribute is between the given min and max values.
     *
     * The method also includes a query to exclude the addresses attribute from the result.
     *
     * @param min the minimum value of the age attribute
     * @param max the maximum value of the age attribute
     * @return a List of Person objects where the age attribute is between the given min and max values
     */
    @Query(value = "{'age' : { $gt: ?0, $lt: ?1}}", fields = "{addresses : 0}")
    List<Person> findByAgeBetween(Integer min, Integer max);

}