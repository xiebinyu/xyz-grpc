package com.xyz.grpc.user;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The user service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: UserService.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "user.UserService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.xyz.grpc.user.UserRequest,
      com.xyz.grpc.user.UserResponse> METHOD_QUERY_USER_BY_ID =
      io.grpc.MethodDescriptor.<com.xyz.grpc.user.UserRequest, com.xyz.grpc.user.UserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "user.UserService", "QueryUserById"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.xyz.grpc.user.UserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.xyz.grpc.user.UserResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.xyz.grpc.user.UserRequest,
      com.xyz.grpc.user.UserResponse> METHOD_QUERY_USER_IDS =
      io.grpc.MethodDescriptor.<com.xyz.grpc.user.UserRequest, com.xyz.grpc.user.UserResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "user.UserService", "queryUserIds"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.xyz.grpc.user.UserRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.xyz.grpc.user.UserResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    return new UserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *根据id查询用户
     * </pre>
     */
    public void queryUserById(com.xyz.grpc.user.UserRequest request,
        io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_QUERY_USER_BY_ID, responseObserver);
    }

    /**
     * <pre>
     *双向流 支持1次或者多次
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserRequest> queryUserIds(
        io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_QUERY_USER_IDS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_QUERY_USER_BY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.xyz.grpc.user.UserRequest,
                com.xyz.grpc.user.UserResponse>(
                  this, METHODID_QUERY_USER_BY_ID)))
          .addMethod(
            METHOD_QUERY_USER_IDS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.xyz.grpc.user.UserRequest,
                com.xyz.grpc.user.UserResponse>(
                  this, METHODID_QUERY_USER_IDS)))
          .build();
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
    private UserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *根据id查询用户
     * </pre>
     */
    public void queryUserById(com.xyz.grpc.user.UserRequest request,
        io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_QUERY_USER_BY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *双向流 支持1次或者多次
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserRequest> queryUserIds(
        io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_QUERY_USER_IDS, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *根据id查询用户
     * </pre>
     */
    public com.xyz.grpc.user.UserResponse queryUserById(com.xyz.grpc.user.UserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_QUERY_USER_BY_ID, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
    private UserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *根据id查询用户
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.xyz.grpc.user.UserResponse> queryUserById(
        com.xyz.grpc.user.UserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_QUERY_USER_BY_ID, getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_USER_BY_ID = 0;
  private static final int METHODID_QUERY_USER_IDS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_USER_BY_ID:
          serviceImpl.queryUserById((com.xyz.grpc.user.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_USER_IDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.queryUserIds(
              (io.grpc.stub.StreamObserver<com.xyz.grpc.user.UserResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UserServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.xyz.grpc.user.UserServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceDescriptorSupplier())
              .addMethod(METHOD_QUERY_USER_BY_ID)
              .addMethod(METHOD_QUERY_USER_IDS)
              .build();
        }
      }
    }
    return result;
  }
}
