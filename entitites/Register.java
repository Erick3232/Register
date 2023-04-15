package App.entitites;

import java.util.Date;

public class Register {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String Name;
    private String Email;
    private Date BirthDate;
    private Integer CPF;
    private Integer Phone;
    private double BaseSalary;
    private String Department;
    private Integer DepartmentId;
    
    public Register(){

    }
    public Register(Integer id, String name, String email, Date birthDate, Integer CPF, Integer phone,
            double baseSalary, String department, Integer DepartmentId) 
    {
        this.id = id;
        this.Name = name;
        this.Email = email;
        this.BirthDate = birthDate;
        this.CPF = CPF;
        this.Phone = phone;
        this.BaseSalary = baseSalary;
        this.Department = department;
        this.DepartmentId = DepartmentId;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Date getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }
    public Integer getCPF() {
        return CPF;
    }
    public void setCPF(Integer cPF) {
        CPF = cPF;
    }
    public Integer getPhone() {
        return Phone;
    }
    public void setPhone(Integer phone) {
        Phone = phone;
    }
    public double getBaseSalary() {
        return BaseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        BaseSalary = baseSalary;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    public Integer getDepartmentId(){
        return DepartmentId;
    }
    public void setDepartmentId(Integer DepartmentId){
        this.DepartmentId = DepartmentId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Register other = (Register) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Register [id=" + id + ", Name=" + Name + ", Email=" + Email + ", BirthDate=" + BirthDate + ", CPF="
                + CPF + ", Phone=" + Phone + ", BaseSalary=" + BaseSalary + ", Department=" + Department
                + ", DepartmentId=" + DepartmentId + "]";
    }
}
