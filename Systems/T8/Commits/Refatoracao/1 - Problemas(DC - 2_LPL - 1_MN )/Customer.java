package br.sistemalojaroupas.model.entities;

import java.io.Serializable;
import java.util.Objects;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices(
        @Index(value = "cpf", type = IndexType.Unique)
)
public class Customer implements Serializable, TableContract {

    @Id
    private NitriteId id;
    private String cpf;
    private String name;
    private String email;
    private String phone;

    public Customer() {

    }

    public Customer(String cpf, String name, String email, String phone) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public NitriteId getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public Object[] tableRowModel() {
        return new Object[]{
                getName(),
                getCpf(),
                getPhone(),
                getEmail()
        };
    }

}
