package com.martijn.timvandersteenBackend.controller;

import com.martijn.timvandersteenBackend.exception.ResourceNotFoundException;
import com.martijn.timvandersteenBackend.model.Partner;
import com.martijn.timvandersteenBackend.dao.PartnerDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    PartnerDao partnerDao;

    @GetMapping("/all")
    public String getAllPartners() throws JsonProcessingException {
        List<Partner> list = partnerDao.findAll();
        String gson = new Gson().toJson(list);
        return gson;
    }

    //GEEN JSON?
    @GetMapping("/{id}")
    public Partner getPartnerById(@PathVariable(value = "id") int partnerId) {
        Partner returnVal =partnerDao.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Partner", "id", partnerId));
        return returnVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Partner createPartner(@Validated @RequestBody String partnerJson) {
        Partner addPartner = new Gson().fromJson( partnerJson, Partner.class );
        return partnerDao.save(addPartner);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Partner updatePartner(@PathVariable(value = "id") int partnerId,
                                 @Validated @RequestBody Partner partnerDetails) {

        Partner partner = partnerDao.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", partnerId));

        partner.setBrand(partnerDetails.getBrand());
        partner.setHref(partnerDetails.getHref());
        partner.setImage(partnerDetails.getImage());

        Partner updatedNote = partnerDao.save(partner);
        return updatedNote;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable(value = "id") int partnerId) {
        Partner partner = partnerDao.findById(partnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Partner", "id", partnerId));

        partnerDao.delete(partner);

        return ResponseEntity.ok().build();
    }
}
