package vegan.service;

import java.util.List;

import vegan.model.Reserve;


public interface ReserveService {
	Integer insertReserve(Reserve r);
	Reserve getReserveById(Integer reserveId);
	List<Reserve> reserveList();
}
