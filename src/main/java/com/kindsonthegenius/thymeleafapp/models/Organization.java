package com.kindsonthegenius.thymeleafapp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Organization {

	@Id
	private Integer Id;
	private String CompanyName;
	private String BusinessStreamName;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date establishmentDate;
	private Blob OrganizationLogo;

	public Organization() {
	}

	public Integer getId() {
		return Id;
	}

	public Organization(Integer id, String companyName, String businessStreamName, Date establishmentDate, Blob organizationLogo) {
		Id = id;
		CompanyName = companyName;
		BusinessStreamName = businessStreamName;
		this.establishmentDate = establishmentDate;
		OrganizationLogo = organizationLogo;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getBusinessStreamName() {
		return BusinessStreamName;
	}

	public void setBusinessStreamName(String businessStreamName) {
		BusinessStreamName = businessStreamName;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public Blob getOrganizationLogo() {
		return OrganizationLogo;
	}

	public void setOrganizationLogo(Blob organizationLogo) {
		OrganizationLogo = organizationLogo;
	}
}
