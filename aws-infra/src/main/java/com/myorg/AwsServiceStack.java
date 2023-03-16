package com.myorg;

import software.amazon.awscdk.Fn;
import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecs.AwsLogDriverProps;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.LogDriver;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.amazon.awscdk.services.logs.LogGroup;
import software.constructs.Construct;

import java.util.HashMap;
import java.util.Map;

// Service
public class AwsServiceStack extends Stack {
    public AwsServiceStack(final Construct scope, final String id, final Cluster cluster) {
        this(scope, id, null, cluster);
    }

    public AwsServiceStack(final Construct scope, final String id, final StackProps props, final Cluster cluster) {
        super(scope, id, props);

        // Variaveis de ambiente do banco mysql (AwsRdsStack)
        Map<String, String> autenticacao = new HashMap<>();
        autenticacao.put("SPRING_DATASOURCE_URL", "jdbc:mysql://" + Fn.importValue("pedidos-db-endpoint") +
                ":3306/alurafood-pedidos?createDatabaseIfNotExist=true");
        autenticacao.put("SPRING_DATASOURCE_USERNAME", "admin");
        autenticacao.put("SPRING_DATASOURCE_PASSWORD", Fn.importValue("pedidos-db-senha"));

        // Create a load-balanced Fargate service and make it public
        ApplicationLoadBalancedFargateService.Builder.create(this, "AluraService")
                .serviceName("alura-service-ecs-sample")
                .cluster(cluster)           // Required
                .cpu(512)                   // Default is 256 - CPU Memory
                .desiredCount(1)            // Default is 1 - Instancias a serem levantadas da img
                .listenerPort(8080)         // Porta de escuta da aplicacao
                .assignPublicIp(true)       // IP Publico
                .taskImageOptions(
                        ApplicationLoadBalancedTaskImageOptions.builder()
                                .image(ContainerImage.fromRegistry("guilhermehenrysilva/pedidos-ms"))
                                .containerPort(8080)
                                .containerName("app_ola")
                                .environment(autenticacao)
                                .logDriver(LogDriver.awsLogs(AwsLogDriverProps.builder() //Log Config. O Aws Log Insights permite a criação de alarmes customizados. Ex: Caso encontre a palavra "exception" dispare um email...
                                .logGroup(LogGroup.Builder.create(this, "PedidosMsLogGroup")
                                        .logGroupName("PedidosMsLog")
                                        .removalPolicy(RemovalPolicy.DESTROY)
                                        .build())
                                .streamPrefix("PedidosMS")
                                .build()))

                                .build())
                .memoryLimitMiB(1024)       // Default is 512
                .publicLoadBalancer(true)   // Default is false
                .build();
    }
}
