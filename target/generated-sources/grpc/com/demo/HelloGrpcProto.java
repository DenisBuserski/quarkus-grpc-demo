// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto
// Protobuf Java Version: 3.25.5
package com.demo;

public final class HelloGrpcProto {

    private HelloGrpcProto() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_HelloRequest_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_HelloRequest_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_HelloReply_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_HelloReply_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_NumberRequest_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_NumberRequest_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_NumberResponse_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_NumberResponse_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_ProductIdRequest_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_ProductIdRequest_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_ProductResponse_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_ProductResponse_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_hello_ProductRequest_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_hello_ProductRequest_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = { "\n\013hello.proto\022\005hello\"\034\n\014HelloRequest\022\014\n\004" + "name\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007message\030\001 \001(" + "\t\"\036\n\rNumberRequest\022\r\n\005count\030\001 \001(\003\".\n\016Num" + "berResponse\022\r\n\005index\030\001 \001(\003\022\r\n\005value\030\002 \001(" + "\003\"\036\n\020ProductIdRequest\022\n\n\002id\030\001 \001(\003\"@\n\017Pro" + "ductResponse\022\014\n\004name\030\001 \001(\t\022\r\n\005price\030\002 \001(" + "\t\022\020\n\010quantity\030\003 \001(\005\"?\n\016ProductRequest\022\014\n" + "\004name\030\001 \001(\t\022\r\n\005price\030\002 \001(\t\022\020\n\010quantity\030\003" + " \001(\0052\216\002\n\tHelloGrpc\0224\n\010SayHello\022\023.hello.H" + "elloRequest\032\021.hello.HelloReply\"\000\022F\n\023Stre" + "amRandomNumbers\022\024.hello.NumberRequest\032\025." + "hello.NumberResponse\"\0000\001\022A\n\016GetProductBy" + "Id\022\027.hello.ProductIdRequest\032\026.hello.Prod" + "uctResponse\022@\n\rInsertProduct\022\025.hello.Pro" + "ductRequest\032\026.hello.ProductResponse\"\000B\034\n" + "\010com.demoB\016HelloGrpcProtoP\001b\006proto3" };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {});
        internal_static_hello_HelloRequest_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_hello_HelloRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_HelloRequest_descriptor, new java.lang.String[] { "Name" });
        internal_static_hello_HelloReply_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_hello_HelloReply_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_HelloReply_descriptor, new java.lang.String[] { "Message" });
        internal_static_hello_NumberRequest_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_hello_NumberRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_NumberRequest_descriptor, new java.lang.String[] { "Count" });
        internal_static_hello_NumberResponse_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_hello_NumberResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_NumberResponse_descriptor, new java.lang.String[] { "Index", "Value" });
        internal_static_hello_ProductIdRequest_descriptor = getDescriptor().getMessageTypes().get(4);
        internal_static_hello_ProductIdRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_ProductIdRequest_descriptor, new java.lang.String[] { "Id" });
        internal_static_hello_ProductResponse_descriptor = getDescriptor().getMessageTypes().get(5);
        internal_static_hello_ProductResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_ProductResponse_descriptor, new java.lang.String[] { "Name", "Price", "Quantity" });
        internal_static_hello_ProductRequest_descriptor = getDescriptor().getMessageTypes().get(6);
        internal_static_hello_ProductRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_hello_ProductRequest_descriptor, new java.lang.String[] { "Name", "Price", "Quantity" });
    }
    // @@protoc_insertion_point(outer_class_scope)
}
