package github.com.mstepan.grpc.examples.service;

import github.com.mstepan.grpc.examples.service.hello.HelloServiceGrpc;
import github.com.mstepan.grpc.examples.service.hello.HelloServiceOuterClass;
import io.grpc.stub.StreamObserver;

public final class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(
            HelloServiceOuterClass.HelloRequest request,
            StreamObserver<HelloServiceOuterClass.HelloResponse> responseObserver) {

        HelloServiceOuterClass.HelloResponse response =
                HelloServiceOuterClass.HelloResponse.newBuilder()
                        .setMessage("Hello from %s".formatted(request.getName()))
                        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
