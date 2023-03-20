package org.tms.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.tms.boot.config.PathConfig;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Configuration
@RequiredArgsConstructor
public class AppLaunchCounter {

    private final PathConfig pathConfig;


    @Bean
    public void startCounterExist() {
        if (pathConfig.getCreatePath().getName() == null ||
                pathConfig.getCreatePath().getPath() == null ||
                pathConfig.getCreatePath().getPath().isEmpty() ||
                pathConfig.getCreatePath().getName().isEmpty()) {
            System.out.println("the one of param is empty or null");
        } else {
            String pathFolder = pathConfig.getCreatePath().getPath();
            String pathName = pathConfig.getCreatePath().getName();

            Path path = Paths.get(pathFolder + pathName);

            try {
                if (!Files.exists(path)) {
                    Path createFileOnFolder = Files.createFile(path);
                    Files.writeString(createFileOnFolder, "1", StandardOpenOption.WRITE);
                } else {
                    String readCounterLaunch = Files.readString(path);
                    String counterLaunch = String.valueOf(Integer.parseInt(readCounterLaunch) + 1);
                    Files.writeString(path, counterLaunch, StandardOpenOption.WRITE);
                }
            } catch (NoSuchFileException fileException) {
                throw new RuntimeException("Attention!!! : " + fileException);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }

    }
}
