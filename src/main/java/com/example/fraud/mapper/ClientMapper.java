package com.example.fraud.mapper;

import com.example.fraud.dto.ClientDTO;
import com.example.fraud.dto.PointsDTO;
import com.example.fraud.dto.ValidationDTO;
import com.example.fraud.entity.Client;
import com.example.fraud.entity.Validation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO clientToDto(Client client);
    Client dtoToClient(ClientDTO clientDTO);
    List<ClientDTO> clientsToDto(List<Client> clients);
    Client dtoToClients(ClientDTO clientDTO);
}
