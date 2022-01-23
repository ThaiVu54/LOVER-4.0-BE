package com.example.lover.service.image;

import com.example.lover.model.account.Image;
import com.example.lover.model.account.Provider;
import com.example.lover.service.IServiceGeneral;

public interface IImageService extends IServiceGeneral<Image> {
    Iterable<Image> findAllByProvider (Provider provider);
}
