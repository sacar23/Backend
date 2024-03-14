package com.example8.gp28.contact;


import jakarta.persistence.*;



@Entity
@Table
public class Contact {
    @Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String msg;


    public Contact() {
    }



    public Contact(Long id, String name, String email, String mobile, String msg) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.msg = msg;
    }

    public Contact(String name, String email, String mobile, String msg) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

