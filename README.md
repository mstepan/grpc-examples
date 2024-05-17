# grpc examples using maven and java 21

Uses the following:
* `Java 21` early access
* maven wrapper with `maven 3.6.3`

## Build & Run locally

* Build project using maven wrapper first
```bash
./mvnw clean package -DskipTests
```

## Unit tests.

For unit tests execute the following command
```bash
./mvnw clean test
```

## Code Style

Code formatted using [spotless-maven-plugin](https://github.com/diffplug/spotless/tree/master/plugin-maven ). The `spotless:apply` called just before the compilation 
phase to format code properly.

## References

The main repo for reference is [https://github.com/grpc/grpc-java](https://github.com/grpc/grpc-java/blob/master/examples/pom.xml)



