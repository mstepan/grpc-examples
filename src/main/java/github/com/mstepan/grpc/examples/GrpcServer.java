package github.com.mstepan.grpc.examples;

import github.com.mstepan.grpc.examples.service.HelloServiceImpl;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import java.io.IOException;

/**
 * As a reference use
 * https://github.com/grpc/grpc-java/blob/master/examples/example-jwt-auth/src/main/java/io/grpc/examples/jwtauth/AuthServer.java
 */
final class GrpcServer {

    // private static final Logger logger = Logger.getLogger(AuthServer.class.getName());

    private Server server;
    private final int port;

    public GrpcServer(int port) {
        this.port = port;
    }

    void start() throws IOException {
        server =
                Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                        .addService(new HelloServiceImpl())
                        .build()
                        .start();

        System.out.printf("Server started, listening at part %d%n", port);

        Runtime.getRuntime()
                .addShutdownHook(
                        new Thread(
                                () -> {
                                    // Use stderr here since the logger may have been reset by its
                                    // JVM shutdown hook.
                                    System.err.println(
                                            "*** shutting down gRPC server since JVM is shutting down");
                                    GrpcServer.this.stop();
                                    System.err.println("*** server shut down");
                                }));
    }

    void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /** Await termination on the main thread since the grpc library uses daemon threads. */
    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
