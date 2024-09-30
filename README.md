# SQS Producer and Consumer

Este projeto contém duas classes Java que demonstram como usar o Amazon SQS (Simple Queue Service) com LocalStack para simular a interação com filas SQS.

## Estrutura do Projeto

- **SqsProducer**: Classe responsável por enviar mensagens para a fila SQS.
- **SqsConsumer**: Classe responsável por receber e processar mensagens da fila SQS.

## SqsProducer

- **Objetivo**: Enviar uma mensagem de teste para a fila SQS.
- **Endpoint**: Configurado para `http://localhost:4566`.
- **Uso**:
  - Cria um cliente SQS.
  - Envia uma mensagem "Olá, esta é uma mensagem de teste!".
  - Fecha o cliente após o envio.

## SqsConsumer

- **Objetivo**: Receber mensagens da fila SQS e excluí-las após o processamento.
- **Endpoint**: Configurado para `http://localhost:4566`.
- **Uso**:
  - Cria um cliente SQS.
  - Recebe até 5 mensagens com um tempo de espera de 10 segundos (long polling).
  - Exibe o conteúdo da mensagem recebida e a exclui da fila.
  - Fecha o cliente após o processamento.

## Pré-requisitos

- **Docker**: Necessário para iniciar o LocalStack.
- LocalStack em execução.
- AWS SDK para Java.
- Java 11 ou superior.

## Como Usar

1. **Inicie o LocalStack** com Docker:
   ```bash
   docker run --rm -p 4566:4566 localstack/localstack
2. **Crie a fila SQS**:
```aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name TestFila```
3. **Agora execute o SqsProducer**;
4. **E depois o SqsConsumer**

Por fim o resultado esperando após executar o ``producer`` é esse:
![37badf63-91ee-4879-9d7e-08f6dadfdeb8](https://github.com/user-attachments/assets/fd221a80-670c-41e2-91b8-f6f2b35a4456)
E após executar o ``consumer``é esse:
![575de4b7-686b-496d-b852-ae6db27912b1](https://github.com/user-attachments/assets/0e78a199-a356-42f4-94b3-98defa35f5e9)
