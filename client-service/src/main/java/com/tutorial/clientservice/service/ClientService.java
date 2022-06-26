package com.tutorial.clientservice.service;

import com.tutorial.clientservice.entity.Client;
import com.tutorial.clientservice.feignclients.LoanFeignClient;
import com.tutorial.clientservice.model.Loan;
import com.tutorial.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoanFeignClient loanFeignClient;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client) {
        Client clientNew = clientRepository.save(client);
        return clientNew;
    }

    public Loan saveLoan(int clientId, Loan loan) {
        loan.setClientId(clientId);
        Loan loanNew = loanFeignClient.save(loan);
        return loanNew;
    }
}
