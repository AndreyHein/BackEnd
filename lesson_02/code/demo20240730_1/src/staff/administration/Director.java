package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;

public class Director {
    @Autowired
    private ProductChief productChief;
    @Autowired
    private SalesChief salesChief;

    public void setProductChief(ProductChief productChief) {
        this.productChief = productChief;
    }

    public void setSalesChief(SalesChief salesChief) {
        this.salesChief = salesChief;
    }

    public  void manageCompany() {
        productChief.giveOrder();
        salesChief.giveOrders();
    }
}
