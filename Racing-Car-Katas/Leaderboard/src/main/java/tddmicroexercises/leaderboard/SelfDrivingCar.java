package tddmicroexercises.leaderboard;

import java.util.Objects;

public class SelfDrivingCar extends Driver {

    private String algorithmVersion;

    public SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SelfDrivingCar))
            return false;
        if (!super.equals(o))
            return false;
        SelfDrivingCar that = (SelfDrivingCar) o;
        return Objects.equals(algorithmVersion, that.algorithmVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), algorithmVersion);
    }
}
