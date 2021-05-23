package entities;

import javax.persistence.*;

@Entity
@Table(name = "age_restriction")
public class AgeRestriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String restrictionName;

    private int minAge;

    public AgeRestriction() {
    }

    public AgeRestriction(String restrictionName, int minAge) {
        this.restrictionName = restrictionName;
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return "AgeRestriction{" +
                "id=" + id +
                ", restrictionName='" + restrictionName + '\'' +
                ", minAge=" + minAge +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestrictionName() {
        return restrictionName;
    }

    public void setRestrictionName(String restrictionName) {
        this.restrictionName = restrictionName;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
