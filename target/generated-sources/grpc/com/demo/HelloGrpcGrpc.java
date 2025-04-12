package com.demo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * "service" is an interface of the service
 * "rpc" is used to define an RPC service
 * </pre>
 */
@io.quarkus.Generated(value = "by gRPC proto compiler (version 1.69.1)", comments = "Source: hello.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloGrpcGrpc {

    private HelloGrpcGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "hello.HelloGrpc";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.demo.HelloRequest, com.demo.HelloReply> getSayHelloMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "SayHello", requestType = com.demo.HelloRequest.class, responseType = com.demo.HelloReply.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.demo.HelloRequest, com.demo.HelloReply> getSayHelloMethod() {
        io.grpc.MethodDescriptor<com.demo.HelloRequest, com.demo.HelloReply> getSayHelloMethod;
        if ((getSayHelloMethod = HelloGrpcGrpc.getSayHelloMethod) == null) {
            synchronized (HelloGrpcGrpc.class) {
                if ((getSayHelloMethod = HelloGrpcGrpc.getSayHelloMethod) == null) {
                    HelloGrpcGrpc.getSayHelloMethod = getSayHelloMethod = io.grpc.MethodDescriptor.<com.demo.HelloRequest, com.demo.HelloReply>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.HelloRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.HelloReply.getDefaultInstance())).setSchemaDescriptor(new HelloGrpcMethodDescriptorSupplier("SayHello")).build();
                }
            }
        }
        return getSayHelloMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.demo.NumberRequest, com.demo.NumberResponse> getStreamRandomNumbersMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "StreamRandomNumbers", requestType = com.demo.NumberRequest.class, responseType = com.demo.NumberResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<com.demo.NumberRequest, com.demo.NumberResponse> getStreamRandomNumbersMethod() {
        io.grpc.MethodDescriptor<com.demo.NumberRequest, com.demo.NumberResponse> getStreamRandomNumbersMethod;
        if ((getStreamRandomNumbersMethod = HelloGrpcGrpc.getStreamRandomNumbersMethod) == null) {
            synchronized (HelloGrpcGrpc.class) {
                if ((getStreamRandomNumbersMethod = HelloGrpcGrpc.getStreamRandomNumbersMethod) == null) {
                    HelloGrpcGrpc.getStreamRandomNumbersMethod = getStreamRandomNumbersMethod = io.grpc.MethodDescriptor.<com.demo.NumberRequest, com.demo.NumberResponse>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamRandomNumbers")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.NumberRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.NumberResponse.getDefaultInstance())).setSchemaDescriptor(new HelloGrpcMethodDescriptorSupplier("StreamRandomNumbers")).build();
                }
            }
        }
        return getStreamRandomNumbersMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.demo.ProductIdRequest, com.demo.ProductResponse> getGetProductByIdMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetProductById", requestType = com.demo.ProductIdRequest.class, responseType = com.demo.ProductResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.demo.ProductIdRequest, com.demo.ProductResponse> getGetProductByIdMethod() {
        io.grpc.MethodDescriptor<com.demo.ProductIdRequest, com.demo.ProductResponse> getGetProductByIdMethod;
        if ((getGetProductByIdMethod = HelloGrpcGrpc.getGetProductByIdMethod) == null) {
            synchronized (HelloGrpcGrpc.class) {
                if ((getGetProductByIdMethod = HelloGrpcGrpc.getGetProductByIdMethod) == null) {
                    HelloGrpcGrpc.getGetProductByIdMethod = getGetProductByIdMethod = io.grpc.MethodDescriptor.<com.demo.ProductIdRequest, com.demo.ProductResponse>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProductById")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.ProductIdRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.demo.ProductResponse.getDefaultInstance())).setSchemaDescriptor(new HelloGrpcMethodDescriptorSupplier("GetProductById")).build();
                }
            }
        }
        return getGetProductByIdMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static HelloGrpcStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<HelloGrpcStub> factory = new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcStub>() {

            @java.lang.Override
            public HelloGrpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new HelloGrpcStub(channel, callOptions);
            }
        };
        return HelloGrpcStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static HelloGrpcBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<HelloGrpcBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcBlockingStub>() {

            @java.lang.Override
            public HelloGrpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new HelloGrpcBlockingStub(channel, callOptions);
            }
        };
        return HelloGrpcBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static HelloGrpcFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<HelloGrpcFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcFutureStub>() {

            @java.lang.Override
            public HelloGrpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new HelloGrpcFutureStub(channel, callOptions);
            }
        };
        return HelloGrpcFutureStub.newStub(factory, channel);
    }

    /**
     * <pre>
     * "service" is an interface of the service
     * "rpc" is used to define an RPC service
     * </pre>
     */
    public interface AsyncService {

        /**
         */
        default void sayHello(com.demo.HelloRequest request, io.grpc.stub.StreamObserver<com.demo.HelloReply> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
        }

        /**
         */
        default void streamRandomNumbers(com.demo.NumberRequest request, io.grpc.stub.StreamObserver<com.demo.NumberResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamRandomNumbersMethod(), responseObserver);
        }

        /**
         */
        default void getProductById(com.demo.ProductIdRequest request, io.grpc.stub.StreamObserver<com.demo.ProductResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductByIdMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service HelloGrpc.
     * <pre>
     * "service" is an interface of the service
     * "rpc" is used to define an RPC service
     * </pre>
     */
    public static abstract class HelloGrpcImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return HelloGrpcGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service HelloGrpc.
     * <pre>
     * "service" is an interface of the service
     * "rpc" is used to define an RPC service
     * </pre>
     */
    public static class HelloGrpcStub extends io.grpc.stub.AbstractAsyncStub<HelloGrpcStub> {

        private HelloGrpcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloGrpcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HelloGrpcStub(channel, callOptions);
        }

        /**
         */
        public void sayHello(com.demo.HelloRequest request, io.grpc.stub.StreamObserver<com.demo.HelloReply> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void streamRandomNumbers(com.demo.NumberRequest request, io.grpc.stub.StreamObserver<com.demo.NumberResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(getChannel().newCall(getStreamRandomNumbersMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getProductById(com.demo.ProductIdRequest request, io.grpc.stub.StreamObserver<com.demo.ProductResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service HelloGrpc.
     * <pre>
     * "service" is an interface of the service
     * "rpc" is used to define an RPC service
     * </pre>
     */
    public static class HelloGrpcBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloGrpcBlockingStub> {

        private HelloGrpcBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloGrpcBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HelloGrpcBlockingStub(channel, callOptions);
        }

        /**
         */
        public com.demo.HelloReply sayHello(com.demo.HelloRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getSayHelloMethod(), getCallOptions(), request);
        }

        /**
         */
        public java.util.Iterator<com.demo.NumberResponse> streamRandomNumbers(com.demo.NumberRequest request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(getChannel(), getStreamRandomNumbersMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.demo.ProductResponse getProductById(com.demo.ProductIdRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetProductByIdMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service HelloGrpc.
     * <pre>
     * "service" is an interface of the service
     * "rpc" is used to define an RPC service
     * </pre>
     */
    public static class HelloGrpcFutureStub extends io.grpc.stub.AbstractFutureStub<HelloGrpcFutureStub> {

        private HelloGrpcFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected HelloGrpcFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HelloGrpcFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.demo.HelloReply> sayHello(com.demo.HelloRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.demo.ProductResponse> getProductById(com.demo.ProductIdRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetProductByIdMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_SAY_HELLO = 0;

    private static final int METHODID_STREAM_RANDOM_NUMBERS = 1;

    private static final int METHODID_GET_PRODUCT_BY_ID = 2;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AsyncService serviceImpl;

        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_SAY_HELLO:
                    serviceImpl.sayHello((com.demo.HelloRequest) request, (io.grpc.stub.StreamObserver<com.demo.HelloReply>) responseObserver);
                    break;
                case METHODID_STREAM_RANDOM_NUMBERS:
                    serviceImpl.streamRandomNumbers((com.demo.NumberRequest) request, (io.grpc.stub.StreamObserver<com.demo.NumberResponse>) responseObserver);
                    break;
                case METHODID_GET_PRODUCT_BY_ID:
                    serviceImpl.getProductById((com.demo.ProductIdRequest) request, (io.grpc.stub.StreamObserver<com.demo.ProductResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getSayHelloMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.demo.HelloRequest, com.demo.HelloReply>(service, METHODID_SAY_HELLO))).addMethod(getStreamRandomNumbersMethod(), io.grpc.stub.ServerCalls.asyncServerStreamingCall(new MethodHandlers<com.demo.NumberRequest, com.demo.NumberResponse>(service, METHODID_STREAM_RANDOM_NUMBERS))).addMethod(getGetProductByIdMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.demo.ProductIdRequest, com.demo.ProductResponse>(service, METHODID_GET_PRODUCT_BY_ID))).build();
    }

    private static abstract class HelloGrpcBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        HelloGrpcBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.demo.HelloGrpcProto.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("HelloGrpc");
        }
    }

    private static final class HelloGrpcFileDescriptorSupplier extends HelloGrpcBaseDescriptorSupplier {

        HelloGrpcFileDescriptorSupplier() {
        }
    }

    private static final class HelloGrpcMethodDescriptorSupplier extends HelloGrpcBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final java.lang.String methodName;

        HelloGrpcMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (HelloGrpcGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new HelloGrpcFileDescriptorSupplier()).addMethod(getSayHelloMethod()).addMethod(getStreamRandomNumbersMethod()).addMethod(getGetProductByIdMethod()).build();
                }
            }
        }
        return result;
    }
}
