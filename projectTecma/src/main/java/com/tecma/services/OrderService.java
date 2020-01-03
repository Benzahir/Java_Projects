package com.tecma.services;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecma.entities.Order;
import com.tecma.entities.Product;
import com.tecma.repositories.OrdersRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderService {
	
	
	private OrdersRepository ordersRepository;
	
	@Autowired
	public OrderService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	public Order save(ArrayList<Product> cart) {
		
		Order o = new Order();
		Random rnd = new Random();
        int ini = 100000 + rnd.nextInt(900000);
        
		for (int i=0; i<cart.size(); i++) {
			o.setProductId(cart.get(i).getId());
			o.setProductName(cart.get(i).getName());
			o.setQuantityOfMeasure(cart.get(i).getQuantityOfMeasure());;
			o.setUnitPrice(o.getUnitPrice());
			o.setTotalPrice(cart.get(i).getSellingPrice());
			o.setOrderNumber(ini);
		}
		o = ordersRepository.save(o);
		return o;
	}
	
	

}
