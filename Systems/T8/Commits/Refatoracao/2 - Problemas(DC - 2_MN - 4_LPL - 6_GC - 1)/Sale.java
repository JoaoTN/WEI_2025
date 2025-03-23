package br.sistemalojaroupas.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.dizitart.no2.objects.Id;

public class Sale implements Serializable, TableContract {
    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static int MIN = 1;
    private static  int MAX = 4;

    @Id
    private Long id;

    private Set<SaleItem> items = new HashSet<>();
    private Employee employee;
    private Customer customer;
    private Integer payment;
    private Integer installments;
    private Date moment;

    public static class PaymentType {
        public static final int MONEY = 1;
        public static final int CREDIT = 2;
        public static final int DEBIT = 3;
        public static final int MONEY_CREDIT = 4;
    }

    public Sale() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SaleItem> getItems() {
        return items;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void addItem(SaleItem item) {
        items.add(item);
    }

    public void removeItem(SaleItem item) {
        items.remove(item);
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getEmployeeName() {
        return (employee == null) ? "N/A" : employee.getName();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerName() {
        return (customer == null) ? "N/A" : customer.getName();
    }

    public String getCustomerCpf() {
        return (customer == null) ? "N/A" : customer.getCpf();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentName() {
        if (payment == null) {
            throw new IllegalStateException("O método de pagamento não pode ser nulo.");
        }
        if (payment == PaymentType.MONEY) {
            return "DINHEIRO";
        }
        if (payment == PaymentType.CREDIT) {
            return "CRÉDITO";
        }
        if (payment == PaymentType.DEBIT) {
            return "DÉBITO";
        }
        if (payment == PaymentType.MONEY_CREDIT) {
            return "DINHEIRO + CRÉDITO";
        }
        return "N/A";
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        if (payment > MAX|| payment < MIN) {
            throw new IllegalArgumentException("Opção inválida");
        }
        this.payment = payment;
    }

    public Object getFormattedInstallments() {
        return (installments == null) ? "N/A" : installments;
    }

    public void setInstallments(Integer installments) {
        if (payment == null) {
            throw new IllegalStateException("O método de pagamento ainda não foi definido.");
        }
        if (payment == PaymentType.CREDIT || payment == PaymentType.MONEY_CREDIT) {
            this.installments = installments;
        }
    }

    public String getFormattedDate() {
        return sdf.format(moment);
    }

    public Double getTotal() {
        double sum = 0.0;

        for (SaleItem element : items) {
            sum += element.getSubTotal();
        }
        return sum;
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
        Sale other = (Sale) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", items=" + items + ", moment=" + moment + ", total=" + getTotal() + '}';
    }

    @Override
    public Object[] tableRowModel() {
        return new Object[]{
                getId(),
                String.format("%.2f", getTotal()),
                getFormattedDate(),
                (customer == null) ? "N/A" : getCustomer().getName(),
                (customer == null) ? "N/A" : getCustomer().getCpf()
        };
    }
}
