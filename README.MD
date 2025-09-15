# Debezium CDC Demo (Spring Boot + Kafka + Postgres)

Пример проекта Change Data Capture (CDC) с использованием Spring Boot, Kafka и Debezium.

## Требования

- Docker & Docker Compose
- Java 17+
- Gradle 8+

## Запуск

1. Запустите инфраструктуру:
   ```bash
   docker-compose up -d
   ```

2.Зарегистрируйте Debezium коннектор:

```bash
curl -X POST http://localhost:8083/connectors -H "Content-Type: application/json" --data @connector/debezium-connector.json
   ```

3.Запустите сервисы:
```bash
cd user-service && ./gradlew bootRun
cd consumer-service && ./gradlew bootRun
```

4.Тестируйте:
```bash
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"Daniyal","email":"daniyal@example.com"}'
```

