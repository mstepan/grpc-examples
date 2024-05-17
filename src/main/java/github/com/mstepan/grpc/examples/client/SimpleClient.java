package github.com.mstepan.grpc.examples.client;

import github.com.mstepan.grpc.examples.AppMain;
import github.com.mstepan.grpc.examples.service.hello.HelloServiceGrpc;
import github.com.mstepan.grpc.examples.service.hello.HelloServiceOuterClass;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

/**
 * As a reference use
 * https://github.com/grpc/grpc-java/blob/master/examples/example-jwt-auth/src/main/java/io/grpc/examples/jwtauth/AuthClient.java
 */
public class SimpleClient {

    public static void main(String[] args) {
        ManagedChannel channel =
                Grpc.newChannelBuilderForAddress(
                                "localhost", AppMain.PORT, InsecureChannelCredentials.create())
                        .build();

        HelloServiceGrpc.HelloServiceBlockingStub blockingStub =
                HelloServiceGrpc.newBlockingStub(channel);

        HelloServiceOuterClass.HelloRequest request =
                HelloServiceOuterClass.HelloRequest.newBuilder().setName("Zorro").build();

        HelloServiceOuterClass.HelloResponse response = blockingStub.sayHello(request);

        System.out.printf("Client response: %s%n", response.getMessage());
    }
}
