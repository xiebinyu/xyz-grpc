// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package com.xyz.grpc.user;

public interface UserResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.UserResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 userId = 1;</code>
   */
  long getUserId();

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 3;</code>
   */
  int getAge();
}
