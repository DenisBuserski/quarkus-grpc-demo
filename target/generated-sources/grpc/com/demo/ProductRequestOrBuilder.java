// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto
// Protobuf Java Version: 3.25.5
package com.demo;

public interface ProductRequestOrBuilder extends // @@protoc_insertion_point(interface_extends:hello.ProductRequest)
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
     * <code>string price = 2;</code>
     * @return The price.
     */
    java.lang.String getPrice();

    /**
     * <code>string price = 2;</code>
     * @return The bytes for price.
     */
    com.google.protobuf.ByteString getPriceBytes();

    /**
     * <code>int32 quantity = 3;</code>
     * @return The quantity.
     */
    int getQuantity();
}
