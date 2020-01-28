package com.livenet.livenet.amigos;

public class Amigo {
    private String alias1, alias2;

    public Amigo(){}

    public Amigo(String alias1, String alias2) {
        this.alias1 = alias1;
        this.alias2 = alias2;

    }

    public String getAlias1() {
        return alias1;
    }

    public void setAlias1(String alias1) {
        this.alias1 = alias1;
    }

    public String getAlias2() {
        return alias2;
    }

    public void setAlias2(String alias2) {
        this.alias2 = alias2;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "alias1='" + alias1 + '\'' +
                ", alias2='" + alias2 + '\'' +
                '}';
    }
}
