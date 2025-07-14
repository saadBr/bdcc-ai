package ma.enset.bdccai.controllers;

import ma.enset.bdccai.outputs.CIN;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MultiModelController {
    private ChatClient chatClient;
    @Value("classpath:/images/CIN2.png")
    private Resource image;
    @Value("classpath:/images/image.png")
    private Resource image2;
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

    @GetMapping("/askImage")
    public String askImage(String question){
        return chatClient.prompt()
                .system("answer the question about the handwritten image")
                .user(u->
                        u.text(question)
                                .media(MediaType.IMAGE_PNG,image2)
                ).call()
                .content();

    }

    @PostMapping(value = "/askImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String askImage(@RequestParam(name = "image") MultipartFile image, String question) throws IOException {
        byte[] bytes = image.getBytes();
        return chatClient.prompt()
                .system("answer the question about the attached image")
                .user(u->
                        u.text(question)
                                .media(MediaType.IMAGE_PNG,new ByteArrayResource(bytes))
                ).call()
                .content();

    }
}
