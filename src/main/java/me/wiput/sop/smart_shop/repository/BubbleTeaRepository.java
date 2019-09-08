package me.wiput.sop.smart_shop.repository;

import me.wiput.sop.smart_shop.models.BubbleTeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BubbleTeaRepository extends JpaRepository<BubbleTeaModel, Long> {

}
