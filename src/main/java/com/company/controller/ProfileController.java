package com.company.controller;

import com.company.dto.ProfileDTO;
import com.company.dto.ProfileResponseDTO;
import com.company.dto.RegistrationDTO;
import com.company.entity.ProfileEntity;
import com.company.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;


    @PostMapping("/adm/create")
    public ResponseEntity<String> create(@RequestBody @Valid RegistrationDTO profileDto) {

        profileService.create(profileDto);
        return ResponseEntity.ok().body("successfully");
    }
    @PutMapping("/user/changePassword/{password}")
    public ResponseEntity<String>changePassword(@PathVariable("password") String password){
        profileService.changePassword(password);
        return ResponseEntity.ok().body("successfully");
    }


    @PutMapping("/user/changeNameSurname")
    public ResponseEntity<String>changeNameSurname(@RequestBody @Valid ProfileDTO profileDto){
        profileService.changeNameSurname(profileDto);
        return ResponseEntity.ok().body("successfully");
    }


    @GetMapping("/user/getProfileDetail")
    public ResponseEntity<ProfileResponseDTO> getProfileDetail() {

        ProfileResponseDTO dto = profileService.getProfileDetail();
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping("/user/get")
    public Page<ProfileEntity> getUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return profileService.getUsers(pageNumber, pageSize);
    }

}
