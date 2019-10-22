package me.jhonnatanmesquita.heroesbattlearena.repositories;

import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Integer> {
}
