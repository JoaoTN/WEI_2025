package br.sistemalojaroupas.model.entities;

import java.util.Objects;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices(
        @Index(value = "name", type = IndexType.Unique)
)
public class Brand {

    @Id
    private NitriteId id;
    private String name;

    public Brand() {

    }

    public Brand(String name) {
        this.name = name;
    }

    public NitriteId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Brand other = (Brand) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }
}
