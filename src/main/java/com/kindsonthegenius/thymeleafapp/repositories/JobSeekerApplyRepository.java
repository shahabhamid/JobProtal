package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerApply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends CrudRepository<JobSeekerApply, Integer> {

   /* @Query(value = " SELECT j.* FROM job_seeker_apply j " +
            " inner join job_post_activity jp " +
            " on jp.job_post_id = j.job_post_id " +
            " where j.job_post_id = :job "  ,nativeQuery = true)*/
    public List<JobSeekerApply> findByJob(JobPostActivity job);
}
