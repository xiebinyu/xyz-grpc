package com.xyz.service;

import com.xyz.bean.User;
import com.xyz.grpc.user.UserRequest;
import com.xyz.grpc.user.UserResponse;
import com.xyz.grpc.user.UserServiceGrpc;
import com.xyz.interceptor.ClientHeaderGrpcInterceptor;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author hjforever
 */
@Service
public class GrpcClientService {

    static final Metadata.Key<String> USERID_HEADER_KEY = Metadata.Key.of("user_id", Metadata.ASCII_STRING_MARSHALLER);

    @GrpcClient("ms-service")
    private Channel serverChannel;

    public String queryUserNameById(Long userId) {

        Metadata metadata = new Metadata();
        metadata.put(USERID_HEADER_KEY, "" + userId);

        serverChannel = ClientInterceptors.intercept(serverChannel, new ClientHeaderGrpcInterceptor(metadata));

        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(serverChannel);

        UserRequest userRequest = UserRequest.newBuilder().setUserId(userId).build();

        UserResponse UserResponse = stub.queryUserById(userRequest);

        return UserResponse.getName();
    }

    public List<User> queryUserByIds(List<Long> ids) {

        UserServiceGrpc.UserServiceStub asyncStub = UserServiceGrpc.newStub(serverChannel);

        List<User> UserResponseList = new ArrayList<>();

        //只有当流结束或者发生异常时才终止,不然就一直等待，可以在调用时判断时间防止一直等待
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<UserRequest> userRequestStreamObserver = asyncStub.queryUserIds(new StreamObserver<UserResponse>() {

            @Override
            public void onNext(UserResponse UserResponse) {
                User user = new User();
                user.setUserId(UserResponse.getUserId());
                user.setUserName(UserResponse.getName());
                user.setAge(UserResponse.getAge());
                UserResponseList.add(user);
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        });

        /**
         * 设置 UserRequest 请求流
         */
        for (Long id : ids) {
            UserRequest userRequest = UserRequest.newBuilder().setUserId(id).build();
            userRequestStreamObserver.onNext(userRequest);
        }
        userRequestStreamObserver.onCompleted();

        /**
         * 阻塞直到结束，建议加上超时时间 eg : finishLatch.await(1,TimeUnit.SECONDS)
         */
        try {
            finishLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return UserResponseList;
    }


}
