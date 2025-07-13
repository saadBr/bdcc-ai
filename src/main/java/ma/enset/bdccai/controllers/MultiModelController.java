package ma.enset.bdccai.controllers;

import ma.enset.bdccai.outputs.CIN;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiModelController {
    private ChatClient chatClient;
    @Value("classpath:/images/CIN2.png")
    private Resource image;
    public MultiModelController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/describe")
    public CIN describeImage(){
        return chatClient.prompt()
                .system("give me a description for the attached image")
                .user(u->
                        u.text("descirbe the image")
                                .media(MediaType.IMAGE_PNG,image)
                ).call()
                .entity(CIN.class);

    }
}
