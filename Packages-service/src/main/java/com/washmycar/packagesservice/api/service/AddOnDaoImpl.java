package com.washmycar.packagesservice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washmycar.packagesservice.api.model.AddOn;
import com.washmycar.packagesservice.api.repository.AddOnDaoInterface;
import com.washmycar.packagesservice.api.repository.AddOnRepository;

@Service
public class AddOnDaoImpl implements AddOnDaoInterface {
	
	@Autowired
	private AddOnRepository addOnRepository;

	@Override
	public AddOn addAddOn(AddOn addOns) {
		return addOnRepository.save(addOns);
	}

	@Override
	public List<AddOn> getAddOns() {
		return addOnRepository.findAll();
	}

	@Override
	public Optional<AddOn> getAddOnsbyAddOnCode(String addOnCode) {
		return addOnRepository.findByAddOnCode(addOnCode);
	}

	@Override
	public Optional<AddOn> getAddOnsbyAddOnName(String addOnName) {
		return addOnRepository.findByAddOnName(addOnName);
	}

	@Override
	public AddOn UpdatebyAddOnCode(String addOnCode, AddOn addOns) {
		Optional<AddOn> addOns1 = addOnRepository.findByAddOnCode(addOnCode);
		AddOn updateAddOn =addOns1.get();
		//updateAddOn.setAddonCode(addOns.getAddOnCode());
		updateAddOn.setAddOnName(addOns.getAddOnName());
		updateAddOn.setPrice(addOns.getPrice());
		return addOnRepository.save(updateAddOn);
	}

	@Override
	public String deleteAddOnbyAddOnCode(String addOnCode) {
		addOnRepository.deleteByAddOnCode(addOnCode);
		return addOnCode;
	}

}
