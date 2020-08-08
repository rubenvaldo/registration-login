package ie.cct.springboot.repository;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;

import ie.cct.springboot.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	//Booking findByLicence(String licence_plate);
	//Booking findByEmail(String email); // delete this
	

	//checking how many bookings with the same date and time
	@Query(value = "SELECT count(*) FROM booking WHERE DAY(date) = DAY(:newDate)", nativeQuery = true)
	public int countByDate(@Param("newDate") LocalDate date);

}