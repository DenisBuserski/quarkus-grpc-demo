package com.demo;

import static com.demo.HelloGrpcGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public final class MutinyHelloGrpcGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyHelloGrpcGrpc() {
    }

    public static MutinyHelloGrpcStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyHelloGrpcStub(channel);
    }

    /**
     * <pre>
     *  &quot;service&quot; is an interface of the service
     *  &quot;rpc&quot; is used to define an RPC service
     * </pre>
     */
    public static class MutinyHelloGrpcStub extends io.grpc.stub.AbstractStub<MutinyHelloGrpcStub> implements io.quarkus.grpc.MutinyStub {

        private HelloGrpcGrpc.HelloGrpcStub delegateStub;

        private MutinyHelloGrpcStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = HelloGrpcGrpc.newStub(channel);
        }

        private MutinyHelloGrpcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = HelloGrpcGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyHelloGrpcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyHelloGrpcStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<com.demo.HelloReply> sayHello(com.demo.HelloRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::sayHello);
        }

        public io.smallrye.mutiny.Uni<com.demo.ProductResponse> getProductById(com.demo.ProductIdRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getProductById);
        }

        public io.smallrye.mutiny.Uni<com.demo.ProductResponse> insertProduct(com.demo.ProductRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::insertProduct);
        }

        public io.smallrye.mutiny.Multi<com.demo.NumberResponse> streamRandomNumbers(com.demo.NumberRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::streamRandomNumbers);
        }
    }

    /**
     * <pre>
     *  &quot;service&quot; is an interface of the service
     *  &quot;rpc&quot; is used to define an RPC service
     * </pre>
     */
    public static abstract class HelloGrpcImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public HelloGrpcImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<com.demo.HelloReply> sayHello(com.demo.HelloRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.demo.ProductResponse> getProductById(com.demo.ProductIdRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.demo.ProductResponse> insertProduct(com.demo.ProductRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Multi<com.demo.NumberResponse> streamRandomNumbers(com.demo.NumberRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(com.demo.HelloGrpcGrpc.getSayHelloMethod(), asyncUnaryCall(new MethodHandlers<com.demo.HelloRequest, com.demo.HelloReply>(this, METHODID_SAY_HELLO, compression))).addMethod(com.demo.HelloGrpcGrpc.getStreamRandomNumbersMethod(), asyncServerStreamingCall(new MethodHandlers<com.demo.NumberRequest, com.demo.NumberResponse>(this, METHODID_STREAM_RANDOM_NUMBERS, compression))).addMethod(com.demo.HelloGrpcGrpc.getGetProductByIdMethod(), asyncUnaryCall(new MethodHandlers<com.demo.ProductIdRequest, com.demo.ProductResponse>(this, METHODID_GET_PRODUCT_BY_ID, compression))).addMethod(com.demo.HelloGrpcGrpc.getInsertProductMethod(), asyncUnaryCall(new MethodHandlers<com.demo.ProductRequest, com.demo.ProductResponse>(this, METHODID_INSERT_PRODUCT, compression))).build();
        }
    }

    private static final int METHODID_SAY_HELLO = 0;

    private static final int METHODID_STREAM_RANDOM_NUMBERS = 1;

    private static final int METHODID_GET_PRODUCT_BY_ID = 2;

    private static final int METHODID_INSERT_PRODUCT = 3;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final HelloGrpcImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(HelloGrpcImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_SAY_HELLO:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.demo.HelloRequest) request, (io.grpc.stub.StreamObserver<com.demo.HelloReply>) responseObserver, compression, serviceImpl::sayHello);
                    break;
                case METHODID_STREAM_RANDOM_NUMBERS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.demo.NumberRequest) request, (io.grpc.stub.StreamObserver<com.demo.NumberResponse>) responseObserver, compression, serviceImpl::streamRandomNumbers);
                    break;
                case METHODID_GET_PRODUCT_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.demo.ProductIdRequest) request, (io.grpc.stub.StreamObserver<com.demo.ProductResponse>) responseObserver, compression, serviceImpl::getProductById);
                    break;
                case METHODID_INSERT_PRODUCT:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.demo.ProductRequest) request, (io.grpc.stub.StreamObserver<com.demo.ProductResponse>) responseObserver, compression, serviceImpl::insertProduct);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
