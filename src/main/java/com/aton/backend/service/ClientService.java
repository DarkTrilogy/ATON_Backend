package com.aton.backend.service;

import com.aton.backend.dto.user.UserChangeRequest;
import com.aton.backend.entity.Client;
import com.aton.backend.entity.User;
import com.aton.backend.repository.ClientRepository;
import com.aton.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Transactional
    public List<Client> addToUser(UserChangeRequest userChangeRequest) {
        log.info(userChangeRequest.toString());
        Client newClient = userChangeRequest.getClient();
        User user = userRepository.findByLogin(userChangeRequest.getLogin()).orElseThrow();
        newClient.setResponsibleUser(user);
        user.setClients(user.getClients().stream().filter(client -> !client.getId().equals(newClient.getId())).collect(toList()));
        Client client = clientRepository.getByAccountNumber(newClient.getAccountNumber());
        if (client != null) {
            clientRepository.delete(client);
        }
        clientRepository.save(newClient);
        user.getClients().add(newClient);
        userRepository.save(user);


        return user.getClients();
    }

    public List<Client> deleteFromUser(Integer clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        User user = client.getResponsibleUser();
        user.getClients().remove(client);
        userRepository.save(user);
        clientRepository.delete(client);
        return user.getClients();
    }

    public Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow();
    }
}