package text;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: machine.proto")
public final class TextGrpc {

  private TextGrpc() {}

  public static final String SERVICE_NAME = "forum.Text";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<text.Chunk,
      text.Acknowledge> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "upload",
      requestType = text.Chunk.class,
      responseType = text.Acknowledge.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<text.Chunk,
      text.Acknowledge> getUploadMethod() {
    io.grpc.MethodDescriptor<text.Chunk, text.Acknowledge> getUploadMethod;
    if ((getUploadMethod = TextGrpc.getUploadMethod) == null) {
      synchronized (TextGrpc.class) {
        if ((getUploadMethod = TextGrpc.getUploadMethod) == null) {
          TextGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<text.Chunk, text.Acknowledge>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  text.Chunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  text.Acknowledge.getDefaultInstance()))
              .setSchemaDescriptor(new TextMethodDescriptorSupplier("upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<text.Acknowledge,
      text.Chunk> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "download",
      requestType = text.Acknowledge.class,
      responseType = text.Chunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<text.Acknowledge,
      text.Chunk> getDownloadMethod() {
    io.grpc.MethodDescriptor<text.Acknowledge, text.Chunk> getDownloadMethod;
    if ((getDownloadMethod = TextGrpc.getDownloadMethod) == null) {
      synchronized (TextGrpc.class) {
        if ((getDownloadMethod = TextGrpc.getDownloadMethod) == null) {
          TextGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<text.Acknowledge, text.Chunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  text.Acknowledge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  text.Chunk.getDefaultInstance()))
              .setSchemaDescriptor(new TextMethodDescriptorSupplier("download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TextStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TextStub>() {
        @java.lang.Override
        public TextStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TextStub(channel, callOptions);
        }
      };
    return TextStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TextBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TextBlockingStub>() {
        @java.lang.Override
        public TextBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TextBlockingStub(channel, callOptions);
        }
      };
    return TextBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TextFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TextFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TextFutureStub>() {
        @java.lang.Override
        public TextFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TextFutureStub(channel, callOptions);
        }
      };
    return TextFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TextImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<text.Chunk> upload(
        io.grpc.stub.StreamObserver<text.Acknowledge> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<text.Acknowledge> download(
        io.grpc.stub.StreamObserver<text.Chunk> responseObserver) {
      return asyncUnimplementedStreamingCall(getDownloadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                text.Chunk,
                text.Acknowledge>(
                  this, METHODID_UPLOAD)))
          .addMethod(
            getDownloadMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                text.Acknowledge,
                text.Chunk>(
                  this, METHODID_DOWNLOAD)))
          .build();
    }
  }

  /**
   */
  public static final class TextStub extends io.grpc.stub.AbstractAsyncStub<TextStub> {
    private TextStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<text.Chunk> upload(
        io.grpc.stub.StreamObserver<text.Acknowledge> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<text.Acknowledge> download(
        io.grpc.stub.StreamObserver<text.Chunk> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TextBlockingStub extends io.grpc.stub.AbstractBlockingStub<TextBlockingStub> {
    private TextBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TextFutureStub extends io.grpc.stub.AbstractFutureStub<TextFutureStub> {
    private TextFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TextFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_UPLOAD = 0;
  private static final int METHODID_DOWNLOAD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TextImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TextImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.upload(
              (io.grpc.stub.StreamObserver<text.Acknowledge>) responseObserver);
        case METHODID_DOWNLOAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.download(
              (io.grpc.stub.StreamObserver<text.Chunk>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TextBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TextBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return text.Machine.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Text");
    }
  }

  private static final class TextFileDescriptorSupplier
      extends TextBaseDescriptorSupplier {
    TextFileDescriptorSupplier() {}
  }

  private static final class TextMethodDescriptorSupplier
      extends TextBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TextMethodDescriptorSupplier(String methodName) {
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
      synchronized (TextGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TextFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .addMethod(getDownloadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
