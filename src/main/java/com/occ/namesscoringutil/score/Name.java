package com.occ.namesscoringutil.score;

public class Name {

    private String firstNmae;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstNmae = firstName;
        this.lastName = lastName;
    }

    public Name(){

    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Name{");
        sb.append("firstNmae='").append(firstNmae).append('\'');
        sb.append(", lastName=").append(lastName);
        sb.append('}');
        return sb.toString();
    }
}
