package com.xyz.controller;

import com.xyz.bean.User;
import com.xyz.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * test controller
 */
@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/api/user")
    public String queryUserName(@RequestParam(defaultValue = "1") Long userId) {
        return grpcClientService.queryUserNameById(userId);
    }

    @RequestMapping("/api/users")
    public List<User> users(@RequestBody List<Long> userIds){
        return grpcClientService.queryUserByIds(userIds);
    }
}
