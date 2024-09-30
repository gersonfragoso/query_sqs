package org.example;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsProducer {

    // Substitua pelos valores reais
    private static final String QUEUE_URL = "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/TestFila";

    public static void main(String[] args) {
        // Cria o cliente SQS
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1) // Substitua pela sua região
                .build();

        // Envia uma mensagem
        sendMessage(sqsClient, "Olá, esta é uma mensagem de teste!");

        // Fecha o cliente
        sqsClient.close();
    }

    public static void sendMessage(SqsClient sqsClient, String message) {
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .messageBody(message)
                .delaySeconds(0)
                .build();

        sqsClient.sendMessage(sendMsgRequest);
        System.out.println("Mensagem enviada: " + message);
    }
}
