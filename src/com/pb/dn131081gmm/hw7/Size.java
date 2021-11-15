package com.pb.dn131081gmm.hw7;

public enum Size { XXS("очень-очень маленький", 32),
                    XS("очень маленький", 36),
                    S("маленький", 38),
                    M("средний", 40),
                    L("большой", 42),
                    SL("очень большой", 46);
    private int euroSize;
    private String description;
    Size(String descrip, int  eSize){
        euroSize=eSize;
        description=descrip;
    }
    public String getDescription(){
        return description;
    }
    public  int getEuroSize(){
        return euroSize;
    }
}
