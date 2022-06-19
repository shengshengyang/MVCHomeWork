package vegan.service;

import java.util.List;

import vegan.model.Reserve;


public interface ReserveService {
	Integer insertReserve(Reserve r);
	Reserve getReserveById(Integer reserveId);
	void deleteReserveById(Integer reserveId);
	Reserve updateReserve(Integer reserveId, Reserve reserve);
	List<Reserve> reserveList();
}
