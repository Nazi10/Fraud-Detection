package com.example.fraud.controller;

import com.example.fraud.dto.ClientDTO;
import com.example.fraud.entity.Client;
import com.example.fraud.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/addClient")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.addNewClient(clientDTO));
    }

    @GetMapping("/allClients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PatchMapping("/updateClient")
    public ResponseEntity<ClientDTO> updateValidation(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(clientDTO));
    }

    @DeleteMapping("/deleteClient/{clientId}")
    public void deleteClients(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }
}
