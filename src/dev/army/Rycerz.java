package dev.army;

import dev.interfejsy.strzelanie.NieStrzelam;
import dev.interfejsy.strzelanie.StrzelanieInterfejs;
import dev.interfejsy.walka.WalkaInterfejs;
import dev.interfejsy.walka.Walcz;

public class Rycerz extends Army {
	public void init_features(){
		strzelanie_interfejs=new NieStrzelam();
		walka_interfejs=new Walcz();
	}
	public Rycerz(){
		init_features();
	}
	public Rycerz(Jednostka ¿o³nierz){
		super(¿o³nierz);
		init_features();
	}
	public String _toString(){
        return "rycerz";
    }
}
