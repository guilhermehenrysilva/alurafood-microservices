package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

//Doc: https://docs.aws.amazon.com/pt_br/cdk/v2/guide/ecs_example.html
public class AwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        //Stacks
        AwsVpcStack vpcStack = new AwsVpcStack(app, "Vpc");

        AwsClusterStack clusterStack = new AwsClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack); //priority - O Vpc precisa ser criado primeiro em relação ao cluster

        AwsRdsStack rdsStack = new AwsRdsStack(app, "Rds", vpcStack.getVpc());
        rdsStack.addDependency(vpcStack);

        AwsServiceStack serviceStack = new AwsServiceStack(app, "Service", clusterStack.getCluster());
        serviceStack.addDependency(clusterStack);

        app.synth();
    }
}

