# BDCC AI SpringBoot Application

This is a Spring Boot project integrating the experimental [Spring AI](https://github.com/spring-projects/spring-ai) framework to build a multimodal application using AI agents. It showcases capabilities such as:

- Natural language chat interactions via AI agents.
- Image-to-text processing.
- AI-generated image rendering from prompts.
- Multi-model endpoint support.

## 📁 Project Structure

```
main/
├── java/ma/enset/bdccai/
│   ├── BdccAiApplication.java         # Main Spring Boot application
│   ├── controllers/                   # Controllers for REST endpoints
│   ├── outputs/                       # POJOs for structured outputs
├── resources/
│   ├── application.properties         # Spring config
│   ├── images/                        # Sample images for testing
```

## 🚀 Features

- **/chat** – Interact with an AI agent using natural language.
- **/streaming** – Stream chat responses.
- **/structured** – Return structured JSON responses for predefined formats like movies or CIN (ID card).
- **/image/generate** – Generate an image from a text prompt.
- **/describe** – Return a text description of a provided image using a multimodal AI model.

## 🔧 Setup Instructions

### Prerequisites

- Java 21
- Maven
- Spring Boot 3.x+
- Access to a supported AI model provider (e.g., OpenAI, Hugging Face, or local LLMs)
- Internet connection for model API calls (unless local inference is used)

### Installation

```bash
git clone https://github.com/yourusername/bdcc-ai-springboot.git
cd bdcc-ai-springboot
```

### Configuration

Update the `application.properties` file with your Spring AI provider settings:

```properties
spring.ai.openai.api-key=your_openai_key
# or any other provider you’re using
```

### Running the Application

```bash
mvn spring-boot:run
```

### API Access

Once running, access endpoints via:

```
GET http://localhost:8899/chat
GET http://localhost:8899/describe
POST http://localhost:8899/image/generate
```

Use tools like Swagger or Postman to test these endpoints.

## 📷 Sample Images

Sample images are available under `resources/images/` and used to test the `/describe` endpoint.

## 📦 Dependencies

- Spring Boot
- Spring AI (Spring Experimental)
- OpenAI/HuggingFace client libraries

## 🧠 Authors

Saad EL MABROUK