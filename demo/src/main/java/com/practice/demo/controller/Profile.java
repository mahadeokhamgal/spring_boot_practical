/**
 * Write a Spring boot controller to get Request from API URL 
 * which has profileid from path variable, and name as query param. and send response as JSON in below format.
 * GET HTTP - localhost:8080/profile/1005?name=Sun
 * Profile(  profileId,  name)
 * // RESPONSE
 * {
 *  "profileID" : 1005,
 *  "name":"Sun"
 * }
 */

package com.practice.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.Pojo.User;

@RestController
@RequestMapping("/api/profile")
public class Profile {

    @GetMapping("/{profileId}")
    public ResponseEntity<User> getUserDetails(@PathVariable long profileId, @RequestParam String name) {
        User user = new User(profileId, name);
        return ResponseEntity.ok(user);
    }
}
