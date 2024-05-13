package com.example.dating.controller;
import com.example.dating.DTO.ProfileDTO;
import com.example.dating.entity.User;
import com.example.dating.repository.UserRepository;
import com.example.dating.service.ProfileDTOService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customProfileController")
@RequestMapping("/api/profile")
public class ProfileController {
    private final UserRepository userRepository ;

    public ProfileController(UserRepository userRepository){
        this.userRepository = userRepository ;
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
