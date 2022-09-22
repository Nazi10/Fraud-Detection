package com.example.fraud.service.concrete;

import com.example.fraud.entity.Client;
import com.example.fraud.entity.Validation;
import com.example.fraud.repository.ClientRepo;
import com.example.fraud.repository.ValidationRepo;
import com.example.fraud.service.interfaces.PointCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PointCalculationServiceImpl implements PointCalculationService {
    private final ClientRepo clientRepo;
    private final ValidationRepo validationRepo;

    @Override
    public Double calculateWallet() {
        List<Client> clientsList = clientRepo.findAll();
        Set<Client> repeat = new HashSet<>();
//        public Set<Integer> findDuplicates(List <Integer> listContainingDuplicates) {
//            final Set<Integer> setToReturn = new HashSet<>();
//            final Set<Integer> set1 = new HashSet<>();
//            for (Integer yourInt : listContainingDuplicates) {
//                if (!set1.add(yourInt)) {
//                    setToReturn.add(yourInt);
//                }
//            }
//            return setToReturn;
//        }
        return 0d;
    }

    @Override
    public Double calculateTransactions() {
        List<Client> clientsList = clientRepo.findAll();
        for (var client : clientsList) {
            Validation validation = validationRepo
                    .findValidationByClientClientId(client.getClientId());
            validation.setRiskPoints(0d);
            String type = client.getCardType();
            if (type.equalsIgnoreCase("virtual") || type.equalsIgnoreCase("prepaid")) {
                validation.setRiskPoints(validation.getRiskPoints() + 2d);
                validationRepo.save(validation);
            }
            String ip = client.getIpAddress();
            if (ip.contains("tor")) {
                validation.setRiskPoints(validation.getRiskPoints() + 8d);
                validationRepo.save(validation);
            }
            String email = client.getEmail().toLowerCase(Locale.ROOT);
            String firstName = client.getFirst().toLowerCase(Locale.ROOT);
            String lastName = client.getLast().toLowerCase(Locale.ROOT);
            if (!email.contains(firstName) && !email.contains(lastName)) {
                validation.setRiskPoints(validation.getRiskPoints() + 3d);
                validationRepo.save(validation);
            }
            if (!email.contains("@")) {
                validation.setRiskPoints(validation.getRiskPoints() + 7d);
                validationRepo.save(validation);
            }
            String fullName = client.getFirst()+client.getLast();
            if(fullName.matches(".*\\d.*")){
                validation.setRiskPoints(validation.getRiskPoints() + 7d);
                validationRepo.save(validation);
            }
            if(validation.getRiskPoints() >= 7){
                validation.setStatus("Fraud");
            }
        }
        return null;
    }

//    @Override
//    public Boolean checkEmailValidity(String email) {
//        Client client = new Client();
//        return client.getEmail().contains("@");
//    }


}
