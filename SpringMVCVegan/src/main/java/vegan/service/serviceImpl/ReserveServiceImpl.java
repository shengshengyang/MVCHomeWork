package vegan.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.ReserveDao;
import vegan.model.Reserve;
import vegan.service.ReserveService;



@Service
@Transactional
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveDao reserveDao;
	
	@Override
	public Integer insertReserve(Reserve r) {
		return reserveDao.insertReserve(r);
	}

	@Override
	public Reserve getReserveById(Integer reserveId) {
		return reserveDao.getReserveById(reserveId);
	}

	@Override
	public List<Reserve> reserveList() {
		return reserveDao.reserveList();
	}

}
