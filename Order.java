
public class Order {
    private String description;
    OrderStatus orderType = OrderStatus.NEW;  

    public Order(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public OrderStatus getOrderType() {
    	return orderType;
    }
    
    public void setOrderStatus(OrderStatus orderType) {
    	this.orderType = orderType;
    }
}