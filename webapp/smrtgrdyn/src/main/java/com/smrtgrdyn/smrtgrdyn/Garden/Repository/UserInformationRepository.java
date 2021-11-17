package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInformationRepository extends CrudRepository<User, String> {
}
