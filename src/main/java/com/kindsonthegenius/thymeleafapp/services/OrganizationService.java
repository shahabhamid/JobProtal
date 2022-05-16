package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.Organization;
import com.kindsonthegenius.thymeleafapp.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	public List<Organization> getAll() {
		return (List<Organization>) organizationRepository.findAll();
	}
	public Optional<Organization> getOne(Integer Id) {
		return organizationRepository.findById(Id);
	}
	public void addNew(Organization organization) {
		System.out.println(("Add New Organization"));
		System.out.println(organization.toString());
		organizationRepository.save(organization);
	}
	public void update(Organization organization) {
		organizationRepository.save(organization);
	}
	public void delete(Integer Id) {
		organizationRepository.deleteById(Id);
	}

}
