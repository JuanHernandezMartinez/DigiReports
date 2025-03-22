This project uses Quarkus, the Supersonic Subatomic Java Framework.
## Running the application in dev mode
Aplicacion en modo de desarrollo
```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Dev UI en la ruta <http://localhost:8080/q/dev/>.

## Packaging and running the application
Empaquetar la aplicacion, necesita ejecutarse dentro del directorio target
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.
The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

Empaquetado de la aplicacion para ejecutar directamente con el puro jar
```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```
The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## GENERATE PUBLICKKEY
openssl genrsa -out rsaPrivateKey.pem 2048
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem

## GENERATE PRIVATEKEY
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem

## GENERATE A TOKEN MANUALLY
$ ./mvnw exec:java -Dexec.mainClass=org.acme.security.jwt.GenerateToken -Dexec.classpathScope=test -Dsmallrye.jwt.sign.key.location=privateKey.pem