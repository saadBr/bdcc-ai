package ma.enset.bdccai.controllers;

import ma.enset.bdccai.outputs.Movie;
import ma.enset.bdccai.outputs.MovieList;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AIAgentStructuredController {
    private ChatClient chatClient;
    public AIAgentStructuredController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
    @GetMapping("/askAgent")
    public MovieList askLLM(String query) {
        String systemMessage = """
                You are a specialist in Cinema
                Answer user question about this
               
                """;
        return chatClient.prompt()
                .system(systemMessage)
                .user(query)
                .call()
                .entity(MovieList.class);
    }
}
