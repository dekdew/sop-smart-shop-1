package me.wiput.sop.smart_shop.repository;

import me.wiput.sop.smart_shop.models.BubbleTeaMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BubbleTeaMenuRepository extends JpaRepository<BubbleTeaMenuModel, Long> {
}
