package com.garage.maneger.maneger.modules.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public byte[] getImageById(Long id) {
        Optional<Image> imageOpt = imageRepository.findById(id);
        return imageOpt.map(Image::getDados).orElse(null);
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image updateImage(Long id, Image novaImage) {
        Optional<Image> imageOpt = imageRepository.findById(id);
        if (imageOpt.isPresent()) {
            Image image = imageOpt.get();
            image.setDados(novaImage.getDados());
            return imageRepository.save(image);
        }
        return null;
    }
}
