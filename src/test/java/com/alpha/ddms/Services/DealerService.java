package com.alpha.ddms.Services;

import com.alpha.ddms.domains.DealerModel;
import com.alpha.ddms.repositories.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DealerService {
    @Autowired
    DealerRepository dealerRepository;
    public DealerModel getDealer(String idDealer){
        Optional<DealerModel> data = dealerRepository.findById(idDealer);
        return data.isPresent() ? null : data.get();
    }

    public Optional<DealerModel> findById(String dealerId){
        Optional<DealerModel> dealerModel = dealerRepository.findById(dealerId);
        return dealerModel;
    }
}
