# todo-back

## Summary

BE part of **TODO: task tracker**

## Run application

	mvn spring-boot:run 
        -Dspring.profiles.active=[dev/prod]
        -Dspring-boot.run.jvmArguments='-Dport=8090'
        
    where: 
        -Dport=8090 - server port start
            default: 
                local: 8080
                dev: 8080
                prod: 8080

## Profiles

    'default' - default run local app + h2 in-memory db
    dev - TODO: run local app + + h2 in-memory db (probably will be changed)
    prod - TODO: run local app + + h2 in-memory db (probably will be changed)

    P.S: without defining profiles will be chosen default one