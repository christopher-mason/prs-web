package com.prs.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prs.business.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {
	
	// PR Lines List line items for a PR
	List<LineItem> findByRequestId(int id);
	
	// LineItem Add PR.total needs to be recalculated - call recalculation
	//List<LineItem> findPrTotalRecalcByAdd(double prTotal);

}
