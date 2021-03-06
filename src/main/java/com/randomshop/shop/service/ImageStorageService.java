package com.randomshop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("path")
public class ImageStorageService{

    @Setter
    private String root;
    @Setter
    private String site;
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        if(!Files.isDirectory(Paths.get(root))){
            try {
                Files.createDirectory(Paths.get(root));
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
        if(!Files.isDirectory(Paths.get(site))){
            try {
                Files.createDirectory(Paths.get(site));
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
    }

    public String save(MultipartFile file) {
        String imgName = (getRandomString(6) + LocalDateTime.now() + "_" + file.getOriginalFilename()).replace(":", "_");
        try {
            Files.copy(file.getInputStream(), Paths.get(this.root).resolve(imgName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return imgName;
    }

    public String saveSiteImg(MultipartFile file) {
        String imgName = (getRandomString(6) + LocalDateTime.now() + "_" + file.getOriginalFilename()).replace(":", "_");
        try {
            Files.copy(file.getInputStream(), Paths.get(this.site).resolve(imgName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return imgName;
    }

    public String saveSiteLogo(MultipartFile file) {
        String ori = file.getOriginalFilename();
        assert ori != null;
        String imgName = getRandomString(3) + LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + "logo".concat(ori.substring(ori.lastIndexOf(".")));
        try {
            deleteLogo();
            Files.copy(file.getInputStream(), Paths.get(this.site).resolve(imgName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return imgName;
    }

    public void deleteFile(String fileName){
        try {
            Files.delete(Paths.get(this.root).resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Could not delete the file. Error: " + e.getMessage());
        }
    }

    public void deleteLogo() throws IOException {
        Files.list(Paths.get(this.site)).filter(p -> p.toString().contains("logo")).forEach((p) ->{
            try {
                Files.deleteIfExists(p);
            }catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private String getRandomString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
