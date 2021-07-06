package com.doctor.appointment.security;

import com.doctor.appointment.dto.AuthDto;
import com.doctor.appointment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

//    private static List<String> userList =Arrays.asList("gxg@cst.ro");

    private UserRepository doctorRepository;

    @Autowired
    public void setServices(UserRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String email = authentication.getName().trim();
        String inputPassword = authentication.getCredentials().toString();


        Optional<AuthDto> optionalAuthDto = doctorRepository.getByEmailWithPasswordAndRole(email);
//        Optional<User> optionalDoctor = doctorRepository.findByEmail(email);

        if (optionalAuthDto.isPresent()) {

            AuthDto authDto = optionalAuthDto.get();
//            User doctor = optionalDoctor.get();
            String dbPassword = authDto.getPassword();

            if (BCrypt.checkpw(inputPassword, dbPassword)) {
                UserDetails userDetails = UserPrinciple.build(authDto);
                Authentication newAuth = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(newAuth);

                return newAuth;
            } throw new BadCredentialsException("Wrong password");

        } return null;
    }
}
