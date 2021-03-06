package com.alpha.ddms.dto;

import com.alpha.ddms.domains.PpnModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PpnDto {

    private String id;
    private String dealerId;
    private String ahmDealerCode;
    private String ppnDescription;
    private float ppnRate;
    private float ppnRatePrevious;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm",timezone = "GMT+7")
    private Date effectiveStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm",timezone = "GMT+7")
    private Date effectiveEndDate;

    private String status;
//    private int code;
//    private PpnModel data;
//    private String message;
//    private String statuss;


}
