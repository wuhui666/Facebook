package Bean;
public class User {
    public int number;
    public String name;
    public String account;
    public String sex;
    public String password;
    public int age;
   
    public int getnumber() {
        return number;
    }
    public void setnumber(int number2) {
        this.number = number2;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public int getage() {
        return age;
    }
    public void setage(int age2) {
        this.age = age2;
    }
    public String getsex() {
        return sex;
    }
    public void setsex(String sex2) {
        this.sex = sex2;
    }
    public String getaccount() {
        return account;
    }
    public void setaccount(String account2) {
        this.account = account2;
    }
     
}