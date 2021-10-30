package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInformationRepository extends CrudRepository<User, String> {
}
