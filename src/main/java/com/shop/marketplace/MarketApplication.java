package com.shop.marketplace;

import com.shop.marketplace.repository.UserRepository;
import com.shop.marketplace.repository.RoleRepository;
import com.shop.marketplace.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication implements CommandLineRunner {

	@Autowired
    UserRepository doctorRepository;

	@Autowired
    RoleRepository roleRepository;

	@Autowired
    EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	//	emailService.sendMail("george.brande@cst.ro", "test subject",
	//			"test text");

//		Optional<User> optionalDoctor = doctorRepository.findByEmail("gxg@cst.ro");
//		if (optionalDoctor.isPresent()) {
//			User doctor = optionalDoctor.get();
//
//			doctor.setPassword(BCrypt.hashpw("Password2", BCrypt.gensalt()));
//
//			doctorRepository.save(doctor);
//		}


//		Role admin = new Role("ROLE_ADMIN");
//		Role roleDefault = new Role("ROLE_DEFAULT");
//
//		roleRepository.save(admin);
//		roleRepository.save(roleDefault);

//		Optional<User> optionalDoctor =
//				doctorRepository.findById(1L);
//
//		if (optionalDoctor.isPresent()) {
//			User doctor = optionalDoctor.get();
//
//			Optional<Role> optionalRole = roleRepository.findByRole("ROLE_ADMIN");
//			if (optionalRole.isPresent()) {
//				Role role = optionalRole.get();
//
//				doctor.setRole(role);
//				doctorRepository.save(doctor);
//			}
//
//		}
//
//		User defaultDoctor = new User("gxg@cst.ro", "George", 18);
//		doctorRepository.save(defaultDoctor);
//
//		Optional<Role> optionalRole = roleRepository.findByRole("ROLE_DEFAULT");
//		if (optionalRole.isPresent()) {
//			Role role = optionalRole.get();
//
//			defaultDoctor.setRole(role);
//			doctorRepository.save(defaultDoctor);
//		}

	}

}
