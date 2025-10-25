package devencarnacion.app_amf_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devencarnacion.app_amf_back.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
