package com.washmycar.packagesservice.api.repository;

import java.util.List;
import java.util.Optional;

import com.washmycar.packagesservice.api.model.AddOn;


public interface AddOnDaoInterface  {
	public AddOn addAddOn(AddOn addOns);
	public List<AddOn> getAddOns();
	public Optional<AddOn> getAddOnsbyAddOnCode(String addOnCode);
	public Optional<AddOn> getAddOnsbyAddOnName(String addOnName);
	public AddOn UpdatebyAddOnCode(String addOnCode,AddOn addOns);
	public String deleteAddOnbyAddOnCode(String addOnCode);

}
