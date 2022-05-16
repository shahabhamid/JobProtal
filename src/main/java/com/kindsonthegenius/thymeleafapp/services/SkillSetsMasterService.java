package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.SkillSetsMaster;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerProfileRepository;
import com.kindsonthegenius.thymeleafapp.repositories.SkillSetsMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillSetsMasterService {

	@Autowired
	private SkillSetsMasterRepository skillSetsMasterRepository;
	public List<SkillSetsMaster> getAll() {
		return (List<SkillSetsMaster>) skillSetsMasterRepository.findAll();
	}
	public Optional<SkillSetsMaster> getOne(Integer Id) {
		return skillSetsMasterRepository.findById(Id);
	}
	public void addNew(SkillSetsMaster skillSetsMaster) {
		System.out.println(("Add New Skill Set"));
		System.out.println(skillSetsMaster.toString());
		skillSetsMasterRepository.save(skillSetsMaster);
	}
	public void update(SkillSetsMaster skillSetsMaster) {
		skillSetsMasterRepository.save(skillSetsMaster);
	}
	public void delete(Integer Id) {
		skillSetsMasterRepository.deleteById(Id);
	}

}
