package com.xyz.service;

import com.xyz.grpc.user.UserRequest;
import com.xyz.grpc.user.UserResponse;
import com.xyz.grpc.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * user service
 */
@GrpcService(UserServiceGrpc.class)
public class UserGrpcServerService extends UserServiceGrpc.UserServiceImplBase {

    Logger logger = LoggerFactory.getLogger(UserGrpcServerService.class);

    @Override
    public void queryUserById(UserRequest userRequest, StreamObserver<UserResponse> responseObserver) {

        logger.info("请求参数为: {}", userRequest);

        Long userId = userRequest.getUserId();

        UserResponse userReply = UserResponse.newBuilder().setUserId(userId).setName("mike" + userId).setAge(18).build();

        responseObserver.onNext(userReply);

        responseObserver.onCompleted();

    }


    @Override
    public StreamObserver<UserRequest> queryUserIds(final StreamObserver<UserResponse> streamObserver) {

        return new StreamObserver<UserRequest>() {
            @Override
            public void onNext(UserRequest userRequest) {
                logger.info("user request is : {}", userRequest);
                /**
                 * 根据 userRequest 查询对应的 userReply
                 */
                UserResponse userReply = UserResponse.newBuilder()
                        .setName("mike"+userRequest.getUserId())
                        .setAge(18)
                        .setUserId(userRequest.getUserId())
                        .build();
                streamObserver.onNext(userReply);
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                streamObserver.onCompleted();
            }
        };
    }
}
