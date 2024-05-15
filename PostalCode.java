//Emhenya Supreme 
public class PostalCode implements Comparable<PostalCode> {
    private String code;
    private String area;
    private String province;
    private double latitude;
    private double longitude;

    // Constructor
    public PostalCode(String code, String area, String province, double latitude, double longitude) {
        this.code = code;
        this.area = area;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int compareTo(PostalCode other) {
        return this.code.compareTo(other.getCode());
    }

    public String toString() {
        return "PostalCode: " +
                "code(Key)='" + code + ", (Value) area='" + area + '\'' +", province='" + province + '\'' +
                ", latitude=" + latitude +", longitude=" + longitude +"}";
    }
}

