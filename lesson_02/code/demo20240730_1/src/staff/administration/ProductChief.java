package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;
import staff.specialists.prodaction.MachineOperator;
import staff.specialists.prodaction.Storekeeper;

public class ProductChief {
    @Autowired
    MachineOperator machineOperator;
    @Autowired
    Storekeeper storekeeper;

    public void setMachineOperator(MachineOperator machineOperator) {
        this.machineOperator = machineOperator;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void giveOrder() {
        machineOperator.work();
        storekeeper.work();
    }
}
