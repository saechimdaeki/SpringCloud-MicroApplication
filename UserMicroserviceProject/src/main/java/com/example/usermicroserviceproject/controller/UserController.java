package com.example.usermicroserviceproject.controller;

import com.example.usermicroserviceproject.dto.UserDto;
import com.example.usermicroserviceproject.service.UserService;
import com.example.usermicroserviceproject.vo.Greeting;
import com.example.usermicroserviceproject.vo.RequestUser;
import com.example.usermicroserviceproject.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final UserService userService;
    private final Greeting greeting;




    @GetMapping("/user-service/health_check")
    public String status(){
        return String.format("It's Working in User Service on PORT %s"
                ,env.getProperty("local.server.port"));
    }

    @GetMapping("/user-service/welcome")
    public String welcome(){
        //return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @PostMapping("/user-service/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto=mapper.map(user,UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser=mapper.map(userDto,ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
