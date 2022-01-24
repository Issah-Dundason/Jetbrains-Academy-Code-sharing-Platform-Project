package platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
    Code findCodeById(String id);
    List<Code> findTop10ByRestrictedOrderByLoadDateDesc(boolean restricted);
}
