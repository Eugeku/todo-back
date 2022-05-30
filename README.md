# todo-back

## Summary

BE part of **TODO: task tracker**

## Run application

	mvn spring-boot:run 
        -Dspring.profiles.active=[dev/prod]
        -Dspring-boot.run.jvmArguments='-Dport=8090 -Ddb=jdbc:h2:mem:testdb -Ddbuser=sa -Ddbpassword=password'
        
    where: 
        -Dport=8090 - server port start
            default: 
                local: 8080
                dev: 8080
                prod: 8080

        -Ddb=jdbc:h2:mem:testdb - datasource url
            default: 
                local: jdbc:h2:mem:testdb
                dev: jdbc:h2:mem:testdb
                prod: jdbc:h2:mem:testdb

        -Ddbuser=sa - db user
            default: 
                local: sa
                dev: sa
                prod: sa

        -Ddbpassword=password - db password
            default: 
                local:
                dev:
                prod:

## Profiles

    'default' - default run local app + h2 in-memory db
    dev - TODO: run local app + + h2 in-memory db (probably will be changed)
    prod - TODO: run local app + + h2 in-memory db (probably will be changed)

    P.S: without defining profiles will be chosen default one