package app.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: multiplication.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MultiplicationGrpc {

  private MultiplicationGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Multiplication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<app.grpc.MultiplicationProto.MultiplicationRequest,
      app.grpc.MultiplicationProto.MultiplicationResponse> getGetMultiplicationTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMultiplicationTable",
      requestType = app.grpc.MultiplicationProto.MultiplicationRequest.class,
      responseType = app.grpc.MultiplicationProto.MultiplicationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<app.grpc.MultiplicationProto.MultiplicationRequest,
      app.grpc.MultiplicationProto.MultiplicationResponse> getGetMultiplicationTableMethod() {
    io.grpc.MethodDescriptor<app.grpc.MultiplicationProto.MultiplicationRequest, app.grpc.MultiplicationProto.MultiplicationResponse> getGetMultiplicationTableMethod;
    if ((getGetMultiplicationTableMethod = MultiplicationGrpc.getGetMultiplicationTableMethod) == null) {
      synchronized (MultiplicationGrpc.class) {
        if ((getGetMultiplicationTableMethod = MultiplicationGrpc.getGetMultiplicationTableMethod) == null) {
          MultiplicationGrpc.getGetMultiplicationTableMethod = getGetMultiplicationTableMethod =
              io.grpc.MethodDescriptor.<app.grpc.MultiplicationProto.MultiplicationRequest, app.grpc.MultiplicationProto.MultiplicationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMultiplicationTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  app.grpc.MultiplicationProto.MultiplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  app.grpc.MultiplicationProto.MultiplicationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MultiplicationMethodDescriptorSupplier("getMultiplicationTable"))
              .build();
        }
      }
    }
    return getGetMultiplicationTableMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MultiplicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiplicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiplicationStub>() {
        @java.lang.Override
        public MultiplicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiplicationStub(channel, callOptions);
        }
      };
    return MultiplicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MultiplicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiplicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiplicationBlockingStub>() {
        @java.lang.Override
        public MultiplicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiplicationBlockingStub(channel, callOptions);
        }
      };
    return MultiplicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MultiplicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MultiplicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MultiplicationFutureStub>() {
        @java.lang.Override
        public MultiplicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MultiplicationFutureStub(channel, callOptions);
        }
      };
    return MultiplicationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Le client envoie UN objet (Request), le serveur renvoie un FLUX (Stream)
     * </pre>
     */
    default void getMultiplicationTable(app.grpc.MultiplicationProto.MultiplicationRequest request,
        io.grpc.stub.StreamObserver<app.grpc.MultiplicationProto.MultiplicationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMultiplicationTableMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Multiplication.
   */
  public static abstract class MultiplicationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MultiplicationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Multiplication.
   */
  public static final class MultiplicationStub
      extends io.grpc.stub.AbstractAsyncStub<MultiplicationStub> {
    private MultiplicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiplicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiplicationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Le client envoie UN objet (Request), le serveur renvoie un FLUX (Stream)
     * </pre>
     */
    public void getMultiplicationTable(app.grpc.MultiplicationProto.MultiplicationRequest request,
        io.grpc.stub.StreamObserver<app.grpc.MultiplicationProto.MultiplicationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMultiplicationTableMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Multiplication.
   */
  public static final class MultiplicationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MultiplicationBlockingStub> {
    private MultiplicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiplicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiplicationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Le client envoie UN objet (Request), le serveur renvoie un FLUX (Stream)
     * </pre>
     */
    public java.util.Iterator<app.grpc.MultiplicationProto.MultiplicationResponse> getMultiplicationTable(
        app.grpc.MultiplicationProto.MultiplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMultiplicationTableMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Multiplication.
   */
  public static final class MultiplicationFutureStub
      extends io.grpc.stub.AbstractFutureStub<MultiplicationFutureStub> {
    private MultiplicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MultiplicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MultiplicationFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MULTIPLICATION_TABLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MULTIPLICATION_TABLE:
          serviceImpl.getMultiplicationTable((app.grpc.MultiplicationProto.MultiplicationRequest) request,
              (io.grpc.stub.StreamObserver<app.grpc.MultiplicationProto.MultiplicationResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMultiplicationTableMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              app.grpc.MultiplicationProto.MultiplicationRequest,
              app.grpc.MultiplicationProto.MultiplicationResponse>(
                service, METHODID_GET_MULTIPLICATION_TABLE)))
        .build();
  }

  private static abstract class MultiplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MultiplicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return app.grpc.MultiplicationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Multiplication");
    }
  }

  private static final class MultiplicationFileDescriptorSupplier
      extends MultiplicationBaseDescriptorSupplier {
    MultiplicationFileDescriptorSupplier() {}
  }

  private static final class MultiplicationMethodDescriptorSupplier
      extends MultiplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MultiplicationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MultiplicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MultiplicationFileDescriptorSupplier())
              .addMethod(getGetMultiplicationTableMethod())
              .build();
        }
      }
    }
    return result;
  }
}
