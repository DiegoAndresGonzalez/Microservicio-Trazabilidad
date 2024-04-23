package com.pragma.powerup.feignclient;

import com.pragma.powerup.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "userServiceClient", url = "${microservice.userServiceUrl}")
public interface IUserFeignClient {

    @GetMapping("data")
    UserModel fetchUser(@RequestHeader("Authorization") String authorization);

}