// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto
// Protobuf Java Version: 3.25.5
package com.demo;

public interface ProductResponseOrBuilder extends // @@protoc_insertion_point(interface_extends:hello.ProductResponse)
com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    java.lang.String getName();

    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString getNameBytes();

    /**
     * <code>double price = 2;</code>
     * @return The price.
     */
    double getPrice();

    /**
     * <code>int64 quantity = 3;</code>
     * @return The quantity.
     */
    long getQuantity();
}
