package com.example.dating.controller;
import com.example.dating.DTO.ProfileDTO;
import com.example.dating.entity.User;
import com.example.dating.repository.UserRepository;
import com.example.dating.service.ProfileDTOService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customProfileController")
@RequestMapping("/api/profile")
public class ProfileController {
    private static final String BASE_PATH = "C:/Users/Mintsa/Desktop/dating/upload/profiles/";
    private final UserRepository userRepository ;

    public ProfileController(UserRepository userRepository){
        this.userRepository = userRepository ;
    }
    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getProfileImage(@PathVariable String filename) {
        try {
            Resource file = new FileSystemResource(BASE_PATH + filename);
            if (file.exists() && file.isReadable()) {
                return ResponseEntity.ok(file);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getUserProfile(@PathVariable Long id) {
        User user = userRepository.findByUserID(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        ProfileDTO profileDTO = ProfileDTOService.converToProfileDTO(user) ;
        return ResponseEntity.ok(profileDTO);
    }

}
