package com.example.lover.service.image;

import com.example.lover.model.account.Image;
import com.example.lover.model.account.Provider;
import com.example.lover.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ImageService implements IImageService{

    @Autowired private IImageRepository imageRepository;
    @Override
    public Page<Image> pageFindAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
imageRepository.deleteById(id);
    }

    @Override
    public Iterable<Image> findAllByProvider(Provider provider) {
        return imageRepository.findAllByProvider(provider);
    }
}
