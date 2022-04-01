package com.alpha.ddms.services;

import com.alpha.ddms.domains.SalesModel;
import com.alpha.ddms.models.ViewSales;
import com.alpha.ddms.repositories.SalesRepository;
import com.alpha.ddms.repositories.ViewSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalesService {

    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ViewSalesRepository viewSalesRepository;

    public SalesModel findSupervisorId(String supervisorId){
        Optional<SalesModel> salesModel = salesRepository.findSupervisorId(supervisorId);
        return (!salesModel.isPresent()) ? null : salesModel.get();
    }

    public SalesModel save(SalesModel data){
        return salesRepository.save(data);
    }

    public Optional<SalesModel> findById(String salesId){
        Optional<SalesModel> salesModel = salesRepository.findById(salesId);
        return salesModel;
    }

    public String findLatestId(String salesId){
        Optional<SalesModel> salesModel = salesRepository.findLatestId(salesId);
        return !salesModel.isPresent() ? null : salesModel.get().getSales_id();
    }

//    public List<SalesModel> searchSales(String salesName, String dealerId, String salesStatus, int offset, int limit){
//        return salesRepository.searchSalesModel(salesName, dealerId, salesStatus, offset, limit);
//    }

    public Page<ViewSales> searchSales(String salesName, String dealerId, String salesStatus, int page, int limit){
        return viewSalesRepository.searchSalesModel(salesName, dealerId, salesStatus, PageRequest.of(page,limit));
    }
}
