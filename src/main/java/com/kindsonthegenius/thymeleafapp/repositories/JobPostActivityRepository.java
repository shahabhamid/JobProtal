package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobPostActivityRepository extends CrudRepository<JobPostActivity, Integer> {
    @Query(value="SELECT * FROM job_post_activity j INNER JOIN job_location l on j.job_location_id=l.Id  WHERE j.job_title LIKE %:job%"
            + " AND (l.city LIKE %:location%"
            + " OR l.country LIKE %:location%"
            + " OR l.state LIKE %:location%) " +
            " AND (j.job_type IN(:type)) " +
            " AND (j.remote IN(:remote)) " +
            " AND (posted_date >= :date)" ,nativeQuery = true)
    public List<JobPostActivity> search(@Param("job") String job,
                                        @Param("location") String location,
                                        @Param("remote") List<String> remote,
                                        @Param("type") List<String> type,
                                        @Param("date") LocalDate date);
}
