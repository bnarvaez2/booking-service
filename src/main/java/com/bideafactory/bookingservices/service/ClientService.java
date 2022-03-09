package com.bideafactory.bookingservices.service;

import java.util.List;

import com.bideafactory.bookingservices.entity.Client;
import com.bideafactory.bookingservices.model.request.DiscountRequest;
import com.bideafactory.bookingservices.model.response.DiscountResponse;
import com.bideafactory.bookingservices.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getUserById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client getUserByCode(String userCode) {
        return clientRepository.findById(userCode);
    }

    public String createUser(Client client) {
        client.validateUserProperties();
        Client newClient = clientRepository.save(client);
        return newClient.getId();
    }

    public DiscountResponse newDiscount(DiscountRequest data) {
        DiscountResponse discountResponse = restTemplate.postForObject(
                "https://622271e2666291106a26a17c.mockapi.io/discount/v1/new", data,
                DiscountResponse.class);
        return discountResponse;
    }

}
