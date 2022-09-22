package com.example.fraud.service.interfaces;

import com.example.fraud.dto.ClientDTO;
import com.example.fraud.entity.Client;

import java.util.List;

public interface ClientService {
    ClientDTO addNewClient(ClientDTO clientDTO);

    void deleteClient(Long clientId);

    ClientDTO updateClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients();

    Client getClientById(Long clientId);

    List<ClientDTO> getLowRiskClients(ClientDTO clientDTO);
}
