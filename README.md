# Polytomic Java Library

[![Maven Central](https://img.shields.io/maven-central/v/com.polytomic/polytomic-java)](https://central.sonatype.com/artifact/com.polytomic/polytomic-java)

The Polytomic Java SDK provides convenient access to the Polytomic API from Java or Kotlin.

## Documentation

API reference documentation is available [here](https://docs.polytomic.com/reference).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.polytomic:polytomic-java:0.0.1-beta0'
}
```

### Maven
Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.polytomic</groupId>
    <artifactId>polytomic-java</artifactId>
    <version>0.0.1-beta0</version>
</dependency>
```

## Usage
```java
import com.polytomic.api.Polytomic;

Polytomic polytomic = Polytomic.builder()
  .token("YOUR_API_KEY")
  .build();
  
var bulkSync = polytomic.bulkSync().get("bulk-sync-id")

System.out.printlin("Received response! " + bulkSync);
```

## Handling Errors
When the API returns a non-success status code (4xx or 5xx response),
a subclass of [ApiError](./src/main/java/com/polytomic/api/core/ApiError.java)
will be thrown:

```java
import com.polytomic.api.core.ApiError;

try {
  polytomic.bulkSync().executions().list(/* ... */);
} catch (ApiError error) {
  System.out.println(error.getBody());
  System.out.println(error.getStatusCode());
}
```

## Additional Properties
Sometimes, the server response may include additional properties that are not
available in the SDK. Use the `getAdditionalProperties()` method to access them.

```java
Object value = entity.getAdditionalProperties().get("new_prop");
```

## Request Options
Every method in the SDK takes an optional `RequestOptions` class where 
you can specify overrides for that specific endpoint call.  

```java
import com.polytomic.api.core.RequestOptions;

try {
  polytomic.bulkSync().get("...", RequestOptions.builder()
    .apiKey("....") // override the API key for this endpoint call
    .build());
```

## Staged Builders
All models in the SDK use the staged builder the pattern. In particular, 
the `build` method for a model will not be accessible until all required
properties are specified. 

```java
import comp.polytomic.api.types.BulkSchedule;

BulkSchedule.builder()
  .build() // build method inacessible


BulkSchedule.builder()
  .frequency("12h")
  .build() // build methd accessible after specifying frequency
```

## Version pinning
We recommend pinning the package
version to a specific version in your build.gradle file. This way, you can 
install the same version each time without breaking changes unless you are
intentionally looking for the latest version.

## Contributing
While we value open-source contributions to this SDK, this library 
is generated programmatically. Additions made directly to this library 
would have to be moved over to our generation code, otherwise they would 
be overwritten upon the next generated release. Feel free to open a PR as a
proof of concept, but know that we will not be able to merge it as-is. 
We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
