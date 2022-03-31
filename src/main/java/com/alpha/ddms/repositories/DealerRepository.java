package com.alpha.ddms.repositories;

import com.alpha.ddms.domains.DealerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DealerRepository extends JpaRepository<DealerModel, String> {

    @Query(value = "select * from mst_dealer where dealer_code=:dealer_code",nativeQuery = true)
    Optional<DealerModel> findByCode(String dealer_code);

    @Override
    DealerModel save(DealerModel data);

    @Query(value = "select * from mst_dealer where dealer_code like :dealerId",nativeQuery = true)
    DealerModel findByDealerId(String dealerId);

 //   @Query(value = "select * from mst_dealer where dealer_code =:dealer_code% and lower(dealer_status)=:dealer_status and lower(dealer_name) like %:dealer_name% order by dealer_code ASC",nativeQuery = true)
   // Page<DealerModel> getAllPage (Pageable pageable,String dealer_code,String dealer_status, String dealer_name);

    @Query(value = "select * from mst_dealer where dealer_code = :dealer_code or lower(dealer_status)=:dealer_status or lower(dealer_name) like %:dealer_name% order by dealer_code ASC",nativeQuery = true)
    Page<DealerModel> getAllPage (Pageable pageable,String dealer_code,String dealer_status, String dealer_name);

}

