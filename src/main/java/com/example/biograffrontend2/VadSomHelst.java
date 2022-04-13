package com.example.biograffrontend2;

public class VadSomHelst {

    public String SkillName;
    public String Lala;

    public VadSomHelst(String skillName, String Lala) {
        this.SkillName = skillName;
        this.Lala = Lala;

    }


    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public String getLala() {
        return Lala;
    }

    public void setLala(String lala) {
        Lala = lala;
    }

    @Override
    public String toString() {
        return "VadSomHelst{" +
                "SkillName='" + SkillName + '\'' +
                ", Lala='" + Lala + '\'' +
                '}';
    }


}
