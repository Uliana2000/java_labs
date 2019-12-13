package lab1.model;

import java.util.Objects;

/**
 * Can be created using Builder
 */
public class Reader {

    private Integer id;

    private String firstName;

    private String lastName;

    private String telephone;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (!Objects.equals(id, reader.id)) return false;
        if (!Objects.equals(firstName, reader.firstName)) return false;
        if (!Objects.equals(lastName, reader.lastName)) return false;
        if (!Objects.equals(telephone, reader.telephone)) return false;
        return Objects.equals(address, reader.address);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    private Reader() {

    }

    public static class Builder {

        Reader reader;

        public Builder() {
            reader = new Reader();
        }

        public Builder setId(Integer id) {
            reader.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            reader.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            reader.lastName = lastName;
            return this;
        }

        public Builder setTelephone(String telephone) {
            reader.telephone = telephone;
            return this;
        }

        public Builder setAddress(String address) {
            reader.address = address;
            return this;
        }

        public Reader build() {
            return reader;
        }

    }

}
