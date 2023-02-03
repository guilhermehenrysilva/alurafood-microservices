package com.myorg;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.*;
import software.amazon.awscdk.services.rds.*;
import software.amazon.awscdk.services.ssm.CfnParameter;
import software.constructs.Construct;

import java.util.Collections;

// RDS - Relational Database Service
public class AwsRdsStack extends Stack {

    public AwsRdsStack(final Construct scope, final String id, final Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public AwsRdsStack(final Construct scope, final String id, final StackProps props, final Vpc vpc) {
        super(scope, id, props);

        // Parametro - Criação de parametro para inserção da senha do database na hora do deploy
        CfnParameter senha = CfnParameter.Builder.create (this, "senha")
        .type("String")
                .description("Senha do database pedidos-ms")
                .build();

        // Security Group
        ISecurityGroup iSecurityGroup = SecurityGroup.fromSecurityGroupId(this, id, vpc.getVpcDefaultSecurityGroup()); // Pega as default configs da nossa Vpc
        iSecurityGroup.addIngressRule(Peer.anyIpv4(), Port.tcp(3306)); // Qualquer IP de serviço que estiver dentro da nossa Vpc podera acessar o DB na porta 3306

        // Database Instance - Criando o BD
        DatabaseInstance database = DatabaseInstance.Builder
                .create(this, "Rds-pedidos")
                .instanceIdentifier("alura-aws-pedido-db")
                .engine(DatabaseInstanceEngine.mysql(MySqlInstanceEngineProps.builder()
                        .version(MysqlEngineVersion.VER_8_0)
                        .build()))
                .vpc(vpc)
                .credentials(Credentials.fromUsername("admin",
                CredentialsFromUsernameOptions.builder()
                        .password(SecretValue.unsafePlainText(senha.getValue()))
                        .build()))
                .instanceType(InstanceType.of(InstanceClass.BURSTABLE2, InstanceSize.MICRO))
                .multiAz(false)
                .allocatedStorage(10)
                .securityGroups(Collections.singletonList(iSecurityGroup))
                .vpcSubnets(SubnetSelection.builder()
                        .subnets(vpc.getPrivateSubnets())
                        .build())
                .build();

        // Disponibilizando Valores para outras aplicações (Valores para conexão com o BD: endereço, user, senha)
        CfnOutput.Builder.create(this, "pedidos-db-endpoint")
                .exportName("pedidos-db-endpoint")
                .value(database.getDbInstanceEndpointAddress())
                .build();

        CfnOutput.Builder.create(this, "pedidos-db-senha")
                .exportName("pedidos-db-senha")
                .value(senha.getValue())
                .build();
    }

}
