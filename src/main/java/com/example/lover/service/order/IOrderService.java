package com.example.lover.service.order;

import com.example.lover.model.account.Order;
import com.example.lover.model.account.Provider;
import com.example.lover.model.account.User;
import com.example.lover.service.IServiceGeneral;

import java.util.List;

public interface IOrderService extends IServiceGeneral<Order> {
    List<Order> listAccomplished();

    List<Order> listWait();

    List<Order> listReceived();

    List<Order> findAllByProvider(Provider provider);

    List<Order> findAllByUser(User user);
}
