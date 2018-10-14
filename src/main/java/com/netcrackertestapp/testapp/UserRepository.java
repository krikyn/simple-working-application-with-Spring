package com.netcrackertestapp.testapp;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<People, Integer> {

}