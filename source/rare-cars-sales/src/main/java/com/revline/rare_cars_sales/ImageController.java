package com.revline.rare_cars_sales;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;

@RestController
public class ImageController {

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String filename) {

        File fileSystemFile = new File("src/main/resources/static/images/" + filename);

        if (fileSystemFile.exists() && fileSystemFile.canRead()) {
            Resource resource = new FileSystemResource(fileSystemFile);
            MediaType mediaType = MediaType.IMAGE_JPEG;
            if (filename.toLowerCase().endsWith(".png")) mediaType = MediaType.IMAGE_PNG;

            return ResponseEntity.ok().contentType(mediaType).body(resource);
        }

        return ResponseEntity.notFound().build();
    }
}
