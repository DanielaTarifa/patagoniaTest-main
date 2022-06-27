package com.tutorial.clientservice.controller;

import com.tutorial.clientservice.entity.Client;
import com.tutorial.clientservice.model.Loan;
import com.tutorial.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        if(clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") int id) {
        Client client = clientService.getClientById(id);
        if(client == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(client);
    }

    @PostMapping()//"/addClient"
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client clientNew = clientService.save(client);
        return ResponseEntity.ok(clientNew);
    }

   /* @GetMapping("/loan/{clientId}")
    public ResponseEntity<List<Loan>> getLoan(@PathVariable("clientId") int clientId) {
        Client client = clientService.getClientById(clientId);
        if(client == null)
            return ResponseEntity.notFound().build();
        List<Client> loan = clientService.getLoan(clientId);
        return ResponseEntity.ok(loan);

    } */

    @PostMapping("/saveloan/{clientId}")
    public ResponseEntity<Loan> saveLoan(@PathVariable("clientId") int clientId, @RequestBody Loan loan) {
        if(clientService.getClientById(clientId) == null)
            return ResponseEntity.notFound().build();
        Loan loanNew = clientService.saveLoan(clientId, loan);
        return ResponseEntity.ok(loan);
    }
}
