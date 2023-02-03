# Welcome to your CDK Java project!

This is a blank project for CDK development with Java.

The `cdk.json` file tells the CDK Toolkit how to execute your app.

It is a [Maven](https://maven.apache.org/) based project, so you can open this project with any Maven compatible Java IDE to build and run tests.

## Useful commands

 * `mvn package`     compile and run tests
 * `cdk ls`          list all stacks in the app
 * `cdk synth`       emits the synthesized CloudFormation template
 * `cdk list`        show stacks
 * `cdk deploy`      deploy this stack to your default AWS account/region
 * `cdk diff`        compare deployed stack with current state
 * `cdk docs`        open CDK documentation

Enjoy!

---
### Config
- Necessario rodar o comando na raiz do projeto aws-infra (Apenas uma vez):
```
cdk bootstrap aws://ACCOUNT-NUMBER/REGION Ex: cdk bootstrap aws://701603830239/us-east-1
```
Doc: https://docs.aws.amazon.com/cdk/v2/guide/getting_started.html

- Realizar deploy do Rds:
```
cdk deploy --parameters Rds:senha=12345678 Rds
```

---
### Anotações
- Cada Stack file representa uma camada de nossa infraestrutura na Cloud:
VPC, Cluster, Service, Task definition e, por último, o Container definition.
Doc: https://docs.aws.amazon.com/pt_br/cdk/v2/guide/ecs_example.html


