package com.example.test_case.controller;


import com.example.test_case.jwt.JwtResponse;
import com.example.test_case.jwt.JwtService;
import com.example.test_case.model.Customer;
import com.example.test_case.model.Role;
import com.example.test_case.service.ICustomerService;
import com.example.test_case.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(iCustomerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/find/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(iCustomerService.findByEmailAddress(email), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customer.getName(), customer.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Customer currentUser = iCustomerService.findByName(customer.getName()).get();
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("Hello User", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> responseEntity(@RequestBody Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/role")
    public ResponseEntity<Iterable<Role>> getRole() {
        Iterable<Role> roles = iRoleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
