package se331.lab08_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab08_1.entity.Bid;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid,Long> {

}
