package com.doctor.appointment.service;

import com.doctor.appointment.exception.Conflict;
import com.doctor.appointment.exception.CustomConflictException;
import com.doctor.appointment.model.Media;
import com.doctor.appointment.model.User;
import com.doctor.appointment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class MediaService {

    private static String path = "/files";

    @Autowired
    UserRepository userRepository;

    public String addMediaToUser(String fileName,
                                     Long employeeId,
                                     String type) throws CustomConflictException {
        if (type.equals(".mp4")) {
            throw new CustomConflictException(Conflict.FILE_NOT_SUPPORTED);
        }

        Optional<User> optionalEmployee = userRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            long now = System.currentTimeMillis();
            User user = optionalEmployee.get();
            Media mediaFile = new Media(path, fileName, ".jpg", now);
            LocalDate localDate =
                    Instant.ofEpochMilli(now)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
            System.out.println("localDate: " + localDate);
            user.setProfileImage(mediaFile);

            userRepository.save(user);

            return "saved file";
        } return "not saved";

    }
}
