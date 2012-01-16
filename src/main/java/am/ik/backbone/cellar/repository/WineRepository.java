package am.ik.backbone.cellar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import am.ik.backbone.cellar.entity.Wine;

public interface WineRepository extends JpaRepository<Wine, Integer> {

}
