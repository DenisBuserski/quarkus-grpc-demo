// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto
// Protobuf Java Version: 3.25.5
package com.demo;

/**
 * Protobuf type {@code hello.NumberRequest}
 */
public final class NumberRequest extends com.google.protobuf.GeneratedMessageV3 implements // @@protoc_insertion_point(message_implements:hello.NumberRequest)
NumberRequestOrBuilder {

    private static final long serialVersionUID = 0L;

    // Use NumberRequest.newBuilder() to construct.
    private NumberRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private NumberRequest() {
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
        return new NumberRequest();
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.demo.HelloGrpcProto.internal_static_hello_NumberRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.demo.HelloGrpcProto.internal_static_hello_NumberRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(com.demo.NumberRequest.class, com.demo.NumberRequest.Builder.class);
    }

    public static final int COUNT_FIELD_NUMBER = 1;

    private long count_ = 0L;

    /**
     * <code>int64 count = 1;</code>
     * @return The count.
     */
    @java.lang.Override
    public long getCount() {
        return count_;
    }

    private byte memoizedIsInitialized = -1;

    @java.lang.Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1)
            return true;
        if (isInitialized == 0)
            return false;
        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        if (count_ != 0L) {
            output.writeInt64(1, count_);
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1)
            return size;
        size = 0;
        if (count_ != 0L) {
            size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, count_);
        }
        size += getUnknownFields().getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.demo.NumberRequest)) {
            return super.equals(obj);
        }
        com.demo.NumberRequest other = (com.demo.NumberRequest) obj;
        if (getCount() != other.getCount())
            return false;
        if (!getUnknownFields().equals(other.getUnknownFields()))
            return false;
        return true;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + COUNT_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getCount());
        hash = (29 * hash) + getUnknownFields().hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static com.demo.NumberRequest parseFrom(java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.demo.NumberRequest parseFrom(java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.demo.NumberRequest parseFrom(com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.demo.NumberRequest parseFrom(com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.demo.NumberRequest parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.demo.NumberRequest parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.demo.NumberRequest parseFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.demo.NumberRequest parseFrom(java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.demo.NumberRequest parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.demo.NumberRequest parseDelimitedFrom(java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.demo.NumberRequest parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.demo.NumberRequest parseFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.demo.NumberRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * Protobuf type {@code hello.NumberRequest}
     */
    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements // @@protoc_insertion_point(builder_implements:hello.NumberRequest)
    com.demo.NumberRequestOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.demo.HelloGrpcProto.internal_static_hello_NumberRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.demo.HelloGrpcProto.internal_static_hello_NumberRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(com.demo.NumberRequest.class, com.demo.NumberRequest.Builder.class);
        }

        // Construct using com.demo.NumberRequest.newBuilder()
        private Builder() {
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            bitField0_ = 0;
            count_ = 0L;
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.demo.HelloGrpcProto.internal_static_hello_NumberRequest_descriptor;
        }

        @java.lang.Override
        public com.demo.NumberRequest getDefaultInstanceForType() {
            return com.demo.NumberRequest.getDefaultInstance();
        }

        @java.lang.Override
        public com.demo.NumberRequest build() {
            com.demo.NumberRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public com.demo.NumberRequest buildPartial() {
            com.demo.NumberRequest result = new com.demo.NumberRequest(this);
            if (bitField0_ != 0) {
                buildPartial0(result);
            }
            onBuilt();
            return result;
        }

        private void buildPartial0(com.demo.NumberRequest result) {
            int from_bitField0_ = bitField0_;
            if (((from_bitField0_ & 0x00000001) != 0)) {
                result.count_ = count_;
            }
        }

        @java.lang.Override
        public Builder clone() {
            return super.clone();
        }

        @java.lang.Override
        public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
            return super.setField(field, value);
        }

        @java.lang.Override
        public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @java.lang.Override
        public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @java.lang.Override
        public Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @java.lang.Override
        public Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof com.demo.NumberRequest) {
                return mergeFrom((com.demo.NumberRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.demo.NumberRequest other) {
            if (other == com.demo.NumberRequest.getDefaultInstance())
                return this;
            if (other.getCount() != 0L) {
                setCount(other.getCount());
            }
            this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @java.lang.Override
        public final boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch(tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            {
                                count_ = input.readInt64();
                                bitField0_ |= 0x00000001;
                                break;
                            }
                        // case 8
                        default:
                            {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    // was an endgroup tag
                                    done = true;
                                }
                                break;
                            }
                    }
                    // switch (tag)
                }
                // while (!done)
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            } finally {
                onChanged();
            }
            // finally
            return this;
        }

        private int bitField0_;

        private long count_;

        /**
         * <code>int64 count = 1;</code>
         * @return The count.
         */
        @java.lang.Override
        public long getCount() {
            return count_;
        }

        /**
         * <code>int64 count = 1;</code>
         * @param value The count to set.
         * @return This builder for chaining.
         */
        public Builder setCount(long value) {
            count_ = value;
            bitField0_ |= 0x00000001;
            onChanged();
            return this;
        }

        /**
         * <code>int64 count = 1;</code>
         * @return This builder for chaining.
         */
        public Builder clearCount() {
            bitField0_ = (bitField0_ & ~0x00000001);
            count_ = 0L;
            onChanged();
            return this;
        }

        @java.lang.Override
        public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @java.lang.Override
        public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }
        // @@protoc_insertion_point(builder_scope:hello.NumberRequest)
    }

    // @@protoc_insertion_point(class_scope:hello.NumberRequest)
    private static final com.demo.NumberRequest DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new com.demo.NumberRequest();
    }

    public static com.demo.NumberRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<NumberRequest> PARSER = new com.google.protobuf.AbstractParser<NumberRequest>() {

        @java.lang.Override
        public NumberRequest parsePartialFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
            Builder builder = newBuilder();
            try {
                builder.mergeFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());
            } catch (com.google.protobuf.UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(builder.buildPartial());
            }
            return builder.buildPartial();
        }
    };

    public static com.google.protobuf.Parser<NumberRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<NumberRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public com.demo.NumberRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
