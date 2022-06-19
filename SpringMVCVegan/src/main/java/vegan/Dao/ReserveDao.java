package vegan.Dao;

import java.util.List;

import vegan.model.Reserve;

public interface ReserveDao {
	Integer insertReserve(Reserve r);
	Reserve getReserveById(Integer reserveId);
	List<Reserve> reserveList();
	Reserve updateReserve(Integer reserveId, Reserve reserve);
	void deleteReserveById(Integer reserveId);
}
