package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerSave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends CrudRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByJob(JobPostActivity job);

    public List<JobSeekerSave> findByUserId(JobSeekerProfile user_account_id);
}
