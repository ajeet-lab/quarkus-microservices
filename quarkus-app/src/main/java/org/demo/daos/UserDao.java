package org.demo.daos;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Id;
import org.demo.entities.User;

@ApplicationScoped
public class UserDao implements PanacheRepository<User> {


}
