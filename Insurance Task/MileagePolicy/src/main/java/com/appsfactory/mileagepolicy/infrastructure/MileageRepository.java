package com.appsfactory.mileagepolicy.infrastructure;




import com.appsfactory.mileagepolicy.domain.model.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MileageRepository extends JpaRepository<Mileage, Long>{
	
	 @Query("SELECT e.Id,e.minRange,e.maxRange,e.factor  FROM Mileage e  WHERE (:pAnnualDistance) between e.minRange and e.maxRange")
	 public static   Mileage findByAnnualDistance(@Param("pAnnualDistance")   int annualDistance) {
		return null;
}

}
