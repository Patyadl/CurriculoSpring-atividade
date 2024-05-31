package Repository;

import Model.Idiomas;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomasRepository  extends JpaRepository<Idiomas, Long> {
}
