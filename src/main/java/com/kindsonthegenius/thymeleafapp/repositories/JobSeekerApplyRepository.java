package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerApply;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends CrudRepository<JobSeekerApply, Integer> {

    public List<JobSeekerApply> findByJob(JobPostActivity job);

    public List<JobSeekerApply> findByUserId(JobSeekerProfile user_account_id);
}
