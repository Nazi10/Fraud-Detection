package com.example.fraud.service.concrete;

import com.example.fraud.dto.ClientDTO;
import com.example.fraud.entity.Client;
import com.example.fraud.mapper.ClientMapper;
import com.example.fraud.repository.ClientRepo;
import com.example.fraud.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;
    @Override
    public ClientDTO addNewClient(ClientDTO clientDTO) {
        clientRepo.save(clientMapper.dtoToClient(clientDTO));
        return clientDTO;
    }

    @Override
    public void deleteClient(Long clientId) {
        boolean exists = clientRepo.existsById(clientId);
        if (!exists) {
            throw new IllegalStateException(
                    "client with id " + clientId + " does not exist");
        }
        clientRepo.deleteById(clientId);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        clientRepo.save(clientMapper.dtoToClient(clientDTO));
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientMapper.clientsToDto(clientRepo.findAll());
    }

    @Override
    public Client getClientById(Long clientId) {
        return null;
    }

    @Override
    public List<ClientDTO> getLowRiskClients(ClientDTO clientDTO) {
        return null;
    }
}
