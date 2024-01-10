package com.example.demo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  
public class VaccineCenterDAO {
	
	@Autowired
	LoginRepo repo;
	
	@Autowired
	CenterRepo crepo;
	
	@Autowired
	CitizenRepo zrepo;
	
	public Admin insertAdmin(Admin a) {
		return repo.save(a);
	}
	
	public Admin findByEmail(String email) {
        return repo.findById(email).orElse(null);
    }
	
	public Center insertCenter(Center c) {
		return crepo.save(c);
	}
	
	 public List<Center> findAllCenters() {
	        return crepo.findAll();
	}
	 
	 public List<Citizen> findAllCitizen() {
	        return zrepo.findAll();
	}
	 
	 public Center findCenterByName(String centername) {
	        return crepo.findByCentername(centername);
	 }

	public Citizen insertCitizen(Citizen c) {
		return zrepo.save(c);
	}

	public Center findCenterById(int centerId) {
	    return crepo.findById(centerId).orElse(null);
	}
	
	public List<Citizen> findCitizensByCenter(Center center) {
	    return zrepo.findByCenter(center);
	}
	
	public Citizen findCitizenById(int citizenId) {
	    return zrepo.findById(citizenId).orElse(null);
	}

	public Center updateCenter(int id,Center center) {
		Center c=crepo.findById(id).orElse(null);
		c.setCentercity(center.getCentercity());
		c.setCentername(center.getCentername());
		return crepo.save(c);
		
	}
	
	public Citizen updateCitizen(int id,Citizen citizen) {
		Citizen c=zrepo.findById(id).orElse(null);
		c.setName(citizen.getName());
		c.setCity(citizen.getCity());
		c.setDose(citizen.getDose());
		c.setStatus(citizen.getStatus());
		c.setCenter(citizen.getCenter());
		return zrepo.save(c);
		
	}
	
	public void deleteCitizenById(int id) {
	    zrepo.deleteById(id);
	}

	public List<Citizen> getCitizens(Center center) {
	    return zrepo.findByCenter(center);
	}
	
	public void deleteAll(List<Citizen> citizens) {
	    zrepo.deleteAll(citizens);
	}
	
	public void delete(Center center) {
	    crepo.delete(center);
	}
	
}