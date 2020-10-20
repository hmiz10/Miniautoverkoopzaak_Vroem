package be.intecbrussel.entities;

import be.intecbrussel.model.Employee;
import be.intecbrussel.model.Office;

public interface OfficeDao {
    void createOffice(Office office);
    Office readOffice(int officeCode);
    void updateOffice(Office office);
    void deleteOffice(Office office);
}
