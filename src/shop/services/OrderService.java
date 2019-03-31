package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository = RepositoryConfiguration.getInstance().getOrderRepository();

    public void addOrder () {

    }

}
